import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';

import { SchoolItem } from "./SchoolItem/SchoolItem";
import { schoolServiceFactory } from "../../services/schoolService";

const FilterFormKeys = {
    Name: "name",
    District: "district",
    Profile: "profile",
};

let filteredSchools = "";
let filteredSchoolsForPagination = "";
let filteredPaginatedSchools = "";


export const SchoolList = () => {
    const [schools, setSchools] = useState([]);
    const schoolService = schoolServiceFactory();

    const navigate = useNavigate();

    const [pageNumber, setPageNumber] = useState(1);
    const [postNumber, setPostNumber] = useState(10);
   
    const pageOffset = 10;

    let schoolsForPagination = schools;

    useEffect(() => {
        schoolService.getAll().then((result) => {
        setSchools(result);
        });
    }, []);

    //Filter logic
    let schoolDistricts =
        schools
            .map(s => s.district)
            .filter((item, index, arr) => arr.indexOf(item) === index);

    let schoolProfiles =
        schools
            .map(s => s.profile)
            .filter((item, index, arr) => arr.indexOf(item) === index);

    const [values, setValues] = useState({
        [FilterFormKeys.Name]: "",
        [FilterFormKeys.District]: "",
        [FilterFormKeys.Profile]: "",
    });

    const changeHandler = (e) => {
        setValues(state => ({...state, [e.target.name]: e.target.value}));
    };

    const onSubmit = (e) => {
        e.preventDefault()

        const schoolNameFilter = values.name;
        const schoolDistrictFilter = values.district;
        const schoolProfileFilter = values.profile;

        if(schoolNameFilter) {
            filteredSchools = schools.filter(x => 
                x.name.toLowerCase().includes(schoolNameFilter.toLowerCase()));  

            if(schoolDistrictFilter) {
                filteredSchools = filteredSchools.filter(x => 
                    x.district.includes(schoolDistrictFilter));  
            }

            if(schoolProfileFilter) {
                filteredSchools = filteredSchools.filter(x => 
                    x.profile.includes(schoolProfileFilter));
            }
       
            if(filteredSchools.length === 0) {
                if(!schoolDistrictFilter && !schoolProfileFilter) {
                    window.alert(`Училище с име "${schoolNameFilter}" не е намерено!`);

                } else if(schoolDistrictFilter && !schoolProfileFilter){
                    window.alert(`Училище съдържащо в името "${schoolNameFilter}" в район "${schoolDistrictFilter}" не е намерено!`);

                } else if(!schoolDistrictFilter && schoolProfileFilter) {
                    window.alert(`Училище съдържащо в името "${schoolNameFilter}" и с обучителен профил "${schoolProfileFilter}" не е намерено!`);

                } else {
                    window.alert(`Училище съдържащо в името "${schoolNameFilter}", в район "${schoolDistrictFilter}" и с обучителен профил "${schoolProfileFilter}" не е намерено!`);
                }
            }

        } else {
            filteredSchools = schools;
        }

        if(!schoolNameFilter && schoolDistrictFilter) {
            filteredSchools = schools.filter(x => 
                x.district.includes(schoolDistrictFilter));  
        }

        if(!schoolNameFilter && schoolProfileFilter) {
            filteredSchools = schools.filter(x => 
                x.profile.includes(schoolProfileFilter));  
        }

        if(!schoolNameFilter && schoolDistrictFilter && schoolProfileFilter) {
            filteredSchools = schools.filter(x => 
                x.district.includes(schoolDistrictFilter));  

            filteredSchools = filteredSchools.filter(x => 
                x.profile.includes(schoolProfileFilter));  

            if(filteredSchools.length === 0) {
                window.alert(`Училище в район "${schoolDistrictFilter}" и с обучителен профил "${schoolProfileFilter}" не е намерено!`);
                
                filteredSchools = schools;
            }
        }

        if(filteredSchools) {
            schoolsForPagination = filteredSchools;
        } 

        navigate('/schools/all');
    };

    //Pagination
    const currentPageNumber = pageNumber * pageOffset - pageOffset;
    let paginatedSchools = schoolsForPagination.slice(currentPageNumber, postNumber);

    filteredSchoolsForPagination = filteredSchools;
    filteredPaginatedSchools = filteredSchoolsForPagination.slice(currentPageNumber, postNumber);

    const totalPageNumbers = filteredSchools.length === 0 ?
        Math.ceil(schoolsForPagination.length / pageOffset) :
        Math.ceil(filteredSchoolsForPagination.length / pageOffset);

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
                
                <div className="container">
                    <h2 className="text-center text-white">Намери училище</h2>
                    <div className="card-body.search text-center">
                    <Link className="card-link" to="/">
                    Назад
                    </Link>
                        <form
                                className="form-inline"
                                style={{justifyContent: 'center', marginTop: '50px'}}
                                onSubmit={onSubmit}
                                >
                                
                                <div>
                                    <label className="mr-sm-2 text-center text-white font-weight-bold" htmlFor="name"></label>
                                    <input
                                            className="form-control mr-sm-2"
                                            style={{width: '280px'}}
                                            type="search"
                                            placeholder="Име на училище..."
                                            aria-label="Search"
                                            id="name"
                                            name="name"
                                            value={values[FilterFormKeys.Name]}
                                            onChange={changeHandler}
                                    />
                                </div>

                            <label className="mr-sm-2 text-center text-white font-weight-bold" htmlFor="district">
                                <select
                                        id="district"
                                        name="district"
                                        className="form-control"
                                        value={values[FilterFormKeys.District]}
                                        onChange={changeHandler}
                                        >
                                    <option value="">-- Избери Район --</option>
                                    
                                    {schoolDistricts.map((x) => (
                                        <option value={x} key={x.index}>{x}</option>
                                    ))}

                                </select>
                            </label>

                            <label className="text-center text-white font-weight-bold" htmlFor="profile">
                                <select
                                        id="profile"
                                        name="profile"
                                        className="form-control"
                                        value={values[FilterFormKeys.Profile]}
                                        onChange={changeHandler}
                                        >
                                    <option value="">-- Избери обучителен профил --</option>

                                    {schoolProfiles.map((x) => (
                                        <option value={x}  key={x.index}>{x}</option>
                                    ))}

                                </select>
                            </label>

                            <div className="search-but">
                                <div className="col col-md-4 ">
                                    <button className="btn btn-info btn-lg" type="submit">Филтрирай</button>

                                </div>
                            </div>
                        </form>
                    </div>


                    <div className="text-center text-white mt-5">Page {pageNumber} (from {totalPageNumbers}) </div>
                    <div className="text-center">
                        {pageNumber <= 1 ? 
                        <button disabled={true}>prev</button>
                        : <button onClick={handlePrev}>prev</button>}
                        {pageNumber >= totalPageNumbers ? 
                        <button disabled={true}>next</button>
                        : <button onClick={handleNext}>next</button>}
                    </div>
                </div>

                {filteredSchools.length === 0 
                    ? paginatedSchools.map((x) => (
                        <SchoolItem schoolId={x._id} key={x._id} {...x} />))
                    : filteredPaginatedSchools.map((x) => (
                        <SchoolItem schoolId={x._id} key={x._id} {...x} />
                ))}

            </div>
    );
};
