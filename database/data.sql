INSERT INTO ASSIGNATURE (id,Name,Creditos) VALUES (1,'ARSW',4);
INSERT INTO ASSIGNATURE (id,Name,Creditos) VALUES (2,'AREP',4);
INSERT INTO ASSIGNATURE (id,Name,Creditos) VALUES (3,'SPTI',4);
INSERT INTO ASSIGNATURE (id,Name,Creditos) VALUES (4,'FDGP',3);
INSERT INTO ASSIGNATURE (id,Name,Creditos) VALUES (5,'EGR1',3);

INSERT INTO DATE (id,hora,dia,idAssignature) VALUES (1,1,'L',1);
INSERT INTO DATE (id,hora,dia,idAssignature) VALUES (2,5,'J',2);
INSERT INTO DATE (id,hora,dia,idAssignature) VALUES (3,3,'S',3);
INSERT INTO DATE (id,hora,dia,idAssignature) VALUES (4,7,'M',1);
INSERT INTO DATE (id,hora,dia,idAssignature) VALUES (5,4,'X',3);

INSERT INTO COSTUMER (id,name) VALUES (1,"Ernesto Perez");
INSERT INTO COSTUMER (id,name) VALUES (2,"Elton Osoria");
INSERT INTO COSTUMER (id,name) VALUES (3,"Susana Tito");
INSERT INTO COSTUMER (id,name) VALUES (4,"Juanito Baez");
INSERT INTO COSTUMER (id,name) VALUES (5,"Dajis Castillo");

INSERT INTO KANBAN (id,IdCDate) VALUES (1,1);
INSERT INTO KANBAN (id,IdCDate) VALUES (2,2);
INSERT INTO KANBAN (id,IdCDate) VALUES (3,3);
INSERT INTO KANBAN (id,IdCDate) VALUES (4,4);
INSERT INTO KANBAN (id,IdCDate) VALUES (5,5);

INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (1,1,"TO DO");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (2,2,"DOING");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (3,3,"DONE");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (4,4,"TO DO");
INSERT INTO KANBANCOLUMN (id,IdKanban,Name) VALUES (5,5,"DONE");

INSERT INTO SCHEDUALES (id,owner) VALUES (1,"Susana Tito");
INSERT INTO SCHEDUALES (id,owner) VALUES (2,"Dajis Castillo");
INSERT INTO SCHEDUALES (id,owner) VALUES (3,"Ernesto Perez");
INSERT INTO SCHEDUALES (id,owner) VALUES (4,"Susana Tito");
INSERT INTO SCHEDUALES (id,owner) VALUES (5,"Elton Osoria");

INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (1,1,1);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (2,2,2);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (3,3,3);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (4,4,4);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (5,5,5);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (6,1,2);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (7,3,3);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (8,2,1);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (9,5,3);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (10,4,1);
INSERT INTO AssignatureXScheduale (id,schedualeId,assignatureId) VALUES (11,1,5);

INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (1,1,1,True,"Tarea 1","Realizar tarea 1",'2022-03-19T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (2,2,2,False,"Tarea 2","Realizar tarea 2",'2022-03-20T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (3,3,3,False,"Tarea 3","Realizar tarea 3",'2022-03-21T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (4,4,4,True,"Tarea 4","Realizar tarea 4",'2022-03-22T11:43:13Z');
INSERT INTO TASKS (id,IdKanbanColumn,IdCustomer,isPublic,Title,Description,LastDate) VALUES (5,5,5,True,"Tarea 5","Realizar tarea 5",'2022-03-23T11:43:13Z');
