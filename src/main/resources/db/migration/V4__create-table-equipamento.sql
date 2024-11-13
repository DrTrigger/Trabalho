CREATE TABLE TipoEquipamento (
    id_tipo SERIAL PRIMARY KEY,
    nome_tipo VARCHAR(50) NOT NULL, -- Exemplo: "Anilha", "Halter", "Máquina", etc.
    descricao TEXT -- Descrição do tipo, se necessário
);

CREATE TABLE Equipamento (
    id_equipamento SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL, -- Nome do equipamento, ex: "Halter 10kg"
    tipo_fk INT REFERENCES TipoEquipamento(id_tipo) ON DELETE SET NULL, -- Chave estrangeira para o tipo
    peso DECIMAL(5,2), -- Peso do equipamento, se aplicável, ex: "10.00" kg
    fabricante VARCHAR(50), -- Fabricante do equipamento, se houver
    data_aquisicao DATE, -- Data de aquisição do equipamento
    estado VARCHAR(20) DEFAULT 'Novo', -- Estado do equipamento, ex: "Novo", "Usado"
    descricao TEXT -- Outras informações adicionais
);
