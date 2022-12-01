import { deleteById, getById, makeDonate, getDonate, getUserDonation } from '../api/data.js';
import { html, nothing } from '../lit.js';

const detailsTemplate = (data, isOwner, isLogged, donationAmount, userHasDonated) => html`
        <section id="detailsPage">
            <div class="details">
                <div class="animalPic">
                    <img src=${data.image}>
                </div>
                <div>
                    <div class="animalInfo">
                        <h1>Name: ${data.name}</h1>
                        <h3>Breed: ${data.breed}</h3>
                        <h4>Age: ${data.age}</h4>
                        <h4>Weight: ${data.weight}</h4>
                        <h4 class="donation">Donation: ${donationAmount}$</h4>
                    </div>
                    <!-- if there is no registered user, do not display div-->
                    ${isOwner ? html `
                    <div class="actionBtn">
                        <!-- Only for registered user and creator of the pets-->
                        <a href=${`/edit/${data._id}`} class="edit">Edit</a>
                        <a @click=${deleteItem} href="javascript:void(0)" class="remove">Delete</a>

                        <!--(Bonus Part) Only for no creator and user-->
                        <!-- <a href="#" class="donate">Donate</a> -->
                    </div>
                    ` : 
                    nothing
                    }

                    ${isLogged && !isOwner ? html `
                    <div class="actionBtn">
                        <!-- Only for registered user and creator of the pets-->
                        <!-- <a href="#" class="edit">Edit</a>
                        <a href="#" class="remove">Delete</a> -->

                        <!--(Bonus Part) Only for no creator and user-->
                        ${ userHasDonated != 1 ?
                        html `
                        <div class="actionBtn">
                            <a @click=${onDonate} href="javascript:void(0)" class="donate">Donate</a>
                        </div>
                            ` :
                            nothing
                        }
                    
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
    const petId = ctx.params.id;
    const data = await getById(petId);

    const user = JSON.parse(sessionStorage.getItem('user'));
    const isOwner = user ? user._id === data._ownerId : false;
    const isLogged = !user ? false : true;

    const donationAmount = await getDonate(petId);
    const userHasDonated = await getUserDonation(petId, user._id)
    
    ctx.render(detailsTemplate(data, isOwner, isLogged, donationAmount, userHasDonated));

}

async function deleteItem(e) {
    e.preventDefault();
    const confirmed = confirm('Are you sure you want to delete this item?');
    if (confirmed) {
        await deleteById(ctx.params.id);
        ctx.page.redirect('/');
    }
}

async function onDonate(e) {
    e.preventDefault();
    
    const petId = ctx.params.id;
    await makeDonate(petId);

    ctx.page.redirect(`/details/${petId}`);
}
