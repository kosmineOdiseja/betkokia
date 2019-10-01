-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2019 at 12:50 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `links`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategorijos`
--

CREATE TABLE `kategorijos` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(256) COLLATE utf8_lithuanian_ci NOT NULL,
  `id_parent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nuorodos`
--

CREATE TABLE `nuorodos` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(256) COLLATE utf8_lithuanian_ci NOT NULL,
  `laikas` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `link` varchar(1024) COLLATE utf8_lithuanian_ci NOT NULL,
  `kategorijos_id` int(10) UNSIGNED NOT NULL,
  `tipas` enum('html','audio','video','file') COLLATE utf8_lithuanian_ci NOT NULL DEFAULT 'html',
  `rating` int(11) NOT NULL,
  `flags` enum('super','reikia_analizuoti','fragmentai','kita') COLLATE utf8_lithuanian_ci NOT NULL DEFAULT 'kita',
  `aprasymas` text COLLATE utf8_lithuanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nuorodos_zymos`
--

CREATE TABLE `nuorodos_zymos` (
  `id` int(10) UNSIGNED NOT NULL,
  `zymos_id` int(10) UNSIGNED NOT NULL,
  `nuorodos_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `zymos`
--

CREATE TABLE `zymos` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(32) COLLATE utf8_lithuanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategorijos`
--
ALTER TABLE `kategorijos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_parent` (`id_parent`);

--
-- Indexes for table `nuorodos`
--
ALTER TABLE `nuorodos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kategorijos_id` (`kategorijos_id`);

--
-- Indexes for table `nuorodos_zymos`
--
ALTER TABLE `nuorodos_zymos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nuorodos_id` (`nuorodos_id`),
  ADD KEY `zymos_id` (`zymos_id`);

--
-- Indexes for table `zymos`
--
ALTER TABLE `zymos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategorijos`
--
ALTER TABLE `kategorijos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nuorodos`
--
ALTER TABLE `nuorodos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nuorodos_zymos`
--
ALTER TABLE `nuorodos_zymos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `zymos`
--
ALTER TABLE `zymos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nuorodos_zymos`
--
ALTER TABLE `nuorodos_zymos`
  ADD CONSTRAINT `nuorodos_zymos_ibfk_1` FOREIGN KEY (`nuorodos_id`) REFERENCES `nuorodos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nuorodos_zymos_ibfk_2` FOREIGN KEY (`zymos_id`) REFERENCES `zymos` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
