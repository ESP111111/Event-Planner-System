-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2024 at 01:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventplanner`
--

-- --------------------------------------------------------

--
-- Table structure for table `event_category`
--

CREATE TABLE `event_category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_category`
--

INSERT INTO `event_category` (`id`, `name`) VALUES
(1, 'birthday'),
(2, 'wedding');

-- --------------------------------------------------------

--
-- Table structure for table `event_info`
--

CREATE TABLE `event_info` (
  `id` int(11) NOT NULL,
  `organizer_id` int(11) DEFAULT NULL,
  `event_category_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `event_time` time DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `no_visitor` int(11) DEFAULT NULL,
  `price_per_person` float NOT NULL,
  `no_meals` int(11) NOT NULL,
  `meal_price` float NOT NULL,
  `no_drinks` int(11) NOT NULL,
  `drink_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_info`
--

INSERT INTO `event_info` (`id`, `organizer_id`, `event_category_id`, `name`, `event_date`, `event_time`, `description`, `no_visitor`, `price_per_person`, `no_meals`, `meal_price`, `no_drinks`, `drink_price`) VALUES
(1, 6, 1, 'Rawand birthday', '2024-03-06', '18:09:00', 'Welcome all.', 400, 10, 350, 15, 350, 3);

-- --------------------------------------------------------

--
-- Table structure for table `event_meta`
--

