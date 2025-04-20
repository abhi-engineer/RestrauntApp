import axios from "axios";

const baseUrl = "http://localhost:8080/items/"

export const getItems = async () => {
    try {
        const response = await axios.get(`${baseUrl}get`)
        return response
    }
    catch (error) {
        throw error
    }
}

export const updateStatus = async (data) => {
    try {
        const response = await axios.put(`${baseUrl}updateStatus`, data)
        console.log("Update response:", response);
        return response
    }
    catch(error){
        throw error
    }
}