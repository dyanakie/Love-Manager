-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for lovemanager
CREATE DATABASE IF NOT EXISTS `lovemanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lovemanager`;

-- Dumping structure for table lovemanager.active
CREATE TABLE IF NOT EXISTS `active` (
  `id` int(11) NOT NULL DEFAULT 1,
  `activeId` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `characterId` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lovemanager.active: ~0 rows (approximately)
/*!40000 ALTER TABLE `active` DISABLE KEYS */;
INSERT INTO `active` (`id`, `activeId`, `name`, `characterId`) VALUES
	(1, 0, 'drago', 61);
/*!40000 ALTER TABLE `active` ENABLE KEYS */;

-- Dumping structure for table lovemanager.character
CREATE TABLE IF NOT EXISTS `character` (
  `characterId` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL DEFAULT 0,
  `userId` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `intelligence` int(11) NOT NULL DEFAULT 0,
  `physique` int(11) NOT NULL DEFAULT 0,
  `vehicle` varchar(50) DEFAULT 'None',
  `outfit` varchar(50) DEFAULT 'None',
  `accessories` varchar(50) DEFAULT 'None',
  `itemsOwnedId` varchar(50) NOT NULL DEFAULT '0',
  `usedGirls` varchar(200) DEFAULT '""',
  PRIMARY KEY (`characterId`),
  KEY `FK_character_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

-- Dumping data for table lovemanager.character: ~0 rows (approximately)
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
/*!40000 ALTER TABLE `character` ENABLE KEYS */;

-- Dumping structure for table lovemanager.girl
CREATE TABLE IF NOT EXISTS `girl` (
  `id` int(11) DEFAULT 1,
  `name` varchar(50) DEFAULT '1',
  `type` varchar(50) DEFAULT '1',
  `pic` varchar(50) DEFAULT '1',
  `presentation` varchar(200) DEFAULT '1',
  `level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lovemanager.girl: ~0 rows (approximately)
/*!40000 ALTER TABLE `girl` DISABLE KEYS */;
INSERT INTO `girl` (`id`, `name`, `type`, `pic`, `presentation`, `level`) VALUES
	(1, 'Elizabeth', 'status', '/pics/girls/Elizabeth.jpg', 'You find Elizabeth at a business conference.She is a manager of a successful Real Estate company...', 2);
/*!40000 ALTER TABLE `girl` ENABLE KEYS */;

-- Dumping structure for table lovemanager.item
CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `picUrl` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `statsType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lovemanager.item: ~0 rows (approximately)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `name`, `picUrl`, `type`, `bonus`, `level`, `statsType`) VALUES
	(1, 'sunglasses', '/pics/items/accessories/glasses.png', 'accessories', 1, 1, 'physique');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table lovemanager.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `characterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_character` (`characterId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table lovemanager.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `characterId`) VALUES
	(13, 'drago', '022113$3', 61);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
