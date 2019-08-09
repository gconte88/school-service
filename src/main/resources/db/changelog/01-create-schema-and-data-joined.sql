CREATE TABLE IF NOT EXISTS `PERSON` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name`  VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `id`     BIGINT(20)     NOT NULL AUTO_INCREMENT,
  `salary` DECIMAL(19, 2) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `JANITOR` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `working_area` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `PRINCIPAL` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `STUDENT` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `birth_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `SUBJECT` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `STUDENT_SUBJECT` (
  `student_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`student_id`, `subject_id`),
  CONSTRAINT FK_STUDENT FOREIGN KEY (`student_id`) REFERENCES STUDENT (`id`),
  CONSTRAINT FK_SUBJECT FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `TEACHER` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `TEACHER_SUBJECT` (
  `teacher_id` BIGINT(20) NOT NULL,
  `subject_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`teacher_id`, `subject_id`),
  CONSTRAINT FK_STUDENT FOREIGN KEY (`teacher_id`) REFERENCES TEACHER (`id`),
  CONSTRAINT FK_SUBJECT FOREIGN KEY (`subject_id`) REFERENCES SUBJECT (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;