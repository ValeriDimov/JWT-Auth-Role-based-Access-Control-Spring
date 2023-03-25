export const SchoolItem = () => {
    return (
        <div
            th:each="school : ${schools.getContent()}"
            th:object="${school}"
            className="schools row mx-auto d-flex flex-row justify-content-center"
        >
            <div className="offer card col-sm-4 col-md-6  col-lg-8 m-1 p-0">
            <div className="card-body pb-1">
                <h4 className="card-title text-center">
                <th:block th:text="*{name}"></th:block>
                </h4>
                <h5 className="card-title text-center">
                <th:block th:text="*{cityName}"></th:block>
                </h5>
                <h5 className="card-title text-center">
                <th:block th:text="*{districtName}"></th:block>
                </h5>
                <h6 className="card-title text-center">
                <span th:text="#{schools_website}"></span>
                <span>
                    <th:block th:text="*{schoolUrl}"></th:block>
                </span>
                </h6>
            </div>

            <h6 className="card-title">
                <span th:text="#{schools_profiles}"></span>
            </h6>
            <ul
                className="offer-details list-group list-group-flush"
                th:each="schoolProfile : ${school.getSchoolProfiles()}"
            >
                <li className="list-group-item">
                <div className="card-text">
                    <span>
                    <th:block th:text="${schoolProfile.toString()}"></th:block>
                    </span>
                </div>
                </li>
            </ul>
            <div className="card-body">
                <Link
                className="card-link"
                to={`/schools/${id})`}
                th:text="#{schools_details}"
                >
                Details
                </Link>
            </div>
            </div>
        </div>
    );
};