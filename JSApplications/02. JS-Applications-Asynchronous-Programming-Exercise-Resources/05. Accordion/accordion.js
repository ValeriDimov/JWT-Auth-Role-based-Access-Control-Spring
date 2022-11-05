async function solution() {
    const mainSectionElement = document.getElementById("main");
    const urlList = "http://localhost:3030/jsonstore/advanced/articles/list";
    
    try {
        const responseList = await fetch(urlList);
        let dataList = await responseList.json();
    
        dataList.forEach(element => {
    
            const divAccordeon = document.createElement("div");
            divAccordeon.classList.add("accordion");
    
            const divHead = document.createElement("div");
            divHead.classList.add("head");
            const spanHead = document.createElement("span");
            spanHead.textContent = element.title;
            const btnHead = document.createElement("button");
            btnHead.classList.add("button");
            btnHead.setAttribute("id", element._id);
            btnHead.textContent = "More";
            btnHead.addEventListener('click', giveDetails)
                
            const divExtra = document.createElement("div");
            divExtra.classList.add("extra");
            const pExtra = document.createElement("p");
    
            divHead.appendChild(spanHead);
            divHead.appendChild(btnHead);
            divExtra.appendChild(pExtra);
            divAccordeon.appendChild(divHead);
            divAccordeon.appendChild(divExtra);
            mainSectionElement.appendChild(divAccordeon);
        });
    
    } catch {
        throw new Error("Error");
    }
    
    async function giveDetails(e) {
        const p = e.target.parentElement.parentElement.children[1];
        const tempDivExtra = e.target.parentElement.parentElement.children[1];
        let elementId = e.target.id;
        
        try {
            const urlId = `http://localhost:3030/jsonstore/advanced/articles/details/${elementId}`;
            const responseElement = await fetch(urlId);
            let dataElement = await responseElement.json();
            let contentElement = dataElement.content;
                
            if (e.target.textContent === "More") {
                p.textContent = contentElement;
                tempDivExtra.style.display = 'block';
                e.target.textContent = "Less";
            } else {
                tempDivExtra.style.display = 'none';
                e.target.textContent = "More";
            }
        } catch {
            throw new Error("Error")
        }
     

    }

}

let sol = solution();