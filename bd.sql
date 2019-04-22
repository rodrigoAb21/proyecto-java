-- MySQL Script generated by MySQL Workbench
-- Fri Apr 19 00:56:12 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema arquitectura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema arquitectura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `arquitectura` DEFAULT CHARACTER SET utf8 ;
USE `arquitectura` ;

-- -----------------------------------------------------
-- Table `arquitectura`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nit` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`tecnico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`tecnico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ci` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`tipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`herramienta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`herramienta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`equipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(20) NOT NULL,
  `nro_serie` VARCHAR(20) NOT NULL,
  `marca` VARCHAR(20) NOT NULL,
  `tipo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_equipo_tipo_idx` (`tipo_id` ASC) ,
  CONSTRAINT `fk_equipo_tipo`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `arquitectura`.`tipo` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`informe_servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`informe_servicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha_recepcion` VARCHAR(20) NOT NULL,
  `fecha_finalizacion` VARCHAR(20) NOT NULL,
  `costo_total` FLOAT NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_informe_servicio_cliente1_idx` (`cliente_id` ASC) ,
  CONSTRAINT `fk_informe_servicio_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `arquitectura`.`cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`detalle_informe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`detalle_informe` (
  `informe_servicio_id` INT NOT NULL,
  `equipo_id` INT NOT NULL,
  `costo` FLOAT NOT NULL,
  `observacion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`informe_servicio_id`, `equipo_id`),
  INDEX `fk_detalle_informe_equipo1_idx` (`equipo_id` ASC) ,
  CONSTRAINT `fk_detalle_informe_informe_servicio1`
    FOREIGN KEY (`informe_servicio_id`)
    REFERENCES `arquitectura`.`informe_servicio` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_informe_equipo1`
    FOREIGN KEY (`equipo_id`)
    REFERENCES `arquitectura`.`equipo` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`trabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`trabajo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha_inicio` VARCHAR(20) NOT NULL,
  `fecha_fin` VARCHAR(20) NOT NULL,
  `costo` FLOAT NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `tecnico_id` INT NOT NULL,
  `detalle_informe_informe_servicio_id` INT NOT NULL,
  `detalle_informe_equipo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trabajo_tecnico1_idx` (`tecnico_id` ASC) ,
  INDEX `fk_trabajo_detalle_informe1_idx` (`detalle_informe_informe_servicio_id` ASC, `detalle_informe_equipo_id` ASC) ,
  CONSTRAINT `fk_trabajo_tecnico1`
    FOREIGN KEY (`tecnico_id`)
    REFERENCES `arquitectura`.`tecnico` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_trabajo_detalle_informe1`
    FOREIGN KEY (`detalle_informe_informe_servicio_id` , `detalle_informe_equipo_id`)
    REFERENCES `arquitectura`.`detalle_informe` (`informe_servicio_id` , `equipo_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arquitectura`.`detalle_trabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arquitectura`.`detalle_trabajo` (
  `trabajo_id` INT NOT NULL,
  `herramienta_id` INT NOT NULL,
  PRIMARY KEY (`trabajo_id`, `herramienta_id`),
  INDEX `fk_detalle_trabajo_herramienta1_idx` (`herramienta_id` ASC) ,
  CONSTRAINT `fk_detalle_trabajo_trabajo1`
    FOREIGN KEY (`trabajo_id`)
    REFERENCES `arquitectura`.`trabajo` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_trabajo_herramienta1`
    FOREIGN KEY (`herramienta_id`)
    REFERENCES `arquitectura`.`herramienta` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- ************************************** POBLACION *************************************************


INSERT INTO CLIENTE VALUES (NULL, '12345', 'FARMACORP', 'DOBLE VIA', '3542102');
INSERT INTO CLIENTE VALUES (NULL, '78954', 'INQUIFARMED', 'RADIAL 17 1/2', '3532412');
INSERT INTO CLIENTE VALUES (NULL, '96542', 'UAGRM', 'AV. BUSCH', '3333542');
INSERT INTO CLIENTE VALUES (NULL, '87456', 'COPIJSUD', 'AV. CUMORAH', '3587765');
INSERT INTO CLIENTE VALUES (NULL, '13335', 'VOLTEC', 'AV. BANZER', '3974454');



INSERT INTO TECNICO VALUES (NULL, '815245', 'JUAN', 'PEREZ', 'IMPRESORAS', 'DOBLE VIA', '3542102');
INSERT INTO TECNICO VALUES (NULL, '815245', 'JORGE', 'TORRES', 'MONITORES', 'DOBLE VIA', '3542102');
INSERT INTO TECNICO VALUES (NULL, '815245', 'MARIO', 'TOLEDO', 'TELEVISORES', 'DOBLE VIA', '3542102');
INSERT INTO TECNICO VALUES (NULL, '815245', 'NORMA', 'GUTIERREZ', 'TECLADOS', 'DOBLE VIA', '3542102');
INSERT INTO TECNICO VALUES (NULL, '815245', 'CARMEN', 'ARANCIBIA', 'CASES', 'DOBLE VIA', '3542102');


INSERT INTO TIPO VALUES (NULL, 'MONITOR');
INSERT INTO TIPO VALUES (NULL, 'IMPRESORA');
INSERT INTO TIPO VALUES (NULL, 'FUENTE');
INSERT INTO TIPO VALUES (NULL, 'TECLADO');
INSERT INTO TIPO VALUES (NULL, 'PARLANTE');


