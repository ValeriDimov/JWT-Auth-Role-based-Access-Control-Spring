import { getSearch } from "../api/data.js"
import { html, nothing } from "../lit.js"

const searchTemplete = () => html `
<section id="search">
          <h2>Search by Brand</h2>

          <form @submit=${getFormData} class="search-wrapper cf">
            <input
              id="#search-input"
              type="text"
              name="search"
              placeholder="Search here..."
              required
            />
            <button type="submit">Search</button>
          </form>

          <h3>Results:</h3>
        </section>
`;

const searchWithResultTemplate = (result, isLogged) => html `
    <section id="search">
          <h2>Search by Brand</h2>

          <form @submit=${getFormData} class="search-wrapper cf">
            <input
              id="#search-input"
              type="text"
              name="search"
              placeholder="Search here..."
              required
            />
            <button type="submit">Search</button>
          </form>

          <h3>Results:</h3>

          <div id="search-container">
            <ul class="card-wrapper">
              <!-- Display a li with information about every post (if any)-->
              ${result.length > 0 ?
            result.map(i => cardItem(i, isLogged))
                :
                html`
                <!-- Display an h2 if there are no posts -->
            <h2>There are no results found.</h2>
            `
            }
            </ul>

            </div>
    </section>
`;

const cardItem = (item, isLogged) => 
 html`
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
                ${isLogged ? 
                html `
                        <a class="details-btn" href=${`/details/${item._id}`}>Details</a>
                    ` :
                    nothing
                }
    </li>
    `;

let ctx = null;

async function getFormData(e) {
    e.preventDefault();
    const form = new FormData(e.target);
    const data = Object.fromEntries(form); 
    const { search } = data;

    if(!search) {
        alert("The search field can not be empty");
        return;
    }

    const result = await getSearch(search);

    const user = JSON.parse(sessionStorage.getItem('user'));
    const isLogged = !user ? false : true;
    
    ctx.render(searchWithResultTemplate(result, isLogged));

}

export async function showSearch(context) {
    ctx = context;       
    ctx.render(searchTemplete());

}