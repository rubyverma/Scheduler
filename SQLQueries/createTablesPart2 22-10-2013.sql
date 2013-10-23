/*
SQLyog Community v11.21 (64 bit)
MySQL - 5.6.12-log : Database - scheduler
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`scheduler` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `scheduler`;

/*Table structure for table `faq` */

DROP TABLE IF EXISTS `faq`;

CREATE TABLE `faq` (
  `faqId` int(50) NOT NULL AUTO_INCREMENT,
  `categoryId` int(50) NOT NULL,
  `officialId` int(50) NOT NULL,
  `faqQuestion` varchar(255) NOT NULL,
  `faqAnswer` varchar(255) NOT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`faqId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `generaluser` */

DROP TABLE IF EXISTS `generaluser`;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `officialuser` */

DROP TABLE IF EXISTS `officialuser`;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `roleId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `privilege` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `timeslot` */

DROP TABLE IF EXISTS `timeslot`;

CREATE TABLE `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
