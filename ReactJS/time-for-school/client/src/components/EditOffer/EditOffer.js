import { useParams, Link } from "react-router-dom";
import { useEffect } from "react";

import { useOfferContext } from "../../contexts/OfferContext";
import { useService } from "../../hooks/useService";
import { offerServiceFactory } from "../../services/offerService";

import { useForm } from "../../hooks/useForm";
import { useAuthContext } from "../../contexts/AuthContext";

import styles from './EdithOffer.module.css';

export const EdithOffer = () => {
    const { onOfferEditSubmit } = useOfferContext();
    const { isAuthenticated, name } = useAuthContext();
    const { offerId } = useParams();
    const offerService = useService(offerServiceFactory);

    const { values, changeHandler, changeValues,  onSubmit } = useForm({
        course: '',
        description: '',
        contact: '',
        name,
    }, onOfferEditSubmit);

    useEffect(() => {
        offerService.getOne(offerId)
            .then(result => {
                changeValues(result);
            });
    }, [offerId]);
 
    return (
        <div className="container">
            <h2 className="text-center text-white">
            Редактирай обява
            </h2>

            <form
                method="POST" 
                onSubmit={onSubmit}
                className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center"
            >
                <div className="form-group">
                    <label
                        className="text-white font-weight-bold"
                        htmlFor="course"
                    >Име на курс
                    </label>
                    <input
                        id="course"
                        type="text"
                        value={values.course} 
                        onChange={changeHandler}
                        name="course"
                        className="form-control"
                    />
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Име на курс е задължително.</span>
                    </p>
                </div>

                <div className="form-group">
                    <label
                        className="text-white font-weight-bold"
                        htmlFor="description"
                    >Описание
                    </label>
                    <textarea
                        id="description"
                        type="textarea"
                        value={values.description} 
                        onChange={changeHandler}
                        name="description"
                        className="form-control"
                        rows="3"
                    ></textarea>
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Описанието е задължително.</span>
                    </p>
                </div>

                <div className="form-group">
                    <label
                        className="text-white font-weight-bold"
                        htmlFor="description"
                    >Контакти
                    </label>
                    <textarea
                        id="contact"
                        type="textarea"
                        value={values.contact} 
                        onChange={changeHandler}
                        name="contact"
                        className="form-control"
                        rows="3"
                    ></textarea>
                    <p className="invalid-feedback errors alert alert-danger">
                        <span>Контактите са задължителни.</span>
                    </p>
                </div>

                {isAuthenticated 
                ?
                <div className="row">
                <div className="col col-md-4">
                    <div className="button-holder d-flex">
                        <input
                            type="submit"
                            className="btn btn-info btn-lg"
                            value="Редектирай"
                        />
                    </div>
                </div>
            </div>
            : <div className={styles['non-authrized']}>Моля влезте във Вашия профил, за да публикувате обява!</div>
                }
                
                <div className="row">
                    <div className="card-body">
                        <Link
                        className="card-link"
                        to={`/offers/${offerId}`}
                        >Назад</Link>
                    </div>
                </div>
            </form>
        </div>
    );
}; 