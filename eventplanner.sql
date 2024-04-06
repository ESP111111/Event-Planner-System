-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2024 at 10:55 PM
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
(2, 'wedding'),
(3, 'barbecue');

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
(11, 42, 3, 'Ev1', '2024-04-07', '22:00:00', 'Hii', 3000, 3, 1500, 2, 2000, 1),
(13, 42, 2, 'Week_end', '2024-04-07', '19:00:00', 'sadsad', 100, 3, 90, 1, 130, 1),
(14, 42, 1, 'EV2', '2024-05-03', '14:26:00', 'RRRRRRRRRRRRRRRRR', 1000, 1, 900, 2, 1000, 1),
(15, 42, 3, 'EVV3', '2024-04-10', '03:00:00', 'erwsf', 400, 1, 66, 1, 88, 1),
(62, 42, 2, 'My_Event', '2024-04-08', '08:00:00', 'wrestgdfbvqweghnfv', 700, 1, 500, 2.5, 1500, 1),
(67, 42, 1, 'EEE', '2024-04-08', '05:00:00', 'weqwrfed', 600, 1, 900, 2.5, 1800, 1),
(77, 42, 1, 'Test', '2024-04-15', '10:30:00', 'Hello', 1300, 2.5, 1100, 1.5, 1700, 1);

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

--
-- Dumping data for table `event_meta`
--

INSERT INTO `event_meta` (`id`, `event_info_id`, `link`, `type`) VALUES
(7, 11, 'SSSSSSSSSS', 1),
(44, 11, 'JJJJJ.mb4', 2),
(49, 67, 'dadfsd.png', 1),
(50, 67, 'asfdgsfghdf', 2),
(54, 11, 'ABC.png', 1),
(55, 11, 'ABC.png', 1),
(56, 11, 'ABC.png', 1),
(57, 11, 'ABC.png', 1),
(58, 11, 'ABC.png', 1),
(59, 11, 'ABC.png', 1),
(60, 11, 'ABC.png', 1);

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
(7, 11, 3, '2024-04-07', '2024-04-09', '22:00:00', '11:00:00'),
(9, 14, 3, '2024-05-03', '2024-05-03', '14:26:00', '22:00:00'),
(10, 15, 3, '2024-04-10', '2024-04-11', '03:00:00', '23:00:00'),
(11, 62, 4, '2024-04-08', '2024-04-09', '08:00:00', '21:00:00');

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
(42, 51);

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
(3, 7, '7alt_Nablus', 'Nablus', 1000, 1500, 5),
(4, 7, 'AL_Qal3a', 'Nablus', 3600, 6000, 3),
(5, 7, 'Ballur', 'Tulkarm', 3300, 4500, 2),
(88, 7, 'ROSE', 'Tulkarm', 3400, 5000, 4),
(92, 7, 'NewPP', 'Nablus', 800, 900, 3),
(98, 7, 'NewPP', 'Nablus', 800, 900, 3);

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
(5, 'Ramy1', 'Ramy', 'mohammad', 'Ahmad@gmail.com', 'ahmad12345', 'R.png', 0),
(14, 'Aya', 'Aya', 'Ahmad', 'Ahmad@gmail.com', 'Aya12345', 'Aqq.png', 0),
(16, 'Oday', 'Oday', 'mohammad', 'Ahmad@gmail.com', 'Oday777', 'Ah.png', 0),
(20, 'Moh_1', 'Mohammad', 'Ali', 'Moh@gmail.com', 'moh12345', '12qa.png', 0),
(21, 'Dana_9', 'Dana', 'Mohammad', 'Dana@gmail.com', 'DDDd5555', 'My.jpg', 0),
(22, 'Saly5', 'Saly', 'Ali', 'SS@gmail.com', 'SS11111', 'Im.png', 0),
(23, 'Ali_A', 'Ali', 'Ali', 'sfg@gmail.com', 'Ali11111', 'A.png', 0),
(51, 'Rawand', 'Rawand', 'Aqel', 'RRR@gmail.com', 'Rawand123', 'Ima.png', 0),
(577, 'AA', 'AB', 'AC', 'AA@gmail.com', 'AA12345', 'qq.png', 0);

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
(7, 14);

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
(175, 1),
(177, 5),
(1, 16),
(3, 21),
(5, 22),
(178, 23);

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
-- Dumping data for table `visits_order`
--

INSERT INTO `visits_order` (`id`, `visitor_id`, `event_info_id`, `no_persons`, `VIP`) VALUES
(45, 1, 67, 6, 0),
(46, 3, 67, 4, 1),
(47, 5, 67, 1, 0),
(53, 1, 11, 2, 1),
(54, 3, 11, 7, 0),
(55, 5, 11, 1, 1),
(56, 175, 11, 3, 0),
(57, 177, 14, 5, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `event_info`
--
ALTER TABLE `event_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `event_meta`
--
ALTER TABLE `event_meta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `event_place_order`
--
ALTER TABLE `event_place_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `organizer`
--
ALTER TABLE `organizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=218;

--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=608;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=193;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=184;

--
-- AUTO_INCREMENT for table `visits_order`
--
ALTER TABLE `visits_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

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
