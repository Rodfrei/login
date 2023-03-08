INSERT INTO usuario (email, nome, telefone, criado_em, atualizado_em, foto_perfil, senha) 
VALUES 
('rodolfo@cwi.com.br', 'Rodolfo Reichert Schirmer Freitas', '123456789', '1997-03-18', '2022-03-01', 'https://i.pinimg.com/originals/55/2b/af/552bafe5dd51bbac1c9c763a5952b92c.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG'),
('maria@cwi.com.br', 'Maria da Silva', '111111111', '2000-07-25', '2019-03-08', 'https://i.pinimg.com/originals/55/2b/af/552bafe5dd51bbac1c9c763a5952b92c.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG'),
('joao@cwi.com.br', 'Joao da Silva', '777777777', '2007-07-25', '2015-03-08', 'https://i.pinimg.com/originals/55/2b/af/552bafe5dd51bbac1c9c763a5952b92c.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG'),
('pedro@cwi.com.br', 'Pedro da Silva', '987654321', '2005-03-28', '2021-03-08', 'https://i.pinimg.com/originals/55/2b/af/552bafe5dd51bbac1c9c763a5952b92c.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG');

insert into permissao (funcao, usuario_id) values ('USUARIO', 1);
insert into permissao (funcao, usuario_id) values ('USUARIO', 2);
insert into permissao (funcao, usuario_id) values ('USUARIO', 3);
insert into permissao (funcao, usuario_id) values ('ADMIN', 4);