-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 26, 2013 at 01:19 AM
-- Server version: 5.6.12
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `scheduler`
--
CREATE DATABASE IF NOT EXISTS `scheduler` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `scheduler`;

-- --------------------------------------------------------

--
-- Table structure for table `announcement`
--

CREATE TABLE IF NOT EXISTS `announcement` (
  `announcementId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `announcementHeader` varchar(100) NOT NULL,
  `announcementDescription` varchar(255) DEFAULT NULL,
  `gcmMessageId` int(100) NOT NULL,
  `announcementDate` datetime NOT NULL,
  PRIMARY KEY (`announcementId`),
  UNIQUE KEY `UNIQUE` (`gcmMessageId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `announcement`
--

INSERT INTO `announcement` (`announcementId`, `officialId`, `announcementHeader`, `announcementDescription`, `gcmMessageId`, `announcementDate`) VALUES
(3, 1, 'Department Closed', 'Department will be cloased today', 2245, '2013-10-23 10:23:44'),
(4, 2, 'Students Arrival', 'Request to everyone to come on time', 2345, '2013-10-23 09:23:44');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appointmentId`, `departmentTimeId`, `userId`, `officialId`, `purposeOfVisit`, `startTime`, `endTime`, `meetingFinished`, `meetingNotes`, `dateCreated`, `appointmentDate`) VALUES
(1, 1, 1, 1234, 'Course Enquiry', '12:21:55', '08:15:00', 'N', 'Counselled', '2013-11-11 08:16:45', '2013-11-11'),
(2, 2, 2, 1234, 'Course Enquiry Details', '12:21:43', '08:30:00', 'N', 'Counselled', '2013-11-12 08:30:45', '2013-11-12'),
(3, 3, 3, 6, 'Program Enquiry', '08:30:00', '08:45:00', 'Y', 'Counselled', '2013-11-13 08:45:45', '2013-11-13'),
(4, 4, 4, 8, 'Program Enquiry', '09:30:00', '09:45:00', 'Y', 'Counselled', '2013-11-13 09:45:45', '2013-11-13'),
(5, 5, 5, 2, 'Course Enquiry', '10:00:00', '10:12:00', 'Y', 'Counselled', '2013-11-13 10:13:00', '2013-11-13'),
(6, 6, 6, 2, 'Course Enquiry', '10:30:00', '10:48:15', 'Y', 'Counselled', '2013-11-13 10:50:00', '2013-11-13');

-- --------------------------------------------------------

--
-- Table structure for table `campus`
--

CREATE TABLE IF NOT EXISTS `campus` (
  `campusId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `campusName` varchar(50) NOT NULL,
  `campusAddress` varchar(100) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`campusId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `campus`
--

INSERT INTO `campus` (`campusId`, `clientId`, `campusName`, `campusAddress`, `dateCreated`) VALUES
(1, 1, 'Progress Campus', '940 Progress Campus', '2013-10-18 14:30:22'),
(2, 1, 'Morningside Campus', '939 Morningside Campus', '2013-10-19 14:45:22'),
(3, 1, 'Ashtonbee Campus', '938 Ashtonbee Campus', '2013-10-20 14:05:22'),
(4, 1, 'CCC Campus', '937 CCC Campus', '2013-10-21 13:05:22');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryId`, `officialId`, `categoryName`) VALUES
(1, 1, 'Course FAQs'),
(2, 2, 'Admission FAQs'),
(3, 3, 'Course FAQs'),
(4, 4, 'Admission FAQs'),
(5, 5, 'Course FAQs'),
(6, 6, 'Admission FAQs');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`clientId`, `clientName`, `userName`, `password`, `email`, `address`, `memo`, `logo`, `phone1`, `phone2`, `phone3`, `contactPerson`, `website`, `token`, `emailVerified`, `dateJoined`) VALUES
(1, 'Centennial College', 'root', 'admin', 'Centennial@mycentennial.ca', '941 Progress Campus', 'College', 'centlogo-1.JPEG', '416-723-5501', '416-723-5523', '416-456-2637', 'Ann Buller', 'www.centennialcollege.ca', '55757377', 1, '2013-10-16 14:45:16');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `departmentId` int(50) NOT NULL AUTO_INCREMENT,
  `campusId` int(50) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  `departmentHod` varchar(50) NOT NULL,
  `contactInfo` int(15) NOT NULL,
  `departmentDescription` varchar(255) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`departmentId`, `campusId`, `departmentName`, `departmentHod`, `contactInfo`, `departmentDescription`, `dateCreated`) VALUES
