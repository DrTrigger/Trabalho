CREATE TABLE Plano (
    idplano SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    duracao_meses INT NOT NULL
);