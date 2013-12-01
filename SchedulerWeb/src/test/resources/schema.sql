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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 

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