import React from 'react'
import { Link, useNavigate } from 'react-router-dom'

// nav-underline  => provide the underline while hovering and on active link in navbar

export default function Navbar() {

  const navigate = useNavigate()

  const logout = () => {
    localStorage.clear()
    navigate('/login')
  }

  return (
    <nav className="bg-success d-flex justify-content-center align-items-center p-3">
      <div className='d-flex justify-content-between align-items-center text-light flex-wrap gap-5 nav-underline'>
        <Link to='/' className='nav-link fs-5'>Home</Link>
        <Link to='/aboutus' className='nav-link fs-5'>About Us</Link>
        <Link to='/contactus' className='nav-link fs-5'>Contact Us</Link>
        {
          localStorage.getItem('email') ? (
            <div className='d-flex gap-5'>
              <Link to='/adminPortal' className='nav-link fs-5'>Admin Portal</Link>
              <Link to='' onClick={logout} className='nav-link fs-5'>Logout</Link>
            </div>
          ) : (
            <Link to='/login'  className='nav-link fs-5'>login</Link>
          )}

      </div>
    </nav>
  )
}
