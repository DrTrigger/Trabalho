-- Teste
CREATE TABLE Contrato(
    idContrato SERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    idPessoa INT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Aluno(idPessoa)
)