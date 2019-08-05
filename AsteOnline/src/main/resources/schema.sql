-- MySQL Script generated by MySQL Workbench
-- Mon Jul 29 21:35:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema AsteOnline
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `AsteOnline` ;

-- -----------------------------------------------------
-- Schema AsteOnline
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AsteOnline` DEFAULT CHARACTER SET utf8 ;
USE `AsteOnline` ;

-- -----------------------------------------------------
-- Table `AsteOnline`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Role` (
  `idRole` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`AuthenticationData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`AuthenticationData` (
  `idAuthentication` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `registrationDatetime` DATETIME NOT NULL,
  `idRole` INT NOT NULL,
  PRIMARY KEY (`idAuthentication`, `username`),
  INDEX `fk_idRole_idx` (`idRole` ASC) VISIBLE,
  CONSTRAINT `fkIdAuthenticationRole`
    FOREIGN KEY (`idRole`)
    REFERENCES `AsteOnline`.`Role` (`idRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Categories` (
  `idCategory` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Addresses` (
  `idAddress` INT NOT NULL,
  `street` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `province` VARCHAR(100) NOT NULL,
  `nation` VARCHAR(100) NOT NULL,
  `houseNumber` VARCHAR(45) NOT NULL,
  `postalCode` INT NOT NULL,
  PRIMARY KEY (`idAddress`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`ObjectsAndServices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`ObjectsAndServices` (
  `idObjSer` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `startPrice` DOUBLE NOT NULL,
  `isObject` TINYINT NOT NULL,
  `isAvailable` TINYINT NOT NULL DEFAULT 0,
  `idCategory` INT NOT NULL,
  `idUser` INT NOT NULL,
  `idAddress` INT NOT NULL,
  INDEX `fkObj_IdCategory_idx` (`idCategory` ASC) VISIBLE,
  INDEX `fkObj_idUser_idx` (`idUser` ASC) VISIBLE,
  PRIMARY KEY (`idObjSer`),
  INDEX `fk_Obj_idAddress_idx` (`idAddress` ASC) VISIBLE,
  CONSTRAINT `fkObj_IdCategory`
    FOREIGN KEY (`idCategory`)
    REFERENCES `AsteOnline`.`Categories` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkObj_idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `AsteOnline`.`AuthenticationData` (`idAuthentication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Obj_idAddress`
    FOREIGN KEY (`idAddress`)
    REFERENCES `AsteOnline`.`Addresses` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Auctions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Auctions` (
  `idAuction` INT NOT NULL AUTO_INCREMENT,
  `state` TINYINT NOT NULL COMMENT '3 stati: nessunaAstaInCorso, AstaInCorso, AstaTerminata',
  `numTimeSlot` INT NOT NULL,
  `terminationType` TINYINT NOT NULL,
  `cancellationPenalty` INT NOT NULL,
  `timeSlotDuration` DATETIME NOT NULL,
  `startTimeSlot` DATETIME NOT NULL,
  `endTimeSlot` DATETIME NOT NULL,
  `closedEnvelop` TINYINT NOT NULL,
  `winner` VARCHAR(45) NOT NULL,
  `idObjSer` INT NOT NULL,
  `decline` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`idAuction`),
  INDEX `fk_idObjSer2_idx` (`idObjSer` ASC) VISIBLE,
  CONSTRAINT `fk_idObjSer2`
    FOREIGN KEY (`idObjSer`)
    REFERENCES `AsteOnline`.`ObjectsAndServices` (`idObjSer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Offers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Offers` (
  `idOffer` INT NOT NULL AUTO_INCREMENT,
  `amountOfferes` DOUBLE NOT NULL,
  `offerTime` DATETIME NOT NULL,
  `idOfferent` INT NOT NULL,
  `idAuction` INT NOT NULL,
  INDEX `fkIdOfferent` (`idOfferent` ASC) VISIBLE,
  PRIMARY KEY (`idOffer`),
  INDEX `fk_idAuction_Authentication_idx` (`idAuction` ASC) VISIBLE,
  CONSTRAINT `fkIdOfferentIdAuthentication`
    FOREIGN KEY (`idOfferent`)
    REFERENCES `AsteOnline`.`AuthenticationData` (`idAuthentication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idAuction_Authentication`
    FOREIGN KEY (`idAuction`)
    REFERENCES `AsteOnline`.`Auctions` (`idAuction`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Attributes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Attributes` (
  `idAttribute` INT NOT NULL DEFAULT 100,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idAttribute`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`AttributesCategoriesMap`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`AttributesCategoriesMap` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idCategory` INT NOT NULL,
  `idAttribute` INT NOT NULL,
  INDEX `fk_Categorie_has_Attributi_Attributi1_idx` (`idAttribute` ASC) VISIBLE,
  INDEX `fk_Categorie_has_Attributi_Categorie1_idx` (`idCategory` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fkIdCategoryIdCategory`
    FOREIGN KEY (`idCategory`)
    REFERENCES `AsteOnline`.`Categories` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkIdAttributeIdAttribute`
    FOREIGN KEY (`idAttribute`)
    REFERENCES `AsteOnline`.`Attributes` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`Notifications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`Notifications` (
  `id` INT NOT NULL,
  `idNotification` INT NOT NULL,
  `message` VARCHAR(260) NOT NULL,
  `idRecipient` INT NOT NULL,
  INDEX `fk_idRecipient_idx` (`idRecipient` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fkIdRecipientAuthentication`
    FOREIGN KEY (`idRecipient`)
    REFERENCES `AsteOnline`.`AuthenticationData` (`idAuthentication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AsteOnline`.`UsersAccount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AsteOnline`.`UsersAccount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `telephone` VARCHAR(15) NOT NULL,
  `smsNotifications` TINYINT NOT NULL,
  `emailNotifications` TINYINT NOT NULL,
  `creditCardNumber` INT NOT NULL,
  `numberOfCredits` INT NOT NULL,
  `idAddress` INT NOT NULL,
  `idAuthentication` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_1idAuthentication_idx` (`idAuthentication` ASC) VISIBLE,
  INDEX `fk_idAddressUserAccount_idx` (`idAddress` ASC) VISIBLE,
  CONSTRAINT `fk_1idAuthentication`
    FOREIGN KEY (`idAuthentication`)
    REFERENCES `AsteOnline`.`AuthenticationData` (`idAuthentication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idAddressUserAccount`
    FOREIGN KEY (`idAddress`)
    REFERENCES `AsteOnline`.`Addresses` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;