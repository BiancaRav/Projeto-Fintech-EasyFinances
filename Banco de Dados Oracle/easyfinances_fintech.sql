-- CRIA��O DAS TABELAS E COLUNAS
CREATE TABLE T_FINTECH_USUARIO
 (
    CD_USUARIO NUMBER(6)    NOT NULL,
    NM_USUARIO VARCHAR2(60) NOT NULL,
    DS_EMAIL VARCHAR2(50)   NOT NULL,
    NR_SENHA VARCHAR2(10)   NOT NULL
 );

 ALTER TABLE T_FINTECH_USUARIO
    ADD CONSTRAINT PK_FINTECH_USUARIO PRIMARY KEY (CD_USUARIO);
        
        
CREATE TABLE T_FINTECH_CONTA
(
    CD_CONTA NUMBER(6)    NOT NULL,
    NM_CONTA VARCHAR2(20) NOT NULL, 
    CD_USUARIO NUMBER(6)  NOT NULL,
    CD_TIPO_CONTA NUMBER(6) NOT NULL
);

ALTER TABLE T_FINTECH_CONTA
    ADD CONSTRAINT PK_FINTECH_CONTA PRIMARY KEY (CD_CONTA);  
    
    
CREATE TABLE T_FINTECH_TP_CONTA
(
    CD_TIPO_CONTA NUMBER(6)  NOT NULL,
    NM_TIPO_CONTA VARCHAR2(30) NOT NULL
);

ALTER TABLE T_FINTECH_TP_CONTA
    ADD CONSTRAINT PK_FINTECH_TP_CONTA PRIMARY KEY (CD_TIPO_CONTA);
    
    
CREATE TABLE T_FINTECH_CART_CRED
(
    CD_CARTAO_CREDITO NUMBER(6)    NOT NULL,
    NM_CARTAO_CREDITO VARCHAR2(30) NOT NULL,
    VL_LIMITE NUMBER(9,2)          NULL,
    CD_USUARIO NUMBER(6)           NOT NULL
);

ALTER TABLE T_FINTECH_CART_CRED
    ADD CONSTRAINT PK_FINTECH_CART_CRED PRIMARY KEY (CD_CARTAO_CREDITO);
    
ALTER TABLE T_FINTECH_CART_CRED
    ADD CONSTRAINT CK_FINTECH_CART_CRED_LIMITE CHECK (VL_LIMITE > 0);
    
    
CREATE TABLE T_FINTECH_TRANSACAO
(
    CD_TRANSACAO NUMBER(6)    NOT NULL,
    DS_TRANSACAO VARCHAR2(40) NOT NULL,
    VL_TRANSACAO NUMBER(9,2)  NOT NULL,
    DT_TRANSACAO DATE         NOT NULL,
    CD_USUARIO NUMBER(6)      NOT NULL,
    CD_CONTA NUMBER(6)        NOT NULL, 
    CD_TIPO_TRANSACAO NUMBER(6)  NOT NULL,
    CD_CATEGORIA NUMBER(6)    NOT NULL,
    CD_TIPO_PGTO NUMBER(6)    NOT NULL,
    CD_STATUS_TRANSACAO NUMBER(6) NOT NULL,
    CD_CARTAO_CREDITO NUMBER(6)    NOT NULL
);

ALTER TABLE T_FINTECH_TRANSACAO
    MODIFY CD_CARTAO_CREDITO NUMBER(6) NULL;

ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT PK_FINTECH_TRANSACAO PRIMARY KEY (CD_TRANSACAO);
    

    CREATE TABLE T_FINTECH_TP_TRANS
(   CD_TIPO_TRANSACAO NUMBER(6)    NOT NULL,
    NM_TIPO_TRANSACAO VARCHAR2(30) NOT NULL
);

ALTER TABLE T_FINTECH_TP_TRANS
    ADD CONSTRAINT PK_FINTECH_TP_TRANS PRIMARY KEY (CD_TIPO_TRANSACAO);
        
    
CREATE TABLE T_FINTECH_CATEGORIA
(
    CD_CATEGORIA NUMBER(6)    NOT NULL,
    NM_CATEGORIA VARCHAR2(30) NOT NULL
);

