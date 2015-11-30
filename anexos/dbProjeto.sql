-- MySQL Script generated by MySQL Workbench
-- 11/24/15 21:10:45
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbProjeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbProjeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbProjeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dbProjeto` ;

-- -----------------------------------------------------
-- Table `dbProjeto`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Endereco` (
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
-- Table `dbProjeto`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `rg` VARCHAR(45) NULL COMMENT '',
  `cpf` VARCHAR(45) NULL COMMENT '',
  `estadoCivil` VARCHAR(45) NULL COMMENT '',
  `genero` VARCHAR(45) NULL COMMENT '',
  `dataNascimento` DATE NULL COMMENT '',
  `telefoneResidencial` VARCHAR(45) NULL COMMENT '',
  `telefoneCelular` VARCHAR(45) NULL COMMENT '',
  `email` VARCHAR(90) NULL COMMENT '',
  `Endereco_idEndereco` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idPessoa`)  COMMENT '',
  INDEX `fk_Pessoa_Endereco_idx` (`Endereco_idEndereco` ASC)  COMMENT '',
  CONSTRAINT `fk_Pessoa_Endereco`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `dbProjeto`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`Corretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Corretor` (
  `idCorretor` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `salario` DOUBLE NULL COMMENT '',
  `Pessoa_idPessoa` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCorretor`)  COMMENT '',
  INDEX `fk_Corretor_Pessoa1_idx` (`Pessoa_idPessoa` ASC)  COMMENT '',
  CONSTRAINT `fk_Corretor_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `dbProjeto`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `interesse1` VARCHAR(45) NULL COMMENT '',
  `interesse2` VARCHAR(45) NULL COMMENT '',
  `interesse3` VARCHAR(45) NULL COMMENT '',
  `Pessoa_idPessoa` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '',
  INDEX `fk_Cliente_Pessoa1_idx` (`Pessoa_idPessoa` ASC)  COMMENT '',
  CONSTRAINT `fk_Cliente_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `dbProjeto`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`Imovel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Imovel` (
  `idImovel` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `metrosQuadrados` VARCHAR(45) NULL COMMENT '',
  `Cliente_idCliente` INT NOT NULL COMMENT '',
  `valorTotal` DOUBLE NULL COMMENT '',
  `valorMensal` DOUBLE NULL COMMENT '',
  `mesesContrato` INT NULL COMMENT '',
  `Endereco_idEndereco` INT NOT NULL COMMENT '',
  `imagem1` VARCHAR(400) NULL COMMENT '',
  `imagem2` VARCHAR(400) NULL COMMENT '',
  `imagem3` VARCHAR(400) NULL COMMENT '',
  `descricao1` VARCHAR(45) NULL COMMENT '',
  `descricao2` VARCHAR(45) NULL COMMENT '',
  `descricao3` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idImovel`)  COMMENT '',
  INDEX `fk_Imovel_Cliente1_idx` (`Cliente_idCliente` ASC)  COMMENT '',
  INDEX `fk_Imovel_Endereco1_idx` (`Endereco_idEndereco` ASC)  COMMENT '',
  CONSTRAINT `fk_Imovel_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `dbProjeto`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Imovel_Endereco1`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `dbProjeto`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    `imagem4` VARCHAR(400) NULL COMMENT '',
    `possui` INT NOT NULL COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`ImovelAlugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`ImovelAlugar` (
  `idImovelAlugar` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valorMensal` DOUBLE NULL COMMENT '',
  `mesesContrato` INT(11) NULL COMMENT '',
  `Imovel_idImovel` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idImovelAlugar`)  COMMENT '',
  INDEX `fk_ImovelAlugar_Imovel1_idx` (`Imovel_idImovel` ASC)  COMMENT '',
  CONSTRAINT `fk_ImovelAlugar_Imovel1`
    FOREIGN KEY (`Imovel_idImovel`)
    REFERENCES `dbProjeto`.`Imovel` (`idImovel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`ImovelVender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`ImovelVender` (
  `idImovelVender` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valorTotal` DOUBLE NULL COMMENT '',
  `Imovel_idImovel` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idImovelVender`)  COMMENT '',
  INDEX `fk_ImovelVender_Imovel1_idx` (`Imovel_idImovel` ASC)  COMMENT '',
  CONSTRAINT `fk_ImovelVender_Imovel1`
    FOREIGN KEY (`Imovel_idImovel`)
    REFERENCES `dbProjeto`.`Imovel` (`idImovel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbProjeto`.`Venda`
-- -----------------------------------------------------
create table venda(
	idVenda integer not null primary key auto_increment,
    data date,
    comissaoImobiliaria DOUBLE(10,2),
    comissaoCorretor DOUBLE(10,2),
    idCliente integer, 
    idImovel integer,
    idCorretor integer,
    foreign key (idCliente) references cliente(idCliente),
    foreign key (idImovel) references imovel(idImovel),
    foreign key (idCorretor) references corretor(idCorretor)
);


-- -----------------------------------------------------
-- Table `dbProjeto`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbProjeto`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `login` VARCHAR(45) NULL COMMENT '',
  `senha` VARCHAR(45) NULL COMMENT '',
  `Corretor_idCorretor` INT NOT NULL COMMENT '',
  `nivelAcesso` INT NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '',
  INDEX `fk_Usuario_Corretor1_idx` (`Corretor_idCorretor` ASC)  COMMENT '',
  CONSTRAINT `fk_Usuario_Corretor1`
    FOREIGN KEY (`Corretor_idCorretor`)
    REFERENCES `dbProjeto`.`Corretor` (`idCorretor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Imobiliaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbprojeto`.`Imobiliaria` (
  `idImobiliaria` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nomeFantasia` VARCHAR(150) NULL COMMENT '',
  `razaoSocial` VARCHAR(150) NULL COMMENT '',
  `cnpj` VARCHAR(120) NULL COMMENT '',
  PRIMARY KEY (`idImobiliaria`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NotaFiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbprojeto`.`NotaFiscal` (
  idNotaFiscal INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dataEmissao VARCHAR(90),
  valorTotal DOUBLE(10,2),
  idImobiliaria INTEGER,
  idVenda INTEGER,
  foreign key (idImobiliaria) references imobiliaria(idImobiliaria),
  foreign key (idVenda) references venda(idVenda)
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

ALTER TABLE IMOBILIARIA ADD COLUMN idEndereco INTEGER;
ALTER TABLE IMOBILIARIA ADD COLUMN telefone VARCHAR(45);

ALTER TABLE IMOBILIARIA
ADD CONSTRAINT idEndereco FOREIGN KEY (idEndereco)
    REFERENCES endereco(idEndereco);