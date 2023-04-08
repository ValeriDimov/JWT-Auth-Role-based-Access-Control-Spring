import { useForm } from "../../../hooks/useForm";
import { useAuthContext } from "../../../contexts/AuthContext";

import styles from "./AddComment.module.css";

export const AddComment = ({
	onCommentSubmit,
}) => {
	const { name } = useAuthContext();
	const { values, changeHandler, onSubmit } = useForm({
        comment: '',
		name,
    }, onCommentSubmit);

	return (
		<article className={styles['add-comment']}>
			<label className={styles['add-comment-heading']}>Добави коментар:</label>
			<form className="form" onSubmit={onSubmit}>
				<textarea
				name="comment"
				placeholder="Напиши своя коментар..."
				rows="4" cols="50"
				value={values.comment}
				onChange={changeHandler}
				></textarea>
				<div className={styles['add-comment-btn']}>
					<input className="btn btn-info btn-lg" type="submit" value="Добави коментар" />
				</div>
			</form>
		</article>
  	);
};
