INSERT INTO ASSIGNATURES (id,Name) VALUES (1,'ARSW');
INSERT INTO ASSIGNATURES (id,Name) VALUES (2,'AREP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (3,'SPTI');
INSERT INTO ASSIGNATURES (id,Name) VALUES (4,'FDGP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (5,'EGR1');

INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (1,'07:00','10:00','L',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (2,'08:30','10:00','J',2);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (3,'11:30','13:00','V',3);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (4,'07:00','08:30','M',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (5,'16:00','19:00','X',3);

INSERT INTO CUSTOMERS (id,name) VALUES (0,'baez');

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

insert into kanban_columns (id,id_kanban,"name") values (1,1,'TO_DO');
insert into kanban_columns (id,id_kanban,"name") values (2,1,'DOING');
insert into kanban_columns (id,id_kanban,"name") values (3,1,'DONE');
insert into kanban_columns (id,id_kanban,"name") values (4,2,'TO_DO');
insert into kanban_columns (id,id_kanban,"name") values (5,2,'DONE');

insert into tasks (id,creation_date ,description,is_public,last_date,title,id_customer,id_kanban_column) values (1,'2022-03-19 13:00:00.59','Realizar tarea 1',true,'2022-03-20 13:00:00.59','Tarea 1',0,1)
insert into tasks (id,creation_date ,description,is_public,last_date,title,id_customer,id_kanban_column) values (2,'2022-03-21 13:00:00.59','Realizar tarea 2',true,'2022-03-25 13:00:00.59','Tarea 2',0,2)
insert into tasks (id,creation_date ,description,is_public,last_date,title,id_customer,id_kanban_column) values (3,'2022-03-22 13:00:00.59','Realizar tarea 3',true,'2022-03-24 13:00:00.59','Tarea 3',0,3)
