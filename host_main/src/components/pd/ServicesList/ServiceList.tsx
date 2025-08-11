import { Table } from 'antd';
import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { fetchServices } from '../../../features/services/servicesThonks';
import { filterService } from  '../../../features/services/servicesSlice';
import Search from 'antd/es/transfer/search';
import type { SearchProps } from 'antd/es/input';
import { Link } from 'react-router-dom';

function ServiceList() {

  const dispatch = useDispatch<any>();
  const { services, loading, error } = useSelector((state) => state.services);

  const dataSource = services.map(p => ({
    key: p.id,
    id: p.id,
    name: p.summary,
    description: p.description,
  }))

    const columns = [
    { title: 'ID', dataIndex: 'id', key: 'id', render: (text: string, record: any) => (
            <Link to={`/ServiceDetail/${record.id}`}>{text}</Link>),
    },
    { title: 'Name', dataIndex: 'name', key: 'name' },
    { title: 'Description', dataIndex: 'description', key: 'description' },
  ];

  useEffect(() => {
    dispatch(fetchServices());
  }, [dispatch])

    const onSearch: SearchProps['onSearch'] = (value, _e, info) => dispatch(filterService(value));

  return (
    <div>
    <Search placeholder="filtrar servicios" disabled={loading} onSearch={onSearch} enterButton />
    <Table columns={columns} dataSource={dataSource} />
    </div>
  )
}

export default ServiceList