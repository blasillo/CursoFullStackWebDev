--<ScriptOptions statementTerminator=";"/>

CREATE SCHEMA CURSO;


CREATE TABLE SALAS (
		SALA_ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		NOMBRE VARCHAR(50) NOT NULL,
		DESCRIPCION VARCHAR(120),
		CAPACIDAD INTEGER,
		LOCALIZACION VARCHAR(100),
		TIPO_ID INTEGER,
		EDIFICIO_ID INTEGER
	);

CREATE TABLE TIPOS_SALAS (
		TIPO_ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		TIPO VARCHAR(50) NOT NULL
	);

CREATE TABLE EDIFICIOS (
		EDIFICIO_ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL,
		NOMBRE VARCHAR(80) NOT NULL,
		COD_VIA VARCHAR(2),
		NOMBRE_VIA VARCHAR(150),
		NUMERO_VIA VARCHAR(10),
		ID_POBLACION INTEGER,
		COD_POSTAL VARCHAR(5),
		TITULARIDAD VARCHAR(2)
	);

CREATE TABLE PROVINCIA (
		IDPROVINCIA INTEGER NOT NULL,
		PROVINCIA VARCHAR(50) NOT NULL,
		PROVINCIASEO VARCHAR(50) NOT NULL,
		PROVINCIA3 CHAR(3) DEFAULT NULL
	);

CREATE TABLE RESERVAS (
		RESERVA_ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		SALA_ID INTEGER NOT NULL,
		FEC_RESERVA DATE NOT NULL,
		USUARIO VARCHAR(15) NOT NULL
	);

CREATE TABLE POBLACION (
		IDPOBLACION INTEGER NOT NULL,
		IDPROVINCIA INTEGER NOT NULL,
		POBLACION VARCHAR(150) NOT NULL,
		POBLACIONSEO VARCHAR(150) DEFAULT NULL,
		POSTAL INTEGER DEFAULT NULL,
		LATITUD VARCHAR(15) DEFAULT NULL,
		LONGITUD VARCHAR(15) DEFAULT NULL
	);

CREATE UNIQUE INDEX SQL180220132531871 ON RESERVAS (RESERVA_ID ASC);

CREATE UNIQUE INDEX SQL180220132531872 ON RESERVAS (SALA_ID ASC, FEC_RESERVA ASC);

CREATE INDEX SQL180220132531870 ON RESERVAS (SALA_ID ASC);

CREATE INDEX SQL180220130906440 ON SALAS (TIPO_ID ASC);

CREATE INDEX SQL180308180247530 ON SALAS (EDIFICIO_ID ASC);

CREATE UNIQUE INDEX SQL180220130906441 ON SALAS (SALA_ID ASC);

CREATE UNIQUE INDEX SQL180220130857690 ON TIPOS_SALAS (TIPO_ID ASC);

CREATE UNIQUE INDEX SQL180226192016380 ON PROVINCIA (IDPROVINCIA ASC);

ALTER TABLE PROVINCIA ADD CONSTRAINT SQL180226192016380 PRIMARY KEY (IDPROVINCIA);

ALTER TABLE RESERVAS ADD CONSTRAINT SQL180220132531871 PRIMARY KEY (RESERVA_ID);

ALTER TABLE SALAS ADD CONSTRAINT SQL180220130906441 PRIMARY KEY (SALA_ID);

ALTER TABLE EDIFICIOS ADD CONSTRAINT SQL180226193623481 PRIMARY KEY (EDIFICIO_ID);

ALTER TABLE TIPOS_SALAS ADD CONSTRAINT SQL180220130857690 PRIMARY KEY (TIPO_ID);

ALTER TABLE POBLACION ADD CONSTRAINT SQL180226193338911 PRIMARY KEY (IDPOBLACION);

ALTER TABLE SALAS ADD CONSTRAINT SQL180220130906440 FOREIGN KEY (TIPO_ID)
	REFERENCES TIPOS_SALAS (TIPO_ID);

ALTER TABLE RESERVAS ADD CONSTRAINT SQL180220132531870 FOREIGN KEY (SALA_ID)
	REFERENCES SALAS (SALA_ID);

ALTER TABLE EDIFICIOS ADD CONSTRAINT SQL180226193623480 FOREIGN KEY (ID_POBLACION)
	REFERENCES POBLACION (IDPOBLACION);

ALTER TABLE SALAS ADD CONSTRAINT SQL180308180247530 FOREIGN KEY (EDIFICIO_ID)
	REFERENCES EDIFICIOS (EDIFICIO_ID);

