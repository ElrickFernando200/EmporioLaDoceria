
INSERT INTO tb_categoria(nome) VALUES ('Doces Finos');
INSERT INTO tb_categoria(nome) VALUES ('Bolos');
INSERT INTO tb_categoria(nome) VALUES ('Doces Personalizados');

INSERT INTO tb_produto(nome,descricao,preco,img_url) VALUES ('Brigadeiro de leite Ninho perolizado','E o doce é aquele tradicional, simples e fácil brigadeiro',2.0,'http://brigadeiro.com');
INSERT INTO tb_produto(nome,descricao,preco,img_url) VALUES ('Trufa de sereja','Chocolate cremoso, cereja molhadinha e um toque final de açúcar cristal para trazer mais crocância à trufa formam a combinação perfeita.',3.50,'http://trufa.com');
INSERT INTO tb_produto(nome,descricao,preco,img_url) VALUES ('BomBom de Nozes','uma casquinha de chocolate e um recheio cremoso',2.35,'http://casquinha.com');
INSERT INTO tb_produto(nome,descricao,preco,img_url) VALUES ('Brigadeiro de amêndoas','amêndoas para decorar e garantir um doce gostoso e crocante.',1.50,'http://amendoas.com');


INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (1,1);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (1,3);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (2,1);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (2,3);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (3,1);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (3,3);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (4,1);
INSERT INTO tb_produto_categoria (produto_id,categoria_id) VALUES (4,3);


INSERT INTO tb_usuario(nome,email,telefone,senha,data_nasc) VALUES ('Elrick Fernando','elrick@gmail.com','81 98989-0000','f85afa24fa63a1fa','2001-04-24');
INSERT INTO tb_usuario(nome,email,telefone,senha,data_nasc) VALUES ('Sandrelli Pessoa','Sandrelli@gmail.com','81 98585-1111', 'fda5f4a65fa4fa5','2002-02-24');
INSERT INTO tb_usuario(nome,email,telefone,senha,data_nasc) VALUES ('Pietro Fernando','pietro@gmail.com','8199696-2525','f1sa1fs66sgsg1s5','2019-09-24');


INSERT INTO tb_pedido(instant,status,cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-08-11T19:39:25Z',1,1);
INSERT INTO tb_pedido(instant,status,cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-02-15T09:25:45Z',0,2);
INSERT INTO tb_pedido(instant,status,cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-07-02T15:48:10Z',0,1);
INSERT INTO tb_pedido(instant,status,cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-08-05T11:21:03Z',0,3);


INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (1,1,30,2.0);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (1,3,3,2.35);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (2,3,5,3.5);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (3,1,10,2.0);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (3,2,10,3.5);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (3,3,10,2.35);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (3,4,10,1.5);
INSERT INTO tb_item_pedido(pedido_id,produto_id,quantidade,preco) VALUES (4,1,16,2.0);


INSERT INTO tb_pagamento (pedido_id,instant,valor) VALUES (1,'2023-08-11T16:42:35Z',70.5);
