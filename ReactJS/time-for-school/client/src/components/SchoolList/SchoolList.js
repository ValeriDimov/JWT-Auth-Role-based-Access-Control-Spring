import { Link } from "react-router-dom";
import { useState, useEffect } from "react";

import { SchoolItem } from "./SchoolItem/SchoolItem";
import { schoolServiceFactory } from "../../services/schoolService";

export const SchoolList = () => {
    const [schools, setSchools] = useState([]);
    const schoolService = schoolServiceFactory();

    const [pageNumber, setPageNumber] = useState(1);
    const [postNumber, setPostNumber] = useState(10);
    const pageOffset = 10;
    
    const schoolsForPagination = schools;

    const currentPageNumber = pageNumber * pageOffset - pageOffset;
    const paginatedSchools = schoolsForPagination.slice(currentPageNumber, postNumber);

    const handlePrev = () => {
        return setPageNumber(pageNumber => pageNumber - 1);
    };
    const handleNext = () => {
        return (
        setPageNumber(pageNumber => pageNumber + 1),
        setPostNumber(postNumber => postNumber + pageOffset)
        )
    };

    useEffect(() => {
        schoolService.getAll().then((result) => {
        setSchools(result);
        });
    }, []);

    return (
            <div className="container-fluid">
                <form
                    method="get"
                    className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center"
                >
                    <div className="row">
                    <div className="col col-md-4 ">
                        <div className="button-holder d-flex justify-content-center">
                        <input
                            type="submit"
                            className="btn btn-info btn-lg "
                            value="Търси училища"
                        />
                        </div>
                    </div>
                    </div>
                </form>
                <h2 className="text-center text-white mt-5">Всички училища</h2>
                <div className="card-body.search text-center">
                    <Link className="card-link" to="/">
                    Назад
                    </Link>
                    <div className="text-center text-white mt-5">Page {pageNumber} </div>
                    <div>
                        {pageNumber <= 1 ? 
                        <button disabled="true">prev</button>
                        : <button onClick={handlePrev}>prev</button>}
                        {pageNumber >= Math.ceil(schoolsForPagination.length / pageOffset) ? 
                        <button disabled="true">next</button>
                        : <button onClick={handleNext}>next</button>}
                        {/* <button onClick={handleNext}>next</button> */}
                    </div>
                </div>

                {paginatedSchools.map((x) => (
                    <SchoolItem schoolId={x._id} key={x._id} {...x} />
                ))}

            </div>
    );
};
