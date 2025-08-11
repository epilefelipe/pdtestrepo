import { Navigate, Route,  Routes, BrowserRouter  } from 'react-router-dom'
import './App.css'
import Home from './Home'
import UserDetail from './components/user-management/UserDetail'
import CreateUser from './components/user-management/CreateUser'

function App() {
  
  return (  

    <BrowserRouter  >
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/create" element={<CreateUser />} />
        <Route path="/detail/:id" element={<UserDetail />} />
        <Route path="/" element={<Navigate to="/home" replace />} />
        <Route path="*" element={<div>404 - Not Found</div>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
