import { Table } from 'antd';

const data = [
  {
    key: 1,
    name: 'Juan Pérez',
    age: 32,
    address: 'Calle Falsa 123',
    description: 'Detalles adicionales de Juan',
    children: [
      {
        key: 11,
        date: '2023-01-01',
        status: 'Activo',
        upgradeNum: 100,
      },
      {
        key: 12,
        date: '2023-02-01',
        status: 'Inactivo',
        upgradeNum: 50,
      },
    ],
  },
  {
    key: 2,
    name: 'María Gómez',
    age: 28,
    address: 'Av. Siempre Viva 742',
    description: 'Detalles adicionales de María',
    children: [],
  },
];

const columns = [
  { title: 'Nombre', dataIndex: 'name', key: 'name' },
  { title: 'Edad', dataIndex: 'age', key: 'age' },
  { title: 'Dirección', dataIndex: 'address', key: 'address' },
];

const expandedRowRender = (record: any) => {
  const columns = [
    { title: 'Fecha', dataIndex: 'date', key: 'date' },
    { title: 'Estado', dataIndex: 'status', key: 'status' },
    { title: 'Número de upgrade', dataIndex: 'upgradeNum', key: 'upgradeNum' },
  ];

  return <Table columns={columns} dataSource={record.children} pagination={false} />;
};

const BusinessServiceDetail = () => {
  return (
    <Table
      columns={columns}
      expandable={{ expandedRowRender }}
      dataSource={data}
    />
  );
};

export default BusinessServiceDetail;