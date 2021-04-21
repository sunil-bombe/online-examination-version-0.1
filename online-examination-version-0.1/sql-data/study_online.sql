-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Mar 01, 2021 at 10:00 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `study_online`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `aId` int(100) NOT NULL AUTO_INCREMENT,
  `qId` int(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`aId`)
) ENGINE=MyISAM AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `questionpaper`
--

DROP TABLE IF EXISTS `questionpaper`;
CREATE TABLE IF NOT EXISTS `questionpaper` (
  `qId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) DEFAULT NULL,
  `question` tinytext,
  `A` varchar(100) DEFAULT NULL,
  `B` varchar(100) DEFAULT NULL,
  `C` varchar(100) DEFAULT NULL,
  `D` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`qId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionpaper`
--

INSERT INTO `questionpaper` (`qId`, `subject`, `question`, `A`, `B`, `C`, `D`, `answer`) VALUES
(1, 'Angular', 'What Default Data Type ?', 'String', 'Variant', 'Integer', ' Boolean', 'B'),
(2, 'Angular', 'What is Default Form Border Style ?', 'Fixed Single', 'None', 'Sizeable', 'Fixed Diaglog', 'C'),
(3, 'Angular', 'Which is not type of Control ?', 'Text', 'Label', 'Checkbox ', 'Option Button', 'B'),
(4, 'Angular', ' Which of the follwing contexts are available in the add watch window ?', 'Project', 'Module', 'Procedure', 'All', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE IF NOT EXISTS `result` (
  `rId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) DEFAULT NULL,
  `testDate` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`rId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `sId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) DEFAULT NULL,
  `examTime` int(11) DEFAULT NULL,
  `subjectStatus` enum('inactive','active') NOT NULL DEFAULT 'inactive',
  PRIMARY KEY (`sId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`sId`, `subject`, `examTime`, `subjectStatus`) VALUES
(1, 'Angular', 1, 'inactive'),
(2, 'Math', 1, 'inactive'),
(3, 'Aptitude', 1, 'inactive'),
(4, 'English', 1, 'inactive'),
(5, 'Java', 1, 'inactive');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(100) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `userPwd` varchar(100) NOT NULL,
  `userStatus` varchar(100) NOT NULL,
  `userType` enum('User','Admin') NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userName`, `userPwd`, `userStatus`, `userType`) VALUES
(22, 'maheshkarande@gmail.com', 'mahesh', 'active', 'User'),
(21, 'ajitbombe@gmail.com', 'ajit', 'active', 'User'),
(3, 'rahulnarhe@gmail.com', 'rahul', 'active', 'Admin'),
(20, 'mahesh@gmail.com', 'mahesh', 'active', 'User'),
(19, 'ganesh@gmail.com', 'ganesh', 'inactive', 'User'),
(17, 'sahil@gmail.com', 'sahil', 'active', 'User'),
(11, 'sunilbombe@gmail.com', 'sunil', 'active', 'User'),
(23, 'ramesh@gmail.com', 'ramesh', 'active', 'User'),
(26, 'rameshbombe@gmail.com', 'ramesh', 'active', 'User'),
(25, 'manoj@gmail.com', 'manoj', 'active', 'User'),
(27, 'dattabagale@gmail.com', 'datta', 'active', 'User'),
(28, 'samir@gmail.com', 'samir', 'active', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
CREATE TABLE IF NOT EXISTS `userdetails` (
  `ud_Id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ud_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`ud_Id`, `fullname`, `email`, `phone`, `dateOfBirth`, `college`, `userId`) VALUES
(1, 'Sunil Sakharam Bombe', 'sunilbombe@gmail.com', '878857556', '1998-03-26', 'Dr D Y Patil  ACS College Pimpri', 1),
(2, 'Ganesh Bombe', 'ganesh@gmail.com', '9730573220', '2020-08-13', 'SDVP college', 15),
(3, 'Sunil Sakharam Bombe', 'sunilbombe@gmail.com', '878857556', '2020-08-13', 'Dr D Y Patil  ACS College Pimpri', 11),
(4, 'Sahil Dabhade', 'sahil@gmail.com', '878857556', '2020-08-11', 'SDVP college', 17),
(5, 'Mahesh Karande', 'maheshkarande@gmail.com', '878678667', '1998-03-03', 'Dr D Y Patil ', 22),
(6, 'Ganesh Bombe', 'ganesh@gmail.com', '9730573220', '2020-08-28', 'SDVP college', 19),
(7, 'Ramesh Keru Bombe', 'rameshbombe@gmail.com', '7654320987', '2020-08-19', 'Dr D Y Patil ACS College Pimpri', 26),
(8, 'Datta Bagale', 'dattabagale@gmail.com', '1233456789', '2020-08-12', 'IIT', 27),
(9, 'Samir Kaka', 'samir@gmail.com', '08605705665', '2020-08-19', 'S D V P', 28);

-- --------------------------------------------------------

--
-- Table structure for table `userfeedback`
--

DROP TABLE IF EXISTS `userfeedback`;
CREATE TABLE IF NOT EXISTS `userfeedback` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `userEmail` varchar(100) DEFAULT NULL,
  `userPhone` varchar(100) DEFAULT NULL,
  `userComment` varchar(100) DEFAULT NULL,
  `userRemark` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userfeedback`
--

INSERT INTO `userfeedback` (`fId`, `userName`, `userEmail`, `userPhone`, `userComment`, `userRemark`, `userId`) VALUES
(1, 'Sunil Sakharam Bombe', 'sunilbombe@gmail.com', '878857556', 'good', 'neutral', 1),
(2, 'Sahil Dabhade', 'sahil@gmail.com', '878857556', 'goood', 'good', 4),
(3, 'Ganesh Bombe', 'ganesh@gmail.com', '9730573220', 'Good', 'good', 5),
(4, 'Ganesh Bombe', 'ganesh@gmail.com', '9730573220', 'good', 'excellent', 15),
(5, 'Sunil Sakharam Bombe', 'sunilbombe@gmail.com', '878857556', 'good', 'good', 11),
(6, 'Sahil Dabhade', 'sahil@gmail.com', '878857556', 'good', 'good', 17),
(7, 'Mahesh Karande', 'maheshkarande@gmail.com', '78657577635', 'good', 'excellent', 22),
(8, 'Ganesh Bombe', 'ganesh@gmail.com', '9730573220', 'good', 'good', 19),
(9, 'Ramesh Keru Bombe', 'rameshbombe@gmail.com', '7654320987', 'good', 'good', 26),
(10, 'Datta Bagale', 'dattabagale@gmail.com', '5668878787', 'good', 'good', 27);

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE IF NOT EXISTS `userinfo` (
  `udId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`udId`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`udId`, `name`, `userId`) VALUES
(1, 'rahul', 3),
(2, 'ganesh', 16);

-- --------------------------------------------------------

--
-- Table structure for table `userinfod`
--

DROP TABLE IF EXISTS `userinfod`;
CREATE TABLE IF NOT EXISTS `userinfod` (
  `udId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`udId`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfod`
--

INSERT INTO `userinfod` (`udId`, `name`, `userId`) VALUES
(1, 'parag', 18);

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(80) DEFAULT NULL,
  `Address` varchar(80) DEFAULT NULL,
  `pin_code` varchar(80) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_detail`
--

INSERT INTO `user_detail` (`id`, `mobile`, `Address`, `pin_code`, `birth_date`, `college`) VALUES
(1, '8605705665', 'At Post Pimparkhed Tal-Shirur Dist-Pune', '410504', '1998-03-26', 'Dr. D.Y. Patil ACS College Pimpri');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
