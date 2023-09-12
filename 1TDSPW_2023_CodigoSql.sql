/*
INTEGRANTES

98589 - Frederico Andrade de Carvalho
99562 - Kaique Santos de Andrade
550841 - Lucas Araujo Oliveira Silva
99466 - Marcelo Augusto de Mello Paixão
99513 - Rodrigo Batista Freire
*/


-- Apagando possíveis tabelas já existentes
DROP TABLE T_GPP_CHATBOT;
DROP TABLE T_GPP_ORDEM_SERVICO;
DROP TABLE T_GPP_APOLICE;
DROP TABLE T_GPP_VEICULO;
DROP TABLE T_GPP_CLIENTE;
DROP TABLE T_GPP_GUINCHO_PRESTADOR_SERVICO;
DROP TABLE T_GPP_PRESTADOR_SERVICO;
DROP TABLE T_GPP_ADMINISTRADOR;
DROP TABLE T_GPP_USUARIO;
DROP TABLE T_GPP_ENDERECO;
DROP TABLE T_GPP_GUINCHO;
DROP TABLE T_GPP_CATEGORIA_TARIFARIA;
DROP TABLE T_GPP_TIPO_GUINCHO;
DROP TABLE T_GPP_TIPO_USUARIO;


-- Criação da tabela da T_GPP_TIPO_USUARIO
CREATE TABLE T_GPP_TIPO_USUARIO (
    id_tipo_usuario INTEGER PRIMARY KEY,
    ds_nivel_acesso VARCHAR(70) NOT NULL
);

-- Criação da tabela da T_GPP_TIPO_GUINCHO
CREATE TABLE T_GPP_TIPO_GUINCHO (
    id_tipo_guincho INTEGER PRIMARY KEY,
    nm_tipo_guincho VARCHAR(70) NOT NULL,
    qt_capacidade_maxima DECIMAL(5, 2) NOT NULL,
    ds_restricao VARCHAR(100) NOT NULL,
    ob_tipo_guincho VARCHAR(100)
);

-- Criação da tabela da T_GPP_CATEGORIA_TARIFARIA
CREATE TABLE T_GPP_CATEGORIA_TARIFARIA (
    id_categoria_tarifaria INTEGER PRIMARY KEY,
    nm_categoria_tarifaria VARCHAR(50) NOT NULL,
    vl_base DECIMAL(7, 2) NOT NULL,
    vl_peso_maximo DECIMAL (6, 2) NOT NULL
);

-- Criação da tabela da T_GPP_GUINCHO
CREATE TABLE T_GPP_GUINCHO (
    id_guincho INTEGER PRIMARY KEY,
    id_tipo_guincho INTEGER REFERENCES T_GPP_TIPO_GUINCHO(id_tipo_guincho) NOT NULL,
    ds_placa CHAR(7) NOT NULL,
    st_disponibilidade CHAR(2) CHECK (st_disponibilidade IN ('0', '1')) NOT NULL, 
    ds_guincho VARCHAR(100) NOT NULL,
    ob_guinhco VARCHAR(70)
);

-- Criação da tabela da T_GPP_ENDERECO
CREATE TABLE T_GPP_ENDERECO (
    id_endereco INTEGER PRIMARY KEY,
    logradouro VARCHAR(200) NOT NULL,
    cep CHAR(8) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    bairro VARCHAR(150) NOT NULL
);

-- Criação da tabela da T_GPP_USUARIO
CREATE TABLE T_GPP_USUARIO (
    id_usuario INTEGER PRIMARY KEY,
    id_endereco INTEGER REFERENCES T_GPP_ENDERECO(id_endereco) NOT NULL,
    id_tipo_usuario INTEGER REFERENCES T_GPP_TIPO_USUARIO(id_tipo_usuario) NOT NULL,
    nm_usuario VARCHAR(100) NOT NULL,
    ds_email VARCHAR(100) NOT NULL,
    nr_cpf CHAR(11) NOT NULL,
    dt_nascimento DATE NOT NULL,
    tl_celular CHAR(11) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    dt_cadastro DATE NOT NULL
);

-- Criação da tabela da T_GPP_ADMINISTRADOR
CREATE TABLE T_GPP_ADMINISTRADOR (
    id_administrador INTEGER PRIMARY KEY,
    id_usuario INTEGER REFERENCES T_GPP_USUARIO(id_usuario) NOT NULL,
    nr_funcionario VARCHAR(10) NOT NULL,
    ds_cargo VARCHAR(70)
);

