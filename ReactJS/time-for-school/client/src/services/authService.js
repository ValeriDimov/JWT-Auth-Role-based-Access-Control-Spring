import { requestFactory } from './requester';

const baseUrl = `http://localhost:3030/users`;

export const authServiceFactory = (token) => {
    const request = requestFactory(token);

    const getOne = async (ownerId) => {
        const result = await request.get(`${baseUrl}/${ownerId}`);
    
        return result;
      };

    return {
        login: (data) => request.post(`${baseUrl}/login`, data),
        register: (data) => request.post(`${baseUrl}/register`, data),
        logout: () => request.get(`${baseUrl}/logout`),
        getOne,
    }
};
