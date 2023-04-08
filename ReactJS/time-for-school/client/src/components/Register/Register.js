import { useContext, useState } from "react";
import { Link } from "react-router-dom";

import { useForm } from "../../hooks/useForm";
import { AuthContext } from "../../contexts/AuthContext";

import styles from "./Register.module.css";

let nameField = "";

export const Register = () => {
    const [errorField, setErrorField] = useState();
    const { onRegisterSubmit } = useContext(AuthContext);
    const { values, changeHandler, onSubmit } = useForm({
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
    }, onRegisterSubmit);


    const onBlurHandlerName = (e) => {
        if (e.target.value.length < 5) {
            nameField = "Потребителското име трябва да бъде минимум 5 символа"
            setErrorField(nameField);
        } else {
            nameField = ""
            setErrorField(nameField);
        }
    }

    const onBlurHandlerEmail = (e) => {
        if (!e.target.value.includes("@")) {
            nameField = `Вашият имейл адрес трябва да съдържа "@"`;
            setErrorField(nameField);
        } else {
            nameField = ""
            setErrorField(nameField);
        }
    }

    const onBlurHandlerPass = (e) => {
        if (e.target.value.length < 5) {
            nameField = "Паролата трябва да бъде минимум 5 символа";
            setErrorField(nameField);
        } else {
            nameField = "";
            setErrorField(nameField);
        }
    }

    const onBlurHandlerPassConfirm = () => {
        if (values.password !== values.confirmPassword) {
            nameField = "Потвърждението на паролата трябва да съвпада с въведената парола";
            setErrorField(nameField);
        } else {
            nameField = "";
            setErrorField(nameField);
        }
    }

    return (
    <div className="container">
        <h2 className="text-center text-white">Регистрация на потребител</h2>
        <h6 className="text-center text-white">Регистрационната форма е предназначена за учебни центрове и учители с цел публикуване на обяви, както и за всички потребители, които желаят да оставят коментари</h6>
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
                        onChange={changeHandler}
                        onBlur={onBlurHandlerName}/>

                    {errorField === "Потребителското име трябва да бъде минимум 5 символа" && (
                        <p className={styles['error-field-name']}>
                        <span>{errorField}</span>
                    </p>
                    )}
                    
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
                        onBlur={onBlurHandlerEmail}/>

                    {errorField === `Вашият имейл адрес трябва да съдържа "@"` && (
                        <p className={styles['error-field-name']}>
                        <span>{errorField}</span>
                    </p>
                    )}
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
                        onBlur={onBlurHandlerPass}/>

                        {errorField === "Паролата трябва да бъде минимум 5 символа" && (
                        <p className={styles['error-field-name']}>
                            <span>{errorField}</span>
                        </p>
                    )}
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
                        onBlur={onBlurHandlerPassConfirm}/>

                        {errorField === "Потвърждението на паролата трябва да съвпада с въведената парола" && (                        
                            <p className={styles['error-field-name']}>
                                <span>{errorField}</span>
                            </p>)
                        }
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