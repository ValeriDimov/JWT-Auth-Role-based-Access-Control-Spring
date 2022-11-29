import { html, nothing } from "../lit.js";
import { searchAlbums } from "../api/data.js"

const searchTemplate = () => html`
        <section id="searchPage">
            <h1>Search by Name</h1>
        
            <div class="search">
                <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
                <button @click=${getSearch} class="button-list">Search</button>
            </div>
        
            <h2>Results:</h2>
        </section>
`;

const searchResultTemplate = (isLogged, data) => html `
<div class="search-result"></div>
<section id="searchPage">
            <h1>Search by Name</h1>
        
            <div class="search">
                <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
                <button @click=${getSearch} class="button-list">Search</button>
            </div>
        
            <h2>Results:</h2>
        </section>
    ${ data.length > 0 ?
    
    data.map(a => arrayTemplate(a, isLogged))
    :
    html `
                <p class="no-result">No result.</p>`
    }
`;
 
const arrayTemplate = (a, isLogged) => html `
<div class="card-box">
                    <img src=${a.imgUrl}>
                    <div>
                        <div class="text-center">
                            <p class="name">${a.name}</p>
                            <p class="artist">Artist: ${a.artist}</p>
                            <p class="genre">Genre: ${a.genre}</p>
                            <p class="price">Price: $${a.price}</p>
                            <p class="date">Release Date: ${a.releaseDate}</p>
                        </div>
                        ${isLogged ? html `
                        <div class="btn-group">
                            <a href="./details/${a._id}" id="details">${a.description}</a>
                        </div>
                        `:
                        nothing}
                        
                    </div>
                </div>
`;
let ctx = null;

export async function showSearch(context) {
    ctx = context;
    ctx.render(searchTemplate());
    
}

async function getSearch(e) {
    e.preventDefault();
    
    const user = JSON.parse(sessionStorage.getItem('user'));
    const isLogged = !user ? false : true;

    let query = document.getElementById("search-input").value;
    
    if(!query) {
        return alert("The field can not be empty");
    }

    const data = await searchAlbums(query);
    
    ctx.render(searchResultTemplate(isLogged, data));



}