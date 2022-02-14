/* Populate tabla clientes */
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(1, 'Abel', 'Antúnez', 'abel@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(2, 'Ione', 'Abellan', 'ione@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(3, 'Elena', 'Sobres', 'elena@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(4, 'Manuel', 'Pérez', 'manuel@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(5, 'Pepe', 'Robles', 'Pepe@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(6, 'Noelia', 'Gómez', 'noelia@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(7, 'Amparo', 'Parrot', 'amparo@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(8, 'Selena', 'Gutierrez', 'selena@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(9, 'Alfonso', 'Caminos', 'alfonso@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(10, 'Cristina', 'Paredes', 'cristina@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(11, 'John', 'Roe', 'john@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(12, 'Austin', 'Akward', 'austin@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(13, 'Sour', 'Kamen', 'sour@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(14, 'Arnold', 'Kefka', 'arnold@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(15, 'Luke', 'Pikmin', 'luke@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(16, 'Leela', 'Lampin', 'leela@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(17, 'Barbara', 'Luka', 'barbara@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(18, 'Amendio', 'Juarez', 'amendio@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(19, 'Alberto', 'Puentes', 'alberto@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(20, 'Jake', 'Mendoza', 'jake@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(21, 'Gloria', 'Vázquez', 'gloria@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(22, 'Jay', 'Richards', 'jay@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(23, 'Peter', 'Famplin', 'peter@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(24, 'Phil', 'Dunkan', 'phil@email.com', '2022-02-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES(25, 'Greg', 'Cramer', 'greg@email.com', '2022-02-04', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, created_at) VALUES ('Panasonic monitor LCD', 220, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Sony cámara digital DSC-WW320B', 450, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Apple iPod Shuffle', 390, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Sony Notebook Z110', 899, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('HP Multifuncional F2280', 120, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Apple iPad Mini', 549, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 6);

INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES ('Factura cámara Sony', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 2, 2);