ALTER TABLE T_FINTECH_CATEGORIA
    ADD CONSTRAINT PK_FINTECH_CATEGORIA PRIMARY KEY (CD_CATEGORIA);
    
ALTER TABLE T_FINTECH_CATEGORIA
    ADD CONSTRAINT UN_FINTECH_CATEGORIA UNIQUE (NM_CATEGORIA);
        
    
CREATE TABLE T_FINTECH_SUBCATEGORIA
(
    CD_SUBCATEGORIA NUMBER(6)   NOT NULL,
    NM_SUBCATEGORIA VARCHAR(30) NOT NULL,
    CD_CATEGORIA NUMBER(6)    NOT NULL
);

ALTER TABLE T_FINTECH_SUBCATEGORIA 
    ADD CONSTRAINT PK_FINTECH_SUBCATEGORIA PRIMARY KEY (CD_SUBCATEGORIA);
        
        
CREATE TABLE T_FINTECH_TP_PAGTO
(
    CD_TIPO_PGTO NUMBER(6)    NOT NULL,
    NM_TIPO_PGTO VARCHAR2(20) NOT NULL
);

ALTER TABLE T_FINTECH_TP_PAGTO
    ADD CONSTRAINT PK_FINTECH_TP_PAGAMENTO PRIMARY KEY (CD_TIPO_PGTO);
    
        
CREATE TABLE T_FINTECH_STATUS_TRANS
(
    CD_STATUS_TRANSACAO NUMBER(6)     NOT NULL,
    DS_STATUS_TRANSACAO VARCHAR2(20)  NOT NULL
);

ALTER TABLE T_FINTECH_STATUS_TRANS
    ADD CONSTRAINT PK_FINTECH_STATUS_TRANS PRIMARY KEY (CD_STATUS_TRANSACAO);
    
-- RELACIONAMENTOS E CHAVES ESTRANGEIRAS TABELA CONTA

ALTER TABLE T_FINTECH_CONTA
    ADD CONSTRAINT FK_FINTECH_USUARIO FOREIGN KEY (CD_USUARIO)
    REFERENCES T_FINTECH_USUARIO (CD_USUARIO);
    
ALTER TABLE T_FINTECH_CONTA
    ADD CONSTRAINT FK_FINTECH_TIPO_CONTA_CONTA FOREIGN KEY (CD_TIPO_CONTA)
    REFERENCES T_FINTECH_TP_CONTA (CD_TIPO_CONTA);


-- RELACIONAMENTOS E CHAVES ESTRANGEIRAS TABELA CART�O DE CR�DITO
ALTER TABLE T_FINTECH_CART_CRED
    ADD CONSTRAINT FK_FINTECH_USUARIO_CARTAO_CREDITO FOREIGN KEY (CD_USUARIO)
    REFERENCES T_FINTECH_USUARIO (CD_USUARIO);


-- RELACIONAMENTOS E CHAVES ESTRANGEIRAS TABELA TRANSA��O
ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_USUARIO_TRANSACAO FOREIGN KEY (CD_USUARIO)
    REFERENCES T_FINTECH_USUARIO (CD_USUARIO);
    
ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_CONTA_TRANSACAO FOREIGN KEY (CD_CONTA)
    REFERENCES T_FINTECH_CONTA (CD_CONTA);
    
ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_TIPO_TRANSACAO_TRANSACAO FOREIGN KEY (CD_TIPO_TRANSACAO)
    REFERENCES T_FINTECH_TP_TRANS (CD_TIPO_TRANSACAO);

ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_CATEGORIA_TRANSACAO FOREIGN KEY (CD_CATEGORIA)
    REFERENCES T_FINTECH_CATEGORIA (CD_CATEGORIA);

ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_PAGAMENTO_TRANSACAO FOREIGN KEY (CD_TIPO_PGTO)
    REFERENCES T_FINTECH_TP_PAGTO (CD_TIPO_PGTO)
    
ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_STATUS_TRANSACAO FOREIGN KEY (CD_STATUS_TRANSACAO)
    REFERENCES T_FINTECH_STATUS_TRANS (CD_STATUS_TRANSACAO);
    
