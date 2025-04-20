import React, { useState } from 'react'
import { login } from '../service/AdminService';
import { useNavigate } from 'react-router-dom';

export default function Login() {

    const [loading, setLoading] = useState(false)
    const navigate = useNavigate()
    const [data, SetData] = useState({
        email: "",
        password: ""
    });

    function handleChange(e) {
        SetData({ ...data, [e.target.name]: e.target.value })  // email : value and password : value
    }

    async function handleSubmit(event) {
        event.preventDefault();
        setLoading(true)
        try {
            const response = await login(data)
            localStorage.setItem('email', response.email)
            navigate("/adminPortal")
            setLoading(false)
        }
        catch (error) {
            alert(`Login failed:\n${error.response?.data?.errorMsg || error.message}`);
            //here errorMsg the variable in which i declared in the ErrorInfo class to store the msg.
            setLoading(false)
        }

    }


    return (
        <div>
            <div className="container d-flex justify-content-center align-items-center" style={{ height: "81vh" }}>
                <div className="card p-4 shadow" style={{ width: "500px", maxWidth: "400px" }}>
                    <h3 className="text-center mb-4">Admin Login</h3>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="adminEmail" className="form-label">Email address</label>
                            <input type="email" className="form-control" id="adminEmail" placeholder="Enter admin email" required name='email' value={data.email} onChange={handleChange} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="adminPassword" className="form-label">Password</label>
                            <input type="password" className="form-control" id="adminPassword" placeholder="Enter password" required name='password' value={data.password} onChange={handleChange} />
                        </div>
                        <button type="submit" className="btn btn-success w-100">
                            {loading ? "Loading...." : "Login"}
                        </button>
                    </form>
                </div>
            </div>

        </div>
    )
}
