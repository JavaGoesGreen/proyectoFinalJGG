-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema jgg
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jgg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jgg` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `jgg` ;

-- -----------------------------------------------------
-- Table `jgg`.`cargos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jgg`.`cargos` (
  `idcargo` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idcargo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `jgg`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jgg`.`clientes` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `resumen` VARCHAR(200) NULL DEFAULT NULL,
  `logo` VARCHAR(128) NULL DEFAULT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `jgg`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jgg`.`equipo` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `resumen` VARCHAR(512) NULL DEFAULT NULL,
  `foto` VARCHAR(128) NULL DEFAULT NULL,
  `cargo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  INDEX `cargo_fk` (`cargo` ASC) VISIBLE,
  CONSTRAINT `cargo`
    FOREIGN KEY (`cargo`)
    REFERENCES `jgg`.`cargos` (`idcargo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `jgg`.`mensajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jgg`.`mensajes` (
  `idmensaje` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(100) NULL DEFAULT NULL,
  `fecha` TIMESTAMP NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `mensaje` VARCHAR(512) NULL DEFAULT NULL,
  `respuesta` VARCHAR(512) NULL DEFAULT NULL,
  PRIMARY KEY (`idmensaje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `jgg`.`proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jgg`.`proyectos` (
  `idproyecto` INT NOT NULL AUTO_INCREMENT,
  `proyecto` VARCHAR(45) NULL DEFAULT NULL,
  `fechafin` VARCHAR(45) NULL DEFAULT NULL,
  `resumen` VARCHAR(200) NULL DEFAULT NULL,
  `descripcion` VARCHAR(1024) NULL DEFAULT NULL,
  `imagen` VARCHAR(128) NULL DEFAULT NULL,
  `empresa` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  INDEX `empresa_fk` (`empresa` ASC) VISIBLE,
    FOREIGN KEY (`empresa`)
    REFERENCES `jgg`.`clientes` (`idcliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
