-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 11:37 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kaewa_tm`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `client_id` int(15) NOT NULL,
  `date_to_deliver` varchar(20) DEFAULT '20/11/2021',
  `time_to_deliver` varchar(20) DEFAULT NULL,
  `booking_status` varchar(30) NOT NULL DEFAULT 'Cart',
  `booking_date` varchar(20) DEFAULT NULL,
  `booking_remark` text DEFAULT NULL,
  `county_id` int(11) DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  `location` varchar(60) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `client_id`, `date_to_deliver`, `time_to_deliver`, `booking_status`, `booking_date`, `booking_remark`, `county_id`, `town_id`, `location`, `address`) VALUES
(21, 10, '29-3-2022', '14:23:43', 'Pending approval', '2021-10-22 14:23:43', NULL, 6, 15, 'nhtt', '696'),
(22, 10, '29-3-2022', NULL, 'Pending approval', '2021-10-22 14:35:17', NULL, 6, 15, 'nhtt', '696'),
(23, 10, '29-3-2022', NULL, 'Shipping', '2021-10-22 14:35:53', NULL, 6, 15, 'nhtt', '696'),
(24, 10, '29-3-2022', NULL, 'Collected', '2021-10-22 14:39:31', NULL, 6, 15, 'nhtt', '696'),
(25, 11, '29-3-2022', NULL, 'Collected', '2021-10-26 12:49:16', NULL, 8, 19, 'opposite Naivas', '53265'),
(26, 10, '29-3-2022', NULL, 'Pending approval', '2022-02-16 13:58:36', NULL, 9, 20, 'nhtt', '696'),
(27, 11, '29-3-2022', NULL, 'Pending approval', '2022-02-16 00:27:34', NULL, 8, 19, 'opposite Naivas', '53265'),
(28, 10, '29-3-2022', NULL, 'Rejected', '2022-02-16 14:00:04', 'see chhh', 9, 20, 'nhtt', '696'),
(29, 12, '29-3-2022', NULL, 'Collected', '2022-02-16 14:15:05', NULL, 6, 15, 'Near Posta', '55555'),
(30, 12, '29-3-2022', NULL, 'Collected', '2022-02-16 15:02:06', NULL, 6, 15, 'Near Posta', '55555'),
(31, 12, '29-3-2022', NULL, 'Collected', '2022-03-05 16:55:41', NULL, 6, 15, 'Near Posta', '55555'),
(32, 12, '30-9-2022', NULL, 'Pending approval', '2022-09-30 00:09:40', NULL, 6, 15, 'Near Posta', '55555'),
(33, 10, '29-3-2022', NULL, 'Issued', '2022-03-19 03:59:15', NULL, 9, 20, 'nhtt', '696'),
(34, 12, '20/11/2021', NULL, 'Cart', NULL, NULL, NULL, NULL, NULL, NULL),
(35, 14, '3-10-2022', NULL, 'Approved', '2022-10-03 12:23:39', NULL, 7, 11, 'BG hii', '235'),
(36, 14, '7-10-2022', NULL, 'Approved', '2022-10-07 11:53:48', NULL, 7, 11, 'BG hii', '235'),
(37, 15, '15-10-2022', NULL, 'Approved', '2022-10-09 12:11:14', NULL, 8, 17, 'good', '420'),
(38, 16, '18-10-2022', NULL, 'Approved', '2022-10-10 11:00:50', NULL, 6, 14, 'good', '258'),
(39, 17, '27-10-2022', NULL, 'Approved', '2022-10-11 10:43:51', NULL, 7, 11, 'town', '12588'),
(40, 18, '11-10-2022', NULL, 'Shipping', '2022-10-11 14:34:44', NULL, 9, 21, 'rfg', '1258'),
(41, 16, '20-10-2022', NULL, 'Issued', '2022-10-18 11:06:52', NULL, 6, 14, 'good', '258'),
(42, 18, '22-10-2022', NULL, 'Shipping', '2022-10-18 11:30:30', NULL, 9, 21, 'rfg', '1258'),
(43, 16, '20/11/2021', NULL, 'Cart', NULL, NULL, NULL, NULL, NULL, NULL),
(44, 18, '21-10-2022', NULL, 'Issued', '2022-10-18 12:01:48', NULL, 9, 21, 'rfg', '1258');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone_no` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(55) NOT NULL DEFAULT 'Pending approval',
  `password` varchar(50) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `remarks` text DEFAULT NULL,
  `user` varchar(10) NOT NULL DEFAULT 'Client'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `first_name`, `last_name`, `username`, `phone_no`, `email`, `status`, `password`, `date_created`, `remarks`, `user`) VALUES
