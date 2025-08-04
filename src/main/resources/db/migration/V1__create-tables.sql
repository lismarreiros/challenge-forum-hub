CREATE TABLE Perfil (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Usuario_Perfil (
    usuario_id INT NOT NULL,
    perfil_id INT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (perfil_id) REFERENCES Perfil(id) ON DELETE CASCADE
);

CREATE TABLE Curso (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100)
);

CREATE TABLE Topico (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    autor INT,
    curso INT,
    FOREIGN KEY (autor) REFERENCES Usuario(id) ON DELETE SET NULL,
    FOREIGN KEY (curso) REFERENCES Curso(id) ON DELETE SET NULL
);

CREATE TABLE Resposta (
    id SERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico INT,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor INT,
    solucao BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico) REFERENCES Topico(id) ON DELETE CASCADE,
    FOREIGN KEY (autor) REFERENCES Usuario(id) ON DELETE SET NULL
);

