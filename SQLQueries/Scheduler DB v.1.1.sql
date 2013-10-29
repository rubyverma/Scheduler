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

/*Table structure for table `announcement` */

DROP TABLE IF EXISTS `announcement`;

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

/*Data for the table `announcement` */

insert  into `announcement`(`announcementId`,`officialId`,`announcementHeader`,`announcementDescription`,`gcmMessageId`,`announcementDate`) values (1,1,'Department Closed','Department will be closed today',2245,'2013-10-23 10:23:44'),(2,2,'Students Arrival','Request to everyone to come on time',2345,'2013-10-23 09:23:44'),(3,1,'Department Closed','Department will be closed tomorrow',2445,'2013-10-27 07:38:14');

/*Table structure for table `appointment` */

DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (
  `appointmentId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentTimeId` int(50) NOT NULL,
  `userId` int(50) NOT NULL,
  `officialId` int(50) DEFAULT NULL,
  `purposeOfVisit` varchar(255) DEFAULT NULL,
  `startTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  `meetingFinished` varchar(1) DEFAULT NULL,
  `meetingNotes` text,
  `dateCreated` datetime NOT NULL,
  `appointmentDate` date NOT NULL,
  PRIMARY KEY (`appointmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `appointment` */

insert  into `appointment`(`appointmentId`,`departmentTimeId`,`userId`,`officialId`,`purposeOfVisit`,`startTime`,`endTime`,`meetingFinished`,`meetingNotes`,`dateCreated`,`appointmentDate`) values (3,3,3,6,'Program Enquiry','08:30:00','08:45:00','Y','Counselled','2013-11-13 08:45:45','2013-11-13'),(4,4,1,8,'Program Enquiry','09:30:00','09:45:00','L','','2013-11-13 09:45:45','2013-11-13'),(5,5,5,2,'Course Enquiry','10:00:00','10:12:00','Y','Counselled','2013-11-13 10:13:00','2013-11-13'),(6,6,1,2,'Course Enquiry','10:30:00','10:48:15','Y','Counselled','2013-11-13 10:50:00','2013-11-13'),(7,3,1,2,'General Enquiry','12:30:00','12:39:00','C',NULL,'2013-11-15 12:41:00','2013-11-15'),(8,4,1,6,'Program Enquiry','09:25:00','09:35:00','N',NULL,'2013-11-12 09:36:00','2013-11-12'),(9,2,1,8,'Enquiry','08:00:00','08:15:00','N',NULL,'2013-11-10 08:16:00','2013-11-10');

/*Table structure for table `campus` */

DROP TABLE IF EXISTS `campus`;

CREATE TABLE `campus` (
  `campusId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `campusName` varchar(50) NOT NULL,
  `campusAddress` varchar(100) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`campusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `campus` */

insert  into `campus`(`campusId`,`clientId`,`campusName`,`campusAddress`,`dateCreated`) values (1,1,'Progress Campus','940 Progress Campus','2013-10-18 14:30:22'),(2,1,'Morningside Campus','939 Morningside Campus','2013-10-19 14:45:22'),(3,1,'Ashtonbee Campus','938 Ashtonbee Campus','2013-10-20 14:05:22'),(4,1,'CCC Campus','937 CCC Campus','2013-10-21 13:05:22');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `categoryId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`categoryId`,`officialId`,`categoryName`) values (1,1,'Course FAQs'),(2,2,'Admission FAQs'),(3,3,'Course FAQs'),(4,4,'Admission FAQs'),(5,5,'Course FAQs'),(6,6,'Admission FAQs');

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

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

/*Data for the table `client` */

insert  into `client`(`clientId`,`clientName`,`userName`,`password`,`email`,`address`,`memo`,`logo`,`phone1`,`phone2`,`phone3`,`contactPerson`,`website`,`token`,`emailVerified`,`dateJoined`) values (1,'Centennial College','root','admin','Centennial@mycentennial.ca','941 Progress Campus','College','centlogo-1.JPEG','416-723-5501','416-723-5523','416-456-2637','Ann Buller','www.centennialcollege.ca','55757377',1,'2013-10-16 14:45:16');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

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

/*Data for the table `department` */

insert  into `department`(`departmentId`,`campusId`,`departmentName`,`departmentHod`,`contactInfo`,`departmentDescription`,`dateCreated`) values (1,1,'School of Engineering and Technology','Ashley Giles',416,'Enginnering Department','2013-10-20 14:04:22'),(2,1,'School of Business','Matt Giles',416,'Business Department','2013-10-20 14:00:22'),(3,1,'School of Continuing Education','Jeff Giles',416,'Continuing Education Department','2013-10-20 14:04:15'),(4,2,'School of Community and Health Studies','Michael Giles',416,'Community and Health Department','2013-10-20 13:04:22'),(5,2,'School of Advancement','Mitchel Slater',416,'Advancement Department','2013-10-20 12:08:22'),(6,3,'School of Hospitality','Clinton Slater',416,'Hospitality Department','2013-10-20 12:03:22'),(7,3,'School of ChildCare','Arjun Slater',416,'Childcare Department','2013-10-20 12:03:25'),(8,4,'School of Aviation','Randy Slater',416,'Aviation Department','2013-10-22 12:03:25'),(9,4,'Applied Research and Innovation Center','Amy Slater',416,'Research Department','2013-10-22 12:03:45');

/*Table structure for table `departmenttimeslot` */

DROP TABLE IF EXISTS `departmenttimeslot`;

CREATE TABLE `departmenttimeslot` (
  `departmentTimeId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `timeslotId` int(50) NOT NULL,
  `weekdays` varchar(7) NOT NULL,
  `capacity` int(5) NOT NULL,
  PRIMARY KEY (`departmentTimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `departmenttimeslot` */

insert  into `departmenttimeslot`(`departmentTimeId`,`departmentId`,`timeslotId`,`weekdays`,`capacity`) values (1,1,1,'1111000',30),(2,2,1,'1111100',35),(3,4,2,'1110000',25),(4,7,2,'1111100',28),(5,1,3,'0000100',10),(6,1,4,'0000010',10);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `faq` */

insert  into `faq`(`faqId`,`categoryId`,`officialId`,`faqQuestion`,`faqAnswer`,`dateCreated`) values (1,1,1,'How to change course','Navigate to Home => Change Course','2013-11-11 12:34:23'),(2,2,2,'How to register for a program?','Navigate to Home => New Program','2013-11-11 12:23:45');

/*Table structure for table `generaluser` */

DROP TABLE IF EXISTS `generaluser`;

CREATE TABLE `generaluser` (
  `userId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `token` varchar(100) NOT NULL,
  `emailVerified` tinyint(1) DEFAULT NULL,
  `gcmRegId` text,
  PRIMARY KEY (`userId`),
  KEY `UNIQUE` (`username`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `generaluser` */

insert  into `generaluser`(`userId`,`clientId`,`username`,`password`,`firstName`,`lastName`,`email`,`dob`,`address`,`gender`,`token`,`emailVerified`,`gcmRegId`) values (1,1,'dkaith','cc1','Kaith','Devon','dkaith@ccollege.com','1985-12-14','22 Progress Ave','Female','ab12',1,'APA91bEV6sWyrFiPsF5a4Cb8HVKx7BuE3jgEznRGG5SRODgpTimEI5XWjRUgrARq1t-ZFDGiodfTuwSQYTSGnpfrNXjw17welyABfrHzPbCtaQyU9rYc9X4VCx0UzPn6IGiB43I2Q7QmTk_94fxEesvWF4Rwdiumug'),(2,1,'dkemar','cc2','Kemar','Devon','dkemar1@ccollege.com','1985-12-12','46 rudington dr','Male','ac12',1,'APA91bFNiV2wA0nrzr9AmFnmULzBXpg0vuOzEMV36ih9bsWOXiFj8VFFs80cBck55DtVeKo3DFsVgRK8eIu8_PB_in0PNnaRW_vLKiS9lKuMtc6a8m3f5a2tdnHpPmrWRZYCDOIWTr79xWph19Q-PzOfTLOki-oPbg'),(3,1,'pvishal','cc3','Vishal','Punjabi','pvishal@ccollege.com','1986-12-12','45 rudington dr','Male','ad12',1,'abcd'),(4,1,'vagin','cc4','Vishal','Agin','vagin@cccollege.com','1984-12-12','47 rudington dr','Male','ae12',1,'abcd'),(5,1,'dvalecha','cc5','Devraj','Valecha','dvalecha@ccollege.com','1986-10-16','48 rudington dr','Male','af12',1,'abcd'),(6,1,'sbanjara','cc6','Shalin','Banjara','sbanjara@ccollege.com','1984-08-08','49 rudington dr','Male','ag12',1,'abcd'),(7,1,'ksara','cc7','Kim','Sara','ksara@ccollege.com','1984-08-08','50 rudington dr','Female','ah12',1,'abcd');

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `notificationId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `userId` int(50) NOT NULL,
  `gcmMessageId` varchar(100) DEFAULT NULL,
  `notificationHeader` varchar(100) DEFAULT NULL,
  `notificationDescription` varchar(255) NOT NULL,
  `readByUser` tinyint(1) NOT NULL,
  `notificationDate` datetime NOT NULL,
  PRIMARY KEY (`notificationId`),
  UNIQUE KEY `UNIQUE` (`gcmMessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `notification` */

insert  into `notification`(`notificationId`,`officialId`,`userId`,`gcmMessageId`,`notificationHeader`,`notificationDescription`,`readByUser`,`notificationDate`) values (1,2,1,'4354','Meeting Postponed','Meeting has been postponed to tomorrow',1,'2013-10-23 11:23:44'),(2,4,2,'4543','Meeting Delayed','Meeting has been delayed by 1 hour',1,'2013-10-23 10:23:44'),(3,1234,2,NULL,NULL,'Please come in to the department',0,'2013-10-26 01:19:35'),(4,1234,1,'0:1382765377070398%3d747f6b38eb0007',NULL,'Please come in to the department',0,'2013-10-26 01:29:37'),(5,1234,1,'0:1382765459554857%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-26 01:30:59'),(6,1234,1,'0:1382765480057880%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-26 01:31:20'),(7,1234,1,'0:1382767726378383%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-26 02:08:46'),(8,1234,1,'0:1382767736479867%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-26 02:08:56'),(9,1234,1,'0:1382830202348776%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-26 19:30:02'),(10,1234,1,'0:1382851560021703%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-27 01:25:59'),(11,1234,1,'0:1382900396587649%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-27 14:59:56'),(12,1234,1,'0:1382923357845879%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-27 21:22:37'),(13,1234,1,'0:1382923645704178%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-27 21:27:25'),(14,1234,1,'0:1382973485613672%3d747f6b38eb0007','Meeting ready to be started','Please come in to the department',0,'2013-10-28 11:18:05');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `officialuser` */

insert  into `officialuser`(`officialId`,`departmentId`,`roleId`,`officialName`,`email`,`password`,`firstName`,`lastName`,`dateJoined`,`lastLogin`) values (1,1,2,'Ashley Giles','m1@ccollge.com','admin1','Ashley','Giles','2013-05-21','2013-05-22 12:23:34'),(2,1,3,'Mark Waugh','m2@ccollge.com','admin2','Mark','Waugh','2013-05-22','2013-05-23 12:25:34'),(3,2,2,'Matt Giles','m3@ccollge.com','admin3','Matt','Giles','2013-05-22','2013-05-23 13:25:34'),(4,2,3,'Alex Tudor','m4@ccollge.com','admin4','Alex','Tudor','2013-05-23','2013-05-23 13:25:30'),(5,4,2,'Michael Giles','m5@ccollge.com','admin5','Michael','Giles','2013-05-23','2013-05-24 13:25:30'),(6,4,3,'Tony Greg','m6@ccollge.com','admin6','Tony','Greg','2013-05-24','2013-05-25 13:25:30'),(7,7,2,'Arjun Slater','m7@ccollge.com','admin7','Arjun','Slater','2013-05-25','2013-05-25 12:25:30'),(8,7,3,'Karan Slater','m8@ccollge.com','admin8','Karan','Slater','2013-05-26','2013-05-27 12:25:30');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `roleId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `privilege` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`roleId`,`clientId`,`roleName`,`privilege`,`description`) values (1,1,'President','Universal Access','College Affairs'),(2,1,'HOD','Department Access','Department Affairs'),(3,1,'Counsellor','Department Access','Department and Student Affairs');

/*Table structure for table `test_user` */

DROP TABLE IF EXISTS `test_user`;

CREATE TABLE `test_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `test_user` */

insert  into `test_user`(`id`,`firstname`,`lastname`,`email`) values (1,'Sonny','rr','skr@gmail.com'),(2,'shal','ss','ss@gmail.com');

/*Table structure for table `timeslot` */

DROP TABLE IF EXISTS `timeslot`;

CREATE TABLE `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `timeslot` */

insert  into `timeslot`(`timeslotId`,`startTime`,`stopTime`,`description`) values (1,'07:00:00','11:00:00','Slot timings'),(2,'08:00:00','12:00:00','Slot timings'),(3,'09:00:00','13:00:00','Slot timings'),(4,'10:00:00','14:00:00','Slot timings'),(5,'11:00:00','15:00:00','Slot timings');

/*Table structure for table `userannouncements` */

DROP TABLE IF EXISTS `userannouncements`;

CREATE TABLE `userannouncements` (
  `userAnnouncementId` int(11) NOT NULL AUTO_INCREMENT,
  `announcementId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userAnnouncementId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `userannouncements` */

insert  into `userannouncements`(`userAnnouncementId`,`announcementId`,`userId`) values (1,1,1),(2,2,2),(3,3,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
