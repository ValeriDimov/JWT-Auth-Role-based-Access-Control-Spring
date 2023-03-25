import { Link } from "react-router-dom";

export const Register = () => {
    return (
    <div className="container">
        <h2 className="text-center text-white">Регистрация на потребител</h2>
        <h6 className="text-center text-white">Регистрационната форма е предназначена само за учебни центрове и учители с цел да могат да регистрират обява</h6>
        <form
            method="post"
            className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center">
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label for="name" className="text-white font-weight-bold">Име</label>
                    <input
                            id="name"
                            field="*{name}"
                            errorclassName="is-invalid"
                            type="text"
                            className="form-control"
                            placeholder="Име"/>
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Името е задължително и трябва да бъде между 2 и 20 символа.</span>
                    </p>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label for="email" className="text-white font-weight-bold">Имейл</label>
                    <input id="email"
                        field="*{email}"
                        errorclassName="is-invalid"
                        type="text"
                        className="form-control"
                        placeholder="Email"/>
                    <div className="invalid-feedback errors alert alert-danger">
                        <div
                            each="err : ${#fields.errors('email')}"
                            text="${err}"
                        />
                    </div>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label for="password" className="text-white font-weight-bold">Парола</label>
                    <input id="password"
                        field="*{password}"
                        errorclassName="is-invalid"
                        type="password"
                        className="form-control"
                        placeholder="Парола"/>
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Паролата е задължителна и трябва да бъде поне 5 символа.</span>
                    </p>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label for="confirmPassword" className="text-white font-weight-bold">Потвърдете парола</label>
                    <input
                            id="confirmPassword"
                            field="*{confirmPassword}"
                            errorclassName="is-invalid"
                            type="password"
                            className="form-control"
                            placeholder="Потвърдете парола"
                    />
                    <p if="${passMatcher}" className="invalid-feedback errors alert alert-danger">
                        <span>Паролите трябва да съвпадат</span>
                    </p>
                </div>
            </div>
            <div className="row">
                <div className="col mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <div className="button-holder d-flex">
                        <input type="submit" className="btn btn-info btn-lg" value="Регистрирай"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <div class="card-body">
                        <Link class="card-link" to="/">Назад</Link>
                    </div>
                </div>
            </div>
        </form>
</div>
    );
};