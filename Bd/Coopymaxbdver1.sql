CREATE DATABASE  IF NOT EXISTS `copymax` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `copymax`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: copymax
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caja` (
  `idCaja` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `FechaInicio` datetime NOT NULL,
  `FechaFin` datetime DEFAULT NULL,
  `FondoInicial` decimal(10,2) NOT NULL,
  `TotalVentas` decimal(10,2) DEFAULT 0.00,
  `TotalPedidos` decimal(10,2) DEFAULT 0.00,
  `TotalRetiros` decimal(10,2) DEFAULT 0.00,
  `CorteFinal` decimal(10,2) DEFAULT 0.00,
  `TotalCaja` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idCaja`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `caja_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (2,1,'2024-12-02 01:41:00',NULL,320.00,0.00,0.00,0.00,0.00,473.50),(3,1,'2024-12-03 21:25:37','2024-12-03 23:08:45',200.00,171.00,0.00,0.00,365.00,371.00),(4,1,'2024-12-01 00:02:26',NULL,200.00,624.00,0.00,0.00,0.00,824.00),(5,1,'2024-12-12 02:12:21',NULL,150.00,14.00,90.00,0.00,0.00,254.00),(6,1,'2024-12-18 04:31:27',NULL,200.00,7.50,0.00,0.00,0.00,207.50),(7,3,'2025-03-23 01:45:17',NULL,200.00,106.00,0.00,0.00,0.00,306.00);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Celular` varchar(10) DEFAULT NULL,
  `RFC` varchar(18) DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Max ','Bautista Fabián ','9515190825','XXXX','maxstell5549@hotmail.com'),(2,'Bicho','Rojo','9515190825','XXXX','bichorojo123@gmail.com'),(3,'Leah','Knox','0830430861','oTLs380374DNd','dclark@sandoval.com'),(4,'Lisa','Lewis','8488036541','JGqu512892erA','ddonovan@walker.net'),(5,'Frank','Gill','1799903492','cXax969821Crd','moorewilliam@munoz.com'),(6,'Christopher','Williams','7779377493','tdCo501429TKU','rpayne@scott-sloan.com'),(7,'John','Lee','3347909467','NpyZ258349xjD','vhale@yahoo.com'),(8,'Angela','Parsons','9329176883','YbdF571417WWX','bburke@hotmail.com'),(9,'Cody','Fowler','7639561911','deGB295981UUd','timothy31@mckay.org'),(10,'Tina','Harper','3953901406','XrAG432263Cim','greenlaura@moore.biz'),(11,'Jacqueline','King','6967511574','FgzD642336OnG','michael39@foster.com'),(12,'Russell','Olson','3961230323','Jjwq641967sTa','kellyruth@gmail.com'),(13,'Michael','Turner','9595385796','UtiD966600HXk','vhancock@hotmail.com'),(14,'Jessica','White','6852024491','arWd741934pZq','david42@hotmail.com'),(15,'Thomas','Mejia','3698042188','BbWR522451hDC','nicholascervantes@bell.com'),(16,'Laura','Haney','9581599510','bMYQ922737ubN','dawn81@hotmail.com'),(17,'Jessica','Mcintyre','8584707568','oWwW017180pHt','timothyhart@hotmail.com'),(18,'Alyssa','Davis','5637304047','TPQE323860bDV','elizabethlara@gmail.com'),(19,'Angela','Lyons','1175261619','THow474387fVX','thomasstephen@sandoval.info'),(20,'Amanda','Jarvis','0036607133','ZnzW105181aeU','jjones@lopez.com'),(21,'Christina','Moore','0689448698','WWlt873520qoJ','patrickhall@yahoo.com'),(22,'Jose','Hardin','4452788148','Rixp693292dam','greengina@yahoo.com'),(23,'Kenneth','Barton','4393314820','NfUs369273UdQ','scott49@young.org'),(24,'Michelle','Phillips','0614981511','bLQX141456nkN','yjohnson@parker-sherman.org'),(25,'Norma','Jimenez','8524606960','ZAEX766516phR','zoe59@hotmail.com'),(26,'Edward','Gray','5929653762','utPb058304EOv','amanda96@yahoo.com'),(27,'Brian','Velasquez','6276122690','bubU967594WLj','nwilliams@watts.com'),(28,'Kyle','Diaz','5585425767','DkQs173624DBm','kmontgomery@yahoo.com'),(29,'Marcus','Jones','6400750031','qlRD633623yiy','shannonchavez@gmail.com'),(30,'Pamela','Martin','3492400237','NQOQ415883Bih','valeriemartinez@perry-watkins.com'),(31,'Jennifer','Medina','2687506735','CHnF602111wdX','freemanveronica@watson.info'),(32,'Laura','Schmidt','7419701979','TShX789289Bzs','robertrangel@jones-kelly.org'),(383,'Olivia','Fabian Mestas','9511601449','','liquis70@hotmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idVenta` int(11) NOT NULL,
  `idProductos` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioUnitario` decimal(10,2) NOT NULL,
  `Subtotal` decimal(10,2) GENERATED ALWAYS AS (`Cantidad` * `PrecioUnitario`) STORED,
  PRIMARY KEY (`idDetalle`),
  KEY `fk_detalle_venta` (`idVenta`),
  KEY `fk_detalle_producto` (`idProductos`),
  CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`idProductos`) REFERENCES `productos` (`idProductos`),
  CONSTRAINT `fk_detalle_venta` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `NumPedido` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `Nombre_Usuario` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `Nombre_Cliente` varchar(45) NOT NULL,
  `Apellidos_Cliente` varchar(45) DEFAULT NULL,
  `CelularCliente` varchar(12) DEFAULT NULL,
  `Servicio` varchar(30) DEFAULT NULL,
  `Cantidad` int(10) DEFAULT NULL,
  `CantidadCarta` int(11) DEFAULT 0,
  `CantidadOficio` int(11) DEFAULT 0,
  `Tamaño` varchar(10) DEFAULT NULL,
  `TipoDeCopia` varchar(45) DEFAULT 'No',
  `Servicioextra` varchar(45) DEFAULT NULL,
  `Escala` varchar(45) DEFAULT 'No',
  `FechaEmision` date NOT NULL,
  `HoraEmision` time NOT NULL,
  `FechaEntrega` date NOT NULL,
  `HoraEntrega` time NOT NULL,
  `NumeroDePag` int(11) DEFAULT NULL,
  `Frente` varchar(45) DEFAULT 'No',
  `Atras` varchar(45) DEFAULT 'No',
  `Arillo` varchar(10) DEFAULT '0',
  `Comentarios` varchar(150) DEFAULT 'Sin comentarios',
  `Total` decimal(10,2) NOT NULL,
  `Anticipo` decimal(10,2) DEFAULT NULL,
  `Resto` decimal(10,2) DEFAULT NULL,
  `Status` varchar(25) DEFAULT 'Pendiente',
  PRIMARY KEY (`NumPedido`),
  KEY `Idusuario_idx` (`idUsuario`),
  KEY `Idcliente_idx` (`idCliente`),
  KEY `celcliente_idx` (`CelularCliente`),
  KEY `nomvliente_idx` (`Nombre_Cliente`),
  CONSTRAINT `Idcliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Idusuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Engargolados',1,150,0,'Carta','No especificado',NULL,'No especificado','2024-12-09','16:02:56','2024-12-10','16:02:56',150,'Negro Transparente','Negro Solido','# 14','Imprimir pdf del num',66.00,40.00,0.00,'Finalizado'),(2,1,'Max ',2,'Bicho Rojo','Rojo','9515190825','Copias',3,260,0,'Carta',NULL,NULL,'No especificado','2024-12-09','16:18:14','2024-12-10','10:10:00',0,'No','No','No','Imprimir los tickets y hacerles una apliación',234.00,200.00,34.00,'Finalizado'),(3,1,'Max ',3,'Leah Knox','Knox','0830430861','Copias',3,400,0,'Carta',NULL,NULL,NULL,'2024-12-09','16:21:28','2024-12-10','14:30:00',0,'No','No','No','Ampliar tickets',360.00,300.00,60.00,'Finalizado'),(4,1,'Max ',383,'Olivia Fabian Mestas','Fabian Mestas','9511601449','Copias',5,120,0,'Carta',NULL,NULL,NULL,'2024-12-09','16:29:10','2024-12-10','18:29:00',0,'No','No','No','engrapar examenes de la maestra ',180.00,180.00,0.00,'Finalizado'),(5,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',4,250,0,'Carta','TAL COMO ESTA',NULL,'AMPLIACION','2024-12-09','17:08:19','2024-12-10','17:08:19',0,'No','No','No','Prueba',300.00,37.50,262.50,'Finalizado'),(6,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',30,3,0,'Carta','TAL COMO ESTA','ENGRAPADAS','No','2024-12-11','18:33:14','2024-12-12','18:33:14',0,'No','No','No','No especificado',31.50,31.50,0.00,'Finalizado'),(7,1,'Max ',383,'Olivia Fabian Mestas','Fabian Mestas','9511601449','Engargolados',3,150,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','19:16:46','2024-12-11','19:16:46',75,'Cristal Transparente','Negro Solido','# 8','No especificado',189.00,150.00,39.00,'Finalizado'),(8,1,'Max ',2,'Bicho Rojo','Rojo','9515190825','Copias',5,0,200,'Oficio','TAL COMO ESTA','No','No','2024-12-11','20:41:18','2024-12-12','12:41:00',0,'No','No','No','Quitar y volver a poner las grapas',700.00,350.00,350.00,'Finalizado'),(9,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',10,100,0,'Carta','TAL COMO ESTA','RECORTADAS','No','2024-12-11','21:19:04','2024-12-15','11:19:00',0,'No','No','No','No especificado',300.00,150.00,150.00,'Finalizado'),(10,1,'Max ',2,'Bicho Rojo','Rojo','9515190825','Copias',50,4,0,'Carta','TAL COMO ESTA','ENGRAPADAS','No','2024-12-11','21:34:41','2024-12-12','10:40:00',0,'No','No','No','No especificado',60.00,30.00,30.00,'Finalizado'),(11,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',150,2,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','21:43:30','2024-12-12','09:43:00',0,'No','No','No','No especificado',90.00,45.00,45.00,'Finalizado'),(12,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',100,10,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','21:52:04','2024-12-12','09:52:00',0,'No','No','No','No especificado',300.00,150.00,150.00,'Finalizado'),(13,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',1,3500,0,'Carta','No','No','No','2024-12-11','22:07:27','2024-12-15','13:07:00',0,'No','No','No','No especificado',1050.00,0.75,1049.25,'Finalizado'),(14,1,'Max ',383,'Olivia Fabian Mestas','Fabian Mestas','9511601449','Engargolados',1,340,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','22:10:47','2024-12-18','08:10:00',170,'Negro Transparente','Negro Transparente','# 14','AGREGAR UNA HOJA EN BLANCO PORTADA',124.00,62.00,62.00,'Finalizado'),(15,1,'Max ',5,'Frank Gill','Gill','1799903492','Copias',1,1150,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','22:38:30','2024-12-12','22:38:30',0,'No','No','No','No especificado',345.00,270.00,75.00,'Finalizado'),(16,1,'Max ',32,'Laura Schmidt','Schmidt','7419701979','Copias',1,89,0,'Carta','TAL COMO ESTA','No','No','2024-12-11','22:49:40','2024-12-12','22:49:40',0,'No','No','No','No especificado',31.15,15.58,15.57,'Finalizado'),(17,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',1,120,0,'Carta','No','No','No','2024-12-11','22:51:25','2024-12-12','22:51:25',0,'No','No','No','No especificado',36.00,18.00,18.00,'Finalizado'),(18,1,'Max ',1,'Max  Bautista Fabián ','Bautista Fabián ','9515190825','Copias',150,2,0,'Carta','TAL COMO ESTA','ENGRAPADAS','No','2024-12-12','02:13:25','2024-12-12','11:13:00',0,'No','No','No','No especificado',90.00,45.00,45.00,'Finalizado');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_producto` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  `Icono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProductos`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Copia Carta',363,0.50,'Copia / Impresion','copia.png'),(2,'Copia Oficio',818,0.70,'Copia / Impresion','copia.png'),(3,'Lapiz Mirado',17,6.00,'Papelería','Lapizmirado.png'),(4,'Pluma Negra',90,8.00,'Papelería','Pluma.png'),(5,'Carpeta de Costilla',12,20.00,'Papelería','carpetacostilla.png'),(6,'Sobre Amarillo Carta',44,2.50,'Papelería','sobre amarillo.jpg'),(7,'Carpeta Paja',194,4.00,'Papelería','carpeta.png'),(8,'Prit',15,18.00,'Copia / Impresion','resistol.png'),(9,'Lapiz Maped',26,5.00,'Papelería','Lapizmaped.png'),(10,'Engargolado # 4',46,18.00,'Engargolado','Engargolado.png'),(11,'Engargolado # 6',46,18.00,'Engargolado','Engargolado.png'),(13,'Engargolado # 8',45,19.00,'Engargolado','Engargolado.png'),(14,'Engargolado # 10',49,20.00,'Engargolado','Engargolado.png'),(15,'Engargolado # 12',50,21.00,'Engargolado','Engargolado.png'),(16,'Engargolado # 14',50,22.00,'Engargolado','Engargolado.png'),(17,'Engargolado # 16',50,23.00,'Engargolado','Engargolado.png'),(18,'Engargolado # 20',50,24.00,'Engargolado','Engargolado.png'),(19,'Engargolado # 22',50,25.00,'Engargolado','Engargolado.png'),(20,'Negro Solido',50,12.00,'Pasta',NULL),(21,'Negro Transparente',50,12.00,'Pasta',NULL),(22,'Cristal Transparente',50,12.00,'Pasta',NULL),(23,'Azul Transparente',50,12.00,'Pasta',NULL),(24,'Azul Cielo Solido',50,12.00,'Pasta',NULL),(25,'Azul Marino Solido',50,12.00,'Pasta',NULL),(26,'Azul Rey Solido',50,12.00,'Pasta',NULL),(27,'Rosa Solido',50,12.00,'Pasta',NULL),(28,'Rosa Transparente',50,12.00,'Pasta',NULL),(29,'Naranja Transparente',50,12.00,'Pasta',NULL),(30,'Naranaja Solido',50,12.00,'Pasta',NULL),(31,'# 4',50,12.00,'Arillo',NULL),(32,'# 6',50,12.00,'Arillo',NULL),(33,'# 8',50,12.00,'Arillo',NULL),(34,'# 10',50,12.00,'Arillo',NULL),(35,'# 12',50,12.00,'Arillo',NULL),(36,'# 14',50,12.00,'Arillo',NULL),(37,'# 16',50,12.00,'Arillo',NULL),(38,'# 20',50,12.00,'Arillo',NULL),(39,'# 22',50,12.00,'Arillo',NULL),(40,'# 24',50,12.00,'Arillo',NULL),(42,'Engargolado # 24',50,26.00,'Engargolado','Engargolado.png');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retiros`
