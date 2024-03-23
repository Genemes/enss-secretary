INSERT INTO address (id, street, number, neighborhood, city, state)
VALUES (b9e24a8c-f22d-481d-823b-e27a2f1f1f2f, 'Rua Padre Rolim', 100, 'Centro', 'Cajazeiras', 'PB');

INSERT INTO address (id, street, number, neighborhood, city, state)
VALUES (1c0f1e2e-d783-4a2b-801d-b0d0f2f2f2f2, 'Rua Padre Ibiapina', 200, 'Centro', 'Cajazeiras', 'PB');

INSERT INTO address (id, street, number, neighborhood, city, state)
VALUES (42178d3a-a91b-4e1c-a38e-1d3d3f3f3f3f, 'Rua Dom João da Mata', 300, 'Centro', 'Cajazeiras', 'PB');

INSERT INTO responsible(id, name, cpf, rg, birth, phone, email, address)
values(7f4b23ce-5e10-456d-b44f-4e4e4f4f4f4f, 'João Paulo', '00000000011', '3121323', '1985-12-01', '83991912923', 'email@email.com', b9e24a8c-f22d-481d-823b-e27a2f1f1f2f);

INSERT INTO responsible(id, name, cpf, rg, birth, phone, email, address)
values(a67ea860-3c48-472e-b550-5f5f5f5f5f5f, 'Milena', '00000000022', '5121355', '1990-01-01', '83991912555', 'milena@email.com', 1c0f1e2e-d783-4a2b-801d-b0d0f2f2f2f2);

INSERT INTO responsible(id, name, cpf, rg, birth, phone, email, address)
values(d3b22d92-217d-4c3f-8661-707070707070, 'Joana', '00000000033', '3121777', '1995-02-01', '83997772977', 'joana@email.com', 42178d3a-a91b-4e1c-a38e-1d3d3f3f3f3f);

INSERT INTO student(id, name, registration, cpf, birthCertificate, serie, birth, responsibleId)
values(00e5c2c4-b59a-4040-a772-818181818181, 'Gabriel', '33333', '00000000044', 'Livro A pagina X', '1', '2017-11-08', 7f4b23ce-5e10-456d-b44f-4e4e4f4f4f4f);

INSERT INTO student(id, name, registration, cpf, birthCertificate, serie, birth, responsibleId)
values(371957f6-88e6-4d51-b883-929292929292, 'Maria Izadora', '44444', '00000000055', 'Livro B pagina X', '1', '2020-06-25', a67ea860-3c48-472e-b550-5f5f5f5f5f5f);

INSERT INTO student(id, name, registration, cpf, birthCertificate, serie, birth, responsibleId)
values(6e4cdcf8-0c34-4052-ba94-a3a3a3a3a3a3, 'Maria', '55555', '00000000077', 'Livro C pagina X', '1', '2022-02-23', d3b22d92-217d-4c3f-8661-707070707070);

