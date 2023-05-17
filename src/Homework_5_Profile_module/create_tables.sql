create table if not exists flowers
(
    id          serial primary key,
    title       varchar(100) UNIQUE check (title <> '') not null,
    price       integer check (price > 0) not null
);

create table if not exists clients
(
    id          serial primary key,
    name        varchar(100) not null,
    phone       varchar(11) UNIQUE not null
);

create table if not exists orders
(
    id          serial primary key,
    client_id   integer references clients(id) not null,
    flower_id    integer references flowers(id) not null,
    amount      integer check (amount >= 1 and amount <= 1000),
    date        timestamp
);
