import { getById, updateById } from '../api/data.js';
import { html } from '../lit.js';

const editTemplate = (data) => html`
        <section id="editPage">
            <form @submit=${getFormData} class="editForm">
                <img src=${data.image}>
                <div>
                    <h2>Edit PetPal</h2>
                    <div class="name">
                        <label for="name">Name:</label>
                        <input name="name" id="name" type="text" .value=${data.name}>
                    </div>
                    <div class="breed">
                        <label for="breed">Breed:</label>
                        <input name="breed" id="breed" type="text" .value=${data.breed}>
                    </div>
                    <div class="Age">
                        <label for="age">Age:</label>
                        <input name="age" id="age" type="text" .value=${data.age}>
                    </div>
                    <div class="weight">
                        <label for="weight">Weight:</label>
                        <input name="weight" id="weight" type="text" .value=${data.weight}>
                    </div>
                    <div class="image">
                        <label for="image">Image:</label>
                        <input name="image" id="image" type="text" .value=${data.image}>
                    </div>
                    <button class="btn" type="submit">Edit Pet</button>
                </div>
            </form>
        </section>
`;

let ctx = null;

export async function showEdit(context) {
    ctx = context;
    
    const data = await getById(ctx.params.id);
    context.render(editTemplate(data));
}

async function getFormData(e) {
    e.preventDefault();
    
    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData);
    const { name, breed, age, weight, image } = data;

    if (!name || !breed || !age || !weight || !image) {
        alert('All fields are required!');
        return;
    }

    await updateById(ctx.params.id, data);
    e.target.reset();
    ctx.page.redirect(`/details/${ctx.params.id}`);
}
