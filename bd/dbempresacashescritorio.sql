-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-11-2019 a las 21:13:55
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbempresacashescritorio`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `Cliente_Agregar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_Agregar_sp` (IN `nombre` VARCHAR(100), IN `apellidos` CHAR(100), IN `email` VARCHAR(150), IN `dni` CHAR(8), IN `fechaNa` DATE, IN `genero` VARCHAR(15), IN `celular` INT, IN `universidad` VARCHAR(100), IN `carrera` VARCHAR(100), IN `estado` CHAR(15), IN `tipoC` INT)  NO SQL
INSERT INTO cliente (`C_Nombre`, `C_Apellidos`, `C_CorreoElectronico`, `C_Dni`, `C_FechaNacimiento`, `C_Genero`, `C_Celular`, `C_Universidad`, `C_Carrrera`, `C_Estado`, `TC_Id`) VALUES(nombre,apellidos,email,dni,fechaNa,genero,celular,universidad,carrera,estado,tipoC)$$

DROP PROCEDURE IF EXISTS `Cliente_buscarClientes_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_buscarClientes_sp` (IN `dni` CHAR(8))  NO SQL
SELECT c.C_Id,c.C_Nombre,c.C_Apellidos,c.C_CorreoElectronico,c.C_Dni,c.C_FechaNacimiento,c.C_Genero,c.C_Celular,c.C_Universidad,c.C_Carrrera,c.C_Estado,c.TC_Id from cliente as c WHERE c.C_Dni LIKE CONCAT('%', dni, '%')$$

DROP PROCEDURE IF EXISTS `Cliente_buscarDni_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Cliente_buscarDni_sp` (IN `dni` CHAR(8))  NO SQL
SELECT c.C_Id,c.C_Nombre,c.C_Apellidos,c.C_CorreoElectronico,c.C_Dni,c.C_FechaNacimiento,c.C_Genero,c.C_Celular,c.C_Universidad,c.C_Carrrera,c.C_Estado,c.TC_Id from cliente as c WHERE c.C_Dni=dni$$

DROP PROCEDURE IF EXISTS `Cliente_buscar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_buscar_sp` (IN `id` INT)  NO SQL
SELECT c.C_Id,c.C_Nombre,c.C_Apellidos,c.C_CorreoElectronico,c.C_Dni,c.C_FechaNacimiento,c.C_Genero,c.C_Celular,c.C_Universidad,c.C_Carrrera,c.C_Estado,c.TC_Id from cliente as c WHERE c.C_Id=id$$

DROP PROCEDURE IF EXISTS `Cliente_Eliminar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_Eliminar_sp` (IN `id` INT)  NO SQL
DELETE from cliente WHERE C_Id=id$$

DROP PROCEDURE IF EXISTS `Cliente_Modificar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_Modificar_sp` (IN `nombre` VARCHAR(100), IN `apellidos` VARCHAR(100), IN `email` VARCHAR(150), IN `dni` CHAR(8), IN `fechaN` DATE, IN `genero` CHAR(30), IN `celular` INT, IN `universidad` VARCHAR(100), IN `carrera` VARCHAR(100), IN `estado` CHAR(15), IN `tipo` INT, IN `id` INT)  NO SQL
UPDATE cliente as c set c.C_Nombre=nombre, c.C_Apellidos=apellidos,c.C_CorreoElectronico=email,c.C_Dni=dni,c.C_FechaNacimiento=fechaN,c.C_Genero=genero,c.C_Celular=celular,c.C_Universidad=universidad,c.C_Carrrera=carrera,c.C_Estado=estado,c.TC_Id=tipo WHERE c.C_Id=id$$

DROP PROCEDURE IF EXISTS `Cliente_mostrar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Cliente_mostrar_sp` ()  NO SQL
SELECT c.C_Id,c.C_Nombre,c.C_Apellidos,c.C_CorreoElectronico,c.C_Dni,c.C_FechaNacimiento,c.C_Genero,c.C_Celular,c.C_Universidad,c.C_Carrrera,c.C_Estado,c.TC_Id from cliente as c$$

DROP PROCEDURE IF EXISTS `DescripcionPrestamo_Agregar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DescripcionPrestamo_Agregar_sp` (IN `estado` CHAR(15), IN `comision` DOUBLE, IN `monto` DOUBLE, IN `mora` DOUBLE, IN `puntos` INT, IN `descripcion` VARCHAR(100))  NO SQL
INSERT INTO `descripcion_prestamo`( `DP_Comision`, `DP_Monto`, `DP_Mora`, `DP_Puntos`, `DP_Estado`,DP_Descripcion) VALUES (comision,monto,mora,puntos,estado,descripcion)$$

DROP PROCEDURE IF EXISTS `DescripcionPrestamo_Eliminar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DescripcionPrestamo_Eliminar_sp` (IN `id` INT)  NO SQL
DELETE from descripcion_prestamo WHERE DP_Id=id$$

DROP PROCEDURE IF EXISTS `DescripcionPrestamo_Modificar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DescripcionPrestamo_Modificar_sp` (IN `comision` DOUBLE, IN `monto` DOUBLE, IN `mora` DOUBLE, IN `puntos` INT, IN `descripcion` VARCHAR(100), IN `estado` CHAR(15), IN `id` INT)  NO SQL
UPDATE descripcion_prestamo set DP_Comision=comision,DP_Monto=monto,DP_Mora=mora,DP_Puntos=puntos,DP_Estado=estado,DP_Descripcion=descripcion WHERE DP_Id=id$$

DROP PROCEDURE IF EXISTS `DescripcionPrestamo_mostrar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DescripcionPrestamo_mostrar_sp` ()  NO SQL
SELECT dp.DP_Id,dp.DP_Comision,dp.DP_Monto,dp.DP_Mora,dp.DP_Puntos,dp.DP_Estado,dp.DP_Descripcion FROM descripcion_prestamo as dp$$

DROP PROCEDURE IF EXISTS `DetalleGrupo_Agregar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DetalleGrupo_Agregar_sp` (IN `cliente` INT, IN `grupo` INT, IN `fecha` DATE, IN `estado` CHAR(15))  NO SQL
INSERT INTO `detalle_grupo`( `C_Id`, `C_FechaCreacion`, `G_Id`, `DG_Estado`) VALUES (cliente,fecha,grupo,estado)$$

DROP PROCEDURE IF EXISTS `DetalleGrupo_buscarGrupo_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DetalleGrupo_buscarGrupo_sp` (IN `id` INT)  NO SQL
SELECT dg.DG_Id,dg.C_Id,dg.C_FechaCreacion,dg.G_Id,dg.DG_Estado from detalle_grupo as dg WHERE dg.G_Id=id$$

DROP PROCEDURE IF EXISTS `DetalleGrupo_Eliminar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DetalleGrupo_Eliminar_sp` (IN `id` INT)  NO SQL
DELETE from detalle_grupo WHERE DG_Id=id$$

DROP PROCEDURE IF EXISTS `DetalleGrupo_Modificar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `DetalleGrupo_Modificar_sp` (IN `clientes` INT, IN `grupo` INT, IN `fecha` DATE, IN `estado` CHAR(15), IN `id` INT)  NO SQL
UPDATE detalle_grupo as dg set dg.C_Id=clientes,dg.C_FechaCreacion=fecha,dg.G_Id=grupo,dg.DG_Estado=estado WHERE dg.DG_Id=id$$

