CREATE SCHEMA estados;

SET search_path = estados;

CREATE SEQUENCE s_uf
    START WITH 27
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE t_uf (
    cod_uf integer NOT NULL,
    nome character varying(50),
    sigla character varying(2)
);

ALTER TABLE ONLY t_uf
    ADD CONSTRAINT t_uf_pk PRIMARY KEY (cod_uf);

INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (1, 'ACRE', 'AC');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (2, 'ALAGOAS', 'AL');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (3, 'AMAPÁ', 'AP');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (4, 'AMAZONAS', 'AM');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (5, 'BAHIA', 'BA');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (6, 'CEARÁ', 'CE');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (7, 'DISTRITO FEDERAL', 'DF');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (8, 'ESPÍRITO SANTO', 'ES');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (9, 'GOIÁS', 'GO');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (10, 'MARANHÃO', 'MA');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (11, 'MATO GROSSO', 'MT');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (12, 'MATO GROSSO DO SUL', 'MS');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (13, 'MINAS GERAIS', 'MG');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (14, 'PARÁ', 'PA');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (15, 'PARAÍBA', 'PB');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (16, 'PARANÁ', 'PR');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (17, 'PERNAMBUCO', 'PE');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (18, 'PIAUÍ', 'PI');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (19, 'RIO DE JANEIRO', 'RJ');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (20, 'RIO GRANDE DO NORTE', 'RN');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (21, 'RIO GRANDE DO SUL', 'RS');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (22, 'RONDÔNIA', 'RO');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (23, 'RORAIMA', 'RR');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (24, 'SANTA CATARINA', 'SC');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (25, 'SÃO PAULO	', 'SP');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (26, 'SERGIPE', 'SE');
INSERT INTO t_uf (cod_uf, nome, sigla) VALUES (27, 'TOCANTINS', 'TO');


CREATE SCHEMA funcionarios;

SET search_path = funcionarios;

CREATE SEQUENCE s_funcionario
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE t_funcionario (
    cod_funcionario integer NOT NULL,
    nome character varying(200),
    data_admissao date,
    data_nascimento timestamp without time zone,
    telefone character varying(20),
    cpf character varying(15)
);

ALTER TABLE ONLY t_funcionario
    ADD CONSTRAINT t_funcionario_pkey PRIMARY KEY (cod_funcionario);

INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (1, 'MARIA 1', '2000-01-01', '1980-01-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (2, 'MARIA 2', '2000-02-01', '1980-02-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (3, 'MARIA 3', '2000-03-01', '1980-03-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (4, 'MARIA 4', '2000-04-01', '1980-04-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (5, 'MARIA 5', '2000-05-01', '1980-05-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (6, 'MARIA 6', '2000-06-01', '1980-06-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (7, 'MARIA 7', '2000-07-01', '1980-07-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (8, 'MARIA 8', '2000-08-01', '1980-08-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (9, 'MARIA 9', '2000-09-01', '1980-09-01 00:00:00', '85912345678', '11111111111');
INSERT INTO t_funcionario (cod_funcionario, nome, data_admissao, data_nascimento, telefone, cpf) VALUES (10, 'MARIA 10', '2000-10-01', '1980-10-01 00:00:00', '85912345678', '11111111111');


CREATE SCHEMA seguranca;

SET search_path = seguranca;

CREATE SEQUENCE s_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE t_oauth_client_details (
    cod_oauth_client_details integer NOT NULL,
    client_id character varying(256) NOT NULL,
    resource_ids character varying(256),
    client_secret character varying(256) NOT NULL,
    scope character varying(256),
    authorized_grant_types character varying(256),
    web_server_redirect_uri character varying(256),
    authorities character varying(256),
    access_token_validity integer,
    refresh_token_validity integer,
    additional_information character varying(4000),
    autoapprove character varying(256)
);

ALTER TABLE ONLY t_oauth_client_details
    ADD CONSTRAINT t_oauth_client_details_client_id_key UNIQUE (client_id);
ALTER TABLE ONLY t_oauth_client_details
    ADD CONSTRAINT t_oauth_client_details_pkey PRIMARY KEY (cod_oauth_client_details);

INSERT INTO t_oauth_client_details (cod_oauth_client_details, client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES (1, 'clientId', NULL, '{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.', 'read,write', 'password,refresh_token', NULL, 'ROLE_OAUTH_CLIENT', 3000, 4000, NULL, NULL);
INSERT INTO t_oauth_client_details (cod_oauth_client_details, client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES (2, 'clientService', NULL, '{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.', 'read,write', 'client_credentials', NULL, 'ROLE_OAUTH_CLIENT,ACTUATOR,SWAGGER', 3000, 4000, NULL, NULL);

CREATE TABLE t_usuario (
    cod_usuario integer NOT NULL,
    login character varying(256),
    senha character varying(256),
    papel character varying(256)
);

ALTER TABLE ONLY t_usuario
    ADD CONSTRAINT t_usuario_login_key UNIQUE (login);
ALTER TABLE ONLY t_usuario
    ADD CONSTRAINT t_usuario_pkey PRIMARY KEY (cod_usuario);

INSERT INTO t_usuario (cod_usuario, login, senha, papel) VALUES (1, 'TESTE', '{bcrypt}$2a$10$cyf5NfobcruKQ8XGjUJkEegr9ZWFqaea6vjpXWEaSqTa2xL9wjgQC', 'ROLE_USER');

