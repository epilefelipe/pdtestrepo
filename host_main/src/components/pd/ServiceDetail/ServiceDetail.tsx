import { useEffect } from 'react';
import { Layout, Table } from 'antd';
import { fetchService } from '../../../features/services/servicesThonks';
import { useDispatch, useSelector } from 'react-redux';
import { useParams } from "react-router-dom";

const expandedRowRender = (record: any) => {
 const columns = [
    { title: 'ID', dataIndex: 'id', key: 'id' },
    { title: 'Summary', dataIndex: 'summary', key: 'summary' },
    { title: 'Status', dataIndex: 'status', key: 'status' },
  ];

  return <Table columns={columns} dataSource={record.children} pagination={false} />;
};

const ServiceDetail = () => {

  const { id } = useParams();

  const dispatch = useDispatch();
  const { service, loading, error } = useSelector((state) => state.services);

const dataSource = service
  ? [
      {
        key: service.id,
        id: service.id,
        name: service.name,
        description: service.description,
        children: [
        {
        key: service.summary,
        summary: service.summary,
        status: service.status,
      },
        {
        key: service.summary,
        id: service.id,
        type: service.type,
        summary: service.summary,
        self: service.self,
        html_url: service.html_url,
      }
        ]
      },
    ]
  : [];

      useEffect(() => {
      dispatch(fetchService(id));
    }, [dispatch])

  return (
    <Layout style={{width: '100vw'}}>
    <Table
      columns={columns}
      expandable={{ expandedRowRender }}
      dataSource={dataSource}
      />
    </Layout>
  );
};

export default ServiceDetail;