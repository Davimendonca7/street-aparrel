CREATE TABLE cliente (
         id BIGINT AUTO_INCREMENT PRIMARY KEY,
         nome VARCHAR(255) NOT NULL,
         cpf VARCHAR(14) UNIQUE NOT NULL,
         telefone VARCHAR(15),
         endereco TEXT,
         usuario_id BIGINT UNIQUE,
         data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
         data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
         FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);