CREATE TABLE usuarios (
      id UUID PRIMARY KEY,
      login VARCHAR(255) NOT NULL UNIQUE,
      senha VARCHAR(255) NOT NULL,
      role VARCHAR(50) NOT NULL
);