(15, 'José', 'marina', 'marina', '0123456798', 'marina@gmail.com', 'Approved', '1234', '2022-10-09 09:01:25', NULL, 'Client'),
(16, 'brian', 'cheru', 'cheru', '0712345678', 'bri@gmail.com', 'Approved', '1234', '2022-10-10 07:54:48', NULL, 'Client'),
(17, 'brenda', 'mwangi', 'brenda', '0712369875', 'bren@gmail.com', 'Approved', '1234', '2022-10-11 07:38:30', NULL, 'Client'),
(18, 'david', 'kaje', 'kaje', '0729235689', 'kaje@gmail.com', 'Approved', '1234', '2022-10-11 11:28:31', NULL, 'Client');

-- --------------------------------------------------------

--
-- Table structure for table `counties`
--

CREATE TABLE `counties` (
  `county_id` int(11) NOT NULL,
  `county_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `counties`
--

INSERT INTO `counties` (`county_id`, `county_name`) VALUES
(6, 'Makueni'),
(7, 'Machakos'),
(8, 'Kitui'),
(9, 'Kiambu');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `id` int(11) NOT NULL,
  `county_id` int(11) NOT NULL,
  `town_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `address` varchar(20) NOT NULL,
  `location` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`id`, `county_id`, `town_id`, `client_id`, `address`, `location`) VALUES
(12, 9, 20, 10, '696', 'nhtt'),
(13, 8, 19, 11, '53265', 'opposite Naivas'),
(14, 6, 15, 12, '55555', 'Near Posta'),
(15, 7, 11, 14, '235', 'BG hii'),
(16, 8, 17, 15, '420', 'good'),
(17, 6, 14, 16, '258', 'good'),
(18, 7, 11, 17, '12588', 'town'),
(19, 9, 21, 18, '1258', 'rfg');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_cost`
--

CREATE TABLE `delivery_cost` (
  `d_id` int(11) NOT NULL,
  `cost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery_cost`
--

INSERT INTO `delivery_cost` (`d_id`, `cost`) VALUES
(2, 850);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT current_timestamp(),
  `userlevel` varchar(20) NOT NULL DEFAULT 'Staff',
  `status` varchar(20) NOT NULL DEFAULT 'Active',
  `contact` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_id`, `f_name`, `l_name`, `username`, `email`, `password`, `date_added`, `userlevel`, `status`, `contact`) VALUES
(16, 'Uhuru', 'Kenyatta', 'Uhunye', 'uhunye@gmail.com', '1234', '2022-10-09 08:42:46', 'Finance', 'Active', '0123456789'),
(17, 'Judas', 'Isacriot', 'Betrayer', 'betrayers@gmail.com', '1234', '2022-10-09 08:44:10', 'Service manager', 'Active', '0123456788'),
(18, 'Babu', 'Owino', 'Babuu', 'ba@gmail.com', '1234', '2022-10-09 08:45:17', 'Inventory manager', 'Active', '0123456780'),
(19, 'Edmond', 'edu', 'edu', 'edu@gmail.com', '1234', '2022-10-09 08:46:11', 'Project manager', 'Active', '0123456782'),
(20, 'Donald', 'Trump', 'dona', 'tru@gmail.com', '1234', '2022-10-09 08:47:39', 'Operator', 'Active', '0123456785'),
(21, 'musa', 'amiir', 'musa', 'musa@gmail.com', '1234', '2022-10-10 07:34:09', 'Service manager', 'Active', '1234567890'),
(22, 'Brian', 'cheru', 'cheru', 'cheru@gmail.com', '1234', '2022-10-10 07:35:42', 'Inventory manager', 'Active', '1234567809'),
(23, 'Nasaba', 'Bora', 'bora', 'bo@gmail.com', '1234', '2022-10-10 07:37:22', 'Finance', 'Active', '1234567980'),
(24, 'Marcus', 'Rashford', 'Rashy', 'manu@gmail.com', '1234', '2022-10-11 08:23:01', 'Operator', 'Active', '0987654321'),
(25, 'ali', 'abu', 'ali', 'ali@gmail.com', '1234', '2022-10-11 08:26:20', 'Supervisor', 'Active', '1234567812'),
(26, 'yuri', 'mkoza', 'admin', 'mkoza@gmail.com', '1234', '2022-10-13 10:38:42', 'Admin', 'Active', '0123456785'),
(27, 'yuri', 'mkoza', 'admin', 'mkoza@gmail.com', '1234', '2022-10-13 10:38:58', 'Admin', 'Active', '0123456785');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int(30) NOT NULL,
  `event_title` varchar(34) NOT NULL,
  `event_desc` varchar(78) NOT NULL,
  `time_event` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`event_id`, `event_title`, `event_desc`, `time_event`) VALUES
