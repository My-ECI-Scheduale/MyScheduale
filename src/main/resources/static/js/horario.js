let assignatura = document.getElementById("V");
assignatura.innerHTML= tareahtml();
function tareahtml(){
    return("<li class=\"cd-schedule__event\"><a data-start=\"11:30\" data-end=\"13:00\" data-content=\"event-abs-circuit\" data-event=\"event-1\" href=\"#0\">"
            +"<em class=\"cd-schedule__name\">Abs Circuit</em></a></li>")
}