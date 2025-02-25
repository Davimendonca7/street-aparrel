
CREATE TABLE estoque (
         id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único do estoque
         produto_id INT,                     -- Relação com o produto
         quantidade INT NOT NULL,            -- Quantidade do produto no estoque
         data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Data da última atualização no estoque
         FOREIGN KEY (produto_id) REFERENCES produto(id)  -- Chave estrangeira para a tabela produto
);