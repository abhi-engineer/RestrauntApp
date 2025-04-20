import axios from "axios";

const baseUrl = "http://localhost:8080/admin/"



export const login = async (data) => {
    try{
        const response = await axios.post(`${baseUrl}login`,data)
        return response.data
    }catch(error){
        throw error
    }
} 