CREATE TABLE `event_meta` (
  `id` int(11) NOT NULL,
  `event_info_id` int(11) DEFAULT NULL,
  `link` varchar(1024) DEFAULT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_place_order`
--

CREATE TABLE `event_place_order` (
  `id` int(11) NOT NULL,
  `event_info_id` int(11) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_place_order`
--

INSERT INTO `event_place_order` (`id`, `event_info_id`, `place_id`, `start_date`, `end_date`, `start_time`, `end_time`) VALUES
(4, 1, 3, '2024-03-18', '2024-03-18', '15:30:00', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `organizer`
--

CREATE TABLE `organizer` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `organizer`
--

INSERT INTO `organizer` (`id`, `user_id`) VALUES
(6, 20),
(8, 22),
(42, 51),
(76, 183),
(77, 186),
(78, 189),
(79, 192),
(80, 195),
(81, 198),
(82, 201),
(83, 204),
(84, 207),
(85, 210),
(86, 213),
(87, 216),
(88, 219),
(89, 222),
(90, 225),
(91, 228),
(92, 231),
(93, 234),
(94, 237),
(95, 240),
(96, 243),
(97, 246),
(98, 249);

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `id` int(11) NOT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `Price_per_hour` float DEFAULT NULL,
  `rate` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`id`, `vendor_id`, `name`, `location`, `capacity`, `Price_per_hour`, `rate`) VALUES
(3, 7, 'Aya', 'Nablus', 600, 1500, 5),
(4, 7, 'Oday', 'Nablus', 700, 1800, 3),
(5, 7, 'Rawand', 'Tulkarm', 3100, 1600, 2);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `visits_order_id` int(11) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `image` varchar(1024) DEFAULT NULL,
  `token` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_name`, `first_name`, `last_name`, `email`, `password`, `image`, `token`) VALUES
(1, 'Ahmad_11', 'Ahmad', 'Mohammad', 'Ahm1@example.com', 'Ahma12345', 'Asdsaddsac.jpg', 0),
(5, 'RR1', 'Ahmad', 'mohammad', 'Ahmad@gmail.com', 'ahmad12345', 'Ah', 0),
(14, 'Aya', 'Ahmad', 'mohammad', 'Ahmad@gmail.com', 'Aya11#*', 'Ah', 0),
(16, 'Oday', 'Ahmad', 'mohammad', 'Ahmad@gmail.com', 'Oday777', 'Ah', 0),
(20, 'Moh_1', 'Mohammad', 'Ali', 'Moh@gmail.com', 'moh12345', '12qa', 0),
(21, 'qq', 'ww', 'ss', 'ff@gmail.com', 'qq11111', 'ssssdddd', 0),
(22, 'ttt', 'jj', 'ddd', 'qqq@gmail.com', 'aaaa1111', 'ggffssaa', 0),
(23, 'Iiii', 'Aya', 'Aya', 'sfg@gmail.com', 'Aya11111', 'qwerwtewasd', 0),
(51, 'Rawand', 'Rawand', 'Aqel', 'Raw@gmail.com', 'Rawand123', 'sdfg', 0),
(182, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(183, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(185, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(186, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(187, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(188, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(189, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(190, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(191, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(192, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(193, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(194, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(195, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(196, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(197, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(198, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(199, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(200, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(201, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(202, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(203, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(204, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(205, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(206, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(207, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(208, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(209, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(210, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(211, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(212, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(213, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(214, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(215, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(216, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(217, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(218, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(219, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(220, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(221, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(222, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(223, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(224, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(225, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(226, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(227, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(228, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(229, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(230, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(231, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(232, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(233, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(234, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(235, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(236, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(237, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(238, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(239, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(240, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(241, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(242, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(243, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(244, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(245, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(246, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(247, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL),
(248, 'jdoe', 'John', 'Doe', 'jdoe@example.com', 'p@ssw0rd1', 'avatar.jpg', NULL),
(249, 'asmith', 'Alice', 'Smith', 'asmith@example.com', 'p@ssword2', 'avatar2.jpg', NULL),
(250, 'bwayne', 'Bruce', 'Wayne', 'bwayne@example.com', 'password3', 'avatar3.jpg', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `user_id`) VALUES
(33, 1),
(7, 14),
(50, 182),
(51, 185),
(52, 188),
(53, 191),
(54, 194),
(55, 197),
(56, 200),
(57, 203),
(58, 206),
(59, 209),
(60, 212),
(61, 215),
(62, 218),
(63, 221),
(64, 224),
(65, 227),
(66, 230),
(67, 233),
(68, 236),
(69, 239),
(70, 242),
(71, 245),
(72, 248);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`id`, `user_id`) VALUES
(1, 16),
(3, 21),
(5, 22),
(40, 187),
(41, 190),
(42, 193),
(43, 196),
(44, 199),
(45, 202),
(46, 205),
(47, 208),
(48, 211),
(49, 214),
(50, 217),
(51, 220),
(52, 223),
(53, 226),
(54, 229),
(55, 232),
(56, 235),
(57, 238),
(58, 241),
(59, 244),
(60, 247),
(61, 250);

-- --------------------------------------------------------

--
-- Table structure for table `visits_order`
--

CREATE TABLE `visits_order` (
  `id` int(11) NOT NULL,
  `visitor_id` int(11) DEFAULT NULL,
  `event_info_id` int(11) DEFAULT NULL,
  `no_persons` int(11) DEFAULT NULL,
  `VIP` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event_category`
--
ALTER TABLE `event_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `event_info`
--
ALTER TABLE `event_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `organizer_id` (`organizer_id`),
  ADD KEY `event_category_id` (`event_category_id`);

--
-- Indexes for table `event_meta`
--
ALTER TABLE `event_meta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `event_info_id` (`event_info_id`);

--
-- Indexes for table `event_place_order`
--
ALTER TABLE `event_place_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `event_info_id` (`event_info_id`),
  ADD KEY `place_id` (`place_id`);

--
-- Indexes for table `organizer`
--
ALTER TABLE `organizer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vendor_id` (`vendor_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `visits_order_id` (`visits_order_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `visits_order`
--
ALTER TABLE `visits_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `visitor_id` (`visitor_id`),
  ADD KEY `event_info_id` (`event_info_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event_category`
--
ALTER TABLE `event_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `event_info`
--
ALTER TABLE `event_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `event_meta`
--
ALTER TABLE `event_meta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `event_place_order`
--
ALTER TABLE `event_place_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `organizer`
--
ALTER TABLE `organizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `visits_order`
--
ALTER TABLE `visits_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `event_info`
--
ALTER TABLE `event_info`
  ADD CONSTRAINT `event_info_ibfk_1` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_info_ibfk_2` FOREIGN KEY (`event_category_id`) REFERENCES `event_category` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `event_meta`
--
ALTER TABLE `event_meta`
  ADD CONSTRAINT `event_meta_ibfk_1` FOREIGN KEY (`event_info_id`) REFERENCES `event_info` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `event_place_order`
--
ALTER TABLE `event_place_order`
  ADD CONSTRAINT `event_place_order_ibfk_1` FOREIGN KEY (`event_info_id`) REFERENCES `event_info` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_place_order_ibfk_2` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `organizer`
--
ALTER TABLE `organizer`
  ADD CONSTRAINT `organizer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `place`
--
ALTER TABLE `place`
  ADD CONSTRAINT `place_ibfk_1` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`visits_order_id`) REFERENCES `visits_order` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `vendor`
--
ALTER TABLE `vendor`
  ADD CONSTRAINT `vendor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `visitor`
--
ALTER TABLE `visitor`
  ADD CONSTRAINT `visitor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `visits_order`
--
ALTER TABLE `visits_order`
  ADD CONSTRAINT `visits_order_ibfk_1` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `visits_order_ibfk_2` FOREIGN KEY (`event_info_id`) REFERENCES `event_info` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
