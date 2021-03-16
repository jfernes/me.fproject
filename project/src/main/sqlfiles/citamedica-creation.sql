CREATE TABLE USUARIO(
    nombre 		VARCHAR2(40) 	NOT NULL,
	apellidos 	VARCHAR2(100) 	NOT NULL,
	usuario 	VARCHAR2(30) 	NOT NULL,
	clave 		VARCHAR2(30) 	NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (usuario)
);

CREATE TABLE PACIENTE(
    usuario 	VARCHAR2(30) 	NOT NULL,
	nss 		VARCHAR2(11)	NOT NULL,
	numTarjeta	VARCHAR2(20) 	NOT NULL,
	telefono 	VARCHAR2(9) 	NOT NULL,
	direccion	VARCHAR2(100)	NOT NULL,
	CONSTRAINT paciente_pk PRIMARY KEY(usuario),
    CONSTRAINT pac_fk_usu FOREIGN KEY (usuario) REFERENCES USUARIO(usuario)
);

CREATE TABLE MEDICO(
    usuario 	VARCHAR2(30) 	NOT NULL,
	numColegiado	VARCHAR2(9)		NOT NULL,
	CONSTRAINT medico_pk PRIMARY KEY(usuario),
    CONSTRAINT med_fk_usu FOREIGN KEY (usuario) REFERENCES USUARIO(usuario)
);

CREATE TABLE MEDICO_PACIENTE(
	medico 		VARCHAR2(30) NOT NULL,
	paciente 	VARCHAR2(30) NOT NULL,
	CONSTRAINT medpac_pk PRIMARY KEY(medico),
	CONSTRAINT medpac_fk_med FOREIGN KEY(medico) REFERENCES MEDICO(usuario),
	CONSTRAINT medpac_fk_pac FOREIGN KEY(paciente) REFERENCES PACIENTE(usuario)
);

CREATE TABLE CITA(
	id NUMBER(20,0) 	NOT NULL, --todas los valores posibles de un long
	motivoCita VARCHAR2(500) NOT NULL,
	fechaHora DATE NOT NULL, 
	diagnostico NUMBER(20,0) NULL,
    medico VARCHAR2(30) NOT NULL,
    paciente VARCHAR2(30) 	NOT NULL,
	CONSTRAINT cita_pk PRIMARY KEY(id),
    CONSTRAINT cita_fk_med FOREIGN KEY (medico) REFERENCES MEDICO(usuario),
    CONSTRAINT cita_fk_pac FOREIGN KEY (paciente) REFERENCES PACIENTE(usuario)
	--FOREIGN KEY(diagnostico) REFERENCES DIAGNOSTICO(id) se añade despues modificando la tabla
    --porque se hace referencia a una tabla que no existe actualmente
);

CREATE TABLE DIAGNOSTICO(
	id NUMBER(20) NOT NULL,
	valoracionEspecialista VARCHAR2(500) NOT NULL,
	enfermedad VARCHAR2(100) NOT NULL,
	cita NUMBER(20) NOT NULL,
	CONSTRAINT diag_pk PRIMARY KEY(id),
	CONSTRAINT diag_fk_cita FOREIGN KEY(id) REFERENCES CITA(id)
);

ALTER TABLE CITA ADD CONSTRAINT cita_fk_diag FOREIGN KEY (diagnostico) REFERENCES DIAGNOSTICO(id);