INSERT INTO HERRAMIENTA VALUES (NULL, 'DESARMADOR ESTRELLA AMARILLO PEQUEÑO', 'GENERICO');
INSERT INTO HERRAMIENTA VALUES (NULL, 'DESARMADOR PLANO AZUL MEDIANO', 'TRAMONTINA');
INSERT INTO HERRAMIENTA VALUES (NULL, 'ALICATE DE PUNTA ROJO', 'GENERICO');
INSERT INTO HERRAMIENTA VALUES (NULL, 'ALICATE DE CORTE ROJO', 'UNITED');
INSERT INTO HERRAMIENTA VALUES (NULL, 'SOLDADOR ELECTRONICO NEGRO', 'VOLTRON');

INSERT INTO EQUIPO VALUES (NULL, 'JS-3432', 'ASD12312', 'LG', 3);
INSERT INTO EQUIPO VALUES (NULL, 'SD455D4', '4561231', 'ASUS', 1);
INSERT INTO EQUIPO VALUES (NULL, 'TR8454S', '8945212', 'SAMSUNG', 5);
INSERT INTO EQUIPO VALUES (NULL, 'ASD78A', '2N121312', 'EPSON', 3);
INSERT INTO EQUIPO VALUES (NULL, 'QWHE12J', '3412123W', 'EPSON', 1);
INSERT INTO EQUIPO VALUES (NULL, 'FDKSA02', 'R4322', 'HP', 2);
INSERT INTO EQUIPO VALUES (NULL, 'KSFD123', '675876D', 'CANON', 4);





-- ************************************** PROCEDIMIENTOS *************************************************


DROP procedure IF EXISTS `proc_actualizar_detalle_informe`;

DELIMITER $$
USE `arquitectura`$$
CREATE PROCEDURE proc_actualizar_detalle_informe (IN i_id int, in e_id int) 
BEGIN
-- Variables donde almacenar lo que nos traemos desde el SELECT
  declare resultado float default 0;
  declare v_costo float default 0;
  
-- Variable para controlar el fin del bucle
  DECLARE fin INTEGER DEFAULT 0;

-- El SELECT que vamos a ejecutar
  DECLARE trabajos_cursor CURSOR FOR 
    SELECT costo FROM trabajo WHERE detalle_informe_informe_servicio_id=i_id and detalle_informe_equipo_id=e_id;

-- Condición de salida
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin=1;

  OPEN trabajos_cursor;
  get_trabajos: LOOP
    FETCH trabajos_cursor INTO v_costo;
    IF fin = 1 THEN
       LEAVE get_trabajos;
    END IF;
    set resultado = resultado + v_costo;
    

  END LOOP get_trabajos;

  UPDATE detalle_informe 
SET 
    costo = resultado
WHERE
    informe_servicio_id = i_id AND equipo_id = e_id;

  CLOSE trabajos_cursor;
END$$

DELIMITER ;




DROP procedure IF EXISTS `proc_actualizar_informe`;

DELIMITER $$
USE `arquitectura`$$
CREATE PROCEDURE proc_actualizar_informe (IN i_id int) 
BEGIN
-- Variables donde almacenar lo que nos traemos desde el SELECT
  declare resultado float default 0;
  declare v_costo float default 0;
  
-- Variable para controlar el fin del bucle
  DECLARE fin INTEGER DEFAULT 0;

-- El SELECT que vamos a ejecutar
  DECLARE detalles_cursor CURSOR FOR 
    SELECT costo FROM detalle_informe WHERE informe_servicio_id=i_id;

-- Condición de salida
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin=1;

  OPEN detalles_cursor;
  get_detalles: LOOP
    FETCH detalles_cursor INTO v_costo;
    IF fin = 1 THEN
       LEAVE get_detalles;
    END IF;
    set resultado = resultado + v_costo;
    

  END LOOP get_detalles;

  UPDATE informe_servicio 
SET 
    costo_total = resultado
WHERE
    id = i_id;

  CLOSE detalles_cursor;
END$$

DELIMITER ;

-- ************************************** DISPARADORES *************************************************

DROP trigger IF EXISTS `disp_actualizar_insert`;

DELIMITER $$
USE `arquitectura`$$
CREATE trigger disp_actualizar_insert after insert on trabajo
for each row
BEGIN
	call proc_actualizar_detalle_informe(new.detalle_informe_informe_servicio_id, new.detalle_informe_equipo_id);
    call proc_actualizar_informe(new.detalle_informe_informe_servicio_id);
END$$

DELIMITER ;



DROP trigger IF EXISTS `disp_actualizar_update`;

DELIMITER $$
USE `arquitectura`$$
CREATE trigger disp_actualizar_update after update on trabajo
for each row
BEGIN
	call proc_actualizar_detalle_informe(old.detalle_informe_informe_servicio_id, old.detalle_informe_equipo_id);
    call proc_actualizar_informe(old.detalle_informe_informe_servicio_id);
END$$

DELIMITER ;


DROP trigger IF EXISTS `disp_actualizar_delete`;

DELIMITER $$
USE `arquitectura`$$
CREATE trigger disp_actualizar_delete after delete on trabajo
for each row
BEGIN
	call proc_actualizar_detalle_informe(old.detalle_informe_informe_servicio_id, old.detalle_informe_equipo_id);
    call proc_actualizar_informe(old.detalle_informe_informe_servicio_id);
END$$

DELIMITER ;

