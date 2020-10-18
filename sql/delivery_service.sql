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
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `delivery_service`.`directions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`directions` (
  `direction_id` INT NOT NULL AUTO_INCREMENT,
  `direction` ENUM('Kyiv-Kharkiv', 'Kyiv-Lviv', 'Kyiv-Vinnytsa', 'Kyiv-Dnipro', 'Kyiv-Odesa', 'Kyiv-Lutsk', 'Kyiv-Uzhhorod', 'Kyiv-Rivne', 'Kyiv-Ternopil', 'Kyiv-Zhytomyr', 'Kyiv-Khmelnytskyi', 'Kyiv-Chernivtsi', 'Kyiv-Chernihiv', 'Kyiv-Sumy', 'Kyiv-Poltava', 'Kyiv-Cherkasy', 'Kyiv-Kropyvnytskyi', 'Kyiv-Mykolaiv', 'Kyiv-Kherson', 'Kyiv-Zaporizhia') NULL,
  `distance` INT NOT NULL,
  PRIMARY KEY (`direction_id`),
  UNIQUE INDEX `city_id_UNIQUE` (`direction_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  `shipping_date` DATE NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  `users_user_id` INT(11) NOT NULL,
  `directions_direction_id` INT NOT NULL,
  PRIMARY KEY (`order_id`, `users_user_id`, `directions_direction_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC),
  INDEX `fk_orders_users1_idx` (`users_user_id` ASC),
  INDEX `fk_orders_directions1_idx` (`directions_direction_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `delivery_service`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_directions1`
    FOREIGN KEY (`directions_direction_id`)
    REFERENCES `delivery_service`.`directions` (`direction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`rates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`rates` (
  `rates_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rate` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`rates_id`),
  UNIQUE INDEX `rates_id_UNIQUE` (`rates_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery_service`.`bills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery_service`.`bills` (
  `bill_id` INT NOT NULL AUTO_INCREMENT,
  `orders_order_id` INT NOT NULL,
  `orders_users_user_id` INT(11) NOT NULL,
  `orders_directions_direction_id` INT NOT NULL,
  `order_description` VARCHAR(45) NOT NULL,
  `order_address` VARCHAR(45) NOT NULL,
  `order_direction` VARCHAR(45) NOT NULL,
  `order_cost` DECIMAL(5,2) NOT NULL,
  `order_shipping_date` DATE NOT NULL,
  `order_user_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'not_paid',
  PRIMARY KEY (`bill_id`, `orders_order_id`, `orders_users_user_id`, `orders_directions_direction_id`),
  UNIQUE INDEX `bill_id_UNIQUE` (`bill_id` ASC),
  INDEX `fk_bills_orders1_idx` (`orders_order_id` ASC, `orders_users_user_id` ASC, `orders_directions_direction_id` ASC),
  CONSTRAINT `fk_bills_orders1`
    FOREIGN KEY (`orders_order_id` , `orders_users_user_id` , `orders_directions_direction_id`)
    REFERENCES `delivery_service`.`orders` (`order_id` , `users_user_id` , `directions_direction_id`)
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
       
INSERT INTO `rates` (`name`,`rate`)
VALUES 
       ('up_to_2', 1),
       ('over_2', 1.5),
       ('otherwise', 2);
       
INSERT INTO `directions` (`direction`, `distance`)
VALUES
       ('Kyiv-Kharkiv', 480),
       ('Kyiv-Lviv', 541),
       ('Kyiv-Vinnytsa', 269), 
       ('Kyiv-Dnipro', 453), 
       ('Kyiv-Odesa', 475), 
       ('Kyiv-Lutsk', 400), 
       ('Kyiv-Uzhhorod', 811), 
       ('Kyiv-Rivne', 327), 
       ('Kyiv-Ternopil', 420), 
       ('Kyiv-Zhytomyr', 140), 
       ('Kyiv-Khmelnytskyi', 323), 
       ('Kyiv-Chernivtsi', 513), 
       ('Kyiv-Chernihiv', 154), 
       ('Kyiv-Sumy', 333), 
       ('Kyiv-Poltava', 344), 
       ('Kyiv-Cherkasy', 190), 
       ('Kyiv-Kropyvnytskyi', 303), 
       ('Kyiv-Mykolaiv', 481), 
       ('Kyiv-Kherson', 547), 
       ('Kyiv-Zaporizhia', 514);