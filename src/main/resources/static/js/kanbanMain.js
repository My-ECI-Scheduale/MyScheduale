var kanban = (function (){

    var module = kanbanApi;

    function getKanbanData(){    
        module.getKanban(10);
        loadEventListeners();
    }

    function insertItem(element){
        var newItem = parseHtml("<div id=\"task"+module.getTaskCont()+"\" class=\"kanban-item\">"
                    +"<div id=\"t"+module.getTaskCont()+"\" class=\"item-input\" draggable=\"true\"></div>"
                    +"<div class=\"dropzone\"></div>"
                    +"</div>");
        module.sumToCont();
        element.append(newItem);
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    function loadEventListeners(){
        $(document).ready(function(){
            // Add button + click eventListener CREATE
            $(".kanban-column").on("click", ".add-item", function(event){
                console.log(event);
                console.log(event.target.parentElement.querySelector('.items'));
                insertItem(event.target.parentElement.querySelector('.items'));
            });
            // Add double click eventListeners UPDATE
            $(".items").on("dblclick", ".item-input", function(event){
                console.log(event);
                console.log(event.target.id);
                if (!event.target.hasAttribute("contenteditable")) {
                    event.target.setAttribute("contenteditable", "true");   
                }
                else {
                    event.target.removeAttribute("contenteditable");
                }
            });
            // Add dragstart eventListeners
            $(".items").on("dragstart", ".kanban-item", function(event){
                // To solve jquery dataTransfer issue
                $.event.addProp('dataTransfer');
                console.log(event);
                console.log(event.target.parentElement.id);
                event.dataTransfer.setData("text/plain", event.target.parentElement.id);
            });
            // Add input drop event prevent
            $(".items").on("drop", ".kanban-item", function(event){
                event.preventDefault();
            });
            // Add dragover eventListeners
            $(".items").on("dragover", ".dropzone", function(event){
                console.log(event);
                event.preventDefault();
                event.target.classList.add("dropzone-active")
                console.log(event.target.classList);
            });
            $(".items").on("dragover", ".delete-dropzone", function(event){
                console.log(event);
                event.preventDefault();
                event.target.classList.add("delete-dropzone-active")
                console.log(event.target.classList);
            });
            // Add dragLeave event to remove the dropzone-active class
            $(".items").on("dragleave", ".dropzone", function(event){
                console.log(event);
                event.preventDefault();
                event.target.classList.remove("dropzone-active")
            });
            $(".items").on("dragleave", ".delete-dropzone", function(event){
                console.log(event);
                event.preventDefault();
                event.target.classList.remove("delete-dropzone-active")
            });
            // Add drop eventListeners
            $(".items").on("drop", ".dropzone", function(event){
                event.preventDefault();
                console.log(event);
                event.target.classList.remove("dropzone-active")
                // Get the element to insert after
                const insertAfter = event.target.parentElement.classList.contains("kanban-item") ? event.target.parentElement : event.target;
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);
                insertAfter.after(droppedElement);
            });
            // Add drop delete eventListeners
            $(".items").on("drop", ".delete-dropzone", function(event){
                event.preventDefault();
                console.log(event);
                event.target.classList.remove("delete-dropzone-active")
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);
                droppedElement.remove();
            });  
        });
    }

    return {
        read: getKanbanData,
        addItem:insertItem 
    }

})();