CREATE DATABASE  IF NOT EXISTS `scheduler` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scheduler`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: scheduler
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `announcementId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `announcementHeader` varchar(100) NOT NULL,
  `announcementDescription` varchar(255) DEFAULT NULL,
  `gcmMessageId` int(100) NOT NULL,
  `announcementDate` datetime NOT NULL,
  PRIMARY KEY (`announcementId`),
  UNIQUE KEY `UNIQUE` (`gcmMessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (3,1,'Department Closed','Department will be cloased today',2245,'2013-10-23 10:23:44'),(4,2,'Students Arrival','Request to everyone to come on time',2345,'2013-10-23 09:23:44');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `appointmentId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentTimeId` int(50) NOT NULL,
  `userId` int(50) NOT NULL,
  `officialId` int(50) DEFAULT NULL,
  `purposeOfVisit` varchar(255) DEFAULT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `meetingFinished` varchar(1) DEFAULT NULL,
  `meetingNotes` text,
  `dateCreated` datetime NOT NULL,
  `appointmentDate` date NOT NULL,
  PRIMARY KEY (`appointmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,1,1,2,'Course Enquiry','08:00:00','08:15:00','Y','Counselled','2013-11-11 08:16:45','2013-11-11'),(2,2,2,4,'Course Enquiry Details','08:15:00','08:30:00','Y','Counselled','2013-11-12 08:30:45','2013-11-12'),(3,3,3,6,'Program Enquiry','08:30:00','08:45:00','Y','Counselled','2013-11-13 08:45:45','2013-11-13'),(4,4,4,8,'Program Enquiry','09:30:00','09:45:00','Y','Counselled','2013-11-13 09:45:45','2013-11-13'),(5,5,5,2,'Course Enquiry','10:00:00','10:12:00','Y','Counselled','2013-11-13 10:13:00','2013-11-13'),(6,6,6,2,'Course Enquiry','10:30:00','10:48:15','Y','Counselled','2013-11-13 10:50:00','2013-11-13');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campus`
--

DROP TABLE IF EXISTS `campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campus` (
  `campusId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `campusName` varchar(50) NOT NULL,
  `campusAddress` varchar(100) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`campusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campus`
--

