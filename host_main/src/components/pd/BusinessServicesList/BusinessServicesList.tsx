import { Table } from 'antd'
import { Link } from 'react-router-dom';

function BusinessServicesList() {

    const columns = [
    { title: 'Nombre', dataIndex: 'name', key: 'name',       render: (text: string, record: any) => (
        <Link to={`/BusinessServiceDetail/${record.id}`}>{text}</Link>),
},
    { title: 'Edad', dataIndex: 'age', key: 'age' },
    { title: 'Dirección', dataIndex: 'address', key: 'address' },
  ];

  const data = [
    { key: '1', id: 1, name: 'Juan Pérez', age: 32, address: 'Calle Falsa 123' },
    { key: '2', id: 2, name: 'María Gómez', age: 28, address: 'Av. Siempre Viva 742' },
    { key: '3', id: 3, name: 'Carlos Ruiz', age: 45, address: 'Paseo de la Reforma 100' },
  ];

  return (
    <Table columns={columns} dataSource={data} />
  )
}

export default BusinessServicesList