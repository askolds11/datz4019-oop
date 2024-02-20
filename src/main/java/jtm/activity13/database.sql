-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: database
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clases`
--

DROP TABLE IF EXISTS `Clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clases` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clases`
--

LOCK TABLES `Clases` WRITE;
/*!40000 ALTER TABLE `Clases` DISABLE KEYS */;
INSERT INTO `Clases` VALUES (1,'Math'),(2,'Physics'),(3,'Chemistry');
/*!40000 ALTER TABLE `Clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clases_Student_Map`
--

DROP TABLE IF EXISTS `Clases_Student_Map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clases_Student_Map` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `clasesId` int(10) unsigned NOT NULL,
  `studentId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Clases_Student_Map_1` (`clasesId`),
  KEY `FK_Clases_Student_Map_2` (`studentId`),
  CONSTRAINT `FK_Clases_Student_Map_1` FOREIGN KEY (`clasesId`) REFERENCES `Clasese` (`id`),
  CONSTRAINT `FK_Clases_Student_Map_2` FOREIGN KEY (`studentId`) REFERENCES `Student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clases_Student_Map`
--

LOCK TABLES `Clases_Student_Map` WRITE;
/*!40000 ALTER TABLE `Clases_Student_Map` DISABLE KEYS */;
INSERT INTO `Clases_Student_Map` VALUES (1,1,1),(2,1,3),(3,2,1),(4,2,2),(5,3,2),(6,3,3);
/*!40000 ALTER TABLE `Clases_Student_Map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clases_Teacher_Map`
--

DROP TABLE IF EXISTS `Clases_Teacher_Map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clases_Teacher_Map` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `clasesId` int(10) unsigned NOT NULL,
  `teacherId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Clases_Teacher_Map_1` (`clasesId`),
  KEY `FK_Clases_Teacher_Map_2` (`teacherId`),
  CONSTRAINT `FK_Clases_Teacher_Map_1` FOREIGN KEY (`clasesId`) REFERENCES `Clasese` (`id`),
  CONSTRAINT `FK_Clases_Teacher_Map_2` FOREIGN KEY (`teacherId`) REFERENCES `Teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clases_Teacher_Map`
--

LOCK TABLES `Clases_Teacher_Map` WRITE;
/*!40000 ALTER TABLE `Clases_Teacher_Map` DISABLE KEYS */;
INSERT INTO `Clases_Teacher_Map` VALUES (1,1,1),(2,2,3),(3,3,2);
/*!40000 ALTER TABLE `Clases_Teacher_Map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'Anna','Tress'),(2,'Diana','Dos'),(3,'Lana','Uno');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,'Mara','Ett'),(2,'Sara','Du'),(3,'Lara','Tre');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08 12:08:12
