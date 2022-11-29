import { deleteById, getById } from '../api/data.js';
import { html, nothing } from '../lit.js';

const detailsTemplate = (data, isOwner, isLogged) => html`
        <section id="detailsPage">
            <div class="wrapper">
                <div class="albumCover">
                    <img src="./images/Lorde.jpg">
                </div>
                <div class="albumInfo">
                    <div class="albumText">

                        <h1>Name: ${data.name}</h1>
                        <h3>Artist: ${data.artist}</h3>
                        <h4>Genre: ${data.genre}</h4>
                        <h4>Price: $${data.price}</h4>
                        <h4>Date: ${data.releaseDate}</h4>
                        <p>Description: ${data.description}</p>
                    </div>

                    <!-- Only for registered user and creator of the album-->
                    
                    ${isLogged && isOwner ?
                    html`
                    <div class="actionBtn">
                        <a href="/edit/${data._id}" class="edit">Edit</a>
                        <a @click=${deleteItem} href="javascript:void(0)" class="remove">Delete</a>
                    </div>
                    ` :
                    nothing              
                }
                    
                </div>
            </div>
        </section>
`;

let ctx = null;

export async function showDetails(context) {
    ctx = context;
    const albumId = ctx.params.id;
    const data = await getById(albumId);

    const user = JSON.parse(sessionStorage.getItem('user'));
    const isOwner = user ? user._id === data._ownerId : false;
    const isLogged = !user ? false : true;
    
   ctx.render(detailsTemplate(data, isOwner, isLogged));
}

async function deleteItem(e) {
    e.preventDefault();
    const confirmed = confirm('Are you sure you want to delete this item?');
    if (confirmed) {
        await deleteById(ctx.params.id);
        ctx.page.redirect('/catalog');
    }
}
