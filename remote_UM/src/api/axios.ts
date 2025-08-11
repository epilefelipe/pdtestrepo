import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/v1';

export const api = axios.create({
    baseURL: BASE_URL,
    headers: {
        'Authorization': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJub3NlQGhvbGEuY29tIiwiaWF0IjoxNzU0ODcyNDMzLCJleHAiOjE3NTU3NDI0MzN9.xKKmGO3nwclKqw2xk8KbMAuidSdBrrJD5RzV4cvgJ3c',
        'Content-Type': 'application/json'
    }
})