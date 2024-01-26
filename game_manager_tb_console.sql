-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: game_manager
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_console`
--

DROP TABLE IF EXISTS `tb_console`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_console` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `release_year` smallint NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_console`
--

LOCK TABLES `tb_console` WRITE;
/*!40000 ALTER TABLE `tb_console` DISABLE KEYS */;
INSERT INTO `tb_console` VALUES (_binary '113e02d1-df2d-48','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Sony-PlayStation-3-2001A-wController-L.jpg/1920px-Sony-PlayStation-3-2001A-wController-L.jpg','PlayStation 3',2006,NULL),(_binary '4ffdd8cc-e64b-48','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Sony-PlayStation-4-PS4-wDualShock-4.jpg/1024px-Sony-PlayStation-4-PS4-wDualShock-4.jpg','PlayStation 4',2013,NULL),(_binary '6eac9c9d-65cf-41','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Black_and_white_Playstation_5_base_edition_with_controller.png/800px-Black_and_white_Playstation_5_base_edition_with_controller.png','PlayStation 5',2020,NULL),(_binary '6f2bb441-b956-42','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/PS2-Versions.png/1024px-PS2-Versions.png','PlayStation 2',2000,NULL),(_binary '7c67453b-314e-41','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/N64-Console-Set.png/1920px-N64-Console-Set.png','Nintendo 64',1996,NULL),(_binary 'a1899397-f94a-4a','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Xbox-360S-Console-Set.jpg/800px-Xbox-360S-Console-Set.jpg','XBOX 360',2005,NULL),(_binary 'ae832cdb-8412-43','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Sega-Mega-Drive-JP-Mk1-Console-Set.jpg/1920px-Sega-Mega-Drive-JP-Mk1-Console-Set.jpg','Mega Drive',1988,NULL),(_binary 'b51963cb-addd-4b','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/SNES-Mod1-Console-Set.jpg/1920px-SNES-Mod1-Console-Set.jpg','Super Nintendo',1990,NULL),(_binary 'c7b80f17-2d5e-46','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/PSX-Console-wController.png/1920px-PSX-Console-wController.png','PlayStation 1',1994,NULL),(_binary 'd2d67e45-0037-47','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/0/06/Nintendo-Famicom-Console-Set-FL.jpg','Nintendo',1983,NULL),(_binary 'e5082ede-2d0b-4e','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Xbox-One-Console-BR.jpg/1280px-Xbox-One-Console-BR.jpg','XBOX ONE',2013,NULL);
/*!40000 ALTER TABLE `tb_console` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-25 20:21:52
