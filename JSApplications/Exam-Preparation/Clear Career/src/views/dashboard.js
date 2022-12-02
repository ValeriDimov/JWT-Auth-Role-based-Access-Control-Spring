import { html, nothing } from '../lit.js';
import { getAllItems } from "../api/data.js";

const dashboardTemplate = (data) => html`
        <section id="dashboard">
          <h2>Job Offers</h2>
            ${data.length > 0 ? 
            data.map(i => itemCard(i))
            : 
            html `
            <!-- Display an h2 if there are no posts -->
            <h2>No offers yet.</h2>`       
            }
        </section>
`;

const itemCard = (item) => html`
        <!-- Display a div with information about every post (if any)-->
          <div class="offer">
            <img src= ${item.imageUrl} alt="example1" />
            <p>
              <strong>Title: </strong><span class="title">${item.title}</span>
            </p>
            <p><strong>Salary:</strong><span class="salary">${item.salary}</span></p>
            <a class="details-btn" href=${`/details/${item._id}`}>Details</a>
          </div>
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
