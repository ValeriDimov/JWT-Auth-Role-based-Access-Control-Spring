import { useNavigate, useParams } from "react-router-dom";

import * as commentService from "../../../services/commentService";

export const DeleteComment = ({offerOwnerId, x}) => {
    const { offerId } = useParams();
    const navigate = useNavigate();

    const onDeleteCommentSubmit = async (e) => {
        e.preventDefault();

        const result = window.confirm(`Are you sure you want to delete this comment?`);

        if (result) {
            await commentService.deleteComment(x._id);
        }

        navigate(`/offers/${offerId}`);
    };

    return (
    <li className="list-group-item">
      <p>
        <b>{x.comment.name}</b>: {x.comment.comment}
      </p>
      {offerOwnerId === x._ownerId && (
        <div className="card-body">
          <form method="DELETE" onSubmit={onDeleteCommentSubmit}>
            <div className="row">
              <div className="col col-md-4">
                <div className="button-holder d-flex">
                  <input
                    type="submit"
                    className="btn btn-info btn-lg"
                    value="Изтрий"
                  />
                </div>
              </div>
            </div>
          </form>
        </div>
      )}
    </li>
  );
};
