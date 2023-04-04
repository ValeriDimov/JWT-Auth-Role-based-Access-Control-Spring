import { createContext, useContext, useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { offerServiceFactory } from '../services/offerService';

export const OfferContext = createContext();

export const OfferProvider = ({
    children,
}) => {
    const navigate = useNavigate();
    const [offers, setOffers] = useState([]);
    const offerService = offerServiceFactory();

    useEffect(() => {
        offerService.getAll()
            .then(result => {
                setOffers(result)
            })
    }, []);

    const onCreateOfferSubmit = async (data) => {
        const newOffer = await offerService.create(data);

        setOffers(state => [...state, newOffer]);

        navigate('/offers/all');
    };

    const onOfferEditSubmit = async (values) => {
        const result = await offerService.edit(values._id, values);

        setOffers(state => state.map(x => x._id === values._id ? result : x))

        navigate(`/offers/${values._id}`);
    };

    const deleteOffer = (offerId) => {
        setOffers(state => state.filter(offer => offer._id !== offerId));
    };

    const getOffer = (offerId) => {
        return offers.find(offer => offer._id === offerId);
    };

    const contextValues = {
        offers,
        onCreateOfferSubmit,
        onOfferEditSubmit,
        deleteOffer,
        getOffer,
    };

    return (
        <OfferContext.Provider value={contextValues}>
            {children}
        </OfferContext.Provider>
    );

};

export const useOfferContext = () => {
    const context = useContext(OfferContext);

    return context;
};