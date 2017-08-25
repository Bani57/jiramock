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





select * from jiramock_db.issue;

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (2,
  'bmijalcheva',
  'bojana',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (3,
  'vmonev',
  'vilijan',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (4,
  'lpoleksikj',
  'lidija',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (5,
  'bevkoski',
  'bojan',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (6,
  'eshalatanovska',
  'eva',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (7,
  'mbogutcki',
  'michal',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (8,
  'ishontevska',
  'ivana',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (9,
  'spetrovski',
  'stefan',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (10,
  'ajanchevski',
  'andrej',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (11,
  'dzhelkov',
  'dimitri',
  now());

INSERT INTO `jiramock_db`.`user`
(`id`,
 `username`,
 `password`,
 `last_request_time`)
VALUES
 (12,
  'sarsovski',
  'sinisha',
  now());

select * from jiramock_db.user;

INSERT INTO `jiramock_db`.`project`
(`id`,
 `code`,
 `description`)
VALUES
 (2,
  456,
  'test project2');

INSERT INTO `jiramock_db`.`project`
(`id`,
 `code`,
 `description`)
VALUES
 (3,
  789,
  'test project3');

INSERT INTO `jiramock_db`.`project`
(`id`,
 `code`,
 `description`)
VALUES
 (4,
  147,
  'test project4');

INSERT INTO `jiramock_db`.`project`
(`id`,
 `code`,
 `description`)
VALUES
 (5,
  258,
  'test project5');

INSERT INTO `jiramock_db`.`project`
(`id`,
 `code`,
 `description`)
VALUES
 (6,
  369,
  'test project6');

select * from jiramock_db.project;

INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (2,
  1);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (3,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (4,
  3);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (5,
  3);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (6,
  1);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (7,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (8,
  1);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (9,
  3);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (10,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (11,
  1);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (12,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (11,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (11,
  3);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (12,
  1);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (2,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (1,
  2);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (1,
  3);
INSERT INTO `jiramock_db`.`user_project`
(`user_id`,
 `project_id`)
VALUES
 (7,
  3);

select * from jiramock_db.user_project;

INSERT INTO `jiramock_db`.`priority`
(`id`,
 `name`,
 `description`,
 `color`)
VALUES
 (4,
  'CRITICAL',
  'Critical priority',
  '#123456');

INSERT INTO `jiramock_db`.`priority`
(`id`,
 `name`,
 `description`,
 `color`)
VALUES
 (5,
  'BLOCKER',
  'Blocker',
  '#123457');

INSERT INTO `jiramock_db`.`priority`
(`id`,
 `name`,
 `description`,
 `color`)
VALUES
 (6,
  'MAJOR',
  'Major priority',
  '#985123');

INSERT INTO `jiramock_db`.`priority`
(`id`,
 `name`,
 `description`,
 `color`)
VALUES
 (7,
  'MINOR',
  'Minor priority',
  '#ABCDEF');

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

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (4,
  1,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (5,
  1,
  'IN PLANNING',
  'Task in planning');



INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (6,
  2,
  'OPEN',
  'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (7,
  2,
  'IN PROGRESS',
  'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (8,
  2,
  'CLOSED',
  'Task is closed');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (9,
  2,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (10,
  2,
  'IN PLANNING',
  'Task in planning');


INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (11,
  3,
  'OPEN',
  'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (12,
  3,
  'IN PROGRESS',
  'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (13,
  3,
  'CLOSED',
  'Task is closed');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (14,
  3,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (15,
  3,
  'IN PLANNING',
  'Task in planning');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (16,
  4,
  'OPEN',
  'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (17,
  4,
  'IN PROGRESS',
  'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (18,
  4,
  'CLOSED',
  'Task is closed');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (19,
  4,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (20,
  4,
  'IN PLANNING',
  'Task in planning');

select * from jiramock_db.status;


INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (21,
  5,
  'OPEN',
  'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (22,
  5,
  'IN PROGRESS',
  'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (23,
  5,
  'CLOSED',
  'Task is closed');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (24,
  5,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (25,
  5,
  'IN PLANNING',
  'Task in planning');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (26,
  6,
  'OPEN',
  'Task is open');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (27,
  6,
  'IN PROGRESS',
  'Task in progress');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (28,
  6,
  'CLOSED',
  'Task is closed');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (29,
  6,
  'IN TESTING',
  'Task in testing');

INSERT INTO `jiramock_db`.`status`
(`id`,
 `project_id`,
 `name`,
 `description`)
VALUES
 (30,
  6,
  'IN PLANNING',
  'Task in planning');





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
  '1 issue',
  '1 test issue',
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
  '2 issue',
  '2 test issue',
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
  '3 issue',
  '3 test issue',
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
  '4 issue',
  '4 test issue',
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
  '5 issue',
  '5 test issue',
  1,
  2,
  2,
  now());
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('6', '6 issue', '6 test issue', '1', '1', '1', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('7', '7 issue', '7 test issue', '2', '2', '2', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('8', '8 issue', '8 test issue', '3', '3', '3', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('9', '9 issue', '9 test issue', '4', '4', '4', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('10', '10 issue', '10 test issue', '5', '5', '5', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('11', '11 issue', '11 test issue', '6', '1', '6', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('12', '12 issue', '12 test issue', '7', '2', '1', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('13', '13 issue', '13 test issue', '1', '3', '2', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('14', '14 issue', '14 test issue', '2', '4', '3', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('15', '15 issue', '15 test issue', '3', '5', '4', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('16', '16 issue', '16 test issue', '4', '1', '5', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('17', '17 issue', '17 test issue', '5', '2', '6', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('18', '18 issue', '18 test issue', '6', '3', '1', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('19', '19 issue', '19 test issue', '7', '4', '2', '2017-08-08 12:32:01');
INSERT INTO `jiramock_db`.`issue` (`id`, `name`, `description`, `priority_id`, `status_id`, `project_id`, `created_time`) VALUES ('20', '20 issue', '20 test issue', '1', '5', '3', '2017-08-08 12:32:01');

select * from jiramock_db.issue;










