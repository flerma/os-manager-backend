INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_CADASTRAR_ORCAMENTO');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_REMOVER_ORCAMENTO');
INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_PESQUISAR_ORCAMENTO');

-- Fernando
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 9);