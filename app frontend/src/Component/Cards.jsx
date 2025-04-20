import React, { useState } from 'react'

export default function ({ item }) {

    function getOrder() {
        alert("order placed sucessfully")
    }

    return (
        <div className="card bg-light-green" style={{ width: "18rem" }}>
            <h5 className="card-header">{item.itemName}</h5>
            <div className="card-body">
                <p className="card-text">{item.description}</p>
                <p className='fw-bold'>Rs {item.price}</p>
                <p className={`${item.status == "AVAILABLE" ? "text-success" : "text-danger" } fw-bold`}>{item.status}</p>
                <button onClick={() => { getOrder() }} className="btn btn-success"disabled = {item.status != "AVAILABLE"} >Order Now</button>
            </div>
        </div>
    )
}