LOCK TABLES `campus` WRITE;
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
INSERT INTO `campus` VALUES (1,1,'Progress Campus','940 Progress Campus','2013-10-18 14:30:22'),(2,1,'Morningside Campus','939 Morningside Campus','2013-10-19 14:45:22'),(3,1,'Ashtonbee Campus','938 Ashtonbee Campus','2013-10-20 14:05:22'),(4,1,'CCC Campus','937 CCC Campus','2013-10-21 13:05:22');
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,1,'Course FAQs'),(2,2,'Admission FAQs'),(3,3,'Course FAQs'),(4,4,'Admission FAQs'),(5,5,'Course FAQs'),(6,6,'Admission FAQs');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `clientId` int(10) NOT NULL AUTO_INCREMENT,
  `clientName` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `logo` varchar(100) DEFAULT NULL,
  `phone1` varchar(15) NOT NULL,
  `phone2` varchar(15) DEFAULT NULL,
  `phone3` varchar(15) DEFAULT NULL,
  `contactPerson` varchar(50) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  `token` varchar(100) NOT NULL,
  `emailVerified` tinyint(1) DEFAULT NULL,
  `dateJoined` datetime NOT NULL,
  PRIMARY KEY (`clientId`),
  UNIQUE KEY `UNIQUE` (`userName`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Centennial College','root','admin','Centennial@mycentennial.ca','941 Progress Campus','College','centlogo-1.JPEG','416-723-5501','416-723-5523','416-456-2637','Ann Buller','www.centennialcollege.ca','55757377',1,'2013-10-16 14:45:16');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(50) NOT NULL AUTO_INCREMENT,
  `campusId` int(50) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  `departmentHod` varchar(50) NOT NULL,
  `contactInfo` int(15) NOT NULL,
  `departmentDescription` varchar(255) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,1,'School of Engineering and Technology','Ashley Giles',416,'Enginnering Department','2013-10-20 14:04:22'),(2,1,'School of Business','Matt Giles',416,'Business Department','2013-10-20 14:00:22'),(3,1,'School of Continuing Education','Jeff Giles',416,'Continuing Education Department','2013-10-20 14:04:15'),(4,2,'School of Community and Health Studies','Michael Giles',416,'Community and Health Department','2013-10-20 13:04:22'),(5,2,'School of Advancement','Mitchel Slater',416,'Advancement Department','2013-10-20 12:08:22'),(6,3,'School of Hospitality','Clinton Slater',416,'Hospitality Department','2013-10-20 12:03:22'),(7,3,'School of ChildCare','Arjun Slater',416,'Childcare Department','2013-10-20 12:03:25'),(8,4,'School of Aviation','Randy Slater',416,'Aviation Department','2013-10-22 12:03:25'),(9,4,'Applied Research and Innovation Center','Amy Slater',416,'Research Department','2013-10-22 12:03:45');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departmenttimeslot`
--

DROP TABLE IF EXISTS `departmenttimeslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departmenttimeslot` (
  `departmentTimeId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `timeslotId` int(50) NOT NULL,
  `weekdays` varchar(7) NOT NULL,
  `capacity` int(5) NOT NULL,
  PRIMARY KEY (`departmentTimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departmenttimeslot`
--

LOCK TABLES `departmenttimeslot` WRITE;
/*!40000 ALTER TABLE `departmenttimeslot` DISABLE KEYS */;
INSERT INTO `departmenttimeslot` VALUES (1,1,1,'1111000',30),(2,2,1,'1111100',35),(3,4,2,'1110000',25),(4,7,2,'1111100',28),(5,1,3,'0000100',10),(6,1,4,'0000010',10);
/*!40000 ALTER TABLE `departmenttimeslot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faq`
--

DROP TABLE IF EXISTS `faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faq` (
  `faqId` int(50) NOT NULL AUTO_INCREMENT,
  `categoryId` int(50) NOT NULL,
  `officialId` int(50) NOT NULL,
  `faqQuestion` varchar(255) NOT NULL,
  `faqAnswer` varchar(255) NOT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`faqId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq`
--

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
INSERT INTO `faq` VALUES (1,1,1,'How to change course','Navigate to Home => Change Course','2013-11-11 12:34:23'),(2,2,2,'How to register for a program?','Navigate to Home => New Program','2013-11-11 12:23:45');
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generaluser`
--

DROP TABLE IF EXISTS `generaluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generaluser` (
  `userId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `token` varchar(100) NOT NULL,
  `emailVerified` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `UNIQUE` (`username`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generaluser`
--

LOCK TABLES `generaluser` WRITE;
/*!40000 ALTER TABLE `generaluser` DISABLE KEYS */;
INSERT INTO `generaluser` VALUES (1,1,'dkaith','cc1','Kaith','Devon','dkaith@ccollege.com','1985-12-14','22 Progress Ave','Female','ab12',1),(2,1,'dkemar','cc2','Kemar','Devon','dkemar1@ccollege.com','1985-12-12','46 rudington dr','Male','ac12',1),(3,1,'pvishal','cc3','Vishal','Punjabi','pvishal@ccollege.com','1986-12-12','45 rudington dr','Male','ad12',1),(4,1,'vagin','cc4','Vishal','Agin','vagin@cccollege.com','1984-12-12','47 rudington dr','Male','ae12',1),(5,1,'dvalecha','cc5','Devraj','Valecha','dvalecha@ccollege.com','1986-10-16','48 rudington dr','Male','af12',1),(6,1,'sbanjara','cc6','Shalin','Banjara','sbanjara@ccollege.com','1984-08-08','49 rudington dr','Male','ag12',1),(7,1,'ksara','cc7','Kim','Sara','ksara@ccollege.com','1984-08-08','50 rudington dr','Female','ah12',1);
/*!40000 ALTER TABLE `generaluser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notificationId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `userId` int(50) NOT NULL,
  `gcmMessageId` int(100) NOT NULL,
  `notificationHeader` varchar(100) DEFAULT NULL,
  `notificationDescription` varchar(255) NOT NULL,
  `readByUser` tinyint(1) NOT NULL,
  `notificationDate` datetime NOT NULL,
  PRIMARY KEY (`notificationId`),
  UNIQUE KEY `UNIQUE` (`gcmMessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,2,1,4354,'Meeting Postponed','Meeting has been postponed to tomorrow',1,'2013-10-23 11:23:44'),(2,4,2,4543,'Meeting Delayed','Meeting has been delayed by 1 hour',1,'2013-10-23 10:23:44');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officialuser`
--

DROP TABLE IF EXISTS `officialuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `officialuser` (
  `officialId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `roleId` int(50) NOT NULL,
  `officialName` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `dateJoined` date NOT NULL,
  `lastLogin` datetime NOT NULL,
  PRIMARY KEY (`officialId`),
  KEY `UNIQUE` (`officialName`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officialuser`
--

LOCK TABLES `officialuser` WRITE;
/*!40000 ALTER TABLE `officialuser` DISABLE KEYS */;
INSERT INTO `officialuser` VALUES (1,1,2,'Ashley Giles','m1@ccollge.com','admin1','Ashley','Giles','2013-05-21','2013-05-22 12:23:34'),(2,1,3,'Mark Waugh','m2@ccollge.com','admin2','Mark','Waugh','2013-05-22','2013-05-23 12:25:34'),(3,2,2,'Matt Giles','m3@ccollge.com','admin3','Matt','Giles','2013-05-22','2013-05-23 13:25:34'),(4,2,3,'Alex Tudor','m4@ccollge.com','admin4','Alex','Tudor','2013-05-23','2013-05-23 13:25:30'),(5,4,2,'Michael Giles','m5@ccollge.com','admin5','Michael','Giles','2013-05-23','2013-05-24 13:25:30'),(6,4,3,'Tony Greg','m6@ccollge.com','admin6','Tony','Greg','2013-05-24','2013-05-25 13:25:30'),(7,7,2,'Arjun Slater','m7@ccollge.com','admin7','Arjun','Slater','2013-05-25','2013-05-25 12:25:30'),(8,7,3,'Karan Slater','m8@ccollge.com','admin8','Karan','Slater','2013-05-26','2013-05-27 12:25:30');
/*!40000 ALTER TABLE `officialuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `roleId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `privilege` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'President','Universal Access','College Affairs'),(2,1,'HOD','Department Access','Department Affairs'),(3,1,'Counsellor','Department Access','Department and Student Affairs');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslot`
--

DROP TABLE IF EXISTS `timeslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslot`
--

LOCK TABLES `timeslot` WRITE;
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` VALUES (1,'07:00:00','11:00:00','Slot timings'),(2,'08:00:00','12:00:00','Slot timings'),(3,'09:00:00','13:00:00','Slot timings'),(4,'10:00:00','14:00:00','Slot timings'),(5,'11:00:00','15:00:00','Slot timings');
/*!40000 ALTER TABLE `timeslot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-23  9:33:15
