CREATE DATABASE  IF NOT EXISTS `scheduler` /*!40100 DEFAULT CHARACTER SET utf8 */;
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
  `announcementDate` datetime NOT NULL,
  PRIMARY KEY (`announcementId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1,1,'Department Closed','Department will be cloased today','2013-10-23 10:23:44'),(2,2,'Students Arrival','Request to everyone to come on time','2013-10-23 09:23:44');
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
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `meetingFinished` varchar(1) DEFAULT NULL,
  `meetingNotes` text,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`appointmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,1,0,2,'Course Enquiry','2012-00-00 00:00:00','0000-00-00 00:00:00','Y','Explained course details','2013-11-11 12:23:45'),(2,2,0,3,'Admission Enquiry','2013-00-00 00:00:00','0000-00-00 00:00:00','Y','Procedure Explained','2013-11-11 13:21:45');
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
INSERT INTO `campus` VALUES (1,2,'Progress Campus','940 Progress Campus','2013-10-18 14:30:22'),(2,2,'Morningside Campus','939 Morningside Campus','2013-10-19 14:45:22'),(3,2,'Ashtonbee Campus','938 Ashtonbee Campus','2013-10-20 14:05:22'),(4,2,'CCC Campus','937 CCC Campus','2013-10-21 13:05:22');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,2,'Course FAQs'),(2,3,'Admission FAQs');
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
  PRIMARY KEY (`clientId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (2,'Centennial College','root','admin','Centennial@mycentennial.ca','941 Progress Campus','College','centlogo-1.JPEG','416-723-5501','416-723-5523','416-456-2637','Ann Buller','www.centennialcollege.ca','55757377',1,'2013-10-16 14:45:16');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,1,' School of Engineering and Technology','Ashley Giles',416,'Enginnering Department','2013-10-20 14:04:22'),(2,1,'School of Business','Matt Giles',416,'Business Department','2013-10-20 14:00:22'),(3,1,'School of Continuing Education','Jeff Giles',416,'Continuing Education Department','2013-10-20 14:04:15'),(4,2,'School of Community and Health Studies','Michael Giles',416,'Community and Health Department','2013-10-20 13:04:22'),(5,2,'School of Advancement','Mitchel Slater',416,'Advancement Department','2013-10-20 12:08:22'),(6,2,'School of Communication & Media','Ashley Slater',416,'Media Department','2013-10-20 12:04:22'),(7,3,'School of Hospitality','Clinton Slater',416,'Hospitality Department','2013-10-20 12:03:22'),(8,3,'School of ChildCare','Arjun Slater',416,'Childcare Department','2013-10-20 12:03:25'),(9,3,'School of Transportation','Mike Slater',416,'Transportation Department','2013-10-23 12:03:25'),(10,4,'School of Aviation','Randy Slater',416,'Aviation Department','2013-10-22 12:03:25'),(11,4,'Applied Research and Innovation Center','Amy Slater',416,'Research Department','2013-10-22 12:03:45'),(12,4,'School of Environment Studies','Josh Slater',416,'Environment Department','2013-10-22 12:02:25');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departmenttimeslot`
--

LOCK TABLES `departmenttimeslot` WRITE;
/*!40000 ALTER TABLE `departmenttimeslot` DISABLE KEYS */;
INSERT INTO `departmenttimeslot` VALUES (1,1,1,'1111100',20),(2,2,1,'1111100',25),(3,4,1,'1111000',24),(4,3,2,'1111100',30),(5,5,2,'1111100',25),(6,9,1,'1111100',20),(7,10,2,'1111100',25),(8,11,3,'1111100',30);
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
INSERT INTO `faq` VALUES (1,1,2,'How to change course? ','Navigate to Home => Change Course','2013-11-11 12:34:23'),(2,2,3,'How to register for program?','Navigate to Home => New Program','2013-11-11 12:23:45');
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
  `dob` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generaluser`
--

LOCK TABLES `generaluser` WRITE;
/*!40000 ALTER TABLE `generaluser` DISABLE KEYS */;
INSERT INTO `generaluser` VALUES (1,2,'dkaith','cc1','Kaith','Devon','dkaith@ccollege.com','1985-12-14 11:23:45','45 rudington dr','female'),(2,2,'dkemar','cc2','Kemar','Devon','dkaith1@ccollege.com','1985-12-12 11:23:45','46 rudington dr','female');
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
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,2,0,43247,'Meeting Postponed','Meeting has been postponed to tomorrow',1,'2013-10-23 11:23:44');
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
  `dateJoined` datetime NOT NULL,
  `lastLogin` datetime NOT NULL,
  PRIMARY KEY (`officialId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officialuser`
--

LOCK TABLES `officialuser` WRITE;
/*!40000 ALTER TABLE `officialuser` DISABLE KEYS */;
INSERT INTO `officialuser` VALUES (1,1,2,'Ashley Giles','m1@ccollge.com','admin1','2013-05-21 12:23:34','2013-05-22 12:23:34'),(2,1,3,'Mark Waugh','m2@ccollge.com','admin2','2013-05-22 12:24:34','2013-05-22 12:25:34'),(3,2,3,'Steve Waugh','m3@ccollege.com','admin3','2013-05-22 12:15:34','2013-05-23 12:25:34');
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
INSERT INTO `roles` VALUES (1,2,'President','Universal Access','College Affairs'),(2,2,'HOD','Department Access','Department Affairs'),(3,2,'Counsellor','Department Access','Department and Student Affairs');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslot`
--

LOCK TABLES `timeslot` WRITE;
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` VALUES (1,'08:00:00','12:00:00','Slot timings'),(2,'09:00:00','14:00:00','Slot Timings'),(3,'10:00:00','16:00:00','Slot Timings');
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

-- Dump completed on 2013-10-20 16:03:29
