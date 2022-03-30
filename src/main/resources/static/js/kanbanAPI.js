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
                createItem(task);
            });
        });
    }

    function createItemJson(task){
        var newItem = parseHtml("<div id=\"item"+cont+"\" class=\"kanban-item\">"
                +"<div id=\"t"+cont+"\" class=\"item-input\" draggable=\"" +task.ipublic+ "\" columnId=\""+task.idcolumn+"\" taskId=\""+task.idtask+"\">"+task.description+"</div>"
                +"<div class=\"dropzone\"></div>"
                +"</div>");
                var nameColunm = document.querySelector('[columnId=\"' + task.idcolumn+ '\"]').getAttribute("id");
                $("#"+nameColunm).append(newItem);
                cont += 1;
    }

    function createItem(task){
        var newItem = parseHtml("<div id=\"item"+cont+"\" class=\"kanban-item\">"
                +"<div id=\"t"+cont+"\" class=\"item-input\" draggable=\"" +task.public+ "\" columnId=\""+task.idKanbanColumn.id+"\" taskId=\""+task.id+"\">"+task.description+"</div>"
                +"<div class=\"dropzone\"></div>"
                +"</div>");
                var column = document.getElementById(task.idKanbanColumn.name);
                column.setAttribute("columnId", task.idKanbanColumn.id);
                $("#"+task.idKanbanColumn.name).append(newItem);
                cont += 1;
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    return {
        getKanban : getData,
        getTaskCont: getCont,
        sumToCont: sumCont,
        create: createItemJson
    }
})();