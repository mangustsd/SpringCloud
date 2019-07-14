create table if not exists Ingredient (
	id varchar(4) not null primary key,
	name varchar(25) not null,
	type varchar(10) not null
);

create table if not exists Taco (
	id bigint auto_increment primary key,
	name varchar(50) not null,
	createdAt timestamp not null
);

create table if not exists Taco_Ingredients(
	taco bigint not null, 
	ingredient varchar(4) not null, 
	foreign key(taco) references Taco(id),
	foreign key(ingredient) references Ingredient(id)
);

create table if not exists Taco_Order(
	id bigint auto_increment primary key, 
	deliveryName varchar(50),
	deliveryStreet varchar(50), 
	deliveryCity varchar(50), 
	deliveryState varchar(2),
	deliveryZip varchar(10), 
	ccNumber varchar(16), 
	ccExpiration varchar(5), 
	ccCVV varchar(3), 
	placedAt timestamp
);

create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null, 
	foreign key (tacoOrder) references Taco_Order(id),
	foreign key (taco) references Taco(id)
);


insert into Ingredient (id, name, type) values 
	('FLTO', 'Flour Tortilla', 0),
	('COTO', 'Corn Tortilla', 0),
	('GRBF', 'Ground Beef', 1),
	('CARN', 'Carnitas', 1),
	('TMTO', 'Diced Tomatoes', 2),
	('LETC', 'Lettuce', 2),
	('CHED', 'Cheddar', 3),
	('JACK', 'Monterrey Jack', 3), 
	('SLSA', 'Salsa', 4),
	('SRCR', 'Sour Cream', 4);
	