-- Criação da tabela da T_GPP_PRESTADOR_SERVICO
CREATE TABLE T_GPP_PRESTADOR_SERVICO (
    id_prestador_servico INTEGER PRIMARY KEY,
    id_usuario INTEGER REFERENCES T_GPP_USUARIO(id_usuario) NOT NULL,
    nm_prestador_servico VARCHAR(70) NOT NULL,
    ds_tipo_servico VARCHAR(80) NOT NULL,
    ds_area_cobertura VARCHAR(80) NOT NULL,
    ob_prestador_servico VARCHAR(100) NOT NULL
);

-- Criação da tabela da T_GPP_GUINCHO_PRESTADOR_SERVICO
CREATE TABLE T_GPP_GUINCHO_PRESTADOR_SERVICO (
    id_guincho_prestador_servico INTEGER PRIMARY KEY,
    id_guincho INTEGER REFERENCES T_GPP_GUINCHO(id_guincho) NOT NULL,
    id_prestador_servico INTEGER REFERENCES T_GPP_PRESTADOR_SERVICO(id_prestador_servico) NOT NULL,
    ds_localizacao_atual VARCHAR(70) NOT NULL
);

-- Criação da tabela da T_GPP_CLIENTE
CREATE TABLE T_GPP_CLIENTE (
    id_cliente INTEGER PRIMARY KEY,
    id_usuario INTEGER REFERENCES T_GPP_USUARIO(id_usuario) NOT NULL,
    ds_sexo VARCHAR(10) NOT NULL,
    ds_estado_civil VARCHAR(20)
);

-- Criação da tabela da T_GPP_VEICULO
CREATE TABLE T_GPP_VEICULO (
    id_veiculo INTEGER PRIMARY KEY,
    id_categoria_tarifaria INTEGER REFERENCES T_GPP_CATEGORIA_TARIFARIA(id_categoria_tarifaria) NOT NULL,
    id_cliente INTEGER REFERENCES T_GPP_CLIENTE(id_cliente) NOT NULL,
    ds_marca VARCHAR(50) NOT NULL,
    ds_modelo VARCHAR(50) NOT NULL,
    dt_fabricacao DATE NOT NULL,
    nr_chassi CHAR(17) NOT NULL,
    ds_placa CHAR(7) NOT NULL,
    ds_cor VARCHAR(50) NOT NULL,
    ds_combustivel VARCHAR(50) NOT NULL,
    ds_transmissao VARCHAR(50) NOT NULL,
    nr_quilometragem DECIMAL(12,3) NOT NULL
);

-- Criação da tabela da T_GPP_APOLICE
CREATE TABLE T_GPP_APOLICE (
    id_apolice INTEGER PRIMARY KEY,
    id_veiculo INTEGER REFERENCES T_GPP_VEICULO(id_veiculo) NOT NULL,
    nr_apolice VARCHAR(14) NOT NULL,
    nr_endosso VARCHAR(20) NOT NULL,
    nr_proposta VARCHAR(20) NOT NULL,
    dt_inicio_vigencia DATE NOT NULL,
    dt_final_vigencia DATE NOT NULL,
    ds_apolice VARCHAR(200) NOT NULL,
    vl_premio_total DECIMAL(7,2) NOT NULL
);

-- Criação da tabela da T_GPP_ORDEM_SERVICO
CREATE TABLE T_GPP_ORDEM_SERVICO (
    id_ordem_servico INTEGER PRIMARY KEY,
    id_guincho_prestador_servico INTEGER REFERENCES T_GPP_GUINCHO_PRESTADOR_SERVICO(id_guincho_prestador_servico),
    id_veiculo INTEGER REFERENCES T_GPP_VEICULO(id_veiculo) NOT NULL,
    dt_abertura DATE NOT NULL,
    dt_conclusao DATE NOT NULL,
    ds_servico VARCHAR(200) NOT NULL,
    st_servico CHAR(2) CHECK (st_servico IN ('0', '1', '2')) NOT NULL,
    ob_servico VARCHAR(100),
    ds_endereco VARCHAR(70) NOT NULL
);

-- Criação da tabela da T_GPP_CHATBOT
CREATE TABLE T_GPP_CHATBOT (
    id_chatbot INTEGER PRIMARY KEY,
    id_ordem_servico INTEGER REFERENCES T_GPP_ORDEM_SERVICO(id_ordem_servico),
    id_cliente INTEGER REFERENCES T_GPP_CLIENTE(id_cliente) NOT NULL,
    tx_entrada VARCHAR(500) NOT NULL,
    tx_saida VARCHAR(500) NOT NULL,
    dt_mensagem DATE NOT NULL,
    ds_intencao VARCHAR(100) NOT NULL
);












