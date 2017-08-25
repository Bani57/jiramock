-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema jiramock_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jiramock_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jiramock_db` DEFAULT CHARACTER SET utf8 ;
USE `jiramock_db` ;

-- -----------------------------------------------------
-- Table `jiramock_db`.`priority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`priority` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `color` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jiramock_db`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`project` (
  `id` INT(10) NOT NULL,
  `code` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jiramock_db`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`status` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `project_id` INT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_status_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_status_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `jiramock_db`.`project` (`id`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jiramock_db`.`issue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`issue` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `priority_id` INT(10) NOT NULL,
  `status_id` INT(10) NOT NULL,
  `project_id` INT(10) NOT NULL,
  `created_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_issue_priority_idx` (`priority_id` ASC),
  INDEX `fk_issue_status1_idx` (`status_id` ASC),
  INDEX `fk_issue_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_issue_priority`
    FOREIGN KEY (`priority_id`)
    REFERENCES `jiramock_db`.`priority` (`id`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_issue_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `jiramock_db`.`status` (`id`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_issue_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `jiramock_db`.`project` (`id`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jiramock_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`user` (
  `id` INT(10) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `last_request_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jiramock_db`.`user_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jiramock_db`.`user_project` (
  `project_id` INT(10) NOT NULL,
  `user_id` INT(10) NOT NULL,
  INDEX `fk_user_project_project1_idx` (`project_id` ASC),
  INDEX `fk_user_project_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_project_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `jiramock_db`.`project` (`id`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_project_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `jiramock_db`.`user` (`id`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
