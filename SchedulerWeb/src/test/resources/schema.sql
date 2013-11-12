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