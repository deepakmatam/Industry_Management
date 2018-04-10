-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 25, 2017 at 06:51 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clc_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_table`
--

CREATE TABLE `admin_table` (
  `id` int(100) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_table`
--

INSERT INTO `admin_table` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `expenditures`
--

CREATE TABLE `expenditures` (
  `description` varchar(100) NOT NULL,
  `amount` float NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenditures`
--

INSERT INTO `expenditures` (`description`, `amount`, `date`) VALUES
('salary1', 250, '02/03/2015'),
('salary2', 250, '03/03/2015'),
('salary3', 250, '04/03/2015'),
('salary4', 250, '05/03/2015'),
('salary6', 250, '06/03/2015'),
('salary7', 250, '07/03/2015');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `cement` float NOT NULL,
  `flyash` float NOT NULL,
  `chemical` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`cement`, `flyash`, `chemical`) VALUES
(50, 70, 40);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_no` int(15) NOT NULL,
  `customer` text NOT NULL,
  `size` text NOT NULL,
  `quantity` int(15) NOT NULL,
  `amount` int(15) NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_no`, `customer`, `size`, `quantity`, `amount`, `date`) VALUES
(10245, 'zielyx', '6', 9, 10000, '22/09/2015'),
(20156, 'zielyx', '6', 26, 20000, '22/09/2015');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `size` text NOT NULL,
  `quantity` int(12) NOT NULL,
  `amount` text NOT NULL,
  `customer` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`size`, `quantity`, `amount`, `customer`, `date`) VALUES
('4', 12, '1200', 'abc', '02/03/2015'),
('4', 23, '23', 'gh22', '03/03/2015'),
('6', 20, '600', 'ggg', '04/03/2015'),
('45', 4555, '45555', 'kkkk', '05/03/2015');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `s4` int(11) NOT NULL,
  `s6` int(11) NOT NULL,
  `s8` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`s4`, `s6`, `s8`) VALUES
(105, 210, 310);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `id` int(100) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `username`, `password`) VALUES
(0, 'user', 'user123'),
(1, 'example', 'Temp@123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_table`
--
ALTER TABLE `admin_table`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD UNIQUE KEY `invoice_no` (`invoice_no`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD UNIQUE KEY `id` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
