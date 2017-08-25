delete from jiramock_db.issue;
delete from jiramock_db.priority;
delete from jiramock_db.status;
delete from jiramock_db.user_project;
delete from jiramock_db.user;
delete from jiramock_db.project;

INSERT INTO `jiramock_db`.`user`
(`id`,
`username`,
`password`,
`last_request_time`)
VALUES
(1,
'admin',
'admin',
now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
  (2,
   'root',
   'root',
   now());


select * from jiramock_db.user;


INSERT INTO `jiramock_db`.`project`
(`id`,
`code`,
`description`)
VALUES
(1,
123,
'test project');


select * from jiramock_db.project;


INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
`project_id`)
VALUES
(1,
1);

select * from jiramock_db.user_project;


INSERT INTO `jiramock_db`.`priority`
(`id`,
`name`,
`description`,
`color`)
VALUES
(1,
'LOW',
'low priority',
'#FFFFFF');

INSERT INTO `jiramock_db`.`priority`
(`id`,
`name`,
`description`,
`color`)
VALUES
(2,
'MEDIUM',
'Medium priority',
'#000000');

INSERT INTO `jiramock_db`.`priority`
(`id`,
`name`,
`description`,
`color`)
VALUES
(3,
'HIGH',
'High priority',
'#FF0000');


select * from jiramock_db.priority;

INSERT INTO `jiramock_db`.`status`
(`id`,
`project_id`,
`name`,
`description`)
VALUES
(1,
1,
'OPEN',
'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
`project_id`,
`name`,
`description`)
VALUES
(2,
1,
'IN PROGRESS',
'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
`project_id`,
`name`,
`description`)
VALUES
(3,
1,
'CLOSED',
'Task is closed');


select * from jiramock_db.status;




INSERT INTO `jiramock_db`.`issue`
(`id`,
`name`,
`description`,
`project_id`,
`priority_id`,
`status_id`,
`created_time`)
VALUES
(1,
'First issue',
'test first issue',
1,
1,
1,
now());

INSERT INTO `jiramock_db`.`issue`
(`id`,
`name`,
`description`,
`project_id`,
`priority_id`,
`status_id`,
`created_time`)
VALUES
(2,
'Second issue',
'test second issue',
1,
2,
2,
now());


INSERT INTO `jiramock_db`.`issue`
(`id`,
`name`,
`description`,
`project_id`,
`priority_id`,
`status_id`,
`created_time`)
VALUES
(3,
'Third issue',
'test third issue',
1,
3,
3,
now());


INSERT INTO `jiramock_db`.`issue`
(`id`,
`name`,
`description`,
`project_id`,
`priority_id`,
`status_id`,
`created_time`)
VALUES
(4,
'Forth issue',
'test forth issue',
1,
1,
1,
now());

INSERT INTO `jiramock_db`.`issue`
(`id`,
`name`,
`description`,
`project_id`,
`priority_id`,
`status_id`,
`created_time`)
VALUES
(5,
'Fifth issue',
'test fifth issue',
1,
2,
2,
now());


select * from jiramock_db.issue;














