function solve() {
    let stopNext = "";
    let stopName = "";
    const btnDepart = document.getElementById("depart");
    const btnArrive = document.getElementById("arrive");
    const stopNameElement = document.getElementsByClassName("info")[0];

    async function depart() {
        console.log('Depart TODO...');
        let stopNameValue = stopNameElement.textContent;

        if(stopNameValue === "Not Connected") {
            stopNext = "depot";
            stopName = "Depot";
        }
        
        stopNameElement.textContent = `Next stop ${stopName}`;
        const urlDepart = `http://localhost:3030/jsonstore/bus/schedule/${stopNext}`;
        let responseDepart = await fetch(urlDepart);
        let data = await responseDepart.json();

              
        btnDepart.setAttribute("disabled", "");
        btnArrive.removeAttribute("disabled");

        stopNext = data.next;
    }

    async function arrive() {
        console.log('Arrive TODO...');
        
        btnDepart.removeAttribute("disabled");
        btnArrive.setAttribute("disabled", "");

        const urlArrive = `http://localhost:3030/jsonstore/bus/schedule/${stopNext}`;
        stopNameElement.textContent = `Arriving at ${stopName}`;


        const response = await fetch(urlArrive);
        let dataArrive = await response.json();

        stopName = dataArrive.name;
        stopNext = dataArrive.next;

    }


    return {
        depart,
        arrive
    };
}

let result = solve();