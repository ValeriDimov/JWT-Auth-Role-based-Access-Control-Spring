import { html, nothing } from '../lit.js';
import { getAllItems } from "../api/data.js";

const dashboardTemplate = (data) => html`
        <section id="dashboard">
          <h2>Collectibles</h2>
          <ul class="card-wrapper">
            ${data.length > 0 ?
                data.map(i => itemCard(i)) 
              :
              html `
                <!-- Display an h2 if there are no posts -->
                <h2>There are no items added yet.</h2>
              `         
            }
                                  
          </ul>
        </section>
`;

const itemCard = (item) => html`
        <!-- Display a div with information about every post (if any)-->
        <li class="card">
              <img src=${item.imageUrl} alt="travis" />
              <p>
                <strong>Brand: </strong><span class="brand">${item.brand}</span>
              </p>
              <p>
                <strong>Model: </strong
                ><span class="model">${item.model}</span>
              </p>
              <p><strong>Value:</strong><span class="value">${item.value}</span>$</p>
              <a class="details-btn" href=${`/details/${item._id}`}>Details</a>
        </li>   
        `;

let ctx;

export async function showDashboard(context) {
    ctx = context;
    const data = await getAllItems();
    // const user = JSON.parse(sessionStorage.getItem('user'));
    // const isLogged = !user ? false : true;
    // const isLogged = true;
    ctx.render(dashboardTemplate(data));
}
