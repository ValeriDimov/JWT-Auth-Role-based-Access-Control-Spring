import { Link } from "react-router-dom";

export const OfferItem = ({
    course,
    description,
    contact,
    _id,
    name,
}) => {
    return (
        <div className="offers row mx-auto d-flex flex-row justify-content-center">
            <div className="offer card col-sm-4 col-md-6  col-lg-8 m-1 p-0">
                <div className="card-body pb-1">
                    <h4 className="card-title text-center">
                        <span>{course}</span>
                    </h4>
                    <h5 className="card-title text-center">
                        <span>{name}</span>
                    </h5>
                </div>
                <ul className="offer-details list-group list-group-flush">
                    <li className="list-group-item">
                        <h6 className="card-text"><span> - Описание на курса:</span>
                        </h6>
                        <div className="card-text"><span>{description}</span>
                        </div>
                        <h6 className="card-text"><span> - Контакти: </span>
                        </h6>
                        <div className="card-text"><span>{contact}</span>
                        </div>
                    </li>
                </ul>
                <div className="card-body">
                    <Link className="card-link" to={`/offers/${_id}`}
                    >Детайли</Link>
                </div>
            </div>
        </div>
    );
}