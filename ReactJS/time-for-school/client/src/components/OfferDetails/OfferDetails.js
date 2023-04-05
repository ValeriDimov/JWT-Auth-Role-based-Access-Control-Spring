import { Link, useNavigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";

import { useService } from "../../hooks/useService";
import { offerServiceFactory } from "../../services/offerService"
import { useAuthContext } from "../../contexts/AuthContext";
import { useOfferContext } from "../../contexts/OfferContext";

export const OfferDetails = () => {
    const { offerId } = useParams();
    const { userId, isAuthenticated, name } = useAuthContext();
    const { deleteOffer } = useOfferContext();

	const [offer, setOffer] = useState({});
    const offerService = useService(offerServiceFactory);
    const navigate = useNavigate();

    const isOwner = offer._ownerId === userId;

	useEffect(() => {
        offerService.getOne(offerId)
            .then(result => {
                setOffer(result)
            })
    }, [offerId]);

    const onDeleteSubmit = async (e) => {
        e.preventDefault();

        const result = window.confirm(`Are you sure you want to delete ${offer.course}`);

        if (result) {
            await offerService.delete(offer._id);
        }

        deleteOffer(offer._id);

        navigate("/offers/all");
    };

    // TODO: Commments implementation

    return (
        <div className="container-fluid">
            <h2 className="text-center text-white mt-5">
            Детайли
            </h2>
            <div className="offers row mx-auto d-flex flex-row justify-content-center">
                <div className="offer card col-sm-4 col-md-6  col-lg-8 m-1 p-0">
                    <div className="card-body pb-1">
                        <h4 className="card-title text-center">
                            <span>{offer.course}</span>
                        </h4>
                        <h5 className="card-title text-center">
                            <span>{offer.name}</span>
                        </h5>
                    </div>
                    <ul className="offer-details list-group list-group-flush">
                        <li className="list-group-item">
                            <h6 className="card-text">
                                <span> - Описание на курса: </span>
                            </h6>
                            <div className="card-text">
                                <span>
                                    <span>{offer.description}</span>
                                </span>
                            </div>
                            <h6 className="card-text">
                                <span> - Контакти: </span>
                            </h6>
                            <div className="card-text">
                                    <span>{offer.contact}</span>        
                            </div>
                        </li>
                    </ul>
                    {isOwner && (
                        <div className="card-body">
                            <form 
                            method="DELETE"
                            onSubmit={onDeleteSubmit}>
                                <div className="row">
                                    <div className="col col-md-4">
                                        <div className="button-holder d-flex">
                                            <input
                                                type="submit"
                                                className="btn btn-info btn-lg"
                                                value="Изтрий"
                                            />
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    )}

                    {isOwner && (
                        <form>
                            <div className="row">
                                <div className="col col-md-4">
                                    <div className="button-holder d-flex">
                                         <Link
                                            className="btn btn-info btn-lg"
                                            to={`/offers/${offerId}/edit`}
                                            >Редактирай/обнови оферта
                                        </Link>
                                    </div>
                                </div>
                            </div>
                        </form>
                    )}

                
                    {/* {isAuthenticated && <AddComment onCommentSubmit={onCommentSubmit} />} */}

                    <div className="card-body">
                        <Link
                            className="card-link"
                            to="/offers/all"
                        >Назад</Link>
                    </div>
                </div>
            </div>
        </div>
    );
};
