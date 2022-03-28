INSERT INTO ASSIGNATURES (id,Name) VALUES (1,'ARSW');
INSERT INTO ASSIGNATURES (id,Name) VALUES (2,'AREP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (3,'SPTI');
INSERT INTO ASSIGNATURES (id,Name) VALUES (4,'FDGP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (5,'EGR1');

INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (1,'07:00','10:00','L',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (2,'08:30','10:00','J',2);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (3,'11:30','14:00','V',3);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (4,'07:00','08:30','M',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (5,'04:00','19:00','X',3);

INSERT INTO CUSTUMERS (id,name) VALUES (0,'baez');

INSERT INTO schedules(id, creation_date, owner)VALUES (0,current_timestamp,0);

INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,1);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,2);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,3);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,4);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,5);


INSERT INTO KANBAN (id,IdCDate) VALUES (1,1);
INSERT INTO KANBAN (id,IdCDate) VALUES (2,2);
INSERT INTO KANBAN (id,IdCDate) VALUES (3,3);
INSERT INTO KANBAN (id,IdCDate) VALUES (4,4);
INSERT INTO KANBAN (id,IdCDate) VALUES (5,5);

INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (1,1,"TO DO");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (2,1,"DOING");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (3,1,"DONE");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (4,2,"TO DO");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (5,2,"DONE");


INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (1,1,1,True,"Tarea 1","Realizar tarea 1",'2022-03-19T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (2,2,2,False,"Tarea 2","Realizar tarea 2",'2022-03-20T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (3,3,3,False,"Tarea 3","Realizar tarea 3",'2022-03-21T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (4,4,4,True,"Tarea 4","Realizar tarea 4",'2022-03-22T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (5,5,5,True,"Tarea 5","Realizar tarea 5",'2022-03-23T11:43:13Z');
