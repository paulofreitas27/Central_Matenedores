-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema central_matenedores
--

CREATE DATABASE IF NOT EXISTS central_matenedores;
USE central_matenedores;

--
-- Definition of table `boleto`
--

DROP TABLE IF EXISTS `boleto`;
CREATE TABLE `boleto` (
  `codigo` int(11) NOT NULL auto_increment,
  `numero_parcela` int(11) NOT NULL,
  `data_vencimento` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `compromisso_codigo` int(11) NOT NULL,
  `quitado` tinyint(1) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `boleto`
--

/*!40000 ALTER TABLE `boleto` DISABLE KEYS */;
/*!40000 ALTER TABLE `boleto` ENABLE KEYS */;


--
-- Definition of table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
CREATE TABLE `caixa` (
  `codigo` int(11) NOT NULL auto_increment,
  `data_hora_abertura` datetime NOT NULL,
  `data_hora_fechamento` datetime default NULL,
  `aberto` tinyint(4) NOT NULL,
  `usuario_cpf` varchar(14) NOT NULL,
  PRIMARY KEY  (`codigo`),
  KEY `fk_caixa_usuario1_idx` (`usuario_cpf`),
  CONSTRAINT `fk_caixa_usuario1` FOREIGN KEY (`usuario_cpf`) REFERENCES `usuario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `caixa`
--

/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;


--
-- Definition of table `compromisso`
--

DROP TABLE IF EXISTS `compromisso`;
CREATE TABLE `compromisso` (
  `codigo` int(10) NOT NULL auto_increment,
  `data_geracao` datetime NOT NULL,
  `dia_vencimento` date NOT NULL,
  `valor_parcela` decimal(10,2) NOT NULL,
  `total_num_parcela` int(11) NOT NULL,
  `usuario_cpf` varchar(14) NOT NULL,
  `projeto_codigo` int(11) NOT NULL,
  `membro_codigo` int(11) NOT NULL,
  `quitado` tinyint(1) NOT NULL,
  PRIMARY KEY  (`codigo`),
  KEY `FK_compromisso_1` (`usuario_cpf`),
  KEY `FK_compromisso_2` (`projeto_codigo`),
  KEY `FK_compromisso_3` (`membro_codigo`),
  CONSTRAINT `FK_compromisso_1` FOREIGN KEY (`usuario_cpf`) REFERENCES `usuario` (`cpf`),
  CONSTRAINT `FK_compromisso_2` FOREIGN KEY (`projeto_codigo`) REFERENCES `projeto` (`codigo`),
  CONSTRAINT `FK_compromisso_3` FOREIGN KEY (`membro_codigo`) REFERENCES `membro` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `compromisso`
--

/*!40000 ALTER TABLE `compromisso` DISABLE KEYS */;
/*!40000 ALTER TABLE `compromisso` ENABLE KEYS */;


--
-- Definition of table `forma_pagamento`
--

DROP TABLE IF EXISTS `forma_pagamento`;
CREATE TABLE `forma_pagamento` (
  `codigo` int(11) NOT NULL auto_increment,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `forma_pagamento`
--

/*!40000 ALTER TABLE `forma_pagamento` DISABLE KEYS */;
INSERT INTO `forma_pagamento` (`codigo`,`nome`) VALUES 
 (1,'DÉBITO'),
 (2,'CRÉDITO'),
 (3,'DINHEIRO'),
 (4,'TRANSFERÊNCIA');
/*!40000 ALTER TABLE `forma_pagamento` ENABLE KEYS */;


--
-- Definition of table `membro`
--

DROP TABLE IF EXISTS `membro`;
CREATE TABLE `membro` (
  `codigo` int(11) NOT NULL auto_increment,
  `nome` varchar(60) NOT NULL,
  `fone` varchar(10) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `membro`
--

/*!40000 ALTER TABLE `membro` DISABLE KEYS */;
/*!40000 ALTER TABLE `membro` ENABLE KEYS */;


--
-- Definition of table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE `pagamento` (
  `codigo` int(11) NOT NULL auto_increment,
  `data_pagamento` datetime default NULL,
  `valor` decimal(10,2) default NULL,
  `forma_pagamento_codigo` int(11) NOT NULL,
  `boleto_codigo` int(11) NOT NULL,
  `caixa_codigo` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`),
  KEY `fk_pagamento_forma_pagamento1_idx` (`forma_pagamento_codigo`),
  KEY `fk_pagamento_boleto1_idx` (`boleto_codigo`),
  KEY `fk_pagamento_caixa1_idx` (`caixa_codigo`),
  CONSTRAINT `fk_pagamento_forma_pagamento1` FOREIGN KEY (`forma_pagamento_codigo`) REFERENCES `forma_pagamento` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_boleto1` FOREIGN KEY (`boleto_codigo`) REFERENCES `boleto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_caixa1` FOREIGN KEY (`caixa_codigo`) REFERENCES `caixa` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pagamento`
--

/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


--
-- Definition of table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
CREATE TABLE `projeto` (
  `codigo` int(11) NOT NULL auto_increment,
  `nome` varchar(60) NOT NULL,
  `descricao` varchar(250) NOT NULL,
  `data_criacao` datetime NOT NULL,
  `ativo` tinyint(4) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projeto`
--

/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `adm` tinyint(4) NOT NULL,
  `ativo` tinyint(4) NOT NULL,
  PRIMARY KEY  (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`cpf`,`nome`,`senha`,`adm`,`ativo`) VALUES 
 ('123.456.789-10','ADMINISTRADOR','123456',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
