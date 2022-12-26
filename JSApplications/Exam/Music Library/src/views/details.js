import { deleteById, getById, sendLike, getTotalLikesCount, getUserLiked } from '../api/data.js';
import { html, nothing } from '../lit.js';

const detailsTemplate = (data, isOwner, isLogged, likesCount, userHasLiked) => html`
    <section id="details">
        <div id="details-wrapper">
          <p id="details-title">Album Details</p>
          <div id="img-wrapper">
            <img src=${data.imageUrl} alt="example1" />
          </div>
          <div id="info-wrapper">
            <p><strong>Band:</strong><span id="details-singer">${data.singer}</span></p>
            <p>
              <strong>Album name:</strong><span id="details-album">${data.album}</span>
            </p>
            <p><strong>Release date:</strong><span id="details-release">${data.release}</span></p>
            <p><strong>Label:</strong><span id="details-label">${data.label}</span></p>
            <p><strong>Sales:</strong><span id="details-sales">${data.sales}</span></p>
          </div>
          <div id="likes">Likes: <span id="likes-count">${likesCount}</span></div>

            ${isOwner && isLogged ?
                html`
                <!--Edit and Delete are only for creator-->
                <div id="action-buttons">
                    <a href=${`/edit/${data._id}`} id="edit-btn">Edit</a>
                    <a @click=${deleteItem} href="javascript:void(0)" id="delete-btn">Delete</a>
                </div>
                ` : 
                nothing
            }
          
            ${!isOwner && isLogged && userHasLiked == 0 ?
                html `
                <div id="action-buttons">
                    <!--Bonus - Only for logged-in users ( not authors )-->
                    <a @click=${onLike} href="javascript:void(0)" id="like-btn">Like</a>
                </div>
                ` :
                nothing            
            }
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

    const likesCount = await getTotalLikesCount(albumId);

    let userHasLiked = 0;

    if(user) {
        userHasLiked = await getUserLiked(albumId, user._id);
    }
        
    ctx.render(detailsTemplate(data, isOwner, isLogged, likesCount, userHasLiked));
}

async function deleteItem(e) {
    e.preventDefault();
    const confirmed = confirm('Are you sure you want to delete this item?');
    if (confirmed) {
        await deleteById(ctx.params.id);
        ctx.page.redirect('/catalog');
    }
}

async function onLike(e) {
    e.preventDefault();
    
    const albumId = ctx.params.id;
    await sendLike(albumId);

    ctx.page.redirect(`/details/${albumId}`);
}
