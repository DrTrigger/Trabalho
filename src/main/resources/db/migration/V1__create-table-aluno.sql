-- Criando tabela Usuario
-- cpf nao é obrigatório para alunos. Mas, quando se cadastrar um professor, temos regra de negócio no service que impede de ser null e no front-end, posteriormente
CREATE TABLE Pessoa (
    idPessoa SERIAL PRIMARY KEY,
    nome  VARCHAR(255) NOT NULL,
    data_nascimento TIMESTAMP NOT NULL,
    cpf   VARCHAR(14),
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Lembrete abaixo!
    -- O número de registro do CREF (Conselho Regional de Educação Física) geralmente segue o formato CREF 000000-G/UF para profissionais graduados e CREF 000000-P/UF para provisionados2. Isso significa que o número de registro possui:
    -- 4 caracteres fixos para "CREF"
    -- 6 dígitos numéricos
    -- 1 caractere para a categoria (G ou P)
    -- 1 caractere para a barra "/"
    -- 2 caracteres para a sigla do estado (UF)
CREATE TABLE Professor (
    idPessoa INTEGER PRIMARY KEY,
    salario FLOAT NOT NULL,
    cref VARCHAR(14) UNIQUE NOT NULL,
    carga_horaria_semanal INT NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa (idPessoa) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Aluno (
    idPessoa INTEGER PRIMARY KEY,
    matricula_aluno VARCHAR(255) UNIQUE NOT NULL,
    data_matricula TIMESTAMP DEFAULT NOW(),
    restricao_medica TEXT,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa (idPessoa) ON DELETE CASCADE ON UPDATE CASCADE
);