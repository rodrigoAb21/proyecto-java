drop database if exists arquitectura;
create database arquitectura;
use arquitectura;

-- casos base

CREATE TABLE cliente (
    id INT NOT NULL auto_increment,
    nit VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    PRIMARY KEY (id)
);

insert into cliente values (null, '12345', 'FARMACORP', 'Doble via', '3542102');
insert into cliente values (null, '78954', 'INQUIFARMED', 'Radial 17 1/2', '3532412');
insert into cliente values (null, '96542', 'UAGRM', 'Av. Busch', '3333542');
insert into cliente values (null, '87456', 'COPIJSUD', 'Av. Cumorah', '3587765');
insert into cliente values (null, '13335', 'VOLTEC', 'Av. Banzer', '3974454');

CREATE TABLE tecnico (
    id INT NOT NULL auto_increment,
    ci VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    PRIMARY KEY (id)
);

insert into tecnico values (null, '815245', 'Juan', 'Perez', 'Impresoras', 'Doble via', '3542102');
insert into tecnico values (null, '815245', 'Jorge', 'Torres', 'Monitores', 'Doble via', '3542102');
insert into tecnico values (null, '815245', 'Mario', 'Toledo', 'Televisores', 'Doble via', '3542102');
insert into tecnico values (null, '815245', 'Norma', 'Gutierrez', 'Teclados', 'Doble via', '3542102');
insert into tecnico values (null, '815245', 'Carmen', 'Arancibia', 'Cases', 'Doble via', '3542102');

CREATE TABLE tipo (
    id INT NOT NULL auto_increment,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into tipo values (null, 'Monitor');
insert into tipo values (null, 'Impresora');
insert into tipo values (null, 'Fuente');
insert into tipo values (null, 'Teclado');
insert into tipo values (null, 'Parlante');

CREATE TABLE herramienta (
    id INT NOT NULL auto_increment,
    descripcion VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into herramienta values (null, 'Desarmador estrella amarillo pequeño', 'Generico');
insert into herramienta values (null, 'Desarmador plano azul mediano', 'Tramontina');
insert into herramienta values (null, 'Alicate de punta rojo', 'Generico');
insert into herramienta values (null, 'Alicate de corte rojo', 'United');
insert into herramienta values (null, 'Soldador electronico negro', 'Voltron');

-- uno a muchos

CREATE TABLE equipo (
    id INT NOT NULL auto_increment,
    modelo VARCHAR(50) NOT NULL,
    nro_serie VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    tipo_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo_id)
        REFERENCES tipo (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

insert into equipo values (null, 'JS-3432', 'ASD12312', 'LG', 3);
insert into equipo values (null, 'SD455D4', '4561231', 'ASUS', 1);
insert into equipo values (null, 'TR8454S', '8945212', 'SAMSUNG', 5);
insert into equipo values (null, 'ASD78A', '2N121312', 'EPSON', 3);
insert into equipo values (null, 'QWHE12J', '3412123W', 'EPSON', 1);
insert into equipo values (null, 'FDKSA02', 'R4322', 'HP', 2);
insert into equipo values (null, 'KSFD123', '675876D', 'CANON', 4);


CREATE TABLE informe_servicio (
	id INT NOT NULL auto_increment,
    fecha_recepcion varchar(20) not null,
    fecha_finalizacion varchar(20) not null,
    costo_total float not null,
    estado varchar(20) not null,
    cliente_id int not null,
    primary key(id),
    FOREIGN KEY (cliente_id)
        REFERENCES cliente (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE detalle_informe (
    informe_id INT NOT NULL,
    equipo_id INT NOT NULL,
    costo FLOAT NOT NULL,
    observacion VARCHAR(100) NOT NULL,
    PRIMARY KEY (informe_id , equipo_id),
    FOREIGN KEY (informe_id)
        REFERENCES informe_servicio (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (equipo_id)
        REFERENCES equipo (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE trabajo (
    id INT NOT NULL auto_increment,
    fecha_inicio VARCHAR(20) NOT NULL,
    fecha_fin VARCHAR(20) NOT NULL,
    costo FLOAT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    tecnico_id INT NOT NULL,
    informe_id INT NOT NULL,
    equipo_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tecnico_id)
        REFERENCES tecnico (id)
        ON UPDATE CASCADE,
    FOREIGN KEY (informe_id)
        REFERENCES detalle_informe (informe_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (equipo_id)
        REFERENCES detalle_informe (equipo_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE detalle_trabajo (
    trabajo_id INT NOT NULL,
    herramienta_id INT NOT NULL,
    PRIMARY KEY (trabajo_id , herramienta_id),
    FOREIGN KEY (trabajo_id)
        REFERENCES trabajo (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (herramienta_id)
        REFERENCES herramienta (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);




