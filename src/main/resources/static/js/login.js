function login(){
    var user = document.getElementById("User").value;
    fetch("/api/customer/login?name="+user,{method:'POST'}).then(data=>data.json()).then(data=>{
        if(data != null){
            sessionStorage.setItem('User',data.name);
            window.location.href = "/home.html";
        }
        else{
            alert("No existe ese usuario que estas haciendo");
            window.location.href="/";
        }
    })
}