(1, 'crane exhibition', 'there will be crane exhibition on 13th oct', '0000-00-00 00:00:00.000000'),
(2, 'yea', 'there will be crane exhibition on 13th oct', '0000-00-00 00:00:00.000000'),
(3, 'crane exhibition', 'there will be crane exhibition on 13th oct', '0000-00-00 00:00:00.000000'),
(4, 'yea', 'there will be crane exhibition on 13th oct', '0000-00-00 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `fb_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `feedback` text NOT NULL,
  `fb_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `client_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`fb_id`, `comment`, `feedback`, `fb_date`, `client_id`, `emp_id`) VALUES
(3, 'hey', 'Welcome', '2022-03-20 20:27:00', 10, 0),
(4, 'where', '', '2022-03-20 20:28:44', 10, 0),
(5, 'bsbsb', 'alright', '2022-10-03 09:37:03', 14, 0);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `item_id` int(11) NOT NULL,
  `stock_id` int(15) NOT NULL,
  `booking_id` int(15) NOT NULL,
  `item_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `item_status` varchar(30) NOT NULL DEFAULT 'Cart',
  `client_id` int(11) DEFAULT NULL,
  `no_of_days` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `stock_id`, `booking_id`, `item_price`, `quantity`, `item_status`, `client_id`, `no_of_days`) VALUES
(58, 17, 36, 20000, 1, 'Submitted', 14, '1'),
(59, 30, 37, 23000, 1, 'Submitted', 15, '7'),
(60, 30, 38, 23000, 1, 'Submitted', 16, '6'),
(61, 32, 39, 2300, 1, 'Submitted', 17, '3'),
(62, 30, 40, 23000, 2, 'Submitted', 18, '3'),
(63, 30, 41, 23000, 1, 'Submitted', 16, '1'),
(64, 31, 42, 4500, 1, 'Submitted', 18, '1'),
(65, 31, 43, 0, 1, 'Cart', 16, '1'),
(66, 32, 44, 2300, 1, 'Submitted', 18, '6');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `booking_id` int(15) NOT NULL,
  `mpesa_code` varchar(15) NOT NULL,
  `client_id` int(15) NOT NULL,
  `booking_cost` int(11) NOT NULL,
  `delivery_cost` int(11) NOT NULL,
  `total_cost` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `booking_id`, `mpesa_code`, `client_id`, `booking_cost`, `delivery_cost`, `total_cost`, `status`) VALUES
(12, 21, 'RHDFTGSTGD', 10, 64472, 850, 65322, 1),
(13, 22, 'CGRRGETHRD', 10, 53702, 850, 54552, 1),
(14, 23, 'DVRGRHRTGV', 10, 53702, 850, 54552, 1),
(15, 24, 'DBEVRGBTC4', 10, 53702, 850, 54552, 1),
(16, 25, 'AWERTTFG09', 11, 384678, 850, 385528, 1),
(17, 27, 'EFSVEW3FWG', 11, 116808, 850, 117658, 1),
(18, 26, 'HHHRBC69B5', 10, 20500, 850, 21350, 1),
(19, 28, 'BUBG58NTVK', 10, 24000, 850, 24850, 1),
(20, 29, 'TYGHHJ88HJ', 12, 16000, 850, 16850, 1),
(21, 30, 'JDIDJEYFKE', 12, 7500, 850, 8350, 1),
(22, 31, 'UGJVYCHS79', 12, 3000, 850, 3850, 1),
(23, 33, 'RYEYDHD4FF', 10, 3000, 850, 3850, 1),
(24, 32, 'QWERTYUI23', 12, 3000, 850, 3850, 1),
(25, 35, 'QWERTYUI45', 14, 2000, 850, 2850, 1),
(26, 36, 'QWERTYUI98', 14, 20000, 850, 20850, 1),
(27, 37, 'QWERTYUI45', 15, 161000, 850, 161850, 1),
(28, 38, 'QWERTYUI45', 16, 138000, 850, 138850, 1),
(29, 39, 'HGFDHJKN34', 17, 6900, 850, 7750, 1),
(30, 40, '12DFWERTYU', 18, 138000, 850, 138850, 1),
(31, 41, 'WERTYIHG16', 16, 23000, 850, 23850, 1),
(32, 42, 'ETDFGYUI12', 18, 4500, 850, 5350, 1),
(33, 44, 'XRTDFGTR12', 18, 13800, 850, 14650, 1);

-- --------------------------------------------------------

--
-- Table structure for table `penalty`
--

CREATE TABLE `penalty` (
  `penalty_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `remarks` text NOT NULL,
  `penalty_status` varchar(30) NOT NULL DEFAULT 'Pending payment'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penalty`
--

INSERT INTO `penalty` (`penalty_id`, `booking_id`, `amount`, `remarks`, `penalty_status`) VALUES
(1, 24, 750, 'two broken chairs', 'Pending approval'),
(2, 31, 250, 'broken chair', 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `penalty_pay`
--

CREATE TABLE `penalty_pay` (
  `pay_id` int(11) NOT NULL,
  `penalty_id` int(11) NOT NULL,
  `amount_paid` int(11) NOT NULL,
  `mpesa_code` varchar(15) NOT NULL,
  `pay_status` varchar(30) NOT NULL DEFAULT 'Pending approval'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penalty_pay`
