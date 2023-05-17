-- 1.	По идентификатору заказа получить данные заказа и данные клиента,  создавшего этот заказ
select orders.id, orders.client_id, clients.name, clients.phone, orders.flower_id, flowers.title, flowers.price, orders.amount, orders.date
from orders
     inner join clients on clients.id = orders.client_id
     inner join flowers on flowers.id = orders.flower_id
where orders.id = 5;

-- 2.	Получить данные всех заказов одного клиента по идентификатору клиента за последний месяц
select orders.id, orders.client_id, clients.name, clients.phone, orders.flower_id, flowers.title, flowers.price, orders.amount, orders.date
from orders
     inner join clients on clients.id = orders.client_id
     inner join flowers on flowers.id = orders.flower_id
where orders.client_id = 3
and date_trunc('month', date) = date_trunc('month', now())
and date_trunc('year', date) = date_trunc('year', now());

-- 3.	Найти заказ с максимальным количеством купленных цветов, вывести их название и количество
select orders.id, orders.client_id, clients.name, clients.phone, orders.flower_id, flowers.title, flowers.price, orders.amount, orders.date
from orders
     inner join clients on clients.id = orders.client_id
     inner join flowers on flowers.id = orders.flower_id
where amount = (select max(amount) from orders);

-- 4.	Вывести общую выручку (сумму золотых монет по всем заказам) за все время
select sum(orders.amount * flowers.price) as total
from orders
     inner join flowers on flowers.id = orders.flower_id;
