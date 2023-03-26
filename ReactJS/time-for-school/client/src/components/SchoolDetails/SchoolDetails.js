import { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';

import { schoolServiceFactory } from '../../services/schoolService';
// import * as schoolServiceFactory from '../../services/schoolService';
// import * as commentService from '../../services/commentService';
import { useService } from '../../hooks/useService';

export const SchoolDetails = () => {
    const { schoolId } = useParams();
    // const { userId, isAuthenticated, userEmail } = useAuthContext();
	const [school, setSchool] = useState({});
    const schoolService = useService(schoolServiceFactory)
    const navigate = useNavigate();

	useEffect(() => {
        schoolService.getOne(schoolId)
            .then(result => {
                setSchool(result)
            })
    }, [schoolId]);
           

    return (
        <div className="container-fluid">
            <h2 className="text-center text-white mt-5">Детайли</h2>
            <div className="offers row mx-auto d-flex flex-row justify-content-center">
                <div className="offer card col-sm-4 col-md-6 col-lg-8 m-1 p-0">
                    <div className="card-body pb-1">
                        <h4 className="card-title text-center">
                            <tblock>{school.name}</tblock>
                        </h4>
                        <h5 className="card-title text-center">
                            <block>{school.city}</block>
                        </h5>
                        <h5 className="card-title text-center">
                            <block>{school.district}</block>
                        </h5>
                        <h6 className="card-title text-center"><span> - Уебсайт на училището: </span>
                            <span><block>{school.school_url}</block></span>
                        </h6>
                    </div>

                    <h6 className="card-title"><span> - Обучителнен профил: </span></h6>
                    <ul className="offer-details list-group list-group-flush">
                        <li className="list-group-item">
                            <div className="card-text"><span><block>{school.profile}</block></span>
                            </div>
                        </li>
                    </ul>
                    <h6 className="card-title"><span> - Директор: </span>
                        <span><block></block>{school.director}</span></h6>
                    <h6 className="card-title"><span> - Телефон: </span>
                        <span><block>{school.telephone}</block></span></h6>
                    <h6 className="card-title"><span> - Имейл: </span>
                        <span><block>{school.email}</block></span></h6>
                    <h6 className="card-title"><span> - Адрес: </span>
                        <span><block>{school.address}</block></span></h6>

                    <div className="card-body">
                        <Link className="card-link" to="/schools/all">Назад</Link>
                    </div>
                </div>
            </div>
        </div>
    );
};