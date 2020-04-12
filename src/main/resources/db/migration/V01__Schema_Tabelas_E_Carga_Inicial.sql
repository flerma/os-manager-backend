
CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Fernando Lerma', 'fernando.lerma@gmail.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'Administrador', 'admin@vetroc.com.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_CLIENTE');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_REMOVER_CLIENTE');

INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_CADASTRAR_ORDEM_SERVICO');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_REMOVER_ORDEM_SERVICO');
INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_PESQUISAR_ORDEM_SERVICO');


-- Fernando
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 6);


CREATE TABLE cliente (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL,
    data_inclusao DATE NOT NULL,
    usuario_inclusao INT NOT NULL,
    data_alteracao DATE NULL,
    usuario_alteracao INT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true, now(), 1, null, null);
INSERT INTO cliente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true, now(), 1, null, null);

CREATE TABLE status_orcamento (
	codigo INT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO status_orcamento (descricao) VALUE ('SOLICITADO');
INSERT INTO status_orcamento (descricao) VALUE ('FINALIZADO');


CREATE TABLE status_ordem_servico (
	codigo INT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO status_ordem_servico (descricao) VALUE ('CRIADA');
INSERT INTO status_ordem_servico (descricao) VALUE ('AGENDADA');
INSERT INTO status_ordem_servico (descricao) VALUE ('CANCELADA');
INSERT INTO status_ordem_servico (descricao) VALUE ('FINALIZADA');


CREATE TABLE tipo_servico (
	codigo INT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipo_servico (descricao) VALUE ('MANUTENÇÃO DE SACADA');
INSERT INTO tipo_servico (descricao) VALUE ('INSTALAÇÃO DE SACADA');
INSERT INTO tipo_servico (descricao) VALUE ('MANUTENÇÃO DE AR CONDICIONADO');

CREATE TABLE orcamento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_cliente BIGINT(20) NOT NULL,
    codigo_tipo_servico INT NOT NULL,
    codigo_status_orcamento INT NOT NULL,
    data_agendamento DATE NOT NULL,
    data_execucao DATE NULL,
    descricao VARCHAR(1000) NOT NULL,
    valor DECIMAL(10,2) NULL,
    data_inclusao DATE NOT NULL,
    usuario_inclusao INT NOT NULL,
    data_alteracao DATE NULL,
    usuario_alteracao INT NULL,
    FOREIGN KEY (codigo_cliente) REFERENCES CLIENTE(codigo),
	FOREIGN KEY (codigo_tipo_servico) REFERENCES tipo_servico(codigo),
    FOREIGN KEY (codigo_status_orcamento) REFERENCES status_orcamento(codigo)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO orcamento (codigo_cliente, codigo_tipo_servico, codigo_status_orcamento, data_agendamento, data_execucao, descricao, valor, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) VALUE (1, 1, 1, now(), now(), 'Troca de 3 estacionamento', 1080.00, now(), 1, null, null);



CREATE TABLE ordem_servico (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_orcamento BIGINT(20) NOT NULL,
    codigo_status_ordem_servico INT NOT NULL,
    data_agendamento DATE NOT NULL,
    data_execucao DATE NULL,
    descricao VARCHAR(1000) NOT NULL,
    data_inclusao DATE NOT NULL,
    usuario_inclusao INT NOT NULL,
    data_alteracao DATE NULL,
    usuario_alteracao INT NULL,
    FOREIGN KEY (codigo_orcamento) REFERENCES orcamento(codigo),
	FOREIGN KEY (codigo_status_ordem_servico) REFERENCES status_ordem_servico(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ordem_servico (codigo_orcamento, codigo_status_ordem_servico, data_agendamento, data_execucao, descricao, data_inclusao, usuario_inclusao, data_alteracao, usuario_alteracao) VALUE (1, 1, now(), now(), 'Troca de 3 estacionamento', now(), 1, null, null);
