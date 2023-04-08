import { requestFactory } from './requester';

const baseUrl = 'http://localhost:3030/data/comments';
const request = requestFactory();

export const getAll = async (offerId) => {
    
    const searchQuery = encodeURIComponent(`offerId="${offerId}"`);
    const relationQuery = encodeURIComponent(`author=_ownerId:users`);

    const result = await request.get(`${baseUrl}?where=${searchQuery}&load=${relationQuery}`);
    const comments = Object.values(result);

    return comments;
};

export const create = async (offerId, comment) => {
    
    const result = await request.post(baseUrl, { offerId, comment });

    return result;

};

export const deleteComment = async (commentId) => {
    
    const result = await request.delete(`${baseUrl}/${commentId}`);

    return result;

};