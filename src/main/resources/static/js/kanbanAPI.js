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
                element.items.forEach(task => {
                    // Create the new item
                    $("#"+element.name).append("<div contenteditable=\"true\" id=\"task"+cont+"\" class=\"item-input\" draggable=\"true\">"+task+"</div>");
                    cont += 1;
                    // Create the dropzone for the new item
                    $("#"+element.name).append("<div class=\"dropzone\"></div>");
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

    return {
        getKanban : getData,
        insert : insertItem
    }
})();