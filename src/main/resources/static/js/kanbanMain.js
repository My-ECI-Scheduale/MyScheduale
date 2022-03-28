var kanban = (function (){

    var module = kanbanApi;

    function getKanbanData(){    
        module.getKanban(10);
        $(document).ready(function(){
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
            // Add dragLeave event to remove the dropzone-active class
            $(".items").on("dragleave", ".dropzone", function(event){
                console.log(event);
                event.preventDefault();
                event.target.classList.remove("dropzone-active")
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
        });   
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    return {
        read: getKanbanData,
    }
})();