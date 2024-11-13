CREATE TABLE Contrato(
    idContrato SERIAL PRIMARY KEY,
    idPessoa INT NOT NULL,
    idplano INT NOT NULL,
    nome VARCHAR(20) NOT NULL,
    data_inicio TIMESTAMP NOT NULL DEFAULT NOW(),
    data_fim TIMESTAMP NOT NULL,
    data_vencimento TIMESTAMP NOT NULL,
    status VARCHAR(25) NOT NULL,
    valor_pago FLOAT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Aluno(idPessoa) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idplano) REFERENCES Plano(idplano) ON UPDATE CASCADE
);