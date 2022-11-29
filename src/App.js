// import './styles.css';
import 'bootstrap/dist/css/bootstrap.css'
import Button from '@mui/material/Button'
import Layout from './components/Layout'
import Dashboard from "./components/Dashboard"
import JoinedDashboard from "./components/JoinedDashboard"
import CreatedDashboard from "./components/CreatedDashboard"
import Account from "./components/Account"
import Orders from "./components/Orders"
import Nav from "./components/Nav"
import Navbar from "./components/Navbar"
import { Router, Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path='/' element={<Dashboard />} />
        <Route path='/Joined' element={<JoinedDashboard />} />
        <Route path='/Created' element={<CreatedDashboard />} />
        <Route path='/Orders' element={<Orders />} />
        <Route path='/Account' element={<Account />} />
      </Routes>
    </>
  )
};

export default App;
