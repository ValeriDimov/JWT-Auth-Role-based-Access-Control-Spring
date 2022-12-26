import * as api from "./api.js";

const endpoint = {
    'catalog': 'data/albums?sortBy=_createdOn%20desc',
    'create': 'data/albums',
    'getById': 'data/albums/',
    'likes': `data/likes`,
    'totalLikesCount': (albumId) => `data/likes?where=albumId%3D%22${albumId}%22&distinct=_ownerId&count`,
    'userLikes': (albumId, userId) => `data/likes?where=albumId%3D%22${albumId}%22%20and%20_ownerId%3D%22${userId}%22&count`
}

export async function createItem(data) {
    const result = await api.post(endpoint.create, data);
    return result;
}

export async function getAllItems() {
    const result = await api.get(endpoint.catalog);
    return result;
}

export async function getById(id) {
    const result = await api.get(endpoint.getById + id);
    return result;
}

export async function updateById(id, data) {
    const result = await api.put(endpoint.getById + id, data);
    return result;
}

export async function deleteById(id) {
    const result = await api.del(endpoint.getById + id);
    return result;
}

export async function sendLike(albumId) {
    const result = await api.post(endpoint.likes, { albumId });
    return result;
}

export async function getTotalLikesCount(albumId) {
    const result = await api.get(endpoint.totalLikesCount(albumId));
    return result;
}

export async function getUserLiked(albumId, userId) {
    const result = await api.get(endpoint.userLikes(albumId, userId));
    return result;
}
