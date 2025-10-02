CREATE TABLE tb_produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    descricaolink VARCHAR(255),
    descricaoCompleta TEXT,
    preco DECIMAL(10,2) NOT NULL,
    slug VARCHAR(255) UNIQUE,
    categoria_id BIGINT,
    CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);
