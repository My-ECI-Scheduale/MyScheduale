var kanban = (function () {

    var module = kanbanApi;
    var stompClient = null;
    var holding = false;
    var holder =null;

    class Packet {
        constructor(idtask, action, idcolumn, username,idcustomer, ipublic, description) {
            this.idtask = idtask;
            this.idcustomer = idcustomer;
            this.ipublic = ipublic;
            this.description = description;
            this.action = action;
            this.idcolumn = idcolumn;
            this.username = username;
        }
    }

    function connectTopic() {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        //subscribe to /topic/newpoint when connections succeed
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/kanban.' + sessionStorage.getItem("kanban"), function (eventbody) {
                var packet = JSON.parse(eventbody.body);
                var newPacket = new Packet(packet.idtask, packet.action, packet.idcolumn, packet.username,packet.idcustomer, packet.ipublic, packet.description);
                verificarEvento(newPacket);
            });
        });
    }

    function getKanbanData() {
        module.getKanban();
        loadEventListeners();
        connectTopic();
    }

    function insertItem(element) {
        console.log(element);
        var newItem = parseHtml("<div id=\"item" + module.getTaskCont() + "\" class=\"kanban-item\">"
            + "<div id=\"t" + module.getTaskCont() + "\" class=\"item-input\" draggable=\"true\" columnId=\"" + element.getAttribute("columnId") + "\" taskId=\"\"></div>"
            + "<div class=\"dropzone\"></div>"
            + "</div>");
        module.sumToCont();
        element.append(newItem);
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
                console.log("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                console.log(event.target.getAttribute("taskId"));
                // To solve jquery dataTransfer issue
                $.event.addProp('dataTransfer');
                event.target.style.backgroundColor = "red";
                event.dataTransfer.setData("text/plain", event.target.parentElement.id);
                if(!holding){
                    
                    holding = true;
                    holder = event.target.parentElement;
                    var taskid = event.target.getAttribute("taskId");
                    var newPacket = new Packet(taskid, 'M', event.target.getAttribute("columnId"),  sessionStorage.getItem("User"),sessionStorage.getItem('userId'), false, event.target.innerHTML);
                    stompClient.send("/app/kanban."+sessionStorage.getItem("kanban"), {}, JSON.stringify(newPacket));
                }
            });
            // Add dragstart eventListeners
            $(".items").on("dragleave", ".kanban-item", function (event) {
                // To solve jquery dataTransfer issue
                event.target.parentElement.firstChild.style.backgroundColor = null;
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
                console.log("even LEAV DROPZONE");
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
                console.log("DOP DROPZONE");
                event.target.classList.remove("dropzone-active")
                // Get the element to insert after
                const insertAfter = event.target.parentElement.classList.contains("kanban-item") ? event.target.parentElement : event.target;
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);
                insertAfter.after(droppedElement);
                console.log(holder);
                var taskid = holder.firstChild.getAttribute("taskId");
                console.log("-----------------------------------------");
                console.log(holder.firstChild);
                var newPacket = new Packet(taskid, 'M', holder.parentElement.getAttribute("columnid"),  sessionStorage.getItem("User"),sessionStorage.getItem('userId'), true, holder.firstChild.innerHTML);
                stompClient.send("/app/kanban."+sessionStorage.getItem("kanban"), {}, JSON.stringify(newPacket));
                holding = false;
                holder = null;

            });
            // Add drop delete eventListeners
            $(".items").on("drop", ".delete-dropzone", function (event) {
                event.preventDefault();
                console.log("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
                console.log(holder);
                event.target.classList.remove("delete-dropzone-active")
                // Get the dropped element and append
                const droppedElementId = event.dataTransfer.getData("text/plain");
                console.log(event.dataTransfer.getData("text/plain"));
                const droppedElement = document.getElementById(droppedElementId);
                var taskid = document.getElementById(event.dataTransfer.getData("text/plain")).firstChild.getAttribute("taskId");
                var newPacket = new Packet(taskid, 'D', holder.parentElement.getAttribute("columnId"),  sessionStorage.getItem("User"),sessionStorage.getItem('userId'), false, holder.firstChild.innerHTML);
                stompClient.send("/app/kanban."+sessionStorage.getItem("kanban"), {}, JSON.stringify(newPacket));
                droppedElement.remove();
            });
        });
    }

    function verificarEvento(packet) {
        if (sessionStorage.getItem("User") != packet.username) {
            if (packet.action == 'D') {
                var deleteItem = document.querySelector('[taskId=\"' + packet.idtask + '\"]');
                deleteItem.remove();
            }
            else if (packet.action == 'C') {
                module.create(packet.task);
            }
            else if (packet.action == 'U') {
                var item = document.querySelector('[taskId=\"' + packet.idtask+ '\"]');
                if (item.innerHTML != packet.task.description) {
                    item.innerHTML = packet.task.description;
                    item.style.backgroundColor = null;
                }
            }
            else if (!packet.ipublic) {
                console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                var item = document.querySelector('[taskId=\"' + packet.idtask + '\"]');
                item.style.backgroundColor = "red";
                item.setAttribute("isPublic", false);
            }
            else{
                var item = document.querySelector('[taskId=\"' + packet.idtask + '\"]');
                item.remove();
                console.log(item);
                item.setAttribute("columnid",packet.idcolumn);
                item.style.backgroundColor = null;
                item.setAttribute("isPublic", true);
                var parent = document.createElement('div');
                parent.setAttribute("class","kanban-item");
                parent.setAttribute("id","item"+packet.idtask);
                parent.appendChild(item);
                var dro = document.createElement('div')
                dro.setAttribute("class","dropzone");
                parent.appendChild(dro);
                var temp = Array.from(document.getElementsByClassName("items"));
                console.log(packet.idcolumn);
                temp.forEach(e=>{
                        if(e.getAttribute("columnid")==packet.idcolumn){
                            e.appendChild(parent);
                        }
                });
            }
        }
    }

    return {
        read: getKanbanData,
        addItem: insertItem
    }

})();