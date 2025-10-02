CREATE TABLE tb_imagens (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nomeArquivo VARCHAR(255) NOT NULL,
    produto_id BIGINT NOT NULL,
    CONSTRAINT fk_imagem_produto FOREIGN KEY (produto_id) REFERENCES tb_produtos(id)
);
