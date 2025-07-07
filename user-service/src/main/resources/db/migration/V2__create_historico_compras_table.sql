CREATE TABLE historico_compras (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   usuario_id BIGINT,
                                   produto_id BIGINT,
                                   quantidade INT NOT NULL,
                                   data_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
#                                    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
