async function scheduleLoad(){
    return fetch("/api/schedule/one",{method:'GET'}).then(data=>data.json()).then(data=>{
        data.forEach(element => {
            fetch("/api/schedule/assiganture?id="+element.id,{method:'GET'}).then(res=>res.json()).then(res=>{
                res.forEach(date=>{
                    document.getElementById(date.dia).insertAdjacentHTML('beforeend',tareahtml(date.horaInicio,date.horaFinal,element.name,element.id));
                });
        })
        });
        return 0
    });
}

function tareahtml(hora1,hora2,assignaturaname,assignaturaid){
    return("<li class=\"cd-schedule__event\"><a data-start=\""+hora1+"\" data-end=\""+hora2+"\" data-content=\"event-abs-circuit\" data-event=\"event-1\" href=\"#\""
    +"onclick=\"openkanban("+assignaturaid+")\">"
            +"<em class=\"cd-schedule__name\">"+assignaturaname+"</em></a></li>");
}
function loadScript(url){
    var head = document.getElementsByTagName('body')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;
    head.appendChild(script);
}