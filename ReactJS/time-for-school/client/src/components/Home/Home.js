import { Link } from "react-router-dom";

export const Home = () => {
  return (
    <div className="container-fluid">
        <h5 className="text-center text-white mt-5 align-content-center">
            Време е за училище!
        </h5>
        <div className="container-schools">
            <form className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center">
                <div className="form-group">
                    <h4 className="text-white">Намери най - подходящото училище</h4>
                    <h5 className="text-white">
                    Скъпи, родители и ученици, в тази секция ще намерите най -
                    подходящото училище, спрямо профилът му и местоположение.
                    </h5>
                </div>

                <div className="row">
                    <div className="col col-md-4">
                        <div className="button-holder d-flex">
                            <Link className="btn btn-info btn-lg" to="/schools/all">Намери училище</Link>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div className="container-offers">
            <form className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center">
                <div className="form-group">
                    <h4 className="text-white">
                    Търсите подходящ курс за Вас или Вашето дете{" "}
                    </h4>
                    <h5 className="text-white">
                    Тук ще намерите подходящи курсове, спрямо Вашите потребности и
                    желания, като ще може да търсите по различни критерии.
                    </h5>
                </div>

                <div className="row">
                    <div className="col col-md-4">
                        <div className="button-holder d-flex">
                            <Link className="btn btn-info btn-lg" to="/offers/all">Намери курс</Link>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
  );
};
