CREATE TABLE produto (
         id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único do produto
         nome VARCHAR(255) NOT NULL,         -- Nome do produto
         descricao TEXT,                     -- Descrição do produto
         preco DECIMAL(10, 2) NOT NULL,      -- Preço do produto
         imagem_url VARCHAR(255),            -- URL da imagem do produto
         categoria_id INT,                   -- Relacionamento com a categoria
         data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data de criação
         data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Data da última atualização
         FOREIGN KEY (categoria_id) REFERENCES categoria(id)  -- Chave estrangeira para a categoria
);