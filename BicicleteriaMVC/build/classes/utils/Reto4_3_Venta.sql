CREATE TABLE ventas (
   identificador int AUTO_INCREMENT PRIMARY KEY,
   Id_cliente int,
   fecha DATE,
   Id_bicicleta int,
   FOREIGN KEY(Id_cliente) REFERENCES cliente(identificador),
   FOREIGN KEY(Id_bicicleta) REFERENCES bicicleta (identificador)
);
 
INSERT INTO ventas(Id_cliente, fecha, Id_bicicleta) VALUES(1, '2020-07-15', 1001);
 
INSERT INTO ventas(Id_cliente,
fecha, Id_bicicleta)
VALUES(2, '2020-07-16', 1002);

INSERT INTO ventas(Id_cliente,
fecha, Id_bicicleta)
VALUES(3, '2020-07-17', 1003);

INSERT INTO ventas(Id_cliente,
fecha, Id_bicicleta)
VALUES(4, '2020-07-18', 1004);

INSERT INTO ventas(Id_cliente,
fecha, Id_bicicleta)
VALUES(5, '2020-07-19', 1005);