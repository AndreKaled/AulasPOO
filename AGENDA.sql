--
-- Table structure for table `contatos`
--
create database Agenda;
use agenda;

DROP TABLE IF EXISTS Contatos;
DROP TABLE IF EXISTS Compromissos;

CREATE TABLE contatos (
  ID bigint NOT NULL AUTO_INCREMENT,
  NOME varchar(50) NOT NULL,
  APELIDO varchar(15) NOT NULL,
  DATA_NASCIMENTO date NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY NOME (NOME)
);

--
-- Dumping data for table `contatos`
--

SELECT * FROM Contatos;

create table Compromissos(
	codigo int AUTO_INCREMENT primary key,
	dataCompromisso date not null,
    contato bigint,
    observacao varchar(50),
    horaCompromisso varchar(5),
    
    foreign key (contato) references Contatos(ID) 
);

create table teste(
	hora TIME
);

insert into teste values ('10:25');
select * from teste;

LOCK TABLES contatos WRITE;
ALTER TABLE contatos DISABLE KEYS;
INSERT INTO contatos VALUES (1,'emmerson','emmsr','1972-12-07'),(2,'andre','dede5','2005-06-26');
 ALTER TABLE contatos ENABLE KEYS;
UNLOCK TABLES;
