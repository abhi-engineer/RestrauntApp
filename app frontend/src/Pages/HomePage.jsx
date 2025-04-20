import React, { useEffect, useState } from 'react'
import Cards from '../Component/Cards'
import { getItems } from '../service/ItemService'

export default function HomePage() {
    const [items, setItems] = useState([])

    useEffect(() => {
        const fetchedItems = async () => {
            try {
                const response = await getItems()
                setItems(response.data)
            }
            catch (error) {
                alert(`"Items not loaded:\n${error?.response?.data?.errorMsg || error.message}`)
            }
        }

        fetchedItems()
    }, [])

    return (
        <div>
            <h1 className='text-center text-success mt-5'>Restraunt App</h1>
            <div className="container my-5 d-flex justify-content-center">
                <div className='d-flex gap-5 flex-wrap justify-content-between'>
                    {
                        items.map((item,index)=> (
                            <Cards name={"item"} key={index} item={item} />
                        ))
                    }
                    
                </div>
            </div>
        </div>
    )
}
