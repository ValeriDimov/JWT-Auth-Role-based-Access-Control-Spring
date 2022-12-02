import * as api from "./api.js";

const endpoint = {
    'catalog': 'data/offers?sortBy=_createdOn%20desc',
    'create': 'data/offers',
    'getById': 'data/offers/',
    'apply': `data/applications`,
    'applicationsCount': (offerId) => `data/applications?where=offerId%3D%22${offerId}%22&distinct=_ownerId&count`,
    'userApplied': (offerId, userId) => `data/applications?where=offerId%3D%22${offerId}%22%20and%20_ownerId%3D%22${userId}%22&count`
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

export async function sendApplication(offerId) {
    const result = await api.post(endpoint.apply, { offerId });
    return result;
}

export async function getApplicationsCount(offerId) {
    const result = await api.get(endpoint.applicationsCount(offerId));
    return result;
}

export async function getUserApplied(offerId, userId) {
    const result = await api.get(endpoint.userApplied(offerId, userId));
    return result;
}
