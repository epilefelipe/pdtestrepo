import React, { lazy, Suspense } from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from 'react-router-dom';
import SignIn from './components/auth/SignIn/SignIn';
import SignUp from './components/auth/SignUp/SignUp';
import Home from './Home';
import BusinessServiceDetail from './components/pd/BusinessServiceDetail/BusinessServiceDetail';
import ServiceDetail from './components/pd/ServiceDetail/ServiceDetail';
import PrivateRoute from './PrivateRoute';

const UserManagement = lazy(() => import("user-management/App"));


const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/home" element={<PrivateRoute><Home /></PrivateRoute>} />
        <Route path="/BusinessServiceDetail/:id" element={<PrivateRoute > <BusinessServiceDetail /></PrivateRoute>} />
        <Route path="/ServiceDetail/:id" element={<PrivateRoute><ServiceDetail /> </PrivateRoute>} />
        <Route
           path="/management"
           element={
             <Suspense fallback={<div>Loading...</div>}>
               <PrivateRoute><UserManagement /></PrivateRoute>
             </Suspense>
           }
         />
        <Route path="/" element={<Navigate to="/home" replace />} />
        <Route path="*" element={<div>404 - Not Found</div>} />
      </Routes>
    </Router>
  );
};

export default App;