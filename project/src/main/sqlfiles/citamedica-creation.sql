CREATE TABLE USUARIO(
    id NUMBER(20,0) 	NOT NULL,
    nombre 		VARCHAR2(40) 	NOT NULL,
	apellidos 	VARCHAR2(100) 	NOT NULL,
	usuario 	VARCHAR2(30) 	NOT NULL,
	clave 		VARCHAR2(30) 	NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id)
);

CREATE TABLE PACIENTE(
    id 	NUMBER(20,0) 	NOT NULL,
	nss 		VARCHAR2(11)	NOT NULL,
	num_tarjeta	VARCHAR2(20) 	NOT NULL,
	telefono 	VARCHAR2(9) 	NOT NULL,
	direccion	VARCHAR2(100)	NOT NULL,
	CONSTRAINT paciente_pk PRIMARY KEY(id),
    CONSTRAINT pac_fk_usu FOREIGN KEY (id) REFERENCES USUARIO(id)
);

CREATE TABLE MEDICO(
    id 	NUMBER(20,0) 	NOT NULL,
	num_colegiado	VARCHAR2(9)		NOT NULL,
	CONSTRAINT medico_pk PRIMARY KEY(id),
    CONSTRAINT med_fk_usu FOREIGN KEY (id) REFERENCES USUARIO(id)
);

CREATE TABLE MEDICO_PACIENTE(
	medico 		NUMBER(20,0) NOT NULL,
	paciente 	NUMBER(20,0) NOT NULL,
	CONSTRAINT medpac_pk PRIMARY KEY(medico, paciente),
	CONSTRAINT medpac_fk_med FOREIGN KEY(medico) REFERENCES MEDICO(id),
	CONSTRAINT medpac_fk_pac FOREIGN KEY(paciente) REFERENCES PACIENTE(id)
);

CREATE TABLE CITA(
	id NUMBER(20,0) 	NOT NULL, --todas los valores posibles de un long
	motivo_cita VARCHAR2(500) NOT NULL,
	fecha_hora TIMESTAMP(2) NOT NULL, 
	diagnostico NUMBER(20,0) NULL,
    medico NUMBER(20,0) NOT NULL,
    paciente NUMBER(20,0) 	NOT NULL,
	CONSTRAINT cita_pk PRIMARY KEY(id),
    CONSTRAINT cita_fk_med FOREIGN KEY (medico) REFERENCES MEDICO(id),
    CONSTRAINT cita_fk_pac FOREIGN KEY (paciente) REFERENCES PACIENTE(id)
	--FOREIGN KEY(diagnostico) REFERENCES DIAGNOSTICO(id) se añade despues modificando la tabla
    --porque se hace referencia a una tabla que no existe actualmente
);

CREATE TABLE DIAGNOSTICO(
	id NUMBER(20) NOT NULL,
	valoracion_especialista VARCHAR2(500) NOT NULL,
	enfermedad VARCHAR2(100) NOT NULL,
	CONSTRAINT diag_pk PRIMARY KEY(id)
);

ALTER TABLE CITA ADD CONSTRAINT cita_fk_diag FOREIGN KEY (diagnostico) REFERENCES DIAGNOSTICO(id);
