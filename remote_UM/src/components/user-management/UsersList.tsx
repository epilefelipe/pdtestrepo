import React, { useEffect } from 'react';
import { Space, Table, Tag } from 'antd';
import type { TableProps } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { fetchUsers } from '../../feature/users/usersThonks';
import Link from 'antd/es/typography/Link';

interface DataType {
  key: string;
  name: string;
  age: number;
  address: string;
  tags: string[];
}

const columns: TableProps<DataType>['columns'] = [
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    render: (text) => <a>{text}</a>,
  },
  {
    title: 'Age',
    dataIndex: 'age',
    key: 'age',
  },
  {
    title: 'Address',
    dataIndex: 'address',
    key: 'address',
  },
  {
    title: 'Tags',
    key: 'tags',
    dataIndex: 'tags',
    render: (_, { tags }) => (
      <>
        {tags.map((tag) => {
          let color = tag.length > 5 ? 'geekblue' : 'green';
          if (tag === 'loser') {
            color = 'volcano';
          }
          return (
            <Tag color={color} key={tag}>
              {tag.toUpperCase()}
            </Tag>
          );
        })}
      </>
    ),
  },
  {
    title: 'Action',
    key: 'action',
    render: (_, record) => (
      <Space size="middle">
        <a>Update</a>
        <a>Delete</a>
      </Space>
    ),
  },
];

const data: DataType[] = [
  {
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sydney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
];

const UsersList: React.FC = () => {

  const dispatch = useDispatch();
  const { users, loading, error } = useSelector((state) => state.users);

  useEffect(() => {
    dispatch(fetchUsers());
  }, [dispatch])

  const dataSource = users.map(p => ({
    key: p.id,
    id: p.id,
    email: p.email,
    name: p.firstname,
    lastname: p.lastname,
  }))

    const columns = [
    { title: 'ID', dataIndex: 'id', key: 'id', render: (text: string, record: any) => (
            <Link to={`/UserDetail/${record.id}`}>{text}</Link>),
    },
    { title: 'Email', dataIndex: 'email', key: 'email',  },
    { title: 'Name', dataIndex: 'name', key: 'name' },
    { title: 'Lastname', dataIndex: 'lastname', key: 'lastname' },
      {
    title: 'Action',
    key: 'action',
    render: (_, record) => (
      <Space size="middle">
        <a>Update</a>
      </Space>
    ),
  },
    {
    title: 'Action',
    key: 'action',
    render: (_, record) => (
      <Space size="middle">
        <a>Delete</a>
      </Space>
    ),
  }
  ];

  return (
    <>
      <Table<DataType> columns={columns} dataSource={dataSource} />;
    </>
  )

} 

export default UsersList;