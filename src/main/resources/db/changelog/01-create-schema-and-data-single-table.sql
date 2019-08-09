CREATE TABLE IF NOT EXISTS `PERSON` (
  `id`                 BIGINT(20)     NOT NULL AUTO_INCREMENT,
  `first_name`         VARCHAR(255)   NOT NULL,
  `last_name`          VARCHAR(255)   NOT NULL,
  `salary`             DECIMAL(19, 2) NULL,
  `working_area`       VARCHAR(255)   NULL,
  `birth_date`         TIMESTAMP      NULL,
  `type`               VARCHAR(255)   NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE INDEX IDX_TYPE ON PERSON (`type`);
CREATE INDEX IDX_WORKING_AREA ON PERSON (`working_area`);
CREATE INDEX IDX_BIRTH_DATE ON PERSON (`birth_date`);

DELIMITER $$
DROP TRIGGER IF EXISTS check_person_insert $$
CREATE TRIGGER check_person_insert BEFORE INSERT ON `person`
FOR EACH ROW BEGIN
  if NEW.type='STUDENT' THEN
    SET NEW.salary = NULL;
    SET NEW.working_area = NULL;
  END IF;
END;
$$
DELIMITER ;

CREATE TABLE IF NOT EXISTS `SUBJECT` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE INDEX IDX_SUBJECT_NAME ON SUBJECT (`name`);

CREATE TABLE IF NOT EXISTS `STUDENT_SUBJECT` (
  `student_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`student_id`, `subject_id`),
  CONSTRAINT FK_STUDENT FOREIGN KEY (`student_id`) REFERENCES PERSON (`id`),
  CONSTRAINT FK_SUBJECT FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE INDEX STUDENT_SUBJECT_IDX on STUDENT_SUBJECT (`student_id`, `subject_id`);

CREATE TABLE IF NOT EXISTS `TEACHER_SUBJECT` (
  `teacher_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`teacher_id`, `subject_id`),
  CONSTRAINT FK_TEACHER FOREIGN KEY (`teacher_id`) REFERENCES PERSON (`id`),
  CONSTRAINT FK_SUBJECT_TEACHER FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE INDEX TEACHER_SUBJECT_IDX on TEACHER_SUBJECT (`teacher_id`, `subject_id`)
