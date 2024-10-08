-- Rename the table from `order` to `orders`
drop table if exists orders cascade;
create table orders (
    total_amount float(53),
    id bigint generated by default as identity,
    order_date timestamp(6),
    user_id bigint,
    primary key (id)
);

-- Update foreign key references
alter table if exists cart_item add constraint FKfy8a9qqdgyifdrhft50jfd8uu foreign key (order_id) references orders;
alter table if exists orders add constraint FKs9p0s8b1nh7m2no87xxteu83x foreign key (user_id) references users;