(1, 1, 'School of Engineering and Technology', 'Ashley Giles', 416, 'Enginnering Department', '2013-10-20 14:04:22'),
(2, 1, 'School of Business', 'Matt Giles', 416, 'Business Department', '2013-10-20 14:00:22'),
(3, 1, 'School of Continuing Education', 'Jeff Giles', 416, 'Continuing Education Department', '2013-10-20 14:04:15'),
(4, 2, 'School of Community and Health Studies', 'Michael Giles', 416, 'Community and Health Department', '2013-10-20 13:04:22'),
(5, 2, 'School of Advancement', 'Mitchel Slater', 416, 'Advancement Department', '2013-10-20 12:08:22'),
(6, 3, 'School of Hospitality', 'Clinton Slater', 416, 'Hospitality Department', '2013-10-20 12:03:22'),
(7, 3, 'School of ChildCare', 'Arjun Slater', 416, 'Childcare Department', '2013-10-20 12:03:25'),
(8, 4, 'School of Aviation', 'Randy Slater', 416, 'Aviation Department', '2013-10-22 12:03:25'),
(9, 4, 'Applied Research and Innovation Center', 'Amy Slater', 416, 'Research Department', '2013-10-22 12:03:45');

-- --------------------------------------------------------

--
-- Table structure for table `departmenttimeslot`
--

