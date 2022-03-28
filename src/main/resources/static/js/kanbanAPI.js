var kanbanApi = (function(){

    var kanbanData;

    function getData(kanbanId){
        $.ajax({
            type:"GET",
            url: "http://localhost:8080/api/kanban/"+kanbanId
        }).then(function (data) {
            console.log(data);
            var cont = 1;
            data.forEach(element => {
                // Add first dropzone
                $("#"+element.name).append("<div class=\"dropzone\"></div>");
                element.items.forEach(task => {
                    var newItem = parseHtml("<div id=\"task"+cont+"\" class=\"kanban-item\">"
                    +"<div contenteditable=\"true\" id=\"t"+cont+"\" class=\"item-input\" draggable=\"true\">"+task+"</div>"
                    +"<div class=\"dropzone\"></div>"
                    +"</div>");
                    $("#"+element.name).append(newItem);
                    cont += 1;
                });
            });
        });
    }

    function insertItem(columnName, content){
        console.log(kanbanData);
        for (let index = 0; index < kanbanData.length; index++) {
            const element = kanbanData[index];
            if (element.name == columnName) {
                element.items.add(content);
            }    
        }
        console.log(kanbanData);
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    return {
        getKanban : getData,
        insert : insertItem
    }
})();