--

DROP TABLE IF EXISTS `retiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retiros` (
  `idRetiro` int(11) NOT NULL AUTO_INCREMENT,
  `idCaja` int(11) NOT NULL,
  `Monto` decimal(10,2) NOT NULL,
  `FechaHora` datetime NOT NULL,
  `Motivo` text DEFAULT NULL,
  PRIMARY KEY (`idRetiro`),
  KEY `idCaja` (`idCaja`),
  CONSTRAINT `retiros_ibfk_1` FOREIGN KEY (`idCaja`) REFERENCES `caja` (`idCaja`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retiros`
--

LOCK TABLES `retiros` WRITE;
/*!40000 ALTER TABLE `retiros` DISABLE KEYS */;
/*!40000 ALTER TABLE `retiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `Rol` varchar(15) NOT NULL,
  `Usuario_idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  KEY `Usuario_idUsuario` (`Usuario_idUsuario`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `NombreUsuario` varchar(15) NOT NULL,
  `Celular` varchar(20) DEFAULT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Rol` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Max ','Bautista ','maxbf546','9515190825','123max','Administrador'),(2,'Nizalindaly','Bautista','nizabf546','9513972745','niza123','Estandar'),(3,'admin','amin','admin','95147212','admin','Administrador');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario_idUsuario` int(11) DEFAULT NULL,
  `Cliente_idCliente` int(11) DEFAULT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Cliente` varchar(45) NOT NULL,
  `Fecha` datetime NOT NULL,
  `Items` varchar(2000) DEFAULT NULL,
  `Subtotal` decimal(10,2) DEFAULT NULL,
  `Impuesto` decimal(10,2) DEFAULT NULL,
  `Descuento` decimal(10,2) DEFAULT NULL,
  `Total` decimal(10,2) DEFAULT NULL,
  `Recibido` decimal(10,2) DEFAULT NULL,
  `Cambio` decimal(10,2) DEFAULT NULL,
  `Metodo_pago` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `Usuario_idUsuario` (`Usuario_idUsuario`),
  KEY `Cliente_idCliente` (`Cliente_idCliente`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,NULL,NULL,'Max ','General','2024-10-07 19:11:16','10  |Copia Carta         |0.5  |5.0  \n1   |Copia Oficio        |0.7  |0.7  \n1   |Lapiz Mirado        |6.0  |6.0  \n',11.70,0.00,0.00,11.70,20.00,8.30,'Efectivo'),(2,NULL,NULL,'Max ','General','2024-10-10 19:17:32','1600|Copia Carta         |0.5  |800.0\n',800.00,0.00,0.00,800.00,1000.00,200.00,NULL),(3,NULL,NULL,'Max ','General','2024-10-13 23:15:13','110 |Copia Carta         |0.5  |55.0 \n',55.00,0.00,0.00,55.00,100.00,45.00,NULL),(4,NULL,NULL,'Max ','General','2024-11-11 14:45:49','3   |Lapiz Mirado        |6.0  |18.0 \n',18.00,0.00,0.00,18.00,50.00,32.00,NULL),(5,NULL,NULL,'Max ','Max ','2024-11-11 14:47:05','5   |Copia Carta         |0.5  |2.5  \n',2.50,0.00,0.00,2.50,10.00,7.50,NULL),(6,NULL,NULL,'Max ','Max ','2024-11-14 15:55:01','1   |Carpeta Paja        |4.0  |4.0  \n1   |Lapiz Mirado        |6.0  |6.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n',30.00,0.00,0.00,30.00,50.00,20.00,NULL),(7,NULL,NULL,'Max ','Max ','2024-11-14 15:55:25','1   |Carpeta Paja        |4.0  |4.0  \n1   |Lapiz Mirado        |6.0  |6.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n',30.00,0.00,0.00,30.00,50.00,20.00,NULL),(8,1,18,'General','Amanda Jarvis','2024-11-01 15:48:00','Carpeta de Costilla x 6;Sobre Amarillo Carta x 5;Engargolado #8 x 8',264.00,0.00,0.00,264.00,273.00,9.00,NULL),(12,2,30,'General','Laura Schmidt','2024-11-01 07:48:00','Lapiz Mirado x 4;Copia Carta x 2;Engargolado #8 x 9;Copia Oficio x 4',147.00,0.00,0.00,147.00,165.00,18.00,NULL),(13,2,17,'General','Angela Lyons','2024-11-01 18:34:00','Copia Carta x 2',1.00,0.00,0.00,1.00,16.00,15.00,NULL),(14,2,27,'General','Marcus Jones','2024-11-01 07:39:00','Carpeta de Costilla x 10',200.00,0.00,0.00,200.00,211.00,11.00,NULL),(16,2,9,'General','Jacqueline King','2024-11-01 15:09:00','Lapiz Mirado x 4',48.00,0.00,0.00,48.00,59.00,11.00,NULL),(17,1,25,'General','Brian Velasquez','2024-11-01 20:04:00','Prit x 2;Carpeta de Costilla x 6;Sobre Amarillo Carta x 2;Lapiz Maped x 7;Engargolado #6 x 5',371.00,0.00,0.00,371.00,386.00,15.00,NULL),(19,1,1,'General','Leah Knox','2024-11-01 13:57:00','Lapiz Maped x 8;Pluma Negra x 6;Carpeta de Costilla x 7;Sobre Amarillo Carta x 4',88.00,0.00,0.00,88.00,94.00,6.00,NULL),(20,3,8,'General','Tina Harper','2024-11-01 16:53:00','Pluma Negra x 2;Engargolado #6 x 10;Carpeta Paja x 2',248.00,0.00,0.00,248.00,263.00,15.00,NULL),(22,1,26,'General','Kyle Diaz','2024-11-01 07:34:00','Engargolado #6 x 4;Lapiz Mirado x 5;Sobre Amarillo Carta x 6',182.00,0.00,0.00,182.00,200.00,18.00,NULL),(25,1,26,'General','Kyle Diaz','2024-11-01 16:19:00','Engargolado #12 x 7;Copia Oficio x 4;Carpeta de Costilla x 10',181.00,0.00,0.00,181.00,194.00,13.00,NULL),(26,3,2,'General','Lisa Lewis','2024-11-01 08:17:00','Copia Oficio x 10;Engargolado #10 x 1',120.00,0.00,0.00,120.00,132.00,12.00,NULL),(27,2,30,'General','Laura Schmidt','2024-11-01 09:35:00','Lapiz Maped x 2;Sobre Amarillo Carta x 9;Engargolado #10 x 1',63.00,0.00,0.00,63.00,81.00,18.00,NULL),(28,3,8,'General','Tina Harper','2024-11-01 10:13:00','Lapiz Maped x 8',25.00,0.00,0.00,25.00,33.00,8.00,NULL),(29,1,6,'General','Angela Parsons','2024-11-01 11:03:00','Copia Carta x 7;Copia Oficio x 1;Sobre Amarillo Carta x 8',22.00,0.00,0.00,22.00,37.00,15.00,NULL),(31,1,19,'General','Christina Moore','2024-11-01 12:06:00','Lapiz Mirado x 7;Carpeta de Costilla x 7',80.00,0.00,0.00,80.00,94.00,14.00,NULL),(32,1,27,'General','Marcus Jones','2024-11-01 16:11:00','Lapiz Mirado x 4',12.00,0.00,0.00,12.00,29.00,17.00,NULL),(35,3,18,'General','Amanda Jarvis','2024-11-02 13:53:00','Carpeta Paja x 8;Engargolado #6 x 10',82.00,0.00,0.00,82.00,98.00,16.00,NULL),(36,3,21,'General','Kenneth Barton','2024-11-02 20:52:00','Engargolado #8 x 2;Copia Oficio x 5;Copia Carta x 4',79.00,0.00,0.00,79.00,88.00,9.00,NULL),(38,2,23,'General','Norma Jimenez','2024-11-02 13:03:00','Engargolado #8 x 1;Sobre Amarillo Carta x 1;Engargolado #6 x 8',236.00,0.00,0.00,236.00,252.00,16.00,NULL),(39,3,20,'General','Jose Hardin','2024-11-02 08:53:00','Engargolado #8 x 5;Pluma Negra x 6',88.00,0.00,0.00,88.00,95.00,7.00,NULL),(42,2,24,'General','Edward Gray','2024-11-02 20:48:00','Copia Carta x 8;Lapiz Mirado x 4;Prit x 10;Carpeta Paja x 6;Copia Oficio x 7',259.00,0.00,0.00,259.00,274.00,15.00,NULL),(44,3,10,'General','Russell Olson','2024-11-02 16:40:00','Engargolado #6 x 7',126.00,0.00,0.00,126.00,136.00,10.00,NULL),(46,2,9,'General','Jacqueline King','2024-11-02 18:45:00','Carpeta Paja x 3;Carpeta de Costilla x 8;Lapiz Mirado x 10;Engargolado #12 x 5;Prit x 8',410.00,0.00,0.00,410.00,428.00,18.00,NULL),(47,3,9,'General','Jacqueline King','2024-11-02 11:34:00','Engargolado #12 x 9;Prit x 5;Copia Oficio x 6',385.00,0.00,0.00,385.00,396.00,11.00,NULL),(49,3,27,'General','Marcus Jones','2024-11-02 11:56:00','Engargolado #10 x 10;Prit x 5;Engargolado #12 x 10',176.00,0.00,0.00,176.00,188.00,12.00,NULL),(50,1,11,'General','Michael Turner','2024-11-02 16:18:00','Lapiz Mirado x 4;Engargolado #6 x 2',144.00,0.00,0.00,144.00,153.00,9.00,NULL),(51,3,5,'General','John Lee','2024-11-02 13:03:00','Copia Carta x 3',1.00,0.00,0.00,1.00,12.00,11.00,NULL),(52,1,15,'General','Jessica Mcintyre','2024-11-02 14:56:00','Engargolado #12 x 2',200.00,0.00,0.00,200.00,206.00,6.00,NULL),(54,2,28,'General','Pamela Martin','2024-11-02 17:36:00','Pluma Negra x 4',80.00,0.00,0.00,80.00,95.00,15.00,NULL),(55,3,22,'General','Michelle Phillips','2024-11-02 07:19:00','Copia Oficio x 3;Lapiz Mirado x 1',56.00,0.00,0.00,56.00,61.00,5.00,NULL),(56,3,11,'General','Michael Turner','2024-11-02 16:02:00','Copia Oficio x 9;Lapiz Maped x 3',45.00,0.00,0.00,45.00,56.00,11.00,NULL),(57,2,12,'General','Jessica White','2024-11-02 11:43:00','Prit x 1;Copia Oficio x 1;Pluma Negra x 10;Engargolado #12 x 8',271.00,0.00,0.00,271.00,286.00,15.00,NULL),(58,2,30,'General','Laura Schmidt','2024-11-03 08:18:00','Carpeta Paja x 4;Prit x 2;Lapiz Mirado x 7;Engargolado #6 x 4;Engargolado #8 x 2',262.00,0.00,0.00,262.00,278.00,16.00,NULL),(60,3,10,'General','Russell Olson','2024-11-03 08:46:00','Engargolado #12 x 2;Sobre Amarillo Carta x 9;Lapiz Mirado x 5',46.00,0.00,0.00,46.00,65.00,19.00,NULL),(62,2,10,'General','Russell Olson','2024-11-03 19:30:00','Engargolado #12 x 4',120.00,0.00,0.00,120.00,131.00,11.00,NULL),(64,3,23,'General','Norma Jimenez','2024-11-03 17:27:00','Copia Oficio x 10;Pluma Negra x 9;Carpeta de Costilla x 5;Carpeta Paja x 3;Sobre Amarillo Carta x 9',296.00,0.00,0.00,296.00,314.00,18.00,NULL),(65,2,6,'General','Angela Parsons','2024-11-03 07:24:00','Copia Carta x 3;Engargolado #6 x 5',166.00,0.00,0.00,166.00,177.00,11.00,NULL),(66,2,21,'General','Kenneth Barton','2024-11-03 14:09:00','Copia Carta x 1;Lapiz Maped x 4;Engargolado #10 x 8',229.00,0.00,0.00,229.00,246.00,17.00,NULL),(67,2,26,'General','Kyle Diaz','2024-11-03 11:29:00','Engargolado #6 x 7;Pluma Negra x 5;Carpeta de Costilla x 6;Copia Carta x 7;Carpeta Paja x 8',268.00,0.00,0.00,268.00,278.00,10.00,NULL),(68,2,16,'General','Alyssa Davis','2024-11-03 12:37:00','Carpeta Paja x 8',40.00,0.00,0.00,40.00,57.00,17.00,NULL),(71,3,7,'General','Cody Fowler','2024-11-03 15:39:00','Engargolado #8 x 3;Copia Oficio x 4',72.00,0.00,0.00,72.00,91.00,19.00,NULL),(72,2,26,'General','Kyle Diaz','2024-11-03 19:31:00','Pluma Negra x 6;Carpeta Paja x 9',20.00,0.00,0.00,20.00,30.00,10.00,NULL),(73,3,15,'General','Jessica Mcintyre','2024-11-03 17:38:00','Carpeta de Costilla x 6;Lapiz Maped x 10;Copia Oficio x 6;Engargolado #12 x 3;Pluma Negra x 1',338.00,0.00,0.00,338.00,354.00,16.00,NULL),(75,3,8,'General','Tina Harper','2024-11-03 10:34:00','Pluma Negra x 2;Copia Carta x 5;Engargolado #8 x 10',101.00,0.00,0.00,101.00,109.00,8.00,NULL),(80,2,10,'General','Russell Olson','2024-11-03 09:08:00','Carpeta de Costilla x 5;Sobre Amarillo Carta x 8;Engargolado #6 x 8',300.00,0.00,0.00,300.00,313.00,13.00,NULL),(81,3,12,'General','Jessica White','2024-11-03 08:36:00','Carpeta de Costilla x 5',160.00,0.00,0.00,160.00,180.00,20.00,NULL),(84,3,17,'General','Angela Lyons','2024-11-04 10:28:00','Sobre Amarillo Carta x 9;Lapiz Maped x 8;Engargolado #6 x 7',56.00,0.00,0.00,56.00,73.00,17.00,NULL),(85,1,11,'General','Michael Turner','2024-11-04 07:31:00','Carpeta de Costilla x 6;Engargolado #12 x 10;Copia Carta x 1;Carpeta Paja x 6;Lapiz Mirado x 3',301.00,0.00,0.00,301.00,321.00,20.00,NULL),(86,1,10,'General','Russell Olson','2024-11-04 13:31:00','Carpeta Paja x 1;Engargolado #12 x 9;Engargolado #8 x 9;Carpeta de Costilla x 1',362.00,0.00,0.00,362.00,375.00,13.00,NULL),(87,2,27,'General','Marcus Jones','2024-11-04 12:28:00','Engargolado #6 x 7;Carpeta Paja x 8;Pluma Negra x 4;Copia Oficio x 8;Carpeta de Costilla x 7',155.00,0.00,0.00,155.00,174.00,19.00,NULL),(88,3,21,'General','Kenneth Barton','2024-11-04 07:37:00','Engargolado #12 x 7',160.00,0.00,0.00,160.00,165.00,5.00,NULL),(94,2,1,'General','Leah Knox','2024-11-04 16:00:00','Pluma Negra x 4;Prit x 1;Carpeta Paja x 6;Engargolado #10 x 10;Carpeta de Costilla x 7',405.00,0.00,0.00,405.00,419.00,14.00,NULL),(95,3,16,'General','Alyssa Davis','2024-11-04 17:23:00','Engargolado #8 x 10;Engargolado #12 x 4;Engargolado #10 x 6;Prit x 4;Pluma Negra x 10',357.00,0.00,0.00,357.00,367.00,10.00,NULL),(98,1,19,'General','Christina Moore','2024-11-04 19:00:00','Lapiz Maped x 3;Lapiz Mirado x 9;Copia Oficio x 10;Engargolado #8 x 7;Carpeta de Costilla x 5',361.00,0.00,0.00,361.00,377.00,16.00,NULL),(99,1,15,'General','Jessica Mcintyre','2024-11-04 13:10:00','Copia Carta x 1;Lapiz Mirado x 10;Engargolado #8 x 8;Engargolado #10 x 10;Engargolado #12 x 7',129.00,0.00,0.00,129.00,143.00,14.00,NULL),(100,3,22,'General','Michelle Phillips','2024-11-04 14:15:00','Sobre Amarillo Carta x 5',20.00,0.00,0.00,20.00,37.00,17.00,NULL),(101,1,26,'General','Kyle Diaz','2024-11-04 11:01:00','Lapiz Mirado x 6;Engargolado #12 x 2;Prit x 10',308.00,0.00,0.00,308.00,316.00,8.00,NULL),(103,3,15,'General','Jessica Mcintyre','2024-11-04 11:29:00','Sobre Amarillo Carta x 2;Lapiz Mirado x 1;Carpeta de Costilla x 10;Engargolado #10 x 4',258.00,0.00,0.00,258.00,265.00,7.00,NULL),(104,2,19,'General','Christina Moore','2024-11-04 10:14:00','Pluma Negra x 3;Lapiz Mirado x 9;Lapiz Maped x 1;Engargolado #10 x 5;Engargolado #6 x 3',350.00,0.00,0.00,350.00,356.00,6.00,NULL),(105,2,19,'General','Christina Moore','2024-11-04 13:31:00','Copia Carta x 4;Lapiz Maped x 1;Pluma Negra x 9;Carpeta de Costilla x 6;Carpeta Paja x 9',254.00,0.00,0.00,254.00,260.00,6.00,NULL),(106,2,12,'General','Jessica White','2024-11-04 16:52:00','Engargolado #8 x 4;Pluma Negra x 7;Lapiz Mirado x 10;Carpeta de Costilla x 1',336.00,0.00,0.00,336.00,349.00,13.00,NULL),(108,1,2,'General','Lisa Lewis','2024-11-05 17:46:00','Engargolado #12 x 4;Copia Oficio x 10;Engargolado #10 x 3;Carpeta de Costilla x 9;Pluma Negra x 8',305.00,0.00,0.00,305.00,318.00,13.00,NULL),(110,1,10,'General','Russell Olson','2024-11-05 19:03:00','Copia Carta x 2;Pluma Negra x 8',42.00,0.00,0.00,42.00,57.00,15.00,NULL),(112,2,10,'General','Russell Olson','2024-11-05 12:15:00','Lapiz Mirado x 2;Sobre Amarillo Carta x 4;Engargolado #6 x 7',204.00,0.00,0.00,204.00,223.00,19.00,NULL),(114,2,7,'General','Cody Fowler','2024-11-05 18:21:00','Engargolado #8 x 9;Lapiz Mirado x 3;Engargolado #12 x 1;Lapiz Maped x 6',198.00,0.00,0.00,198.00,210.00,12.00,NULL),(116,3,3,'General','Frank Gill','2024-11-05 18:00:00','Lapiz Mirado x 6;Copia Oficio x 9;Pluma Negra x 10;Engargolado #8 x 6;Sobre Amarillo Carta x 9',191.00,0.00,0.00,191.00,206.00,15.00,NULL),(117,3,13,'General','Thomas Mejia','2024-11-05 18:36:00','Prit x 2',72.00,0.00,0.00,72.00,80.00,8.00,NULL),(118,3,13,'General','Thomas Mejia','2024-11-05 15:51:00','Copia Oficio x 5;Lapiz Mirado x 1;Engargolado #10 x 9;Prit x 7',141.00,0.00,0.00,141.00,160.00,19.00,NULL),(119,1,21,'General','Kenneth Barton','2024-11-05 14:30:00','Lapiz Mirado x 2;Engargolado #6 x 2;Carpeta Paja x 9',172.00,0.00,0.00,172.00,181.00,9.00,NULL),(120,2,22,'General','Michelle Phillips','2024-11-05 12:34:00','Engargolado #12 x 6',180.00,0.00,0.00,180.00,193.00,13.00,NULL),(121,3,17,'General','Angela Lyons','2024-11-05 20:42:00','Prit x 2',108.00,0.00,0.00,108.00,123.00,15.00,NULL),(124,1,2,'General','Lisa Lewis','2024-11-05 15:53:00','Prit x 9',90.00,0.00,0.00,90.00,97.00,7.00,NULL),(125,1,20,'General','Jose Hardin','2024-11-05 16:17:00','Copia Carta x 6;Prit x 5;Engargolado #6 x 9;Carpeta Paja x 10',298.00,0.00,0.00,298.00,316.00,18.00,NULL),(127,2,30,'General','Laura Schmidt','2024-11-05 10:53:00','Lapiz Maped x 3;Pluma Negra x 4',101.00,0.00,0.00,101.00,114.00,13.00,NULL),(129,3,3,'General','Frank Gill','2024-11-05 10:10:00','Engargolado #6 x 3;Engargolado #12 x 8;Copia Oficio x 8;Pluma Negra x 10',144.00,0.00,0.00,144.00,164.00,20.00,NULL),(130,3,24,'General','Edward Gray','2024-11-05 07:29:00','Copia Carta x 7;Copia Oficio x 3;Lapiz Maped x 5',13.00,0.00,0.00,13.00,26.00,13.00,NULL),(131,2,24,'General','Edward Gray','2024-11-05 08:28:00','Engargolado #10 x 3;Copia Oficio x 1',135.00,0.00,0.00,135.00,152.00,17.00,NULL),(132,1,23,'General','Norma Jimenez','2024-11-05 12:59:00','Engargolado #10 x 10',19.00,0.00,0.00,19.00,34.00,15.00,NULL),(133,3,22,'General','Michelle Phillips','2024-11-06 13:05:00','Lapiz Maped x 2;Engargolado #6 x 5;Lapiz Mirado x 7',138.00,0.00,0.00,138.00,144.00,6.00,NULL),(138,1,12,'General','Jessica White','2024-11-06 08:59:00','Copia Carta x 10;Pluma Negra x 8;Engargolado #10 x 3;Sobre Amarillo Carta x 5;Copia Oficio x 2',145.00,0.00,0.00,145.00,156.00,11.00,NULL),(139,1,10,'General','Russell Olson','2024-11-06 08:52:00','Engargolado #10 x 7',152.00,0.00,0.00,152.00,168.00,16.00,NULL),(141,3,10,'General','Russell Olson','2024-11-06 14:27:00','Engargolado #10 x 2;Engargolado #6 x 1;Sobre Amarillo Carta x 9;Prit x 3',335.00,0.00,0.00,335.00,340.00,5.00,NULL),(145,2,14,'General','Laura Haney','2024-11-06 07:36:00','Engargolado #8 x 7;Lapiz Mirado x 2;Copia Carta x 9;Engargolado #12 x 7;Engargolado #10 x 9',430.00,0.00,0.00,430.00,441.00,11.00,NULL),(147,3,3,'General','Frank Gill','2024-11-06 18:38:00','Prit x 4;Copia Oficio x 2;Engargolado #8 x 2',306.00,0.00,0.00,306.00,326.00,20.00,NULL),(148,3,2,'General','Lisa Lewis','2024-11-06 13:41:00','Carpeta de Costilla x 4;Engargolado #12 x 10;Copia Oficio x 10;Sobre Amarillo Carta x 4',306.00,0.00,0.00,306.00,317.00,11.00,NULL),(152,3,2,'General','Lisa Lewis','2024-11-06 07:35:00','Engargolado #10 x 3;Pluma Negra x 7',102.00,0.00,0.00,102.00,114.00,12.00,NULL),(153,3,15,'General','Jessica Mcintyre','2024-11-06 16:56:00','Engargolado #8 x 1;Pluma Negra x 3;Engargolado #12 x 2;Prit x 7;Sobre Amarillo Carta x 3',462.00,0.00,0.00,462.00,467.00,5.00,NULL),(155,1,16,'General','Alyssa Davis','2024-11-06 11:29:00','Engargolado #6 x 1;Engargolado #8 x 8;Lapiz Mirado x 3;Carpeta Paja x 1',124.00,0.00,0.00,124.00,140.00,16.00,NULL),(160,1,26,'General','Kyle Diaz','2024-11-07 09:31:00','Copia Oficio x 10;Engargolado #8 x 7;Copia Carta x 5;Prit x 10;Engargolado #12 x 4',460.00,0.00,0.00,460.00,472.00,12.00,NULL),(163,3,2,'General','Lisa Lewis','2024-11-07 08:22:00','Lapiz Mirado x 1;Carpeta de Costilla x 5',184.00,0.00,0.00,184.00,189.00,5.00,NULL),(164,1,23,'General','Norma Jimenez','2024-11-07 18:09:00','Pluma Negra x 7;Carpeta Paja x 9;Prit x 2;Lapiz Mirado x 5',128.00,0.00,0.00,128.00,145.00,17.00,NULL),(165,1,17,'General','Angela Lyons','2024-11-07 09:31:00','Pluma Negra x 9;Lapiz Maped x 3;Carpeta Paja x 7',81.00,0.00,0.00,81.00,88.00,7.00,NULL),(166,3,19,'General','Christina Moore','2024-11-07 14:20:00','Prit x 6',108.00,0.00,0.00,108.00,123.00,15.00,NULL),(167,3,14,'General','Laura Haney','2024-11-07 10:24:00','Engargolado #6 x 4;Copia Carta x 1;Lapiz Mirado x 10;Engargolado #8 x 6',261.00,0.00,0.00,261.00,271.00,10.00,NULL),(168,2,26,'General','Kyle Diaz','2024-11-07 09:29:00','Prit x 10;Engargolado #8 x 3',108.00,0.00,0.00,108.00,122.00,14.00,NULL),(170,3,9,'General','Jacqueline King','2024-11-07 08:39:00','Engargolado #10 x 2',152.00,0.00,0.00,152.00,157.00,5.00,NULL),(171,3,12,'General','Jessica White','2024-11-07 19:35:00','Lapiz Maped x 8;Engargolado #12 x 3',165.00,0.00,0.00,165.00,177.00,12.00,NULL),(172,2,23,'General','Norma Jimenez','2024-11-07 10:02:00','Sobre Amarillo Carta x 1',7.00,0.00,0.00,7.00,15.00,8.00,NULL),(173,3,24,'General','Edward Gray','2024-11-07 09:38:00','Lapiz Maped x 9;Engargolado #12 x 2;Lapiz Mirado x 5;Carpeta de Costilla x 1',280.00,0.00,0.00,280.00,285.00,5.00,NULL),(174,2,19,'General','Christina Moore','2024-11-07 18:34:00','Copia Carta x 1;Prit x 8;Sobre Amarillo Carta x 3;Engargolado #10 x 1',176.00,0.00,0.00,176.00,196.00,20.00,NULL),(176,3,9,'General','Jacqueline King','2024-11-07 08:47:00','Engargolado #12 x 2;Engargolado #8 x 9;Carpeta Paja x 8;Copia Carta x 7;Prit x 10',251.00,0.00,0.00,251.00,265.00,14.00,NULL),(177,2,11,'General','Michael Turner','2024-11-07 09:29:00','Engargolado #8 x 6',126.00,0.00,0.00,126.00,144.00,18.00,NULL),(178,3,24,'General','Edward Gray','2024-11-07 10:52:00','Copia Oficio x 2;Engargolado #12 x 9',87.00,0.00,0.00,87.00,93.00,6.00,NULL),(179,3,24,'General','Edward Gray','2024-11-07 16:10:00','Sobre Amarillo Carta x 8',2.00,0.00,0.00,2.00,17.00,15.00,NULL),(181,1,10,'General','Russell Olson','2024-11-07 20:11:00','Copia Carta x 2',1.00,0.00,0.00,1.00,20.00,19.00,NULL),(183,1,21,'General','Kenneth Barton','2024-11-08 19:09:00','Copia Oficio x 3;Pluma Negra x 5;Engargolado #8 x 10;Lapiz Mirado x 8;Engargolado #6 x 8',398.00,0.00,0.00,398.00,407.00,9.00,NULL),(186,2,30,'General','Laura Schmidt','2024-11-08 15:25:00','Engargolado #10 x 4;Carpeta Paja x 10',176.00,0.00,0.00,176.00,188.00,12.00,NULL),(187,2,23,'General','Norma Jimenez','2024-11-08 14:25:00','Pluma Negra x 9;Prit x 5;Engargolado #12 x 10',338.00,0.00,0.00,338.00,347.00,9.00,NULL),(188,2,16,'General','Alyssa Davis','2024-11-08 14:06:00','Engargolado #8 x 7;Carpeta Paja x 7;Engargolado #10 x 9;Sobre Amarillo Carta x 4;Lapiz Mirado x 6',308.00,0.00,0.00,308.00,326.00,18.00,NULL),(190,1,23,'General','Norma Jimenez','2024-11-08 16:32:00','Prit x 7;Lapiz Maped x 10',56.00,0.00,0.00,56.00,64.00,8.00,NULL),(192,1,7,'General','Cody Fowler','2024-11-08 12:05:00','Lapiz Mirado x 4;Prit x 1;Engargolado #12 x 3;Sobre Amarillo Carta x 9;Pluma Negra x 6',310.00,0.00,0.00,310.00,322.00,12.00,NULL),(193,3,11,'General','Michael Turner','2024-11-08 09:01:00','Carpeta de Costilla x 6',100.00,0.00,0.00,100.00,111.00,11.00,NULL),(195,1,24,'General','Edward Gray','2024-11-08 11:28:00','Lapiz Mirado x 9;Copia Carta x 6;Carpeta de Costilla x 9;Sobre Amarillo Carta x 3;Pluma Negra x 9',294.00,0.00,0.00,294.00,302.00,8.00,NULL),(196,3,22,'General','Michelle Phillips','2024-11-08 09:11:00','Engargolado #6 x 10',180.00,0.00,0.00,180.00,197.00,17.00,NULL),(197,1,25,'General','Brian Velasquez','2024-11-08 07:32:00','Lapiz Mirado x 1;Copia Oficio x 2;Engargolado #6 x 7',187.00,0.00,0.00,187.00,197.00,10.00,NULL),(198,3,22,'General','Michelle Phillips','2024-11-08 07:23:00','Copia Oficio x 6',2.00,0.00,0.00,2.00,19.00,17.00,NULL),(200,3,4,'General','Christopher Williams','2024-11-08 19:21:00','Engargolado #6 x 9;Sobre Amarillo Carta x 4;Copia Oficio x 10;Lapiz Mirado x 5;Engargolado #12 x 2',255.00,0.00,0.00,255.00,267.00,12.00,NULL),(201,2,9,'General','Jacqueline King','2024-11-08 16:03:00','Engargolado #12 x 10',140.00,0.00,0.00,140.00,159.00,19.00,NULL),(203,1,11,'General','Michael Turner','2024-11-08 20:58:00','Copia Carta x 7;Sobre Amarillo Carta x 10',3.00,0.00,0.00,3.00,12.00,9.00,NULL),(204,2,5,'General','John Lee','2024-11-08 11:40:00','Carpeta Paja x 3;Lapiz Mirado x 10;Sobre Amarillo Carta x 4;Engargolado #6 x 8',196.00,0.00,0.00,196.00,203.00,7.00,NULL),(205,1,11,'General','Michael Turner','2024-11-08 19:53:00','Carpeta Paja x 1;Engargolado #10 x 8;Copia Carta x 10',103.00,0.00,0.00,103.00,122.00,19.00,NULL),(207,1,3,'General','Frank Gill','2024-11-08 09:40:00','Prit x 5;Copia Oficio x 6',128.00,0.00,0.00,128.00,140.00,12.00,NULL),(210,2,7,'General','Cody Fowler','2024-11-09 18:22:00','Engargolado #8 x 5;Prit x 10;Sobre Amarillo Carta x 4',92.00,0.00,0.00,92.00,97.00,5.00,NULL),(211,2,9,'General','Jacqueline King','2024-11-09 10:43:00','Lapiz Maped x 5;Engargolado #8 x 10;Carpeta de Costilla x 4',201.00,0.00,0.00,201.00,206.00,5.00,NULL),(212,1,24,'General','Edward Gray','2024-11-09 16:33:00','Carpeta de Costilla x 1',20.00,0.00,0.00,20.00,36.00,16.00,NULL),(214,3,25,'General','Brian Velasquez','2024-11-09 13:40:00','Prit x 2;Engargolado #12 x 9;Lapiz Mirado x 1',188.00,0.00,0.00,188.00,197.00,9.00,NULL),(215,1,14,'General','Laura Haney','2024-11-09 19:12:00','Sobre Amarillo Carta x 1;Lapiz Mirado x 9;Pluma Negra x 9',105.00,0.00,0.00,105.00,119.00,14.00,NULL),(216,2,3,'General','Frank Gill','2024-11-09 13:01:00','Pluma Negra x 8;Carpeta de Costilla x 5;Sobre Amarillo Carta x 7;Engargolado #10 x 4;Prit x 5',432.00,0.00,0.00,432.00,437.00,5.00,NULL),(217,3,5,'General','John Lee','2024-11-09 07:49:00','Copia Oficio x 4;Engargolado #12 x 1;Lapiz Mirado x 10;Engargolado #10 x 9;Prit x 10',399.00,0.00,0.00,399.00,416.00,17.00,NULL),(219,1,22,'General','Michelle Phillips','2024-11-09 07:19:00','Prit x 9;Engargolado #10 x 4;Carpeta Paja x 1;Carpeta de Costilla x 4;Copia Carta x 2',251.00,0.00,0.00,251.00,259.00,8.00,NULL),(220,1,8,'General','Tina Harper','2024-11-09 19:52:00','Copia Carta x 1;Copia Oficio x 9;Pluma Negra x 3;Lapiz Mirado x 8;Engargolado #10 x 8',242.00,0.00,0.00,242.00,247.00,5.00,NULL),(221,2,8,'General','Tina Harper','2024-11-09 11:21:00','Engargolado #12 x 4;Sobre Amarillo Carta x 9',192.00,0.00,0.00,192.00,207.00,15.00,NULL),(222,2,22,'General','Michelle Phillips','2024-11-09 09:12:00','Copia Oficio x 3',2.00,0.00,0.00,2.00,13.00,11.00,NULL),(223,3,29,'General','Jennifer Medina','2024-11-09 18:25:00','Carpeta Paja x 3;Engargolado #10 x 6;Prit x 8',202.00,0.00,0.00,202.00,215.00,13.00,NULL),(224,3,15,'General','Jessica Mcintyre','2024-11-09 10:17:00','Carpeta Paja x 3;Engargolado #10 x 8;Carpeta de Costilla x 7',226.00,0.00,0.00,226.00,242.00,16.00,NULL),(225,1,11,'General','Michael Turner','2024-11-09 13:16:00','Engargolado #10 x 3;Copia Carta x 7',59.00,0.00,0.00,59.00,66.00,7.00,NULL),(226,3,27,'General','Marcus Jones','2024-11-09 16:14:00','Pluma Negra x 4;Sobre Amarillo Carta x 9;Engargolado #10 x 3;Carpeta de Costilla x 6;Carpeta Paja x 2',329.00,0.00,0.00,329.00,344.00,15.00,NULL),(230,2,29,'General','Jennifer Medina','2024-11-09 07:18:00','Engargolado #8 x 10;Carpeta de Costilla x 5;Copia Carta x 3',175.00,0.00,0.00,175.00,188.00,13.00,NULL),(233,1,24,'General','Edward Gray','2024-11-10 14:57:00','Copia Carta x 4;Lapiz Maped x 8;Pluma Negra x 2;Carpeta de Costilla x 1;Engargolado #8 x 7',191.00,0.00,0.00,191.00,203.00,12.00,NULL),(234,3,15,'General','Jessica Mcintyre','2024-11-10 15:12:00','Lapiz Mirado x 4',30.00,0.00,0.00,30.00,37.00,7.00,NULL),(236,3,28,'General','Pamela Martin','2024-11-10 16:38:00','Engargolado #8 x 1;Lapiz Mirado x 1;Lapiz Maped x 3',230.00,0.00,0.00,230.00,246.00,16.00,NULL),(239,1,24,'General','Edward Gray','2024-11-10 14:40:00','Prit x 7',126.00,0.00,0.00,126.00,146.00,20.00,NULL),(240,1,27,'General','Marcus Jones','2024-11-10 17:23:00','Lapiz Mirado x 7;Carpeta de Costilla x 7;Engargolado #8 x 3',390.00,0.00,0.00,390.00,403.00,13.00,NULL),(243,2,21,'General','Kenneth Barton','2024-11-10 07:31:00','Carpeta de Costilla x 5;Engargolado #12 x 4;Lapiz Maped x 7',180.00,0.00,0.00,180.00,189.00,9.00,NULL),(244,2,14,'General','Laura Haney','2024-11-10 12:59:00','Sobre Amarillo Carta x 5;Engargolado #6 x 8;Carpeta de Costilla x 4;Lapiz Maped x 2;Carpeta Paja x 3',393.00,0.00,0.00,393.00,399.00,6.00,NULL),(245,3,19,'General','Christina Moore','2024-11-10 10:44:00','Carpeta Paja x 9;Lapiz Maped x 4',40.00,0.00,0.00,40.00,53.00,13.00,NULL),(248,2,15,'General','Jessica Mcintyre','2024-11-10 12:07:00','Sobre Amarillo Carta x 10',20.00,0.00,0.00,20.00,25.00,5.00,NULL),(249,3,18,'General','Amanda Jarvis','2024-11-10 10:55:00','Copia Carta x 10;Engargolado #6 x 2;Carpeta Paja x 1',204.00,0.00,0.00,204.00,217.00,13.00,NULL),(251,2,9,'General','Jacqueline King','2024-11-10 16:05:00','Engargolado #10 x 3;Engargolado #8 x 9',128.00,0.00,0.00,128.00,136.00,8.00,NULL),(252,1,29,'General','Jennifer Medina','2024-11-10 18:10:00','Engargolado #12 x 5;Copia Oficio x 8',167.00,0.00,0.00,167.00,176.00,9.00,NULL),(253,1,27,'General','Marcus Jones','2024-11-10 09:14:00','Prit x 8;Engargolado #10 x 3;Copia Oficio x 2',39.00,0.00,0.00,39.00,45.00,6.00,NULL),(254,1,2,'General','Lisa Lewis','2024-11-10 19:37:00','Sobre Amarillo Carta x 2;Lapiz Maped x 4;Lapiz Mirado x 1',36.00,0.00,0.00,36.00,50.00,14.00,NULL),(257,3,2,'General','Lisa Lewis','2024-11-10 20:13:00','Carpeta de Costilla x 4;Copia Carta x 9;Engargolado #8 x 7;Copia Oficio x 6;Lapiz Mirado x 7',316.00,0.00,0.00,316.00,324.00,8.00,NULL),(260,3,16,'General','Alyssa Davis','2024-11-11 15:33:00','Engargolado #12 x 1;Copia Oficio x 7;Pluma Negra x 10',65.00,0.00,0.00,65.00,74.00,9.00,NULL),(261,1,3,'General','Frank Gill','2024-11-11 09:04:00','Carpeta de Costilla x 7;Engargolado #8 x 8',56.00,0.00,0.00,56.00,66.00,10.00,NULL),(262,3,24,'General','Edward Gray','2024-11-11 08:35:00','Carpeta Paja x 10;Sobre Amarillo Carta x 10;Engargolado #8 x 8;Prit x 4',329.00,0.00,0.00,329.00,342.00,13.00,NULL),(263,3,25,'General','Brian Velasquez','2024-11-11 18:17:00','Sobre Amarillo Carta x 6;Copia Oficio x 1;Engargolado #6 x 4',96.00,0.00,0.00,96.00,101.00,5.00,NULL),(264,1,29,'General','Jennifer Medina','2024-11-11 19:56:00','Engargolado #6 x 8;Copia Oficio x 6;Engargolado #8 x 2;Copia Carta x 6;Carpeta Paja x 1',113.00,0.00,0.00,113.00,124.00,11.00,NULL),(265,1,25,'General','Brian Velasquez','2024-11-11 20:14:00','Lapiz Mirado x 5;Lapiz Maped x 2',52.00,0.00,0.00,52.00,69.00,17.00,NULL),(268,3,10,'General','Russell Olson','2024-11-11 19:05:00','Engargolado #10 x 3;Prit x 10;Carpeta de Costilla x 8;Copia Oficio x 10',173.00,0.00,0.00,173.00,184.00,11.00,NULL),(269,1,21,'General','Kenneth Barton','2024-11-11 16:02:00','Copia Oficio x 6',2.00,0.00,0.00,2.00,18.00,16.00,NULL),(270,2,21,'General','Kenneth Barton','2024-11-11 10:12:00','Lapiz Mirado x 9;Engargolado #12 x 5;Lapiz Maped x 8',98.00,0.00,0.00,98.00,104.00,6.00,NULL),(271,3,1,'General','Leah Knox','2024-11-11 13:18:00','Lapiz Mirado x 10;Sobre Amarillo Carta x 4;Engargolado #6 x 2;Copia Carta x 3;Engargolado #10 x 6',298.00,0.00,0.00,298.00,314.00,16.00,NULL),(272,3,7,'General','Cody Fowler','2024-11-11 12:49:00','Engargolado #10 x 4;Copia Carta x 9;Carpeta Paja x 3;Lapiz Mirado x 5;Copia Oficio x 2',55.00,0.00,0.00,55.00,65.00,10.00,NULL),(274,3,2,'General','Lisa Lewis','2024-11-11 19:21:00','Lapiz Maped x 4;Engargolado #6 x 9;Engargolado #10 x 4;Engargolado #12 x 10;Copia Carta x 8',195.00,0.00,0.00,195.00,204.00,9.00,NULL),(276,1,13,'General','Thomas Mejia','2024-11-11 14:59:00','Pluma Negra x 8',8.00,0.00,0.00,8.00,18.00,10.00,NULL),(278,1,3,'General','Frank Gill','2024-11-11 17:37:00','Engargolado #12 x 8;Pluma Negra x 8;Engargolado #10 x 4;Engargolado #8 x 9',364.00,0.00,0.00,364.00,375.00,11.00,NULL),(279,1,13,'General','Thomas Mejia','2024-11-11 20:49:00','Engargolado #12 x 3;Engargolado #6 x 1;Copia Carta x 7',271.00,0.00,0.00,271.00,291.00,20.00,NULL),(281,3,2,'General','Lisa Lewis','2024-11-11 12:15:00','Carpeta de Costilla x 3',80.00,0.00,0.00,80.00,99.00,19.00,NULL),(282,1,26,'General','Kyle Diaz','2024-11-11 10:52:00','Carpeta de Costilla x 6;Pluma Negra x 1;Engargolado #6 x 3;Lapiz Maped x 2',337.00,0.00,0.00,337.00,355.00,18.00,NULL),(284,2,6,'General','Angela Parsons','2024-11-12 20:40:00','Engargolado #10 x 9;Prit x 4',127.00,0.00,0.00,127.00,132.00,5.00,NULL),(285,3,29,'General','Jennifer Medina','2024-11-12 13:00:00','Prit x 8;Engargolado #8 x 7;Pluma Negra x 9;Carpeta Paja x 5;Carpeta de Costilla x 8',244.00,0.00,0.00,244.00,261.00,17.00,NULL),(287,2,2,'General','Lisa Lewis','2024-11-12 10:56:00','Prit x 7;Carpeta Paja x 7',68.00,0.00,0.00,68.00,86.00,18.00,NULL),(288,2,6,'General','Angela Parsons','2024-11-12 14:01:00','Engargolado #6 x 6;Engargolado #8 x 5',252.00,0.00,0.00,252.00,266.00,14.00,NULL),(289,2,8,'General','Tina Harper','2024-11-12 13:01:00','Prit x 7;Lapiz Maped x 1;Engargolado #10 x 9;Copia Oficio x 7;Engargolado #6 x 1',332.00,0.00,0.00,332.00,344.00,12.00,NULL),(290,1,29,'General','Jennifer Medina','2024-11-12 12:44:00','Prit x 10;Copia Carta x 3;Lapiz Mirado x 3;Engargolado #12 x 10;Copia Oficio x 5',256.00,0.00,0.00,256.00,271.00,15.00,NULL),(291,3,24,'General','Edward Gray','2024-11-12 07:18:00','Carpeta Paja x 2;Engargolado #10 x 1;Sobre Amarillo Carta x 10',106.00,0.00,0.00,106.00,123.00,17.00,NULL),(292,2,17,'General','Angela Lyons','2024-11-12 16:56:00','Prit x 4;Sobre Amarillo Carta x 4;Engargolado #8 x 3;Carpeta Paja x 5;Engargolado #12 x 7',505.00,0.00,0.00,505.00,522.00,17.00,NULL),(293,3,13,'General','Thomas Mejia','2024-11-12 14:24:00','Prit x 2;Engargolado #10 x 1',241.00,0.00,0.00,241.00,261.00,20.00,NULL),(296,3,6,'General','Angela Parsons','2024-11-12 17:03:00','Sobre Amarillo Carta x 5',25.00,0.00,0.00,25.00,43.00,18.00,NULL),(297,3,30,'General','Laura Schmidt','2024-11-12 20:37:00','Carpeta Paja x 5',40.00,0.00,0.00,40.00,53.00,13.00,NULL),(298,3,22,'General','Michelle Phillips','2024-11-12 07:16:00','Pluma Negra x 2;Carpeta de Costilla x 1',108.00,0.00,0.00,108.00,123.00,15.00,NULL),(302,2,28,'General','Pamela Martin','2024-11-12 08:56:00','Carpeta Paja x 5;Prit x 8;Engargolado #10 x 9;Copia Oficio x 10',191.00,0.00,0.00,191.00,198.00,7.00,NULL),(303,3,14,'General','Laura Haney','2024-11-12 11:13:00','Pluma Negra x 4;Carpeta de Costilla x 10;Sobre Amarillo Carta x 2',78.00,0.00,0.00,78.00,92.00,14.00,NULL),(304,1,15,'General','Jessica Mcintyre','2024-11-12 16:57:00','Copia Carta x 1;Copia Oficio x 4;Carpeta de Costilla x 2;Engargolado #10 x 2;Lapiz Maped x 7',226.00,0.00,0.00,226.00,243.00,17.00,NULL),(305,2,18,'General','Amanda Jarvis','2024-11-12 14:24:00','Lapiz Maped x 5;Lapiz Mirado x 5;Carpeta de Costilla x 3',263.00,0.00,0.00,263.00,273.00,10.00,NULL),(307,2,16,'General','Alyssa Davis','2024-11-12 10:23:00','Engargolado #12 x 6;Lapiz Maped x 4;Carpeta de Costilla x 9',390.00,0.00,0.00,390.00,408.00,18.00,NULL),(310,2,14,'General','Laura Haney','2024-11-13 14:58:00','Lapiz Maped x 6;Engargolado #10 x 1',159.00,0.00,0.00,159.00,175.00,16.00,NULL),(311,1,28,'General','Pamela Martin','2024-11-13 14:02:00','Sobre Amarillo Carta x 1;Carpeta Paja x 5;Prit x 9;Copia Oficio x 2;Carpeta de Costilla x 1',268.00,0.00,0.00,268.00,273.00,5.00,NULL),(315,3,8,'General','Tina Harper','2024-11-13 14:50:00','Engargolado #6 x 2;Lapiz Maped x 8',140.00,0.00,0.00,140.00,159.00,19.00,NULL),(316,1,14,'General','Laura Haney','2024-11-13 10:01:00','Engargolado #10 x 2;Prit x 4;Pluma Negra x 3',297.00,0.00,0.00,297.00,313.00,16.00,NULL),(318,1,26,'General','Kyle Diaz','2024-11-13 14:13:00','Engargolado #6 x 4;Engargolado #10 x 7',166.00,0.00,0.00,166.00,181.00,15.00,NULL),(320,2,13,'General','Thomas Mejia','2024-11-13 09:15:00','Copia Oficio x 7;Engargolado #6 x 1;Pluma Negra x 9;Sobre Amarillo Carta x 1;Prit x 6',233.00,0.00,0.00,233.00,244.00,11.00,NULL),(322,1,10,'General','Russell Olson','2024-11-13 18:22:00','Engargolado #8 x 10;Engargolado #12 x 9;Carpeta de Costilla x 1;Pluma Negra x 4;Sobre Amarillo Carta x 6',450.00,0.00,0.00,450.00,467.00,17.00,NULL),(323,3,16,'General','Alyssa Davis','2024-11-13 13:20:00','Prit x 9;Engargolado #12 x 6;Sobre Amarillo Carta x 9;Engargolado #8 x 3;Lapiz Maped x 1',346.00,0.00,0.00,346.00,352.00,6.00,NULL),(324,3,2,'General','Lisa Lewis','2024-11-13 13:59:00','Carpeta de Costilla x 9;Copia Carta x 4',124.00,0.00,0.00,124.00,137.00,13.00,NULL),(325,3,11,'General','Michael Turner','2024-11-13 16:35:00','Copia Oficio x 9',2.00,0.00,0.00,2.00,20.00,18.00,NULL),(327,3,9,'General','Jacqueline King','2024-11-13 14:28:00','Pluma Negra x 10;Carpeta de Costilla x 8;Engargolado #10 x 4;Prit x 10;Engargolado #12 x 3',569.00,0.00,0.00,569.00,580.00,11.00,NULL),(330,3,18,'General','Amanda Jarvis','2024-11-13 16:25:00','Carpeta Paja x 3;Sobre Amarillo Carta x 1;Pluma Negra x 8',79.00,0.00,0.00,79.00,92.00,13.00,NULL),(331,1,8,'General','Tina Harper','2024-11-13 11:42:00','Copia Carta x 6;Lapiz Mirado x 9;Engargolado #6 x 4;Engargolado #12 x 8',170.00,0.00,0.00,170.00,189.00,19.00,NULL),(332,3,24,'General','Edward Gray','2024-11-13 08:14:00','Sobre Amarillo Carta x 3;Copia Oficio x 9;Copia Carta x 10;Lapiz Mirado x 10;Engargolado #6 x 9',131.00,0.00,0.00,131.00,137.00,6.00,NULL),(333,1,25,'General','Brian Velasquez','2024-11-14 17:10:00','Engargolado #10 x 6;Lapiz Maped x 4;Engargolado #6 x 3;Copia Carta x 1',359.00,0.00,0.00,359.00,370.00,11.00,NULL),(334,2,7,'General','Cody Fowler','2024-11-14 18:00:00','Lapiz Mirado x 8;Copia Oficio x 6;Engargolado #6 x 3;Lapiz Maped x 10;Carpeta de Costilla x 2',184.00,0.00,0.00,184.00,190.00,6.00,NULL),(339,3,23,'General','Norma Jimenez','2024-11-14 16:54:00','Engargolado #10 x 4',152.00,0.00,0.00,152.00,160.00,8.00,NULL),(341,1,5,'General','John Lee','2024-11-14 20:01:00','Sobre Amarillo Carta x 10;Carpeta de Costilla x 8',142.00,0.00,0.00,142.00,154.00,12.00,NULL),(346,2,12,'General','Jessica White','2024-11-14 19:35:00','Engargolado #12 x 6;Engargolado #8 x 3',320.00,0.00,0.00,320.00,330.00,10.00,NULL),(347,2,8,'General','Tina Harper','2024-11-14 15:55:00','Sobre Amarillo Carta x 8;Engargolado #6 x 4;Carpeta Paja x 7',67.00,0.00,0.00,67.00,82.00,15.00,NULL),(349,3,4,'General','Christopher Williams','2024-11-14 13:57:00','Lapiz Mirado x 3;Carpeta Paja x 4;Copia Oficio x 9;Copia Carta x 5',79.00,0.00,0.00,79.00,96.00,17.00,NULL),(350,1,10,'General','Russell Olson','2024-11-14 20:10:00','Carpeta de Costilla x 10;Lapiz Maped x 4',90.00,0.00,0.00,90.00,102.00,12.00,NULL),(353,1,25,'General','Brian Velasquez','2024-11-14 16:58:00','Pluma Negra x 10;Lapiz Mirado x 4;Prit x 2',176.00,0.00,0.00,176.00,196.00,20.00,NULL),(354,1,9,'General','Jacqueline King','2024-11-14 08:47:00','Copia Carta x 8',1.00,0.00,0.00,1.00,6.00,5.00,NULL),(355,1,15,'General','Jessica Mcintyre','2024-11-14 13:29:00','Engargolado #12 x 5;Lapiz Maped x 1;Carpeta Paja x 6;Prit x 7;Lapiz Mirado x 9',199.00,0.00,0.00,199.00,205.00,6.00,NULL),(356,2,19,'General','Christina Moore','2024-11-14 16:59:00','Engargolado #6 x 5;Lapiz Maped x 2;Copia Carta x 7',138.00,0.00,0.00,138.00,147.00,9.00,NULL),(357,3,14,'General','Laura Haney','2024-11-14 20:33:00','Carpeta de Costilla x 4',20.00,0.00,0.00,20.00,28.00,8.00,NULL),(358,3,11,'General','Michael Turner','2024-11-15 08:18:00','Copia Carta x 10;Carpeta de Costilla x 2;Engargolado #6 x 8;Copia Oficio x 7',222.00,0.00,0.00,222.00,241.00,19.00,'Efectivo'),(360,3,18,'General','Amanda Jarvis','2024-11-15 20:04:00','Pluma Negra x 7;Engargolado #12 x 3',48.00,0.00,0.00,48.00,53.00,5.00,'Efectivo'),(361,3,3,'General','Frank Gill','2024-11-15 12:54:00','Lapiz Maped x 3',10.00,0.00,0.00,10.00,19.00,9.00,'Tarjeta'),(364,3,27,'General','Marcus Jones','2024-11-15 07:45:00','Prit x 3;Engargolado #8 x 6',270.00,0.00,0.00,270.00,290.00,20.00,'Tarjeta'),(366,1,12,'General','Jessica White','2024-11-15 17:00:00','Copia Carta x 9',3.00,0.00,0.00,3.00,20.00,17.00,'Efectivo'),(367,2,23,'General','Norma Jimenez','2024-11-15 08:49:00','Lapiz Maped x 8;Prit x 10;Copia Oficio x 3',75.00,0.00,0.00,75.00,93.00,18.00,'Efectivo'),(368,1,2,'General','Lisa Lewis','2024-11-15 10:21:00','Engargolado #10 x 10',171.00,0.00,0.00,171.00,189.00,18.00,'Efectivo'),(374,1,7,'General','Cody Fowler','2024-11-15 16:30:00','Sobre Amarillo Carta x 2;Lapiz Mirado x 4;Carpeta Paja x 2;Engargolado #10 x 6',152.00,0.00,0.00,152.00,164.00,12.00,'Efectivo'),(376,1,21,'General','Kenneth Barton','2024-11-15 12:56:00','Copia Oficio x 4;Pluma Negra x 4;Engargolado #8 x 5;Copia Carta x 1;Sobre Amarillo Carta x 2',120.00,0.00,0.00,120.00,138.00,18.00,'Tarjeta'),(380,2,10,'General','Russell Olson','2024-11-15 20:38:00','Lapiz Mirado x 8;Copia Oficio x 2;Carpeta de Costilla x 4;Engargolado #10 x 10',236.00,0.00,0.00,236.00,256.00,20.00,'Efectivo'),(381,1,1,'General','Leah Knox','2024-11-15 19:59:00','Carpeta Paja x 3;Copia Carta x 9;Sobre Amarillo Carta x 3;Lapiz Maped x 8',66.00,0.00,0.00,66.00,85.00,19.00,'Efectivo'),(382,2,10,'General','Russell Olson','2024-11-15 20:00:00','Prit x 2',126.00,10.00,5.00,126.00,132.00,6.00,'Efectivo'),(383,NULL,NULL,'Max ','General','2024-11-15 20:33:56','1   |Copia Carta         |0.5  |0.5  \n1   |Lapiz Mirado        |6.0  |6.0  \n2   |Pluma Negra         |8.0  |16.0 \n1   |Carpeta de Costilla |20.0 |20.0 \n',42.50,0.00,0.00,42.50,50.00,7.50,'Efectivo'),(384,NULL,NULL,'Max ','General','2024-11-15 22:19:32','199 |Copia Carta         |0.5  |99.5 \n',99.50,15.92,9.95,105.47,110.00,4.53,'Efectivo'),(385,NULL,NULL,'Max ','General','2024-11-21 00:36:28','6   |Copia Carta         |0.5  |3.0  \n20  |Copia Oficio        |0.7  |14.0 \n1   |Prit                |18.0 |18.0 \n1   |Lapiz Maped         |5.0  |5.0  \n1   |Pluma Negra         |8.0  |8.0  \n1   |Carpeta Paja        |4.0  |4.0  \n',52.00,0.00,0.00,52.00,55.00,3.00,'Efectivo'),(386,NULL,NULL,'Max ','General','2024-11-21 00:36:41','1   |Engargolado # 10    |19.0 |19.0 \n1   |Engargolado # 8     |18.0 |18.0 \n1   |Engargolado # 6     |18.0 |18.0 \n',55.00,0.00,0.00,55.00,55.00,0.00,'Tarjeta'),(387,NULL,NULL,'Max ','General','2024-11-21 00:41:09','1   |Pluma Negra         |8.0  |8.0  \n1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Prit                |18.0 |18.0 \n1   |Carpeta Paja        |4.0  |4.0  \n1   |Lapiz Maped         |5.0  |5.0  \n',37.50,0.00,0.00,37.50,50.00,12.50,'Efectivo'),(388,NULL,NULL,'Max ','General','2024-11-21 20:58:54','10  |Copia Carta         |0.5  |5.0  \n',5.00,0.00,0.00,5.00,5.00,0.00,'Efectivo'),(389,NULL,NULL,'Max ','General','2024-11-21 20:59:13','1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Engargolado # 6     |18.0 |18.0 \n1   |Engargolado # 8     |18.0 |18.0 \n1   |Engargolado # 10    |19.0 |19.0 \n1   |Prit                |18.0 |18.0 \n200 |Copia Carta         |0.5  |100.0\n',175.50,0.00,0.00,175.50,200.00,24.50,'Efectivo'),(390,NULL,NULL,'Max ','General','2024-11-21 20:59:27','150 |Copia Oficio        |0.7  |105.0\n',105.00,0.00,0.00,105.00,105.00,0.00,'Tarjeta'),(391,NULL,NULL,'admin','General','2024-11-21 21:47:25','1   |Engargolado # 6     |18.0 |18.0 \n',18.00,0.00,0.00,18.00,18.00,0.00,'Efectivo'),(392,NULL,NULL,'Max ','General','2024-11-21 21:51:38','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,2.00,1.50,'Efectivo'),(393,NULL,NULL,'Max ','General','2024-11-21 22:15:13','1   |Prit                |18.0 |18.0 \n',18.00,0.00,0.00,18.00,20.00,2.00,'Efectivo'),(399,1,NULL,'Max ','General','2024-12-02 01:45:09','100 |Copia Carta         |0.5  |50.0 \n1   |Carpeta de Costilla |20.0 |20.0 \n1   |Prit                |18.0 |18.0 \n1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Pluma Negra         |8.0  |8.0  \n',98.50,0.00,0.00,98.50,100.00,1.50,'Efectivo'),(400,1,NULL,'Max ','General','2024-12-02 01:45:19','1   |Engargolado # 6     |18.0 |18.0 \n1   |Engargolado # 10    |19.0 |19.0 \n1   |Engargolado # 8     |18.0 |18.0 \n',55.00,0.00,0.00,55.00,55.00,0.00,'Tarjeta'),(401,1,NULL,'Max ','General','2024-12-03 21:23:01','1   |Copia Carta         |0.5  |0.5  \n1   |Copia Oficio        |0.7  |0.7  \n1   |Lapiz Mirado        |6.0  |6.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Carpeta Paja        |4.0  |4.0  \n1   |Prit                |18.0 |18.0 \n',51.70,0.00,0.00,51.70,60.00,8.30,'Efectivo'),(402,1,NULL,'Max ','General','2024-12-03 21:23:58','1   |Lapiz Mirado        |6.0  |6.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n',26.00,0.00,0.00,26.00,26.00,0.00,'Efectivo'),(403,1,NULL,'Max ','General','2024-12-03 21:25:46','1   |Lapiz Mirado        |6.0  |6.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n',26.00,0.00,0.00,26.00,26.00,0.00,'Efectivo'),(404,1,NULL,'Max ','General','2024-12-03 21:36:18','1   |Carpeta Paja        |4.0  |4.0  \n1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Carpeta de Costilla |20.0 |20.0 \n1   |Prit                |18.0 |18.0 \n',44.50,0.00,0.00,44.50,44.50,0.00,'Tarjeta'),(405,3,NULL,'admin','General','2024-12-03 23:05:57','1   |Lapiz Maped         |5.0  |5.0  \n1   |Carpeta de Costilla |20.0 |20.0 \n1   |Carpeta Paja        |4.0  |4.0  \n1   |Prit                |18.0 |18.0 \n',47.00,0.00,0.00,47.00,47.00,0.00,'Tarjeta'),(406,3,NULL,'admin','General','2024-12-03 23:06:19','10  |Copia Carta         |0.5  |5.0  \n10  |Copia Oficio        |0.7  |7.0  \n1   |Sobre Amarillo Carta|2.5  |2.5  \n1   |Pluma Negra         |8.0  |8.0  \n1   |Engargolado # 10    |19.0 |19.0 \n1   |Lapiz Mirado        |6.0  |6.0  \n',47.50,0.00,0.00,47.50,50.00,2.50,'Efectivo'),(408,1,NULL,'Max ','General','2024-12-01 00:40:53','1   |Carpeta Paja        |4.0  |4.0  \n',4.00,0.00,0.00,4.00,10.00,6.00,'Efectivo'),(409,1,NULL,'Max ','General','2024-12-01 00:43:15','250 |Copia Carta         |0.5  |125.0\n',125.00,20.00,0.00,145.00,145.00,0.00,'Tarjeta'),(410,1,NULL,'Max ','General','2024-12-01 00:55:41','1000|Copia Carta         |0.5  |500.0\n',500.00,0.00,25.00,475.00,500.00,25.00,'Efectivo'),(411,1,NULL,'Max ','General','2024-12-12 02:12:40','1   |Lapiz Mirado        |6.0  |6.0  \n1   |Pluma Negra         |8.0  |8.0  \n',14.00,0.00,0.00,14.00,14.00,0.00,'Efectivo'),(414,1,NULL,'Max ','General','2024-12-18 00:43:45','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,1.00,0.50,'Efectivo'),(415,1,NULL,'Max ','General','2024-12-18 01:09:40','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,1.00,0.50,'Efectivo'),(416,1,NULL,'Max ','General','2024-12-18 01:11:07','10  |Copia Carta         |0.5  |5.0  \n',5.00,0.00,0.00,5.00,5.00,0.00,'Efectivo'),(417,1,NULL,'Max ','General','2024-12-18 01:19:40','10  |Copia Carta         |0.5  |5.0  \n',5.00,0.00,0.00,5.00,10.00,5.00,'Efectivo'),(418,1,NULL,'Max ','General','2024-12-18 01:19:52','100 |Copia Carta         |0.5  |50.0 \n',50.00,0.00,0.00,50.00,500.00,450.00,'Efectivo'),(419,1,NULL,'Max ','Max ','2024-12-18 04:31:41','1   |Lapiz Mirado        |6.0  |6.0  \n',6.00,0.00,0.00,6.00,10.00,4.00,'Efectivo'),(420,1,NULL,'Max ','Max ','2024-12-18 04:56:42','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,1.00,0.50,'Efectivo'),(421,1,NULL,'Max ','General','2024-12-18 04:58:17','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,1.00,0.50,'Efectivo'),(422,1,NULL,'Max ','Max ','2024-12-18 04:58:31','1   |Copia Carta         |0.5  |0.5  \n',0.50,0.00,0.00,0.50,1.00,0.50,'Efectivo'),(423,1,NULL,'Max ','General','2025-03-12 23:49:32','1   |Lapiz Mirado        |6.0  |6.0  \n',6.00,0.00,0.00,6.00,10.00,4.00,'Efectivo'),(424,1,NULL,'Max ','General','2025-03-12 23:50:02','1   |Lapiz Mirado        |6.0  |6.0  \n3   |Carpeta de Costilla |20.0 |60.0 \n',66.00,0.00,0.00,66.00,90.00,24.00,'Efectivo'),(425,3,NULL,'admin','General','2025-03-23 01:40:41','1   |Paqtepongasachambiar|12.5 |12.5 \n',12.50,0.00,0.00,12.50,13.00,0.50,'Efectivo'),(426,3,NULL,'admin','General','2025-03-23 01:45:23','1   |pqtepogasachambiar  |26.5 |26.5 \n',26.50,0.00,0.00,26.50,50.00,23.50,'Efectivo'),(427,3,NULL,'admin','General','2025-03-23 01:59:59','1   |prueba              |26.5 |26.5 \n',26.50,0.00,0.00,26.50,30.00,3.50,'Efectivo'),(428,3,NULL,'admin','General','2025-03-23 02:01:42','1   |asd                 |26.5 |26.5 \n',26.50,0.00,0.00,26.50,40.00,13.50,'Efectivo'),(429,3,NULL,'admin','General','2025-03-23 02:04:35','1   |admin               |26.5 |26.5 \n',26.50,0.00,0.00,26.50,30.00,3.50,'Efectivo'),(430,3,NULL,'admin','General','2025-03-24 01:05:16','1   |Pqtepongasachambiar |124.5|124.5\n',124.50,0.00,0.00,124.50,200.00,75.50,'Efectivo');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-09 20:00:22
