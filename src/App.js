// import './styles.css';
import 'bootstrap/dist/css/bootstrap.css'
import Button from '@mui/material/Button'
import Layout from './components/Layout'
import Dashboard from "./components/Dashboard"
import Account from "./components/Account"
import Nav from "./components/Nav"
import Navbar from "./components/Navbar"
import { Router, Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path='/' element={<Dashboard />} />
        <Route path='/account' element={<Account />} />
      </Routes>
    </>
  )
};

export default App;
