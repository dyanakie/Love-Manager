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

-- Dumping data for table lovemanager.active: ~1 rows (approximately)
DELETE FROM `active`;
/*!40000 ALTER TABLE `active` DISABLE KEYS */;
INSERT INTO `active` (`id`, `activeId`, `name`) VALUES
	(1, 2, 'bache Kiko');
/*!40000 ALTER TABLE `active` ENABLE KEYS */;

-- Dumping data for table lovemanager.character: ~0 rows (approximately)
DELETE FROM `character`;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` (`characterId`, `level`, `userId`, `knowledge`, `intelligence`, `physique`, `vehicle`, `outfit`, `accessories`, `itemsOwnedId`) VALUES
	(1, 0, 2, 0, 0, 0, NULL, NULL, NULL, '0');
/*!40000 ALTER TABLE `character` ENABLE KEYS */;

-- Dumping data for table lovemanager.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `characterId`) VALUES
	(1, 'drago', '123', NULL),
	(2, 'bache Kiko', '123', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
