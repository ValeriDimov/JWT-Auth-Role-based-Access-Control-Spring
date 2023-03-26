import { useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";
import { schoolServiceFactory } from "../services/schoolService";

export const useService = (schoolServiceFactory) => {
    const { token } = useContext(AuthContext)

    const service = schoolServiceFactory(token);

    return service;
};