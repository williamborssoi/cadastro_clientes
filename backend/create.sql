create table cliente (id int8 generated by default as identity, cpf int8, endereco varchar(255), idade int8, nome varchar(255), primary key (id));
INSERT INTO cliente(nome, idade, endereco, cpf) VALUES('ADRIANO', 26, 'RUA ESMERALDA', 10296193950);
INSERT INTO cliente(nome, idade, endereco, cpf) VALUES('WILLIAM', 25, 'PRESIDENTE CASTELO BRANCO', 07562380996);
INSERT INTO cliente(nome, idade, endereco, cpf) VALUES('HERCULANO', 36, 'RUA DA UNOESC', 89067318402);
INSERT INTO cliente(nome, idade, endereco, cpf) VALUES('ROSELI', 36, 'RUA DA UNOESC', 88951837206);