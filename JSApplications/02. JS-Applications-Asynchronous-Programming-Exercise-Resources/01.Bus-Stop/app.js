async function getInfo() {
    console.log("TODO...");

    let stopId = document.getElementById("stopId");
    let stopIdValue = stopId.value;

    let stpNameElement = document.getElementById("stopName");
    let ulBusesElement = document.getElementById("buses");

    const urlStopId = `http://localhost:3030/jsonstore/bus/businfo/${stopIdValue}`

    try {
        let response = await fetch(urlStopId);
        let data = await response.json();
        stpNameElement.textContent = data.name;

        stopId.value = "";

        let busesObj = data.buses;

        for (const bus of Object.entries(busesObj)) {
            const li = document.createElement("li");
            li.textContent = `Bus ${bus[0]} arrives in ${bus[1]} minutes`;
            ulBusesElement.appendChild(li);
        }
                
    } catch {
        stpNameElement.textContent = "Error";
    }

}