ALTER TABLE T_FINTECH_TRANSACAO
    ADD CONSTRAINT FK_FINTECH_CARTAO_TRANSACAO FOREIGN KEY (CD_CARTAO_CREDITO)
    REFERENCES T_FINTECH_CART_CRED (CD_CARTAO_CREDITO);


--RELACIONAMENTO E CHAVE ESTRANGEIRA TABELA SUBCATEGORIA
ALTER TABLE T_FINTECH_SUBCATEGORIA
    ADD CONSTRAINT FK_FINTECH_CATEGORIA_SUBCATEGORIA FOREIGN KEY (CD_CATEGORIA)
    REFERENCES T_FINTECH_CATEGORIA (CD_CATEGORIA);
    
    
--INSERINDO DADOS NAS TABELAS CATEGORIA E SUBCATEGORIA
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (1, 'CONTAS FIXAS');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (2, 'TRANSPORTE');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (3, 'ALIMENTA��O');
    
INSERT INTO T_FINTECH_CATEGORIA  
    (cd_categoria, nm_categoria) VALUES (4, 'SA�DE');
    
INSERT INTO T_FINTECH_CATEGORIA  
    (cd_categoria, nm_categoria) VALUES (5, 'LAZER');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (6, 'DESPESAS PESSOAIS');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (7, 'RECEBIVEIS');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (8, 'INVESTIMENTOS');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (9, 'EDUCA��O');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (10, 'IMPOSTOS');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (11, 'CART�O DE CR�DITO');
    
INSERT INTO T_FINTECH_CATEGORIA 
    (cd_categoria, nm_categoria) VALUES (12, 'OUTROS');
    
        
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (1, 'CONTAS CONSUMO', 1);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (2, 'ALUGUEL/CONDOMINIO', 1);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (3, 'SEGURO', 1);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (4, 'COMBUSTIVEL', 2);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (5, 'TRANSPORTE', 2);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (6, 'MANUTEN�AO/SERVI�OS', 2);

INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (7, 'SEGURO', 2);

INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (8, 'MERCADO', 3);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (9, 'RESTAURANTE', 3);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (10, 'CONV�IO', 4);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (11, 'MEDICAMENTOS', 4);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (12, 'VIAGENS', 5);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (13, 'ENTRETENIMENTO', 5);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (14, 'VESTIMENTA', 6);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (15, 'CUIDADOS PESSOAIS', 6);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (16, 'ESCOLA', 9);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (17, 'CURSO', 9);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (18, 'MATERIAL', 9);
    
INSERT INTO T_FINTECH_SUBCATEGORIA
    (cd_subcategoria, nm_subcategoria, cd_categoria) VALUES (19, 'OUTROS', 12);
    

--INSERINDO DADOS NAS TABELAS STATUS TRANSA��O, TIPO DE CONTA, TIPO DE PAGTO E TIPO DE TRANSA��O
INSERT INTO T_FINTECH_STATUS_TRANS
    (cd_status_transacao, ds_status_transacao) VALUES (1, 'QUITADA');

INSERT INTO T_FINTECH_STATUS_TRANS
    (cd_status_transacao, ds_status_transacao) VALUES (2, 'PENDENTE');
    
INSERT INTO T_FINTECH_STATUS_TRANS
    (cd_status_transacao, ds_status_transacao) VALUES (3, 'ATRASADA');
    
    
INSERT INTO T_FINTECH_TP_CONTA
    (cd_tipo_conta, nm_tipo_conta) VALUES (1, 'CORRENTE');
    
INSERT INTO T_FINTECH_TP_CONTA
    (cd_tipo_conta, nm_tipo_conta) VALUES (2, 'POUPAN�A');
    
INSERT INTO T_FINTECH_TP_CONTA
    (cd_tipo_conta, nm_tipo_conta) VALUES (3, 'INVESTIMENTO');
    
INSERT INTO T_FINTECH_TP_CONTA
    (cd_tipo_conta, nm_tipo_conta) VALUES (4, 'PJ');
    
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (1, 'D�BITO');
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (2, 'CR�DITO');
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (3, 'TRANSFER�NCIA');
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (4, 'PIX');
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (5, 'BOLETO');
    
INSERT INTO T_FINTECH_TP_PAGTO
    (cd_tipo_pgto, nm_tipo_pgto) VALUES (6, 'DINHEIRO');
    
    
