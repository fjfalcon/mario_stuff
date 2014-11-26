CREATE TABLE ejemplo.empleados
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  office VARCHAR(255),
  departamentoId INT,
  modifyDate TIMESTAMP DEFAULT NOW(),
  salary DOUBLE,
  comision DOUBLE,
  INDEX `fk_empleados-departamento_idx` (`departamentoId` ASC),
  CONSTRAINT `fk_empleado-departamento`
  FOREIGN KEY (`departamentoId`)
  REFERENCES `departamentos` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;