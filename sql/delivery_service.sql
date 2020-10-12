-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema delivery_service
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema delivery_service
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `delivery_service` DEFAULT CHARACTER SET utf8mb4 ;
USE `delivery_service` ;

-- -----------------------------------------------------
-- Table `delivery_service`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` ENUM('manager', 'user') NOT NULL DEFAULT 'user',
  `local` ENUM('uk', 'en', 'ru') NOT NULL DEFAULT 'uk',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `delivery_service`.`rates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`rates` (
  `rates_id` INT NOT NULL AUTO_INCREMENT,
  `rate` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`rates_id`),
  UNIQUE INDEX `rates_id_UNIQUE` (`rates_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`directions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`directions` (
  `direction_id` INT NOT NULL AUTO_INCREMENT,
  `direction` ENUM('Kyiv-Kharkiv', 'Kyiv-Lviv', 'Kyiv-Vinnytsa', 'Kyiv-Dnipro', 'Kyiv-Odesa', 'Kyiv-Lutsk', 'Kyiv-Uzhhorod', 'Kyiv-Rivne', 'Kyiv-Ternopil', 'Kyiv-Zhytomyr', 'Kyiv-Khmelnytskyi', 'Kyiv-Chernivtsi', 'Kyiv-Chernihiv', 'Kyiv-Sumy', 'Kyiv-Poltava', 'Kyiv-Cherkasy', 'Kyiv-Kropyvnytskyi', 'Kyiv-Mykolaiv', 'Kyiv-Kherson', 'Kyiv-Zaporizhia') NULL,
  PRIMARY KEY (`direction_id`),
  UNIQUE INDEX `city_id_UNIQUE` (`direction_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `shipping_date` DATE NOT NULL,
  `arrival_date` DATE NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  `users_user_id` INT(11) NOT NULL,
  `rates_rates_id` INT NOT NULL,
  `directions_direction_id` INT NOT NULL,
  PRIMARY KEY (`order_id`, `rates_rates_id`, `directions_direction_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC),
  INDEX `fk_orders_users1_idx` (`users_user_id` ASC),
  INDEX `fk_orders_rates1_idx` (`rates_rates_id` ASC),
  INDEX `fk_orders_directions1_idx` (`directions_direction_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `delivery_service`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_rates1`
    FOREIGN KEY (`rates_rates_id`)
    REFERENCES `delivery_service`.`rates` (`rates_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_directions1`
    FOREIGN KEY (`directions_direction_id`)
    REFERENCES `delivery_service`.`directions` (`direction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`package`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`package` (
  `package_id` INT NOT NULL AUTO_INCREMENT,
  `package_weight` DOUBLE NOT NULL,
  `package_length` DOUBLE NOT NULL,
  `package_width` DOUBLE NOT NULL,
  `package_height` DOUBLE NOT NULL,
  `orders_order_id` INT NOT NULL,
  PRIMARY KEY (`package_id`, `orders_order_id`),
  INDEX `fk_package_orders1_idx` (`orders_order_id` ASC),
  CONSTRAINT `fk_package_orders1`
    FOREIGN KEY (`orders_order_id`)
    REFERENCES `delivery_service`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `users` (`name`, `last_name`, `login`, `password`, `role`) 
VALUES 
	   ('Manager', 'Manager', 'manager', 'manager', 'manager'),
	   ('Client', 'Client', 'client', 'client', 'user'),
	   ('Клиент', 'Клиент', 'клиент', 'клиент', 'user');
       
INSERT INTO `directions` (`direction`)
VALUES
	   ('Kyiv-Kharkiv'),
       ('Kyiv-Lviv'),
       ('Kyiv-Vinnytsa'), 
       ('Kyiv-Dnipro'), 
       ('Kyiv-Odesa'), 
       ('Kyiv-Lutsk'), 
       ('Kyiv-Uzhhorod'), 
       ('Kyiv-Rivne'), 
       ('Kyiv-Ternopil'), 
       ('Kyiv-Zhytomyr'), 
       ('Kyiv-Khmelnytskyi'), 
       ('Kyiv-Chernivtsi'), 
       ('Kyiv-Chernihiv'), 
       ('Kyiv-Sumy'), 
       ('Kyiv-Poltava'), 
       ('Kyiv-Cherkasy'), 
       ('Kyiv-Kropyvnytskyi'), 
       ('Kyiv-Mykolaiv'), 
       ('Kyiv-Kherson'), 
       ('Kyiv-Zaporizhia');
       
INSERT INTO `rates` (`rate`)
VALUES (10.5),
       (20.5),
       (30.5);
