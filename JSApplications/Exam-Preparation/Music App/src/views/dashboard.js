import { html, nothing } from '../lit.js';
import { getAllItems } from "../api/data.js";

const dashboardTemplate = (data, isLogged) => html`
<section id="catalogPage">
            <h1>All Albums</h1>
            ${data.length > 0 
            ? data.map(a => itemCard(a, isLogged)) 
            : html`
                <p>No Albums in Catalog!</p>`
            }
</section>`;

const itemCard = (item, isLogged) => html`
<div class="card-box">
    <img src=${item.imgUrl}>
    <div>
        <div class="text-center">
            <p class="name">Name: ${item.name}</p>
            <p class="artist">Artist: ${item.artist}</p>
            <p class="genre">Genre: ${item.genre}</p>
            <p class="price">Price: $${item.price}</p>
            <p class="date">Release Date: ${item.releaseDate}</p>
        </div>
            ${isLogged
            ? html`
                <div class="btn-group">
                    <a href="/details/${item._id}" id="details">Details</a>
                </div>` :
                nothing
            }
       
    </div>
</div>`;

let ctx;

export async function showDashboard(context) {
    ctx = context;
    const data = await getAllItems();
    const user = JSON.parse(sessionStorage.getItem('user'));
    const isLogged = !user ? false : true;
    ctx.render(dashboardTemplate(data, isLogged));
}
