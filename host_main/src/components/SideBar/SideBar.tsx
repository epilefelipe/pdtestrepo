import React, { useState } from 'react';
import { Layout, Menu } from 'antd';
import {
  UserOutlined
} from '@ant-design/icons';
import BusinessServicesList from '../pd/BusinessServicesList/BusinessServicesList';
import EscalationPoliciesList from '../pd/EscalationPoliciesList/EscalationPoliciesList';
import ServiceList from '../pd/ServicesList/ServiceList';
import UsersList from '../pd/UsersList/UsersList';
import TeamsList from '../pd/TeamsList/TeamsList';
import ServiceDependenciesList from '../pd/ServicesDependenciesList/ServiceDependenciesList';

const { Sider, Content } = Layout;

const SideBar: React.FC = () => {
    const [selectedKey, setSelectedKey] = useState('1');

  const onMenuClick = (e: { key: string }) => {
    setSelectedKey(e.key);
  };

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider>
        <Menu theme="dark" defaultSelectedKeys={['1']} selectedKeys={[selectedKey]} mode="inline"         onClick={onMenuClick}>
          <Menu.Item key="1" icon={<UserOutlined />}>
            Services
          </Menu.Item>
          <Menu.Item key="2" icon={<UserOutlined />}>
            EscalationPolicies
          </Menu.Item>
          <Menu.Item key="3" icon={<UserOutlined />}>
            BusinessServices
          </Menu.Item>
          <Menu.Item key="4" icon={<UserOutlined />}>
            Users
          </Menu.Item>
          <Menu.Item key="5" icon={<UserOutlined />}>
            Teams
          </Menu.Item>
          <Menu.Item key="6" icon={<UserOutlined />}>
            ServiceDependencies
          </Menu.Item>
        </Menu>
      </Sider>
      <Layout>
        <Content style={{ margin: '16px', width: '100vw' }}>
          {
            selectedKey == '1' ? <ServiceList /> : selectedKey == '2' ? <EscalationPoliciesList/> : selectedKey == '3' ? <BusinessServicesList/> : selectedKey == '4' ? <UsersList/> : selectedKey == '5' ? <TeamsList/> : selectedKey == '6' ? <ServiceDependenciesList/> : <></>
          }
        </Content>
      </Layout>
    </Layout>
  );
};

export default SideBar;
