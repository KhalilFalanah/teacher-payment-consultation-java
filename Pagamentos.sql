CREATE DATABASE pagamentos;
USE pagamentos;

CREATE TABLE ProfessorHorista (
    matricula INT NOT NULL,
	nome VARCHAR(255),
	horasTrabalhadas INT NOT NULL,
    valorHora DOUBLE NOT NULL,
	dataPagamento VARCHAR(255)
);

CREATE TABLE ProfessorDE (
   matricula INT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   salarioBase DOUBLE NOT NULL,
   dataPagamento VARCHAR(255)
);


SELECT * from professorde