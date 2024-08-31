-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 11:42 AM
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
-- Database: `panafricalogistics`
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
(21, 10, '29-3-2022', NULL, 'Pending approval', '2021-10-22 14:23:43', NULL, 6, 15, 'nhtt', '696'),
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
(32, 12, '29-3-2022', NULL, 'Cart', NULL, NULL, NULL, NULL, NULL, NULL),
(33, 10, '29-3-2022', NULL, 'Shipping', '2022-03-19 03:59:15', NULL, 9, 20, 'nhtt', '696');

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
(14, 6, 15, 12, '55555', 'Near Posta');

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
(15, 'musa', 'amir', 'musa', 'musa@gmail.com', '1234', '2022-10-25 09:57:46', 'Finance', 'Active', '1234567890'),
(16, 'Edmond', 'edy', 'edy', 'edy@gmail.com', '1234', '2022-10-25 10:05:19', 'Stock manager', 'Active', '1234567809'),
(17, 'cheru', 'brian', 'cheru', 'cheru@gmail.com', '1234', '2022-10-25 10:06:18', 'Trainee', 'Active', '0987654321'),
(18, 'kevin', 'kevo', 'kevo', 'kevo@gmail.com', '1234', '2022-10-25 10:09:43', 'Driver', 'Active', '1234567834'),
(19, 'felix', 'felo', 'felo', 'kevoh@gmail.com', '12345', '2022-10-25 10:10:48', 'Service manger', 'Active', '1234509876'),
(20, 'lydia', 'lily', 'lily', 'lil@gmail.com', '1234', '2022-10-25 10:12:20', 'Service manager', 'Active', '0987654123'),
(21, 'jean', 'pierre', 'jean', 'jean@gmail.com', '1234', '2022-10-25 10:14:35', 'Technician', 'Active', '12345567890');

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
(4, 'where', '', '2022-03-20 20:28:44', 10, 0);

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
(34, 11, 21, 2154, 2, 'Submitted', 10, '3'),
(35, 12, 21, 2154, 1, 'Submitted', 10, '1'),
(36, 11, 22, 2154, 1, 'Submitted', 10, '1'),
(37, 12, 22, 2154, 1, 'Submitted', 10, '1'),
(38, 11, 23, 2154, 1, 'Submitted', 10, '1'),
(39, 12, 23, 2154, 1, 'Submitted', 10, '1'),
(40, 11, 24, 2154, 1, 'Submitted', 10, '1'),
(41, 12, 24, 2154, 1, 'Submitted', 10, '1'),
(42, 12, 25, 51548, 2, 'Submitted', 11, '3'),
(43, 11, 25, 51548, 5, 'Submitted', 11, '7'),
(44, 11, 26, 2000, 1, 'Submitted', 10, '1'),
(45, 13, 27, 7500, 15, 'Submitted', 11, '1'),
(46, 11, 27, 7500, 1, 'Submitted', 11, '2'),
(47, 12, 26, 2000, 2, 'Submitted', 10, '1'),
(48, 13, 26, 2000, 1, 'Submitted', 10, '1'),
(49, 15, 26, 2000, 1, 'Submitted', 10, '3'),
(50, 14, 28, 3000, 2, 'Submitted', 10, '4'),
(51, 11, 29, 2000, 2, 'Submitted', 12, '4'),
(52, 13, 30, 7500, 1, 'Submitted', 12, '1'),
(53, 14, 31, 3000, 1, 'Submitted', 12, '1'),
(54, 14, 32, 0, 1, 'Cart', 12, '1'),
(55, 14, 33, 3000, 1, 'Submitted', 10, '1');

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
(23, 33, 'RYEYDHD4FF', 10, 3000, 850, 3850, 1);

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
(24, 11, 33, 'Pending deliver', '');

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
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `counties`
--
ALTER TABLE `counties`
  MODIFY `county_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `fb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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
