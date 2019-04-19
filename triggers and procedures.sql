
USE `arquitectura`;

-- PROCEDIMIENTOS

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


















-- DISPARADORES

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

