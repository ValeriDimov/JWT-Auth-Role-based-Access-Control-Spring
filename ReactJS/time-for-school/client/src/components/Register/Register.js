import { useContext } from "react";
import { Link } from "react-router-dom";

import { useForm } from "../../hooks/useForm";
import { AuthContext } from "../../contexts/AuthContext";

export const Register = () => {
    const { onRegisterSubmit } = useContext(AuthContext);
    const { values, changeHandler, onSubmit } = useForm({
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
    }, onRegisterSubmit);

    return (
    <div className="container">
        <h2 className="text-center text-white">Регистрация на потребител</h2>
        <h6 className="text-center text-white">Регистрационната форма е предназначена само за учебни центрове и учители с цел да могат да регистрират обява</h6>
        <form
            className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center"
            method="post"
            onSubmit={onSubmit}>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label htmlFor="name" className="text-white font-weight-bold">Име</label>
                    <input
                        id="name"
                        name="name"
                        type="text"
                        className="form-control"
                        placeholder="Име"
                        value={values.name}
                        onChange={changeHandler}/>

                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Името е задължително и трябва да бъде между 2 и 20 символа.</span>
                    </p>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label htmlFor="email" className="text-white font-weight-bold">Имейл</label>
                    <input 
                        id="email"
                        name="email"
                        type="email"
                        className="form-control"
                        placeholder="Email"
                        value={values.email}
                        onChange={changeHandler}
                        />
                    <div className="invalid-feedback errors alert alert-danger">
                        
                    </div>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label htmlFor="password" className="text-white font-weight-bold">Парола</label>
                    <input 
                        id="password"
                        name="password"
                        type="password"
                        className="form-control"
                        placeholder="Парола"
                        value={values.password}
                        onChange={changeHandler}
                        />
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Паролата е задължителна и трябва да бъде поне 5 символа.</span>
                    </p>
                </div>
            </div>
            <div className="row">
                <div className="form-group mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <label htmlFor="confirmPassword" className="text-white font-weight-bold">Потвърдете парола</label>
                    <input
                        id="confirmPassword"
                        name="confirmPassword"
                        type="password"
                        className="form-control"
                        placeholder="Потвърдете парола"
                        value={values.confirmPassword}
                        onChange={changeHandler}
                    />
                    ({values.password !== values.confirmPassword ? 
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Паролите трябва да съвпадат</span>
                    </p>
                    : ''
                    })
                </div>
            </div>
            <div className="row">
                <div className="col mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <div className="button-holder d-flex">
                        <input type="submit" className="btn btn-info btn-lg" value="Регистрирай"/>
                    </div>
                </div>
            </div>
            <div className="row">
                <div className="col mx-auto col-md-8 d-flex flex-column justify-content-center">
                    <div className="card-body">
                        <Link className="card-link" to="/">Назад</Link>
                    </div>
                </div>
            </div>
        </form>
</div>
    );
};