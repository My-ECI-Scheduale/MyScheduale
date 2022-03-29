var kanban = (function () {

    var module = kanbanApi;
    var stompClient = null;

    class Task {
        constructor(id, isPublic, description) {
            this.id = id;
            this.isPublic = isPublic;
            this.description = description;
            this.idKanbanColumn = null;
            this.idCustomer = null;
        }
    }

    class Packet {
        constructor(task, action, idcolumn, username) {
            this.task = task;
            this.action = action;
            this.idcolumn = idcolumn;
            this.username = username;
        }
    }

    function connectTopic(taskId, isPublic, taskDescription) {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        //subscribe to /topic/newpoint when connections succeed
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/kanban.' + sessionStorage.getItem("kanban"), function (eventbody) {
                var packet = JSON.parse(eventbody.body);
                var newPacket = new Packet(packet.task, packet.action, packet.idcolumn, packet.username);
                verificarEvento(newPacket);
            });
        });
    }

    function getKanbanData() {
        module.getKanban();
        loadEventListeners();
    }

    function insertItem(element) {
        console.log(element);
        var newItem = parseHtml("<div id=\"item" + module.getTaskCont() + "\" class=\"kanban-item\">"
            + "<div id=\"t" + module.getTaskCont() + "\" class=\"item-input\" draggable=\"true\" columnId=\"" + element.getAttribute("columnId") + "\" taskId=\"\"></div>"
            + "<div class=\"dropzone\"></div>"
            + "</div>");
        module.sumToCont();
        element.append(newItem);
        stompClient.send("//", {}, JSON.stringify(pt));
    }

    function parseHtml(html) {
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    function loadEventListeners() {
        $(document).ready(function () {
            // Add button + click eventListener CREATE
            $(".kanban-column").on("click", ".add-item", function (event) {
                console.log(event);
                console.log(event.target.parentElement.querySelector('.items'));
                insertItem(event.target.parentElement.querySelector('.items'));
            });
            // Add double click eventListeners UPDATE
            $(".items").on("dblclick", ".item-input", function (event) {
                // verificar isPublic en task
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
            $(".items").on("dragstart", ".kanban-item", function (event) {
                // To solve jquery dataTransfer issue
                $.event.addProp('dataTransfer');
                event.target.style.backgroundColor = "red";
                console.log(event);
                console.log(event.target.parentElement.id);
                event.dataTransfer.setData("text/plain", event.target.parentElement.id);
            });
            // Add dragstart eventListeners
            $(".items").on("dragleave", ".kanban-item", function (event) {
                // To solve jquery dataTransfer issue
                event.target.style.backgroundColor = null;
            });
            // Add dragover eventListeners
            $(".items").on("dragover", ".dropzone", function (event) {
                console.log(event);
                event.preventDefault();
                event.target.classList.add("dropzone-active")
                console.log(event.target.classList);
            });
            $(".items").on("dragover", ".delete-dropzone", function (event) {
                console.log(event);
                event.preventDefault();
                event.target.classList.add("delete-dropzone-active")
                console.log(event.target.classList);
            });
            // Add dragLeave event to remove the dropzone-active class
            $(".items").on("dragleave", ".dropzone", function (event) {
                console.log(event);
                event.preventDefault();
                event.target.classList.remove("dropzone-active")
            });
            $(".items").on("dragleave", ".delete-dropzone", function (event) {
                console.log(event);
                event.preventDefault();
                event.target.classList.remove("delete-dropzone-active")
            });
            // Add drop eventListeners
            $(".items").on("drop", ".dropzone", function (event) {
                event.preventDefault();
                console.log(event);
                event.target.classList.remove("dropzone-active")
                // Get the element to insert after
                const insertAfter = event.target.parentElement.classList.contains("kanban-item") ? event.target.parentElement : event.target;
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);

                // 
                insertAfter.after(droppedElement);


            });
            // Add drop delete eventListeners
            $(".items").on("drop", ".delete-dropzone", function (event) {
                event.preventDefault();
                console.log(event);
                event.target.classList.remove("delete-dropzone-active")
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);
                var taskid = document.getElementById(event.dataTransfer.getData("text/plain")).firstChild.getAttribute("taskId");
                var task = new Task(taskid, false, "");
                var newPacket = new Packet(task, 'D', -1, sessionStorage.getItem("User"));
                stompClient.send("/app/kanban."+sessionStorage.getItem("kanban"), {}, JSON.stringify(newPacket));
                droppedElement.remove();
                
            });
        });
    }

    function verificarEvento(packet) {
        if (sessionStorage.getItem("User") != packet.username) {
            if (packet.action == 'D') {
                var deleteItem = document.querySelectorAll('[taskId=' + packet.task.id + ']').parentElement;
                deleteItem.remove();
            }
            else if (packet.action == 'C') {
                module.create(packet.task);
            }
            else if (packet.action == 'U') {
                var item = document.querySelectorAll('[taskId=' + packet.task.id + ']').parentElement;
                if (item.innerHTML != packet.task.description) {
                    item.innerHTML = packet.task.description;
                }
                else {
                    item.remove();
                    module.create(packet.task);
                }
            }
            else if (!packet.task.isPublic) {
                var item = document.querySelectorAll('[taskId=' + packet.task.id + ']');
                item.parentElement.style.backgroundColor = "red";
            }
        }
    }

    return {
        read: getKanbanData,
        addItem: insertItem,
        connectToTopic: connectTopic
    }

})();