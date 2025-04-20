import React from 'react'
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import HomePage from './Pages/HomePage'
import Navbar from './Component/Navbar'
import Footer from './Component/Footer'
import Login from './Pages/Login'
import Aboutus from './Pages/Aboutus'
import Contactus from './Pages/Contactus'
import AdminPortal from './Pages/AdminPortal'

export default function App() {
  return (
    <>
    <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path='/' element= {<HomePage/>}/>
        <Route path='/aboutus' element= {<Aboutus/>}/>
        <Route path='/contactus' element= {<Contactus/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/adminPortal' element={<AdminPortal/>}/>
      </Routes>
      <Footer/>
    </BrowserRouter>
    </>
  )
}
