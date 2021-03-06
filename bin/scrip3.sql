-- MySQL Script generated by MySQL Workbench
-- 10/24/15 04:31:11
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `rua` VARCHAR(45) NULL COMMENT '',
  `numero` VARCHAR(45) NULL COMMENT '',
  `bairro` VARCHAR(45) NULL COMMENT '',
  `cidade` VARCHAR(45) NULL COMMENT '',
  `cep` VARCHAR(45) NULL COMMENT '',
  `uf` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idEndereco`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `rg` VARCHAR(45) NULL COMMENT '',
  `cpf` VARCHAR(45) NULL COMMENT '',
  `estadoCivil` VARCHAR(45) NULL COMMENT '',
  `genero` VARCHAR(45) NULL COMMENT '',
  `dataNascimento` DATETIME NULL COMMENT '',
  `telefone` VARCHAR(45) NULL COMMENT '',
  `Endereco_idEndereco` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idPessoa`)  COMMENT '',
  INDEX `fk_Pessoa_Endereco_idx` (`Endereco_idEndereco` ASC)  COMMENT '',
  CONSTRAINT `fk_Pessoa_Endereco`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `mydb`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Corretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Corretor` (
  `idCorretor` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `salario` DOUBLE NULL COMMENT '',
  `comissao` DOUBLE NULL COMMENT '',
  `Pessoa_idPessoa` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCorretor`)  COMMENT '',
  INDEX `fk_Corretor_Pessoa1_idx` (`Pessoa_idPessoa` ASC)  COMMENT '',
  CONSTRAINT `fk_Corretor_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Pessoa_idPessoa` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '',
  INDEX `fk_Cliente_Pessoa1_idx` (`Pessoa_idPessoa` ASC)  COMMENT '',
  CONSTRAINT `fk_Cliente_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Interesses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Interesses` (
  `idInteresses` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(45) NULL COMMENT '',
  `Cliente_idCliente` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idInteresses`)  COMMENT '',
  INDEX `fk_Interesses_Cliente1_idx` (`Cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_Interesses_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Imovel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Imovel` (
  `idImovel` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `metrosQuadrados` VARCHAR(45) NULL COMMENT '',
  `Cliente_idCliente` INT NOT NULL COMMENT '',
  `Endereco_idEndereco` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idImovel`)  COMMENT '',
  INDEX `fk_Imovel_Cliente1_idx` (`Cliente_idCliente` ASC)  COMMENT '',
  INDEX `fk_Imovel_Endereco1_idx` (`Endereco_idEndereco` ASC)  COMMENT '',
  CONSTRAINT `fk_Imovel_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Imovel_Endereco1`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `mydb`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ImovelAlugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ImovelAlugar` (
  `idImovelAlugar` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valorMensal` DOUBLE NULL COMMENT '',
  `mesesContrato` INT(11) NULL COMMENT '',
  `Imovel_idImovel` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idImovelAlugar`)  COMMENT '',
  INDEX `fk_ImovelAlugar_Imovel1_idx` (`Imovel_idImovel` ASC)  COMMENT '',
  CONSTRAINT `fk_ImovelAlugar_Imovel1`
    FOREIGN KEY (`Imovel_idImovel`)
    REFERENCES `mydb`.`Imovel` (`idImovel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ImovelVender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ImovelVender` (
  `idImovelVender` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valorTotal` DOUBLE NULL COMMENT '',
  `Imovel_idImovel` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idImovelVender`)  COMMENT '',
  INDEX `fk_ImovelVender_Imovel1_idx` (`Imovel_idImovel` ASC)  COMMENT '',
  CONSTRAINT `fk_ImovelVender_Imovel1`
    FOREIGN KEY (`Imovel_idImovel`)
    REFERENCES `mydb`.`Imovel` (`idImovel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Historico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Historico` (
  `idHistorico` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data` DATETIME NULL COMMENT '',
  `Cliente_idCliente` INT NOT NULL COMMENT '',
  `Imovel_idImovel` INT NOT NULL COMMENT '',
  `Corretor_idCorretor` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idHistorico`)  COMMENT '',
  INDEX `fk_Historico_Cliente1_idx` (`Cliente_idCliente` ASC)  COMMENT '',
  INDEX `fk_Historico_Imovel1_idx` (`Imovel_idImovel` ASC)  COMMENT '',
  INDEX `fk_Historico_Corretor1_idx` (`Corretor_idCorretor` ASC)  COMMENT '',
  CONSTRAINT `fk_Historico_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historico_Imovel1`
    FOREIGN KEY (`Imovel_idImovel`)
    REFERENCES `mydb`.`Imovel` (`idImovel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historico_Corretor1`
    FOREIGN KEY (`Corretor_idCorretor`)
    REFERENCES `mydb`.`Corretor` (`idCorretor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
