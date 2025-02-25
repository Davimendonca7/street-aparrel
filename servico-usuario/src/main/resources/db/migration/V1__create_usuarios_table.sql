CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL UNIQUE,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          role VARCHAR(50) NOT NULL DEFAULT 'cliente',
                          status VARCHAR(20) DEFAULT 'ativo',
                          data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);