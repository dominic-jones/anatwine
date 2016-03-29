-- run the 2 statements below to create the database and stock user

createdb stock
createuser stock -w -E

-- run the following statements in psql to create the tables the application uses

CREATE TABLE  stock_level (
  id bigint primary key not null,
  quantity integer,
  brand_id bigint not null,
  status varchar(50),
  brand_sku varchar(50),
  updated_at TIMESTAMPTZ
);

CREATE SEQUENCE stock_level_seq_id start with 1;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public to stock;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public to stock;

ALTER USER stock with PASSWORD  'stockpassword';