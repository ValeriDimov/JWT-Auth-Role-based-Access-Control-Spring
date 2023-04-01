import { Link } from "react-router-dom";

import { useAuthContext } from "../../contexts/AuthContext";
import { useForm } from "../../hooks/useForm";

const LoginFormKeys = {
    Email: "email",
    Password: "password",
};

export const Login = () => {
  const { onLoginSubmit } = useAuthContext();
  const { values, changeHandler, onSubmit } = useForm(
    {
      [LoginFormKeys.Email]: "",
      [LoginFormKeys.Password]: "",
    },
    onLoginSubmit
  );

  return (
    <>
      <div className="container">
        <h2 className="text-center text-white text=">Вход</h2>
        <form
          className="main-form mx-auto col-md-8 d-flex flex-column justify-content-center"
          method="POST"
          onSubmit={onSubmit}
        >
          <div className="form-group">
            <label htmlFor="email" className="text-white font-weight-bold">
              Имейл адрес
            </label>
            <input
              id="email"
              type="email"
              min="2"
              max="50"
              className="form-control"
              placeholder="Вашето потребителско име"
              name={LoginFormKeys.Email}
              onChange={changeHandler}
            />
          </div>
          <div className="form-group">
            <label
              htmlFor="password"
              className="text-white font-weight-bold"
              text="Парола"
            ></label>
            <input
              id="password"
              type="password"
              min="2"
              max="20"
              className="form-control"
              placeholder="Вашата парола"
              name={LoginFormKeys.Password}
              value={values[LoginFormKeys.Password]}
              onChange={changeHandler}
            />
          </div>

          <p if="${bad_credentials}" className="errors alert alert-danger">
            <span text="Невалидно потребителско име и парола"></span>
          </p>

          <div className="row">
            <div className="col col-md-4">
              <div className="button-holder d-flex">
                <input
                  type="submit"
                  className="btn btn-info btn-lg"
                  value="Вход"
                />
              </div>
            </div>
          </div>
          <div className="card-body">
            <Link className="card-link" to="/">
              Назад
            </Link>
          </div>
        </form>
      </div>
    </>
  );
};
