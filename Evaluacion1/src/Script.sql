DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (MATRICULA INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL);


-- TEST --
INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES (123456, 'Juan', 'Perez'), (654321, 'Jose', 'Gonzalez');