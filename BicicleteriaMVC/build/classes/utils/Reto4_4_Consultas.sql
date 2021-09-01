-- bicicleta
SELECT identificador, referencia, costo FROM bicicleta WHERE identificador = 1001;

-- cliente
SELECT identificador, nombre, apellido, telefono FROM cliente;

-- ventas
SELECT identificador, Id_cliente, fecha, Id_bicicleta FROM ventas;


-- Select 'Consulta 1';
SELECT nombre
FROM cliente
ORDER BY nombre;

-- Select 'Consulta 2';
SELECT nombre, fecha 
FROM ventas
JOIN cliente ON ventas.Id_cliente = cliente.identificador
ORDER BY fecha;

-- Select 'Consulta 3';
SELECT referencia, fecha 
FROM ventas
JOIN bicicleta ON ventas.Id_bicicleta = bicicleta.identificador;

-- Select 'Consulta 4';
SELECT concat(nombre,concat(" ",apellido)) AS "Nombre", referencia AS "Referencia",
 fecha AS "Fecha", costo AS "Costo"
FROM ventas
JOIN cliente ON ventas.Id_cliente = cliente.identificador
JOIN bicicleta ON ventas.Id_bicicleta = bicicleta.identificador
ORDER BY fecha;
 
-- Crear sumatoria cantidad de ventas por cliente y cuanto ha gastado
SELECT concat(nombre,concat(" ",apellido)) AS "Nombre", 
count(ventas.identificador) AS "Cantidad de compras",
sum(bicicleta.costo) AS "Total compras realizadas"
FROM ventas
JOIN cliente ON Id_cliente = cliente.identificador
JOIN bicicleta ON Id_bicicleta = bicicleta.identificador 
GROUP BY Id_cliente
ORDER BY sum(bicicleta.costo) DESC;

-- referencia más vendida.
SELECT referencia AS "Referencia", 
count(ventas.identificador) AS "Cantidad de ventas",
sum(bicicleta.costo) AS "Total ventas realizadas"
FROM ventas
JOIN bicicleta ON Id_bicicleta = bicicleta.identificador 
GROUP BY Id_bicicleta
ORDER BY sum(bicicleta.costo) DESC;