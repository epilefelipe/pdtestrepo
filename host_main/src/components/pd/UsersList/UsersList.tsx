import { Table } from 'antd';

function UsersList() {
    const columns = [
    { title: 'Nombre', dataIndex: 'name', key: 'name' },
    { title: 'Edad', dataIndex: 'age', key: 'age' },
    { title: 'Dirección', dataIndex: 'address', key: 'address' },
  ];

  const data = [
    { key: '1', name: 'Juan Pérez', age: 32, address: 'Calle Falsa 123' },
    { key: '2', name: 'María Gómez', age: 28, address: 'Av. Siempre Viva 742' },
    { key: '3', name: 'Carlos Ruiz', age: 45, address: 'Paseo de la Reforma 100' },
  ];

  return (
    <Table columns={columns} dataSource={data} />
  )
}

export default UsersList