import { Link } from "react-router-dom";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

import { OfferItem } from "./OfferItem/OfferItem";

let filteredOffers = "";
let filteredOffersForPagination = "";
let filteredPaginatedOffers = "";

const FilterFormKeys = {
    Name: "name",
};


export const OfferList = ({
    offers,
}) => {
    const [pageNumber, setPageNumber] = useState(1);
    const [postNumber, setPostNumber] = useState(2);

    const navigate = useNavigate();

    const pageOffset = 2;

    let offersForPagination = offers;

    //Filter logic
    const [values, setValues] = useState({
        [FilterFormKeys.Name]: "",
    });

    const changeHandler = (e) => {
        setValues(state => ({...state, [e.target.name]: e.target.value}));
    };

    const onSubmit = (e) => {
        e.preventDefault()

        const offerNameFilter = values.name;
debugger
        if(offerNameFilter) {
            filteredOffers = offers.filter(x => 
                x.course.toLowerCase().includes(offerNameFilter.toLowerCase()));  

                if(filteredOffers.length === 0) {
                    window.alert(`Курс с име "${offerNameFilter}" не е намерен!`);
                }
        } else {
            filteredOffers = offers;
        }

        if(filteredOffers) {
            offersForPagination = filteredOffers;
        } 

        navigate('/offers/all');
    }

    //Pagination
    const currentPageNumber = pageNumber * pageOffset - pageOffset;
    let paginatedOffers = offersForPagination.slice(currentPageNumber, postNumber);

    filteredOffersForPagination = filteredOffers;
    filteredPaginatedOffers = filteredOffersForPagination.slice(currentPageNumber, postNumber);

    const totalPageNumbers = filteredOffers.length === 0 ?
        Math.ceil(offersForPagination.length / pageOffset) :
        Math.ceil(filteredOffersForPagination.length / pageOffset);


    const handlePrev = () => {
        return (
        setPageNumber(pageNumber => pageNumber - 1),
        setPostNumber(postNumber => postNumber - pageOffset)
        )
    };
    const handleNext = () => {
        return (
        setPageNumber(pageNumber => pageNumber + 1),
        setPostNumber(postNumber => postNumber + pageOffset)
        )
    };


    return (
        <div className="container-fluid">
            <h2 className="text-center text-white mt-5">Всички курсове</h2>
            <div className="card-body.search text-center">
                <Link className="card-link" to={"/"}>Назад</Link>
            </div>
            <form
                className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center"
                onSubmit={onSubmit}>

                <div>
                    <label className="mr-sm-2 text-center text-white font-weight-bold" htmlFor="name"></label>
                    <input
                        className="form-control mr-sm-2"
                        style={{width: '280px'}}
                        type="search"
                        placeholder="Име на курс..."
                        aria-label="Search"
                        id="name"
                        name="name"
                        value={values[FilterFormKeys.Name]}
                        onChange={changeHandler}
                    />
                </div>

                <div className="search-but">
                    <div className="col col-md-4 ">
                        <button className="btn btn-info btn-lg" type="submit">Филтрирай</button>
                    </div>
                </div>
            </form>
            <div className="text-center text-white mt-5">Page {pageNumber} (from {totalPageNumbers}) </div>
            <div className="text-center">
                {pageNumber <= 1 ? 
                <button disabled={true}>prev</button>
                : <button onClick={handlePrev}>prev</button>}
                {pageNumber >= totalPageNumbers ? 
                <button disabled={true}>next</button>
                : <button onClick={handleNext}>next</button>}
                </div>
        
            {/* {paginatedOffers.map(x => (
                <OfferItem key={x._id} offer_id={x._id} {...x}/>
            ))} */}

            {filteredOffers.length === 0 
                ? paginatedOffers.map((x) => (
                    <OfferItem schoolId={x._id} key={x._id} {...x} />))
                : filteredPaginatedOffers.map((x) => (
                    <OfferItem schoolId={x._id} key={x._id} {...x} />
                ))}

        </div>
    );
}