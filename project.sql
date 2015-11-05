-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2015 at 10:28 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) NOT NULL,
  `photo` mediumblob NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`c_id`, `uname`, `photo`) VALUES
INSERT INTO `contact` (`c_id`, `uname`, `photo`) VALUES

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `uname` varchar(30) NOT NULL,
  `photo` mediumblob,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reg`
--

CREATE TABLE IF NOT EXISTS `reg` (
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `cpass` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `bday` varchar(10) NOT NULL,
  PRIMARY KEY (`uname`),
  UNIQUE KEY `uname` (`uname`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg`
--

INSERT INTO `reg` (`fname`, `lname`, `uname`, `pass`, `cpass`, `email`, `bday`) VALUES
('aaa', 'aaa', 'aaa', 'aaa', 'aaa', 'darshanmodh@gmail.com', '04/01/2013'),
('abc', 'abc', 'abc', 'abc', 'abc', 'abc@abc', '01/16/1993'),
('Darshan', 'Modh', 'darshan', 'darshan', 'darshan', 'darshanmodh@gmail.com', '01/01/1993'),
('Darshan', 'Modh', 'darshanmodh', 'darshan', 'darshan', 'darshanmodh@gmail.com', '01/01/1993'),
('Deep', 'Modh', 'deep', 'deep', 'deep', 'deepmodh@gmail.com', '11/03/1998'),
('Dhruvi', 'Brahmbhatt', 'gopi', 'gopi', 'gopi', 'dhruviibrahmbhatt@yahoo.com', '10/02/1992'),
('Karan', 'Modh', 'Karan', 'kdmodh22101997', 'kdmodh22101997', 'Karanmodh1997@gmail.com', '10/22/1997');

-- --------------------------------------------------------

--
-- Table structure for table `user_event`
--

CREATE TABLE IF NOT EXISTS `user_event` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `eventdesc` varchar(300) NOT NULL,
  `eventdate` date NOT NULL,
  PRIMARY KEY (`eventid`),
  KEY `fk_userevent` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Dumping data for table `user_event`
--

INSERT INTO `user_event` (`eventid`, `username`, `eventdesc`, `eventdate`) VALUES
(1, 'darshan', 'Test 1', '2013-04-01'),
(2, 'darshan', 'b''day', '2013-10-01'),
(3, 'darshan', 'b''day', '2013-04-15'),
(4, 'darshan', 'Test 2', '2013-04-01'),
(5, 'darshan', 'Test 24', '2013-04-04'),
(7, 'darshan', 'Test 4', '2013-04-04'),
(8, 'darshan', 'mcv', '2013-04-09'),
(9, 'darshan', ',mmnfkfngs', '2013-04-16'),
(10, 'darshan', 'mn', '2013-04-11'),
(37, 'darshan', '', '2013-04-01'),
(38, 'darshan', 'd', '2013-04-01'),
(39, 'darshan', 'hashd', '2013-04-15'),
(40, 'darshan', 'fhgsdfs', '2013-04-15'),
(41, 'darshan', 'rsfe', '2013-04-16'),
(42, 'darshan', 'guighiuh', '2013-04-16'),
(43, 'darshan', 'birthday', '2013-04-02'),
(44, 'deep', 'it''s deep modh', '2013-04-01'),
(45, 'deep', 'fasdf', '2013-11-27'),
(46, 'darshan', 'Dhruvi''s Birthday', '2013-10-02');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_event`
--
ALTER TABLE `user_event`
  ADD CONSTRAINT `fk_userevent` FOREIGN KEY (`username`) REFERENCES `reg` (`uname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;