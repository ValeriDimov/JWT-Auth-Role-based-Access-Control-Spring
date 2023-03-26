import { Link } from "react-router-dom";
import { SchoolItem } from "./SchoolItem/SchoolItem";

export const SchoolList = ({
    schools,
}) => {
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
            <Link
            className="card-link"
            to="/"
            >Назад</Link>
        </div>

        {schools.map(x =>
                <SchoolItem schoolId={x._id} key={x._id} {...x} />
            )}
        
    </div>
  );
};
