create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table ingredient (id varchar(255) not null, name varchar(255), type integer, primary key (id)) engine=InnoDB
create table taco (id bigint not null, created_at datetime(6), name varchar(255) not null, primary key (id)) engine=InnoDB
create table taco_ingredients (taco_id bigint not null, ingredients_id varchar(255) not null) engine=InnoDB
create table taco_order (id bigint not null, cccvv varchar(255), cc_expiration varchar(255), cc_number varchar(255), city varchar(255), delivery_zip varchar(255), name varchar(255), placed_at datetime(6), state varchar(255), street varchar(255), primary key (id)) engine=InnoDB
create table taco_order_tacos (order_id bigint not null, tacos_id bigint not null) engine=InnoDB
alter table taco_ingredients add constraint FK7y679y77n5e75s3ss1v7ff14j foreign key (ingredients_id) references ingredient (id)
alter table taco_ingredients add constraint FK27rycuh3mjaepnba0j6m8xl4q foreign key (taco_id) references taco (id)
alter table taco_order_tacos add constraint FKfwvqtnjfview9e5f7bfqtd1ns foreign key (tacos_id) references taco (id)
alter table taco_order_tacos add constraint FKcxwvdkndaqmrxcen10vkneexo foreign key (order_id) references taco_order (id)
insert into Ingredient (id, name, type) values 
	('FLTO', 'Flour Tortilla', 1),
	('COTO', 'Corn Tortilla', 1),
	('GRBF', 'Ground Beef', 2),
	('CARN', 'Carnitas', 2),
	('TMTO', 'Diced Tomatoes', 3),
	('LETC', 'Lettuce', 3),
	('CHED', 'Cheddar', 4),
	('JACK', 'Monterrey Jack', 4), 
	('SLSA', 'Salsa', 5),
	('SRCR', 'Sour Cream', 5);