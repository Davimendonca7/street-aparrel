CREATE TABLE endereco (
      id INT AUTO_INCREMENT PRIMARY KEY,
      cliente_id BIGINT NOT NULL, -- Relacionado ao usuário
      rua VARCHAR(255) NOT NULL,
      numero VARCHAR(50) NOT NULL,
      complemento VARCHAR(255),
      bairro VARCHAR(255) NOT NULL,
      cidade VARCHAR(255) NOT NULL,
      estado VARCHAR(255) NOT NULL,
      cep VARCHAR(20) NOT NULL,
      pais VARCHAR(100) NOT NULL,
      data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
      FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);