DROP PROCEDURE IF EXISTS `Grupo_Agregar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_Agregar_sp` (IN `descripcion` VARCHAR(100), IN `estado` CHAR(15), IN `nombre` VARCHAR(50), IN `fecha` DATE)  NO SQL
INSERT INTO `grupo`( `G_Descripcion`, `G_Estado`,G_Nombre, `G_FechaCreacion`) VALUES (descripcion,estado,nombre,fecha)$$

DROP PROCEDURE IF EXISTS `Grupo_buscarClienteLike_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_buscarClienteLike_sp` (IN `dni` CHAR(8))  NO SQL
SELECT g.G_Id,g.G_Descripcion,g.G_Estado,g.G_FechaCreacion,g.G_Nombre from grupo as g INNER JOIN detalle_grupo as dg on dg.G_Id=g.G_Id INNER JOIN cliente as c on c.C_Id=dg.C_Id WHERE c.C_Dni LIKE CONCAT('%', dni, '%')  ORDER BY g.G_Id DESC$$

DROP PROCEDURE IF EXISTS `Grupo_buscar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_buscar_sp` (IN `id` INT)  NO SQL
SELECT g.G_Id,g.G_Descripcion,g.G_Estado,g.G_FechaCreacion,g.G_Nombre from grupo as g WHERE g.G_Id=id$$

