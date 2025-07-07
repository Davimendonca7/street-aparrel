CREATE TABLE categoria (
       id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único da categoria
       nome VARCHAR(255) NOT NULL,         -- Nome da categoria (ex: Camisetas, Calças)
       descricao TEXT                      -- Descrição da categoria
);