CREATE TABLE IF NOT EXISTS `departmenttimeslot` (
  `departmentTimeId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `timeslotId` int(50) NOT NULL,
  `weekdays` varchar(7) NOT NULL,
  `capacity` int(5) NOT NULL,
  PRIMARY KEY (`departmentTimeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `departmenttimeslot`
--

INSERT INTO `departmenttimeslot` (`departmentTimeId`, `departmentId`, `timeslotId`, `weekdays`, `capacity`) VALUES
(1, 1, 1, '1111000', 30),
(2, 2, 1, '1111100', 35),
(3, 4, 2, '1110000', 25),
(4, 7, 2, '1111100', 28),
(5, 1, 3, '0000100', 10),
(6, 1, 4, '0000010', 10);

-- --------------------------------------------------------

--
-- Table structure for table `faq`
--

CREATE TABLE IF NOT EXISTS `faq` (
  `faqId` int(50) NOT NULL AUTO_INCREMENT,
  `categoryId` int(50) NOT NULL,
  `officialId` int(50) NOT NULL,
  `faqQuestion` varchar(255) NOT NULL,
  `faqAnswer` varchar(255) NOT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`faqId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `faq`
--

INSERT INTO `faq` (`faqId`, `categoryId`, `officialId`, `faqQuestion`, `faqAnswer`, `dateCreated`) VALUES
(1, 1, 1, 'How to change course', 'Navigate to Home => Change Course', '2013-11-11 12:34:23'),
(2, 2, 2, 'How to register for a program?', 'Navigate to Home => New Program', '2013-11-11 12:23:45');

-- --------------------------------------------------------

--
-- Table structure for table `generaluser`
--

CREATE TABLE IF NOT EXISTS `generaluser` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `generaluser`
--

INSERT INTO `generaluser` (`userId`, `clientId`, `username`, `password`, `firstName`, `lastName`, `email`, `dob`, `address`, `gender`, `token`, `emailVerified`, `gcmRegId`) VALUES
(1, 1, 'dkaith', 'cc1', 'Kaith', 'Devon', 'dkaith@ccollege.com', '1985-12-14', '22 Progress Ave', 'Female', 'ab12', 1, 'APA91bEV6sWyrFiPsF5a4Cb8HVKx7BuE3jgEznRGG5SRODgpTimEI5XWjRUgrARq1t-ZFDGiodfTuwSQYTSGnpfrNXjw17welyABfrHzPbCtaQyU9rYc9X4VCx0UzPn6IGiB43I2Q7QmTk_94fxEesvWF4Rwdiumug'),
(2, 1, 'dkemar', 'cc2', 'Kemar', 'Devon', 'dkemar1@ccollege.com', '1985-12-12', '46 rudington dr', 'Male', 'ac12', 1, 'APA91bFNiV2wA0nrzr9AmFnmULzBXpg0vuOzEMV36ih9bsWOXiFj8VFFs80cBck55DtVeKo3DFsVgRK8eIu8_PB_in0PNnaRW_vLKiS9lKuMtc6a8m3f5a2tdnHpPmrWRZYCDOIWTr79xWph19Q-PzOfTLOki-oPbg'),
(3, 1, 'pvishal', 'cc3', 'Vishal', 'Punjabi', 'pvishal@ccollege.com', '1986-12-12', '45 rudington dr', 'Male', 'ad12', 1, 'abcd'),
(4, 1, 'vagin', 'cc4', 'Vishal', 'Agin', 'vagin@cccollege.com', '1984-12-12', '47 rudington dr', 'Male', 'ae12', 1, 'abcd'),
(5, 1, 'dvalecha', 'cc5', 'Devraj', 'Valecha', 'dvalecha@ccollege.com', '1986-10-16', '48 rudington dr', 'Male', 'af12', 1, 'abcd'),
(6, 1, 'sbanjara', 'cc6', 'Shalin', 'Banjara', 'sbanjara@ccollege.com', '1984-08-08', '49 rudington dr', 'Male', 'ag12', 1, 'abcd'),
(7, 1, 'ksara', 'cc7', 'Kim', 'Sara', 'ksara@ccollege.com', '1984-08-08', '50 rudington dr', 'Female', 'ah12', 1, 'abcd');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`notificationId`, `officialId`, `userId`, `gcmMessageId`, `notificationHeader`, `notificationDescription`, `readByUser`, `notificationDate`) VALUES
(1, 2, 1, 4354, 'Meeting Postponed', 'Meeting has been postponed to tomorrow', 1, '2013-10-23 11:23:44'),
(2, 4, 2, 4543, 'Meeting Delayed', 'Meeting has been delayed by 1 hour', 1, '2013-10-23 10:23:44');

-- --------------------------------------------------------

--
-- Table structure for table `officialuser`
--

CREATE TABLE IF NOT EXISTS `officialuser` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `officialuser`
--

INSERT INTO `officialuser` (`officialId`, `departmentId`, `roleId`, `officialName`, `email`, `password`, `firstName`, `lastName`, `dateJoined`, `lastLogin`) VALUES
(1, 1, 2, 'Ashley Giles', 'm1@ccollge.com', 'admin1', 'Ashley', 'Giles', '2013-05-21', '2013-05-22 12:23:34'),
(2, 1, 3, 'Mark Waugh', 'm2@ccollge.com', 'admin2', 'Mark', 'Waugh', '2013-05-22', '2013-05-23 12:25:34'),
(3, 2, 2, 'Matt Giles', 'm3@ccollge.com', 'admin3', 'Matt', 'Giles', '2013-05-22', '2013-05-23 13:25:34'),
(4, 2, 3, 'Alex Tudor', 'm4@ccollge.com', 'admin4', 'Alex', 'Tudor', '2013-05-23', '2013-05-23 13:25:30'),
(5, 4, 2, 'Michael Giles', 'm5@ccollge.com', 'admin5', 'Michael', 'Giles', '2013-05-23', '2013-05-24 13:25:30'),
(6, 4, 3, 'Tony Greg', 'm6@ccollge.com', 'admin6', 'Tony', 'Greg', '2013-05-24', '2013-05-25 13:25:30'),
(7, 7, 2, 'Arjun Slater', 'm7@ccollge.com', 'admin7', 'Arjun', 'Slater', '2013-05-25', '2013-05-25 12:25:30'),
(8, 7, 3, 'Karan Slater', 'm8@ccollge.com', 'admin8', 'Karan', 'Slater', '2013-05-26', '2013-05-27 12:25:30');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `roleId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `privilege` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`roleId`, `clientId`, `roleName`, `privilege`, `description`) VALUES
(1, 1, 'President', 'Universal Access', 'College Affairs'),
(2, 1, 'HOD', 'Department Access', 'Department Affairs'),
(3, 1, 'Counsellor', 'Department Access', 'Department and Student Affairs');

-- --------------------------------------------------------

--
-- Table structure for table `timeslot`
--

CREATE TABLE IF NOT EXISTS `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `timeslot`
--

INSERT INTO `timeslot` (`timeslotId`, `startTime`, `stopTime`, `description`) VALUES
(1, '07:00:00', '11:00:00', 'Slot timings'),
(2, '08:00:00', '12:00:00', 'Slot timings'),
(3, '09:00:00', '13:00:00', 'Slot timings'),
(4, '10:00:00', '14:00:00', 'Slot timings'),
(5, '11:00:00', '15:00:00', 'Slot timings');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
