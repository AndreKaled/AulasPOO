create DATABASE Biblioteca;
use Biblioteca;

drop table if exists Livro;
drop table if exists Funcionario;
drop table if exists AreaAdvocacia;
drop table if exists Editora;
drop table if exists Autor;

create table Livro(
	nome varchar(150),
    autor varchar(100),
    editora varchar(100),
    areaAdvocacia varchar(100),
    data date,
    preco double,
    cod int primary key
);

select * from Livro;

truncate Livro;

create table Funcionario(
	nome varchar(100),
    matricula varchar(10) not null,
    numeroOAB varchar(10)
);

create table areaAdvocacia(
	descricao varchar(50) not null
);

create table Editora(
	nome varchar(100)
);