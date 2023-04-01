import { Link } from "react-router-dom";

export const SchoolItem = ({
        // address,
        // director,
        // email,
        // telephone,
        name,
        school_url,
        city,
        district,
        profile,
        _id
    }) => {
    return (
        <div
            className="schools row mx-auto d-flex flex-row justify-content-center"
        >
            <div className="offer card col-sm-4 col-md-6 col-lg-8 m-1 p-0">
            <div className="card-body pb-1">
                <h4 className="card-title text-center">
                <p>{name}</p>
                </h4>
                <h5 className="card-title text-center">
                <p>{city}</p>
                </h5>
                <h5 className="card-title text-center">
                <p>{district}</p>
                </h5>
                <h6 className="card-title text-center">
                <span> - Уебсайт на училището: </span>
                <span>
                    <div>{school_url}</div>
                </span>
                </h6>
            </div>

            <h6 className="card-title">
                <span> - Обучителен профил: </span>
            </h6>
            <ul
                className="offer-details list-group list-group-flush"
            >
                <li className="list-group-item">
                <div className="card-text">
                    <span>
                    <div>{profile}</div>
                    </span>
                </div>
                </li>
            </ul>
            <div className="card-body">
                <Link
                className="card-link"
                to={`/schools/${_id}`}
                >
                Детайли
                </Link>
            </div>
            </div>
        </div>
    );
};