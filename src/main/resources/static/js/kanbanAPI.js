var kanbanApi = (function(){

    var kanbanData;
    var cont = 1;

    function getCont(){
        return cont;
    }

    function sumCont(){
        cont += 1;
    }

    function getData(){
        $.ajax({
            type:"GET",
            url: "/api/kanban/getById?id="+sessionStorage.getItem("kanban")
        }).then(function (data) {
            data.forEach(task => {
                var newItem = parseHtml("<div id=\"item"+cont+"\" class=\"kanban-item\">"
                +"<div id=\"t"+cont+"\" class=\"item-input\" draggable=\"true\">"+task.description+"</div>"
                +"<div class=\"dropzone\"></div>"
                +"</div>");
                $("#"+task.idKanbanColumn.name).append(newItem);
            });
        });
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    return {
        getKanban : getData,
        getTaskCont: getCont,
        sumToCont: sumCont
    }
})();