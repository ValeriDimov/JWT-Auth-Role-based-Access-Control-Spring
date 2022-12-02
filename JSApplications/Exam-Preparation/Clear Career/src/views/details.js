import { deleteById, getById, sendApplication, getApplicationsCount, getUserApplied } from '../api/data.js';
import { html, nothing } from '../lit.js';

const detailsTemplate = (data, isOwner, isLogged, applicationsCount, userHasApplied) => html`
        <section id="details">
            <div id="details-wrapper">
                <img id="details-img" src=${data.imageUrl} alt="example1" />
                <p id="details-title">${data.title}</p>
                <p id="details-category">
                Category: <span id="categories">${data.category}</span>
                </p>
                <p id="details-salary">
                Salary: <span id="salary-number">${data.salary}</span>
                </p>
                <div id="info-wrapper">
                <div id="details-description">
                    <h4>Description</h4>
                    <span
                    >${data.description}</span
                    >
                </div>
                <div id="details-requirements">
                    <h4>Requirements</h4>
                    <span
                    >${data.requirements}</span
                    >
                </div>
                </div>
                <p>Applications: <strong id="applications">${applicationsCount}</strong></p>

                ${isOwner ?
                html `
                <!--Edit and Delete are only for creator-->
                <div id="action-buttons">
                    <a href=${`/edit/${data._id}`} id="edit-btn">Edit</a>
                    <a @click=${deleteItem} href="javascript:void(0)" id="delete-btn">Delete</a>
                </div>
                ` : 
                nothing
                }

                ${!isOwner && isLogged && userHasApplied == 0 ?
                html `
                <div id="action-buttons">
                    <!--Bonus - Only for logged-in users ( not authors )-->
                    <a @click=${onApply} href="javascript:void(0)" id="apply-btn">Apply</a>
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

    const applicationsCount = await getApplicationsCount(offerId);

    let userHasApplied = 0;

    if(user) {
        userHasApplied = await getUserApplied(offerId, user._id);
    }
        
    ctx.render(detailsTemplate(data, isOwner, isLogged, applicationsCount, userHasApplied));

}

async function deleteItem(e) {
    e.preventDefault();
    const confirmed = confirm('Are you sure you want to delete this item?');
    if (confirmed) {
        await deleteById(ctx.params.id);
        ctx.page.redirect('/catalog');
    }
}

async function onApply(e) {
    e.preventDefault();
    
    const offerId = ctx.params.id;
    await sendApplication(offerId);

    ctx.page.redirect(`/details/${offerId}`);
}
