insert into flowers (title, price)
values ('розы', 100),
       ('лилии', 50),
       ('ромашки', 25);

insert into clients (name, phone)
values ('Маша', '79157648394'),
       ('Глаша', '79042783973'),
       ('Аркаша', '79467358245'),
       ('Саша', '79346278192');

insert into orders (client_id, flower_id, amount, date)
values (1, 2, 7, '2023-03-31'),
       (2, 3, 15, '2022-07-19'),
       (3, 1, 9, '2023-05-07'),
       (3, 2, 12, '2023-02-14'),
       (3, 3, 50, '2022-09-15'),
       (3, 1, 49, '2023-05-08'),
       (3, 1, 7, '2023-05-05'),
       (4, 1, 999, '2023-03-08');