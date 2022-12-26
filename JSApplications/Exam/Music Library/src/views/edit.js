import { getById, updateById } from '../api/data.js';
import { html } from '../lit.js';

const editTemplate = (data) => html`
      <section id="edit">
        <div class="form">
          <h2>Edit Album</h2>
          <form @submit=${getFormData} class="edit-form">
            <input type="text" name="singer" id="album-singer" placeholder="Singer/Band" .value=${data.singer} />
            <input type="text" name="album" id="album-album" placeholder="Album" .value=${data.album} />
            <input type="text" name="imageUrl" id="album-img" placeholder="Image url" .value=${data.imageUrl} />
            <input type="text" name="release" id="album-release" placeholder="Release date" .value=${data.release} />
            <input type="text" name="label" id="album-label" placeholder="Label" .value=${data.label} />
            <input type="text" name="sales" id="album-sales" placeholder="Sales" .value=${data.sales} />

            <button type="submit">post</button>
          </form>
        </div>
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
    const { singer, album, imageUrl, release, label, sales } = data;

    if (!singer || !album || !imageUrl || !release || !label ||!sales) {
        alert('All fields are required!');
        return;
    }

    await updateById(ctx.params.id, data);
    e.target.reset();
    ctx.page.redirect(`/details/${ctx.params.id}`);
}