INSERT INTO T_FINTECH_TP_TRANS
    (cd_tipo_transacao, nm_tipo_transacao) VALUES (1, 'RECEITA');
    
INSERT INTO T_FINTECH_TP_TRANS
    (cd_tipo_transacao, nm_tipo_transacao) VALUES (2, 'DESPESA');
    
INSERT INTO T_FINTECH_TP_TRANS
    (cd_tipo_transacao, nm_tipo_transacao) VALUES (3, 'INVESTIMENTO');
    

--INSERINDO/CADASTRANDO DADOS USUARIO E CONTA
INSERT INTO T_FINTECH_USUARIO
    (cd_usuario, nm_usuario, ds_email, nr_senha) VALUES (1, 'Bianca Andrade', 'biaravanii@gmail.com', 'TH998615');
    
INSERT INTO T_FINTECH_CONTA
    (cd_conta, nm_conta, cd_usuario, cd_tipo_conta) VALUES (1, 'Nubank', 1, 1);
    
INSERT INTO T_FINTECH_CONTA
    (cd_conta, nm_conta, cd_usuario, cd_tipo_conta) VALUES (2, 'Bradesco', 1, 2);
    
--CADASTRO DE RECEITAS
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (1, 'Salario', 1050.00, TO_DATE('05/10/2023', 'DD/MM/YYYY'), 1, 1, 1, 7, 3, 3);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (2, 'Pagamento bolos', 150.00, TO_DATE('20/10/2023', 'DD/MM/YYYY'), 1, 1, 1, 7, 4, 2);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (3, 'Docinhos Joana', 75.00, TO_DATE('02/10/2023', 'DD/MM/YYYY'), 1, 1, 1, 7, 6, 1);


--CADASTRO DE DESPESAS
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (4, 'FIAP', 690.00, TO_DATE('05/09/2023', 'DD/MM/YYYY'), 1, 2, 2, 1, 5, 1);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (5, 'Internet', 120.00, TO_DATE('20/10/2023', 'DD/MM/YYYY'), 1, 1, 2, 1, 4, 3);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (6, 'Vestido', 50.00, TO_DATE('09/10/2023', 'DD/MM/YYYY'), 1, 1, 2, 8, 2, 2);
    
--CADASTRO DE INVESTIMENTOS
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (7, 'Tesouro', 100.00, TO_DATE('20/09/2023', 'DD/MM/YYYY'), 1, 1, 3, 8, 5, 1);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (8, 'Internet', 120.00, TO_DATE('20/10/2023', 'DD/MM/YYYY'), 1, 1, 3, 5, 4, 3);
    
INSERT INTO T_FINTECH_TRANSACAO
    (cd_transacao, ds_transacao, vl_transacao, dt_transacao, cd_usuario, cd_conta, cd_tipo_transacao, cd_categoria, cd_tipo_pgto,
    cd_status_transacao) VALUES (9, 'Vestido', 50.00, TO_DATE('09/10/2023', 'DD/MM/YYYY'), 1, 1, 3, 8, 3, 2);
    

--ALTERA��O DE DADOS 
UPDATE T_FINTECH_USUARIO
SET DS_EMAIL='biaravani@gmail.com', NM_USUARIO='Bianca R Andrade'
WHERE CD_USUARIO=1;

UPDATE T_FINTECH_TRANSACAO
SET  VL_TRANSACAO=77.50, CD_CONTA=2, CD_TIPO_PGTO=4 
WHERE CD_TRANSACAO=3;

UPDATE T_FINTECH_TRANSACAO
SET  CD_STATUS_TRANSACAO=1
WHERE CD_TRANSACAO=1;

UPDATE T_FINTECH_TRANSACAO
SET  DT_TRANSACAO='10/10/2023'
WHERE CD_TRANSACAO=2;

UPDATE T_FINTECH_TRANSACAO
SET  CD_STATUS_TRANSACAO=1 
WHERE CD_TRANSACAO=2;

UPDATE T_FINTECH_TRANSACAO
SET  VL_TRANSACAO=118.99, CD_STATUS_TRANSACAO=2
WHERE CD_TRANSACAO=5;

