// import './styles.css';
import 'bootstrap/dist/css/bootstrap.css'
import Button from '@mui/material/Button'
import Layout from './components/Layout'
import Dashboard from "./components/Dashboard"
import { Router, Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
        <Routes>
          <Route path='/' element={<Dashboard />} />
        </Routes>
    </>
  )
};

export default App;
