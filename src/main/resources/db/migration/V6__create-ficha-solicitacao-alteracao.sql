CREATE TABLE SolicitacaoAlteracao (
    id_solicitacao SERIAL PRIMARY KEY,
    id_ficha INT NOT NULL REFERENCES Ficha(id_ficha) ON DELETE CASCADE,
    tipo_alteracao VARCHAR(50) NOT NULL, -- Tipo de alteração solicitada
    detalhes TEXT, -- Detalhes específicos da solicitação
    data_solicitacao TIMESTAMP DEFAULT NOW(), -- Data da solicitação
    status VARCHAR(20) DEFAULT 'Pendente', -- Status da solicitação
    id_aprovador INT REFERENCES Professor(idPessoa), -- Professor que aprova/rejeita
    data_resposta TIMESTAMP -- Data da resposta
);