UPDATE T_FINTECH_TRANSACAO
SET  CD_CATEGORIA=5, CD_STATUS_TRANSACAO=1 
WHERE CD_TRANSACAO=6;

UPDATE T_FINTECH_TRANSACAO
SET  CD_TIPO_PGTO=3  
WHERE CD_TRANSACAO=7;

UPDATE T_FINTECH_TRANSACAO
SET  DS_TRANSACAO='Poupan�a', VL_TRANSACAO=60.00, CD_CATEGORIA=8, CD_STATUS_TRANSACAO=2
WHERE CD_TRANSACAO=8;

UPDATE T_FINTECH_TRANSACAO
SET  DS_TRANSACAO= 'CRIPTOMOEDA', CD_STATUS_TRANSACAO=1
WHERE CD_TRANSACAO=9;

--CONSULTAS 
SELECT * 
FROM T_FINTECH_USUARIO
WHERE CD_USUARIO=1;


SELECT * 
FROM T_FINTECH_TRANSACAO T 
INNER JOIN T_FINTECH_TP_TRANS F ON (T.CD_TIPO_TRANSACAO = F.CD_TIPO_TRANSACAO)
 WHERE CD_USUARIO=1
    AND F.CD_TIPO_TRANSACAO=2
    AND ROWNUM < 2 ;
    
        
SELECT * 
FROM T_FINTECH_TRANSACAO T 
INNER JOIN T_FINTECH_TP_TRANS F ON (T.CD_TIPO_TRANSACAO = F.CD_TIPO_TRANSACAO)
 WHERE CD_USUARIO=1
    AND NM_TIPO_TRANSACAO= 'DESPESA' 
    ORDER BY CD_TRANSACAO ASC
    
    
SELECT * 
FROM T_FINTECH_TRANSACAO T 
INNER JOIN T_FINTECH_TP_TRANS F ON (T.CD_TIPO_TRANSACAO = F.CD_TIPO_TRANSACAO)
 WHERE CD_USUARIO=1
    AND F.CD_TIPO_TRANSACAO=3
     AND ROWNUM < 2 ;
     

SELECT * 
FROM T_FINTECH_TRANSACAO T 
INNER JOIN T_FINTECH_TP_TRANS F ON (T.CD_TIPO_TRANSACAO = F.CD_TIPO_TRANSACAO)
 WHERE CD_USUARIO=1
    AND NM_TIPO_TRANSACAO= 'INVESTIMENTO' 
    ORDER BY CD_TRANSACAO ASC
     

SELECT U.CD_USUARIO, NM_USUARIO,
       I.*,
       TP_I.NM_TIPO_TRANSACAO,
       D.*,
       TP_D.NM_TIPO_TRANSACAO
FROM T_FINTECH_USUARIO U
    INNER JOIN T_FINTECH_TRANSACAO I  ON I.CD_USUARIO = U.CD_USUARIO
    INNER JOIN T_FINTECH_TP_TRANS TP_I ON TP_I.CD_TIPO_TRANSACAO = I.CD_TIPO_TRANSACAO AND TP_I.NM_TIPO_TRANSACAO = 'INVESTIMENTO' 
    INNER JOIN T_FINTECH_TRANSACAO D   ON D.CD_USUARIO = U.CD_USUARIO
    INNER JOIN T_FINTECH_TP_TRANS TP_D   ON TP_D.CD_TIPO_TRANSACAO = D.CD_TIPO_TRANSACAO AND TP_D.NM_TIPO_TRANSACAO = 'DESPESA'  
WHERE
    I.CD_TRANSACAO = (SELECT MAX(CD_TRANSACAO) FROM T_FINTECH_TRANSACAO WHERE CD_USUARIO = U.CD_USUARIO AND CD_TIPO_TRANSACAO = I.CD_TIPO_TRANSACAO)
    AND D.CD_TRANSACAO = (SELECT MAX(CD_TRANSACAO) FROM T_FINTECH_TRANSACAO WHERE CD_USUARIO = U.CD_USUARIO AND CD_TIPO_TRANSACAO = D.CD_TIPO_TRANSACAO)
    AND U.CD_USUARIO=1

        
    


    
  
       
       
       