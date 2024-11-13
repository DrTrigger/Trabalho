CREATE TABLE Exercicio(
    id_exercicio SERIAL PRIMARY KEY,
    grupo_muscular VARCHAR(100), -- Exemplo: "Peito, Ombros"
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE Ficha(
    id_ficha SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_professor INT NOT NULL,
    data_inicio TIMESTAMP NOT NULL DEFAULT NOW(),
    data_fim TIMESTAMP NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES Aluno(idPessoa) ON DELETE CASCADE,
    FOREIGN KEY (id_professor) REFERENCES Professor(idPessoa) ON UPDATE CASCADE
);


CREATE TABLE ExercicioFicha(
    id_exercicio_ficha SERIAL PRIMARY KEY,
    id_exercicio INT NOT NULL,
    id_ficha INT NOT NULL,
    id_equipamento INT NOT NULL,
    numero_repeticao INT,
    tempo_descanso INT,
    peso INT,
    FOREIGN KEY (id_exercicio) REFERENCES Exercicio(id_exercicio),
    FOREIGN KEY (id_ficha) REFERENCES Ficha(id_ficha) ON DELETE CASCADE,
    FOREIGN KEY (id_equipamento) REFERENCES Equipamento(id_equipamento)
);
