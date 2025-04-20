import React, { useEffect, useState } from 'react'
import { getItems, updateStatus } from '../service/ItemService'

export default function AdminPortal() {
    const [items, setItems] = useState([])

    const handleChange = (index, e) => {
        const updatedStatus = e.target.checked ? "AVAILABLE" : "OUT_OF_STOCK"
        const updatedItems = [...items]
        updatedItems[index].status = updatedStatus
        setItems(updatedItems)
    }

    const update = async () => {
        const updatedItems = items          // passing only changed status items
            .filter(item => item.status === "AVAILABLE" || item.status === "OUT_OF_STOCK")
            .map(item => ({ itemName: item.itemName, status: item.status }));
            
        try {
            await updateStatus(updatedItems)
            alert('Stock updated successfully!')
        } catch (error) {
            alert('Error updating stock')
        }
    }

    useEffect(() => {
        const fetchItems = async () => {
            try {
                const response = await getItems()
                setItems(response.data)
            } catch (error) {
                alert('Error loading items')
            }
        }

        fetchItems()
    }, [])

    return (
        <div className='container my-5'>
            <h1 className='text-center text-success'>Admin Portal</h1>
            <table className='table mt-5 text-center table-bordered table-hover'>
                <thead className='table-success'>
                    <tr>
                        <th>Sr No.</th>
                        <th>Item Name</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th>Available</th>
                    </tr>
                </thead>
                <tbody>
                    {items.map((item, index) => (
                        <tr key={index}>
                            <td>{index + 1}</td>
                            <td>{item.itemName}</td>
                            <td>{item.description}</td>
                            <td>{item.status}</td>
                            <td>
                                <input
                                    type="checkbox"
                                    checked={item.status === "AVAILABLE"}
                                    onChange={(e) => handleChange(index, e)}
                                />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className='d-flex flex-row-reverse'>
                <button className='btn btn-success' onClick={update}>Update Stock</button>
            </div>
        </div>
    )
}
