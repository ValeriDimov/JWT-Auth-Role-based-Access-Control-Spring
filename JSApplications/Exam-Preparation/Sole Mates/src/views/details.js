import { deleteById, getById } from '../api/data.js';
import { html, nothing } from '../lit.js';

const detailsTemplate = (data, isOwner, isLogged) => html`
        <section id="details">
          <div id="details-wrapper">
            <p id="details-title">Shoe Details</p>
            <div id="img-wrapper">
              <img src=${data.imageUrl} alt="example1" />
            </div>
            <div id="info-wrapper">
              <p>Brand: <span id="details-brand">${data.brand}</span></p>
              <p>
                Model: <span id="details-model">${data.model}</span>
              </p>
              <p>Release date: <span id="details-release">${data.release}</span></p>
              <p>Designer: <span id="details-designer">${data.designer}</span></p>
              <p>Value: <span id="details-value">${data.value}</span></p>
            </div>

            ${isOwner ?
            html`
            <!--Edit and Delete are only for creator-->
            <div id="action-buttons">
              <a href=${`/edit/${data._id}`} id="edit-btn">Edit</a>
              <a @click=${deleteItem} href="javascript:void(0)" id="delete-btn">Delete</a>
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
    const offerId = ctx.params.id;
    const data = await getById(offerId);

    const user = JSON.parse(sessionStorage.getItem('user'));
    const isOwner = user ? user._id === data._ownerId : false;
    const isLogged = !user ? false : true;

    // const applicationsCount = await getApplicationsCount(offerId);

    // let userHasApplied = 0;

    // if(user) {
    //     userHasApplied = await getUserApplied(offerId, user._id);
    // }
        
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

// async function onApply(e) {
//     e.preventDefault();
    
//     const offerId = ctx.params.id;
//     await sendApplication(offerId);

//     ctx.page.redirect(`/details/${offerId}`);
// }