DROP PROCEDURE IF EXISTS `Grupo_Modificar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_Modificar_sp` (IN `descripcion` VARCHAR(100), IN `estado` CHAR(15), IN `nombre` VARCHAR(50), IN `fecha` DATE, IN `id` INT)  NO SQL
UPDATE grupo as g set g.G_Descripcion=descripcion,g.G_Estado=estado,g.G_FechaCreacion=fecha WHERE g.G_Id=id$$

DROP PROCEDURE IF EXISTS `Grupo_mostrar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_mostrar_sp` ()  NO SQL
SELECT g.G_Id,g.G_Descripcion,g.G_Estado,g.G_FechaCreacion,g.G_Nombre from grupo as g ORDER BY g.G_Id DESC$$

DROP PROCEDURE IF EXISTS `Grupo_obtenerUltimoRegistro_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_obtenerUltimoRegistro_sp` ()  NO SQL
SELECT g.G_Id,g.G_Descripcion,g.G_Estado,g.G_FechaCreacion,g.G_Nombre from grupo as g ORDER by g.G_Id DESC LIMIT 1$$

DROP PROCEDURE IF EXISTS `Grupo_verificarSiEstaEnGrupo_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Grupo_verificarSiEstaEnGrupo_sp` (IN `id` INT)  NO SQL
SELECT G.G_Id,G.G_Descripcion,G.G_Estado,G.G_FechaCreacion,G.G_Nombre from detalle_grupo as dg inner JOIN grupo as g on g.G_Id=dg.G_Id WHERE dg.C_Id=id and dg.DG_Estado='Activo'$$

DROP PROCEDURE IF EXISTS `Prestamo_Agregar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_Agregar_sp` (IN `clientes` INT, IN `fInicio` DATE, IN `fFin` DATE, IN `estado` CHAR(15), IN `monto` DOUBLE(9,2))  NO SQL
INSERT INTO prestamo(C_Id, P_FechaInicio, P_FechaFin,  P_Monto, P_Estado) VALUES (clientes,fInicio,fFin,monto,estado)$$

DROP PROCEDURE IF EXISTS `Prestamo_buscarPorLike_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_buscarPorLike_sp` (IN `dni` CHAR(8))  NO SQL
SELECT p.P_Id,p.C_Id,p.P_FechaInicio,p.P_FechaFin,p.P_FechaPago,p.P_Monto,p.P_Estado from prestamo as p INNER JOIN cliente as c on c.C_Id=p.C_ID  WHERE c.C_Dni LIKE CONCAT('%', dni, '%') ORDER BY P_Id DESC$$

DROP PROCEDURE IF EXISTS `Prestamo_buscarPrestamoRangoFecha_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_buscarPrestamoRangoFecha_sp` (IN `fInicio` DATE)  NO SQL
SELECT p.P_Id,p.C_Id,p.P_FechaInicio,p.P_FechaFin,p.P_FechaPago,p.P_Monto,p.P_Estado from prestamo as p WHERE p.P_FechaInicio<=fInicio$$

DROP PROCEDURE IF EXISTS `Prestamo_Eliminar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_Eliminar_sp` (IN `id` INT)  NO SQL
DELETE from prestamo WHERE P_Id=id$$

DROP PROCEDURE IF EXISTS `Prestamo_Modificar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_Modificar_sp` (IN `cliente` INT, IN `fInicio` DATE, IN `fFin` DATE, IN `estado` CHAR(15), IN `monto` DOUBLE, IN `id` INT)  NO SQL
UPDATE prestamo as p set p.C_Id=cliente,p.P_FechaInicio=fInicio,p.P_FechaFin=fFin,p.P_Monto=monto,p.P_Estado=estado WHERE p.P_Id=id$$

DROP PROCEDURE IF EXISTS `Prestamo_mostrar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_mostrar_sp` ()  NO SQL
SELECT p.P_Id,p.C_Id,p.P_FechaInicio,p.P_FechaFin,p.P_FechaPago,p.P_Monto,p.P_Estado from prestamo as p ORDER by p.P_Id DESC$$

