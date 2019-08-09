
CREATE TABLE IF NOT EXISTS `PERSON` (
  `id`                 BIGINT(20)     NOT NULL AUTO_INCREMENT,
  `first_name`         VARCHAR(255)   NOT NULL,
  `last_name`          VARCHAR(255)   NOT NULL,
  `salary`             DECIMAL(19,2) NULL,
  `working_area`       VARCHAR(255)   NULL,
  `birth_date`         TIMESTAMP      NULL,
  `type`               VARCHAR(255)   NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `SUBJECT` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `STUDENT_SUBJECT` (
  `student_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`student_id`, `subject_id`),
  CONSTRAINT FK_STUDENT FOREIGN KEY (`student_id`) REFERENCES PERSON (`id`),
  CONSTRAINT FK_SUBJECT FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `TEACHER_SUBJECT` (
  `teacher_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`teacher_id`, `subject_id`),
  CONSTRAINT FK_TEACHER FOREIGN KEY (`teacher_id`) REFERENCES PERSON (`id`),
  CONSTRAINT FK_SUBJECT_TEACHER FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE INDEX IDX_TYPE ON PERSON (`type`);
CREATE INDEX IDX_WORKING_AREA ON PERSON (`working_area`);
CREATE INDEX IDX_BIRTH_DATE ON PERSON (`birth_date`);
CREATE INDEX IDX_SUBJECT_NAME ON SUBJECT (`name`);
CREATE INDEX STUDENT_SUBJECT_IDX on STUDENT_SUBJECT (`student_id`, `subject_id`);
CREATE INDEX TEACHER_SUBJECT_IDX on TEACHER_SUBJECT (`teacher_id`, `subject_id`);

INSERT INTO `PERSON` (`id`, `first_name`, `last_name`, `salary`, `working_area`, `birth_date`, `type`)
VALUES
  (2, 'Seymour', 'Skinner', 35000.00, NULL, NULL, 'PRINCIPAL'),
  (3, 'Bart', 'Simpson', NULL, NULL, '1999-04-05 17:42:17', 'STUDENT'),
  (4, 'Lisa', 'Simpson', NULL, NULL, '2001-04-05 17:42:17', 'STUDENT'),
  (5, 'Milhouse', 'Van Houten', NULL, NULL, '1998-04-05 17:42:17', 'STUDENT'),
  (6, 'Jimbo', 'Roso', NULL, NULL, '1970-04-05 17:42:17', 'STUDENT'),
  (7, 'Nelson', 'Muntz', NULL, NULL, '1997-04-05 17:42:17', 'STUDENT'),
  (8, 'William', 'MacDougal', 15000.00, 'HALLWAY', NULL, 'JANITOR'),
  (9, 'Willie', 'GroundKeeper', 15000.00, 'ENTRANCE', NULL, 'JANITOR'),
  (10, 'Cletus', 'Spuckler', 15000.00, 'CLASSROOM', NULL, 'JANITOR'),
  (11, 'Hugo', 'Jannitore', 15000.00, 'SCHOOLYARD', NULL, 'JANITOR'),
  (12, 'Osman', 'Weaver', 15000.00, 'HALLWAY', NULL, 'JANITOR'),
  (13, 'Amna', 'Bourne', 15000.00, 'HALLWAY', NULL, 'JANITOR'),
  (14, 'DontWant', 'ToStudy', NULL, NULL, '1996-04-05 17:42:17', 'STUDENT'),
  (15, 'Professor', 'Brinks', 15000.00, NULL, NULL, 'TEACHER'),
  (16, 'Professor', 'McGonnagal', 15000.00, NULL, NULL, 'TEACHER'),
  (17, 'Professor', 'Snape', 15000.00, NULL, NULL, 'TEACHER'),
  (18, 'Professor', 'X', 15000.00, NULL, NULL, 'TEACHER');

INSERT INTO `SUBJECT` (`id`, `name`)
VALUES
  (7, 'Art'),
  (8, 'English'),
  (5, 'Geography'),
  (2, 'History'),
  (3, 'Math'),
  (6, 'Music');

INSERT INTO `STUDENT_SUBJECT` (`student_id`, `subject_id`)
VALUES
  (3, 2),
  (5, 2),
  (6, 2),
  (7, 2),
  (4, 3),
  (6, 3),
  (7, 3),
  (3, 5),
  (4, 5),
  (5, 5),
  (6, 5),
  (7, 5),
  (4, 6),
  (4, 7),
  (5, 7),
  (6, 7);

INSERT INTO `TEACHER_SUBJECT` (`teacher_id`, `subject_id`)
VALUES
  (16, 2),
  (15, 3),
  (18, 3),
  (16, 5),
  (18, 5),
  (15, 6),
  (16, 7),
  (17, 7),
  (18, 7),
  (18, 8);
