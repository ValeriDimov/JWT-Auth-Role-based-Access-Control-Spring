import { requestFactory } from "./requester";

const baseUrl = "http://localhost:3030/jsonstore/schools";

export const schoolServiceFactory = (token) => {
  const request = requestFactory(token);

  const getAll = async () => {
    const result = await request.get(baseUrl);
    const schools = Object.values(result);

    return schools;
  };

  const getOne = async (schoolId) => {
    const result = await request.get(`${baseUrl}/${schoolId}`);

    return result;
  };

  return {
    getAll,
    getOne,
  };
};