DROP PROCEDURE IF EXISTS `Prestamo_pagar_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_pagar_sp` (IN `estado` CHAR(15), IN `fpago` TIMESTAMP, IN `id` INT)  NO SQL
UPDATE prestamo as p set p.P_FechaPago=fpago,p.P_Estado=estado WHERE p.P_Id=id$$

DROP PROCEDURE IF EXISTS `Prestamo_verificarSiTienePrestamoActivo_sp`$$
CREATE DEFINER=`levi`@`%` PROCEDURE `Prestamo_verificarSiTienePrestamoActivo_sp` (IN `id` INT)  NO SQL
SELECT p.P_Id,p.C_Id,p.P_FechaInicio,p.P_FechaFin,p.P_FechaPago,p.P_Monto,p.P_Estado from prestamo as p WHERE p.C_Id=id and p.P_Estado='Activo'$$

DROP PROCEDURE IF EXISTS `TipoCliente_Agregar_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TipoCliente_Agregar_sp` (IN `descripcion` VARCHAR(50), IN `estado` CHAR(15))  NO SQL
INSERT INTO tipo_cliente ( `TC_Descripcion`, `TC_Estado`) VALUES(descripcion,estado)$$

DROP PROCEDURE IF EXISTS `TipoCliente_buscar_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TipoCliente_buscar_sp` (IN `codigo` INT)  NO SQL
SELECT tc.TC_Id,tc.TC_Descripcion,tc.TC_Estado from tipo_cliente as tc WHERE tc.TC_Id=codigo$$

DROP PROCEDURE IF EXISTS `TipoCliente_Eliminar_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TipoCliente_Eliminar_sp` (IN `codigo` INT)  NO SQL
DELETE from tipo_cliente WHERE TC_Id=codigo$$

DROP PROCEDURE IF EXISTS `TipoCliente_Modificar_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TipoCliente_Modificar_sp` (IN `descripcion` VARCHAR(50), IN `estado` CHAR(15), IN `codigo` INT)  NO SQL
UPDATE tipo_cliente as tc SET tc.TC_Descripcion=descripcion , tc.TC_Estado=estado WHERE tc.TC_Id=codigo$$

