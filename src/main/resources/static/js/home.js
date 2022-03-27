    console.log("entro");
    fetch('navbar.html')
        .then(res => res.text())
        .then(text => {
            let newelem = document.getElementById("navbar");
            newelem.innerHTML = text;
        })
