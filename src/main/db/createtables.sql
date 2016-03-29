-- run the 2 statements below to create the database and stock user

createdb stock
createuser stock -w -E

-- run the following statements in psql to create the tables the application uses

CREATE TABLE brand (
  id bigint primary key not null,
  brand_name varchar(50)
);

CREATE TABLE channel (
  id bigint primary key not null,
  channel_name varchar(50)
);

CREATE TABLE brands_channels (
  brand_id bigint,
  channel_id bigint
);

CREATE TABLE  stock_level (
  id bigint primary key not null,
  quantity integer,
  brand_id bigint not null,
  status varchar(50),
  brand_sku varchar(50),
  updated_at TIMESTAMPTZ
);

CREATE TABLE stock_levels_channels (
  stock_level_id bigint,
  channel_id bigint
);

CREATE SEQUENCE stock_level_seq_id start with 1;

insert into brand (id, brand_name) values (1, 'brand 1');
insert into brand (id, brand_name) values (2, 'brand 2');
insert into brand (id, brand_name) values (3, 'brand 3');

insert into channel (id, channel_name) values (1, 'channel 1');
insert into channel (id, channel_name) values (2, 'channel 2');
insert into channel (id, channel_name) values (3, 'channel 3');
insert into channel (id, channel_name) values (4, 'channel 4');
insert into channel (id, channel_name) values (5, 'channel 5');
insert into channel (id, channel_name) values (6, 'channel 6');

insert into brands_channels (brand_id, channel_id) VALUES (1, 1);
insert into brands_channels (brand_id, channel_id) VALUES (1, 3);
insert into brands_channels (brand_id, channel_id) VALUES (2, 1);
insert into brands_channels (brand_id, channel_id) VALUES (2, 2);
insert into brands_channels (brand_id, channel_id) VALUES (2, 3);
insert into brands_channels (brand_id, channel_id) VALUES (3, 5);
insert into brands_channels (brand_id, channel_id) VALUES (3, 6);

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public to stock;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public to stock;

ALTER USER stock with PASSWORD  'stockpassword';