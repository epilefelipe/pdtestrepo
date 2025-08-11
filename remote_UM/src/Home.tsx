import React from 'react';
import { UserOutlined } from '@ant-design/icons';
import type { MenuProps } from 'antd';
import { Breadcrumb, Button, Layout, Menu, theme } from 'antd';
import UsersList from './components/user-management/UsersList';
import { useNavigate } from 'react-router-dom';

const { Header, Content, Sider } = Layout;

const items1: MenuProps['items'] = ['1'].map((key) => ({
  key,
  label: `User Management`,
}));

const items2: MenuProps['items'] = [UserOutlined].map(
  (icon, index) => {
    const key = String(index);

    return {
      key: `sub${key}`,
      icon: React.createElement(icon),
      label: `Manage`,
      children: ['Users List'].map((_, j) => {
        const subKey = index * 4 + j + 1;
        return {
          key: subKey,
          label: _,
        };
      }),
    };
  },
);

const Home: React.FC = () => {

    const navigate = useNavigate()

  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  return (
    <Layout style={{ width: '100vw', height: '100vh'}}>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div className="demo-logo" />
        <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          items={items1}
          style={{ flex: 1, minWidth: 0 }}
        />
      </Header>
      <Layout>
        <Sider width={200} style={{ background: colorBgContainer }}>
          <Menu
            mode="inline"
            defaultSelectedKeys={['1']}
            defaultOpenKeys={['sub1']}
            style={{ height: '100%', borderInlineEnd: 0 }}
            items={items2}
          />
        </Sider>
        <Layout style={{ padding: '0 24px 24px' }}>

          <Breadcrumb
            items={[{ title: 'Home' }]}
            style={{ margin: '16px 0' }}
          />

          <Content
            style={{
              padding: 24,
              margin: 0,
              minHeight: 280,
              background: colorBgContainer,
              borderRadius: borderRadiusLG,
            }}
          >
        <Button type="primary"  style={{marginBottom: 20}} onClick={() => navigate('/create')}>
            New User
          </Button>
            <UsersList/>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  );
};

export default Home;