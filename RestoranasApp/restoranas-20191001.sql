-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2019 m. Spa 01 d. 12:46
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
-- Database: `restoranas`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `kliento_informacija`
--

CREATE TABLE `kliento_informacija` (
  `id` int(10) UNSIGNED NOT NULL,
  `vardas` text COLLATE utf8_lithuanian_ci NOT NULL,
  `pavarde` text COLLATE utf8_lithuanian_ci NOT NULL,
  `vartoja_alk_ger` tinyint(3) UNSIGNED DEFAULT NULL,
  `alerg_ries` tinyint(3) UNSIGNED DEFAULT NULL,
  `alerg_pien_pro` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `klientu_uzsakymai`
--

CREATE TABLE `klientu_uzsakymai` (
  `id` int(10) NOT NULL,
  `apsilankymas` int(10) NOT NULL,
  `meniu_id` int(10) NOT NULL,
  `klientas_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `restorano_meniu`
--

CREATE TABLE `restorano_meniu` (
  `id` int(10) NOT NULL,
  `patiekalas` varchar(255) COLLATE utf8_lithuanian_ci NOT NULL,
  `sud_yra_ries` tinyint(3) UNSIGNED NOT NULL,
  `sud_yra_pien` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kliento_informacija`
--
ALTER TABLE `kliento_informacija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klientu_uzsakymai`
--
ALTER TABLE `klientu_uzsakymai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restorano_meniu`
--
ALTER TABLE `restorano_meniu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kliento_informacija`
--
ALTER TABLE `kliento_informacija`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `klientu_uzsakymai`
--
ALTER TABLE `klientu_uzsakymai`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `restorano_meniu`
--
ALTER TABLE `restorano_meniu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
