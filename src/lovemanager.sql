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

-- Dumping data for table lovemanager.active: ~0 rows (approximately)
DELETE FROM `active`;
/*!40000 ALTER TABLE `active` DISABLE KEYS */;
INSERT INTO `active` (`id`, `activeId`, `name`, `characterId`) VALUES
	(1, 16, 'palermo', 0);
/*!40000 ALTER TABLE `active` ENABLE KEYS */;

-- Dumping data for table lovemanager.character: ~2 rows (approximately)
DELETE FROM `character`;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` (`characterId`, `level`, `userId`, `knowledge`, `intelligence`, `physique`, `vehicle`, `outfit`, `accessories`, `itemsOwnedId`) VALUES
	(17, 0, 14, 0, 0, 0, NULL, NULL, NULL, '0'),
	(18, 0, 15, 0, 0, 0, NULL, NULL, NULL, '0'),
	(19, 0, 16, 0, 0, 0, NULL, NULL, NULL, '0');
/*!40000 ALTER TABLE `character` ENABLE KEYS */;

-- Dumping data for table lovemanager.user: ~2 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `characterId`) VALUES
	(14, 'caesar', '123', 17),
	(15, 'mohamed', '123', 18),
	(16, 'palermo', '123', 19);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
