var kanban = (function (){

    var module = kanbanApi;

    function getKanbanData(){    
        module.getKanban(10);
        $(document).ready(function(){
            // Add dragstart eventListeners
            $(".items").on("dragstart", ".item-input", function(event){
                // To solve jquery dataTransfer issue
                $.event.addProp('dataTransfer');
                console.log(event);
                event.dataTransfer.setData("text/plain", event.target.id);
            });
            // Add input drop event prevent
            $(".items").on("drop", ".item-input", function(event){
                event.preventDefault();
            });
            // Add dragover eventListeners
            $(".items").on("dragover", ".dropzone", function(event){
                console.log(event);
                event.preventDefault();
                console.log(event.target.classList.add("dropzone-active"));
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
                const insertAfter = event.target.parentElement.classList.contains("item-input") ? event.target.parentElement : event.target;
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                const droppedElement = document.getElementById(droppedElementId);
                insertAfter.after(droppedElement);
                //
                var newDropzone = parseHtml("<div class=\"dropzone\"></div>");
                droppedElement.after(newDropzone);
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