-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into book (id, titulo, autor, editora, anoLancamento, estaDisponivel) values(1, 'Dom Casmurro', 'Machado de Assis', 'Editora Saraiva', 1899, true);

insert into book (id, titulo, autor, editora, anoLancamento, estaDisponivel) values(2, 'O Pequeno Príncipe', 'Saint', 'Editora Saraiva', 1974, true);

insert into book (id, titulo, autor, editora, anoLancamento, estaDisponivel) values(3, 'Eu Robo', 'Azik Azimov', 'Editora Saraiva', 1930, true);

insert into book (id, titulo, autor, editora, anoLancamento, estaDisponivel) values(4, 'O Mundo de Sofia', 'Jostein Gaarder', 'Editora Saraiva', 1899, true);

insert into recipe (id, nome , categoria, ingredientes, modoPreparo, origem) values (1, 'PratoTeste', 'CategoriaTeste', 'ingredientes','passo passo2','Bolivia');