--

INSERT INTO `penalty_pay` (`pay_id`, `penalty_id`, `amount_paid`, `mpesa_code`, `pay_status`) VALUES
(3, 2, 250, 'CDCDE3FDCX', 'Approved'),
(4, 1, 750, 'FDFRCVDFG2', 'Pending approval');

-- --------------------------------------------------------

--
-- Table structure for table `shipping`
--

CREATE TABLE `shipping` (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  `assign_status` varchar(20) NOT NULL DEFAULT 'Pending deliver',
  `return_back` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipping`
--

INSERT INTO `shipping` (`id`, `emp_id`, `booking_id`, `assign_status`, `return_back`) VALUES
(10, 12, 25, 'Delivered', ''),
(14, 11, 25, 'Delivered', 'Return confirmed'),
(15, 12, 24, 'Delivered', ''),
(16, 11, 24, 'Pending deliver', 'Pending return'),
(17, 12, 29, 'Delivered', ''),
(18, 12, 29, 'Pending deliver', 'Return confirmed'),
(19, 12, 30, 'Delivered', ''),
(20, 11, 30, 'Pending deliver', 'Pending return'),
(21, 12, 31, 'Delivered', ''),
(22, 12, 23, 'Pending deliver', ''),
(23, 12, 31, 'Pending deliver', 'Pending return'),
(24, 11, 33, 'Issued', ''),
(25, 24, 40, 'Pending deliver', ''),
(26, 24, 41, 'Issued', ''),
(27, 24, 42, 'Pending deliver', ''),
(28, 20, 44, 'Issued', '');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `capacity` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `image`, `product_name`, `price`, `stock`, `last_update`, `capacity`) VALUES
(30, '1665134500_5053.jpg', 'crane x', 23000, 4, '2022-10-18 09:22:44', '65kg'),
(31, '1665134696_8218.jpg', 'crane e', 4500, 4, '2022-10-18 08:30:30', '56kg'),
(32, '1665472869_9963.jpg', 'crane t', 2300, 1, '2022-10-18 09:01:48', '60kg'),
(33, '1666084522_7082.jpg', 'shaver', 2500, 5, '2022-10-18 09:15:22', '50kg'),
(34, '1666085207_3521.jpg', 'roller', 4500, 4, '2022-10-18 09:26:47', '45kg'),
(35, '1666085521_5204.jpg', 'truck', 2500, 5, '2022-10-18 09:32:01', '5000kg'),
(36, '1666085709_2723.jpg', 'crane heighter', 2300, 6, '2022-10-18 09:35:09', '700kg'),
(37, '1666085980_2586.jpg', 'winch', 1600, 7, '2022-10-18 09:39:40', '100kg');

-- --------------------------------------------------------

--
-- Table structure for table `towns`
--

CREATE TABLE `towns` (
  `town_id` int(11) NOT NULL,
  `town_name` varchar(50) NOT NULL,
  `county_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `towns`
--

INSERT INTO `towns` (`town_id`, `town_name`, `county_id`) VALUES
(10, 'Mavoko', 7),
(11, 'Masinga', 7),
(12, 'Yatta', 7),
(13, 'Mwala', 7),
(14, 'Wote', 6),
(15, 'Mbooni', 6),
(16, 'Kibwezi', 6),
(17, 'Mwingi', 8),
(18, 'Mutitu', 8),
(19, 'Kabati', 8),
(20, 'Kiambu town', 9),
(21, 'Limuru', 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `client_code` (`client_id`),
  ADD KEY `order_id` (`booking_id`),
  ADD KEY `client_code_2` (`client_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `counties`
--
ALTER TABLE `counties`
  ADD PRIMARY KEY (`county_id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ap_id` (`county_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `town_id` (`town_id`);

--
-- Indexes for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`fb_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `staff_id` (`emp_id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `product_code` (`stock_id`),
  ADD KEY `order_code` (`booking_id`),
  ADD KEY `order_code_2` (`booking_id`),
  ADD KEY `order_code_3` (`booking_id`),
  ADD KEY `product_id` (`stock_id`),
  ADD KEY `order_id` (`booking_id`),
  ADD KEY `pro_id` (`stock_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `order_id` (`booking_id`),
  ADD KEY `order_id_2` (`booking_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `penalty`
--
ALTER TABLE `penalty`
  ADD PRIMARY KEY (`penalty_id`),
  ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `penalty_pay`
--
ALTER TABLE `penalty_pay`
  ADD PRIMARY KEY (`pay_id`),
  ADD KEY `penalty_id` (`penalty_id`);

--
-- Indexes for table `shipping`
--
ALTER TABLE `shipping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`booking_id`),
  ADD KEY `emp_id` (`emp_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`);

--
-- Indexes for table `towns`
--
ALTER TABLE `towns`
  ADD PRIMARY KEY (`town_id`),
  ADD KEY `county_id` (`county_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `counties`
--
ALTER TABLE `counties`
  MODIFY `county_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `fb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `penalty`
--
ALTER TABLE `penalty`
  MODIFY `penalty_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `penalty_pay`
--
ALTER TABLE `penalty_pay`
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `shipping`
--
ALTER TABLE `shipping`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `towns`
--
ALTER TABLE `towns`
  MODIFY `town_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`town_id`) REFERENCES `towns` (`town_id`),
  ADD CONSTRAINT `delivery_ibfk_3` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  ADD CONSTRAINT `items_ibfk_2` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);

--
-- Constraints for table `penalty`
--
ALTER TABLE `penalty`
  ADD CONSTRAINT `penalty_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`);

--
-- Constraints for table `penalty_pay`
--
ALTER TABLE `penalty_pay`
  ADD CONSTRAINT `penalty_pay_ibfk_1` FOREIGN KEY (`penalty_id`) REFERENCES `penalty` (`penalty_id`);

--
-- Constraints for table `shipping`
--
ALTER TABLE `shipping`
  ADD CONSTRAINT `shipping_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  ADD CONSTRAINT `shipping_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`);

--
-- Constraints for table `towns`
--
ALTER TABLE `towns`
  ADD CONSTRAINT `towns_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `counties` (`county_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
