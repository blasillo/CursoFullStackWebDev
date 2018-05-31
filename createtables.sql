create schema CURSO;









create table EDIFICIOS (
   EDIFICIO_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   NOMBRE      VARCHAR(80) NOT NULL,
   COD_VIA     VARCHAR(2),
   NOMBRE_VIA     VARCHAR(150),
   NUMERO_VIA     VARCHAR(10),
   COD_LOCALIDAD  VARCHAR(12),
   COD_POSTAL     VARCHAR(5),
   TITULARIDAD    VARCHAR(2),
   
   PRIMARY KEY (EDIFICIO_ID)
)



create table TIPOS_SALAS (

  TIPO_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  TIPO    VARCHAR(50) NOT NULL,
  
  PRIMARY KEY (TIPO_ID)
)


create table SALAS (

  SALA_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  NOMBRE  VARCHAR(50) NOT NULL,
  DESCRIPCION VARCHAR(120),
  CAPACIDAD   INTEGER,
  LOCALIZACION VARCHAR(100),
  TIPO_ID INTEGER REFERENCES TIPOS_SALAS(TIPO_ID),
  
  PRIMARY KEY (SALA_ID)
)


create table RESERVAS (

  RESERVA_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  SALA_ID    INTEGER NOT NULL REFERENCES SALAS(SALA_ID),
  FEC_RESERVA  DATE NOT NULL,
  USUARIO    VARCHAR(15) NOT NULL,
  
  PRIMARY KEY (RESERVA_ID),
  UNIQUE (SALA_ID, FEC_RESERVA )
)


select count(*) from SALAS;