DROP PROCEDURE IF EXISTS `TipoCliente_mostrar_sp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TipoCliente_mostrar_sp` ()  NO SQL
SELECT tp.TC_Id,tp.TC_Descripcion,tp.TC_Estado from tipo_cliente as tp$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `C_Id` int(11) NOT NULL AUTO_INCREMENT,
  `C_Nombre` varchar(50) NOT NULL,
  `C_Apellidos` varchar(50) NOT NULL,
  `C_CorreoElectronico` varchar(100) DEFAULT NULL,
  `C_Dni` char(8) NOT NULL,
  `C_FechaNacimiento` date DEFAULT NULL,
  `C_Genero` char(30) NOT NULL,
  `C_Celular` int(11) NOT NULL,
  `C_Universidad` varchar(100) NOT NULL,
  `C_Carrrera` varchar(100) NOT NULL,
  `C_Estado` char(15) NOT NULL,
  `TC_Id` int(11) NOT NULL,
  PRIMARY KEY (`C_Id`),
  UNIQUE KEY `C_Dni` (`C_Dni`),
  UNIQUE KEY `C_CorreoElectronico` (`C_CorreoElectronico`),
  KEY `tipo_cliente_fk` (`TC_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`C_Id`, `C_Nombre`, `C_Apellidos`, `C_CorreoElectronico`, `C_Dni`, `C_FechaNacimiento`, `C_Genero`, `C_Celular`, `C_Universidad`, `C_Carrrera`, `C_Estado`, `TC_Id`) VALUES
(7, 'Levi', 'Velasquez Paz', 'l953187894@gmail.com', '73531482', '1998-08-30', 'MASCULINO', 953187894, 'UCV', 'Ing Sistemas', 'Activo', 1),
(4, 'asd', 'asd', 'l9531878944@gmail.com', '60196417', '1998-11-04', 'MASCULINO', 953187894, 'UPAO', '4555', 'Activo', 1),
(5, '45', '45', '45@gmail.com', '60196555', '1998-11-10', 'MASCULINO', 983332468, 'UPAO', '', 'Activo', 1),
(6, 'Jairo', 'Velasquez Paz', 'jairo@gmail.com', '60196418', '1998-10-12', 'MASCULINO', 953187894, 'UCV', 'Sistemas', 'Activo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descripcion_prestamo`
--

DROP TABLE IF EXISTS `descripcion_prestamo`;
CREATE TABLE IF NOT EXISTS `descripcion_prestamo` (
  `DP_Id` int(11) NOT NULL AUTO_INCREMENT,
  `DP_Comision` double NOT NULL,
  `DP_Monto` double NOT NULL,
  `DP_Mora` double NOT NULL,
  `DP_Puntos` int(11) NOT NULL,
  `DP_Estado` char(15) NOT NULL,
  `DP_Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`DP_Id`),
  UNIQUE KEY `DP_Descripcion` (`DP_Descripcion`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `descripcion_prestamo`
--

INSERT INTO `descripcion_prestamo` (`DP_Id`, `DP_Comision`, `DP_Monto`, `DP_Mora`, `DP_Puntos`, `DP_Estado`, `DP_Descripcion`) VALUES
(6, 12, 12, 12, 12, 'ACTIVO', '12'),
(7, 12, 12, 12, 12, 'ACTIVO', '13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_grupo`
--

DROP TABLE IF EXISTS `detalle_grupo`;
CREATE TABLE IF NOT EXISTS `detalle_grupo` (
  `DG_Id` int(11) NOT NULL AUTO_INCREMENT,
  `C_Id` int(11) NOT NULL,
  `C_FechaCreacion` date NOT NULL,
  `G_Id` int(11) NOT NULL,
  `DG_Estado` char(15) NOT NULL,
  PRIMARY KEY (`DG_Id`),
  KEY `grupo_fk` (`G_Id`),
  KEY `cliente_fk` (`C_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle_grupo`
--

INSERT INTO `detalle_grupo` (`DG_Id`, `C_Id`, `C_FechaCreacion`, `G_Id`, `DG_Estado`) VALUES
(11, 4, '2019-11-04', 19, 'Activo'),
(10, 3, '2019-11-04', 14, 'Activo'),
(9, 6, '2019-11-04', 15, 'Activo'),
(12, 7, '2019-11-05', 15, 'Activo'),
(13, 4, '2019-11-05', 21, 'Activo'),
(14, 7, '2019-11-05', 21, 'Activo'),
(15, 5, '2019-11-05', 22, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE IF NOT EXISTS `grupo` (
  `G_Id` int(11) NOT NULL AUTO_INCREMENT,
  `G_Descripcion` varchar(100) NOT NULL,
  `G_Estado` char(15) NOT NULL,
  `G_FechaCreacion` date NOT NULL,
  `G_Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`G_Id`),
  UNIQUE KEY `G_Nombre` (`G_Nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`G_Id`, `G_Descripcion`, `G_Estado`, `G_FechaCreacion`, `G_Nombre`) VALUES
(22, 'PARA PRESTAMOS', 'Activo', '2019-11-05', 'GRUPO N° 22'),
(21, 'PARA PRESTAMOS', 'Activo', '2019-11-05', 'GRUPO N° 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `P_Id` int(11) NOT NULL AUTO_INCREMENT,
  `C_Id` int(11) NOT NULL,
  `P_FechaInicio` date NOT NULL,
  `P_FechaFin` date NOT NULL,
  `P_FechaPago` timestamp NULL DEFAULT NULL,
  `P_Monto` double(9,2) NOT NULL,
  `P_Estado` char(15) NOT NULL,
  PRIMARY KEY (`P_Id`),
  KEY `asdasdas` (`C_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`P_Id`, `C_Id`, `P_FechaInicio`, `P_FechaFin`, `P_FechaPago`, `P_Monto`, `P_Estado`) VALUES
(23, 4, '2019-11-01', '2019-11-05', '2019-11-05 05:00:00', 20.00, 'Pagado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
CREATE TABLE IF NOT EXISTS `tipo_cliente` (
  `TC_Id` int(11) NOT NULL AUTO_INCREMENT,
  `TC_Descripcion` varchar(50) NOT NULL,
  `TC_Estado` char(15) NOT NULL,
  PRIMARY KEY (`TC_Id`),
  UNIQUE KEY `TC_Descripcion` (`TC_Descripcion`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_cliente`
--

INSERT INTO `tipo_cliente` (`TC_Id`, `TC_Descripcion`, `TC_Estado`) VALUES
(1, 'ESTUDIANTE', 'Activo');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
