DROP table if exists test_user;
CREATE TABLE `test_user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP table if exists timeslot;
CREATE TABLE IF NOT EXISTS `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

DROP table if exists departmenttimeslot;
CREATE TABLE IF NOT EXISTS `departmenttimeslot` (
  `departmentTimeId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `timeslotId` int(50) NOT NULL,
  `weekdays` varchar(7) NOT NULL,
  `capacity` int(5) NOT NULL,
  PRIMARY KEY (`departmentTimeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

INSERT INTO `timeslot` (`timeslotId`, `clientId`, `startTime`, `stopTime`, `description`) VALUES
(1, 1, '09:00:00', '13:00:00', 'New timeslot');


DROP TABLE IF EXISTS `appointment`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
INSERT INTO `appointment` (`appointmentId`, `departmentTimeId`, `userId`, `officialId`, `purposeOfVisit`, `startTime`, `endTime`, `meetingFinished`, `meetingNotes`, `dateCreated`, `appointmentDate`) VALUES
(1, 1, 1, 3, 'Course Enquiry', '00:00:00', '00:00:00', '', '', '2013-11-11 08:16:45', '2013-11-10');

DROP TABLE IF EXISTS `generaluser`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

INSERT INTO `generaluser` (`userId`, `clientId`, `username`, `password`, `firstName`, `lastName`, `email`, `dob`, `address`, `gender`, `token`, `emailVerified`, `gcmRegId`) VALUES
(1, 1, 'dkaith', 'cc1234', 'Kaith', 'Devon', 'dkaith@ccollege.com', '1985-12-14', '22 Progress Ave', 'Female', 'ab12', 1, '');

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `departmentId` INT(50) NOT NULL AUTO_INCREMENT,
  `campusId` INT(50) NOT NULL,
  `departmentName` VARCHAR(50) NOT NULL,
  `departmentHod` VARCHAR(50) NOT NULL,
  `contactInfo` BIGINT(15) NOT NULL,
  `departmentDescription` VARCHAR(255) DEFAULT NULL,
  `dateCreated` DATETIME NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=INNODB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

DROP table if exists test_user;
CREATE TABLE `test_user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP table if exists timeslot;
CREATE TABLE IF NOT EXISTS `timeslot` (
  `timeslotId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `stopTime` time NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timeslotId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

DROP table if exists departmenttimeslot;
CREATE TABLE IF NOT EXISTS `departmenttimeslot` (
  `departmentTimeId` int(50) NOT NULL AUTO_INCREMENT,
  `departmentId` int(50) NOT NULL,
  `timeslotId` int(50) NOT NULL,
  `weekdays` varchar(7) NOT NULL,
  `capacity` int(5) NOT NULL,
  PRIMARY KEY (`departmentTimeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

INSERT INTO `timeslot` (`timeslotId`, `clientId`, `startTime`, `stopTime`, `description`) VALUES
(1, 1, '09:00:00', '13:00:00', 'New timeslot');


DROP TABLE IF EXISTS `appointment`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7; 

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `departmentId` INT(50) NOT NULL AUTO_INCREMENT,
  `campusId` INT(50) NOT NULL,
  `departmentName` VARCHAR(50) NOT NULL,
  `departmentHod` VARCHAR(50) NOT NULL,
  `contactInfo` INT(15) NOT NULL,
  `departmentDescription` VARCHAR(255) DEFAULT NULL,
  `dateCreated` DATETIME NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=INNODB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

DROP TABLE IF EXISTS `announcement`;
CREATE TABLE IF NOT EXISTS `announcement` (
  `announcementId` int(50) NOT NULL AUTO_INCREMENT,
  `officialId` int(50) NOT NULL,
  `announcementHeader` varchar(100) NOT NULL,
  `announcementDescription` varchar(255) DEFAULT NULL,
  `gcmMessageId` text,
  `announcementDate` datetime NOT NULL,
  PRIMARY KEY (`announcementId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;


DROP TABLE IF EXISTS `userannouncements`;
CREATE TABLE `userannouncements` (
  `userAnnouncementId` int(11) NOT NULL AUTO_INCREMENT,
  `announcementId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userAnnouncementId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `officialuser`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
INSERT INTO `officialuser` (`officialId`, `departmentId`, `roleId`, `officialName`, `email`, `password`, `firstName`, `lastName`, `dateJoined`, `lastLogin`) VALUES
(1, 1, 2, 'Ashley Giles', 'm1@ccollge.com', 'abcd', 'Ashley', 'Giles', '2013-05-21', '2013-05-22 12:23:34');

DROP TABLE IF EXISTS `campus`;
CREATE TABLE `campus` (
  `campusId` int(50) NOT NULL AUTO_INCREMENT,
  `clientId` int(50) NOT NULL,
  `campusName` varchar(50) NOT NULL,
  `campusAddress` varchar(100) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`campusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
