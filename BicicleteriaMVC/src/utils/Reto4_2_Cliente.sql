CREATE TABLE cliente (
   identificador int PRIMARY KEY,
   nombre varchar(45),
   apellido varchar(45),
   telefono int
);
 
INSERT INTO cliente(identificador, nombre, apellido, telefono) VALUES(1, "Frederick", "Taylor", 86792876);
 
INSERT INTO cliente(
identificador, nombre, apellido, telefono)
VALUES(2, "Nikola", "Tesla", 89789877);
 
INSERT INTO cliente(
identificador, nombre, apellido, telefono)
VALUES(3, "Abraham", "Simpson", 95387871);
 
INSERT INTO cliente(
identificador, nombre, apellido, telefono)
VALUES(4, "David", "Reyes", 85646543);
 
INSERT INTO cliente(
identificador, nombre, apellido, telefono)
VALUES(5, "Diego", "Pinzon", 78887874);