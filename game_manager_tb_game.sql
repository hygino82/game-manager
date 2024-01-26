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
-- Table structure for table `tb_game`
--

DROP TABLE IF EXISTS `tb_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_game` (
  `id` binary(16) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `personal_code` varchar(255) DEFAULT NULL,
  `release_year` int DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  `console_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9ewb7pm6t4oxor4un9gt4tmbr` (`console_id`),
  CONSTRAINT `FK9ewb7pm6t4oxor4un9gt4tmbr` FOREIGN KEY (`console_id`) REFERENCES `tb_console` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_game`
--

LOCK TABLES `tb_game` WRITE;
/*!40000 ALTER TABLE `tb_game` DISABLE KEYS */;
INSERT INTO `tb_game` VALUES (_binary '020c2418-c2c4-45','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/thumb/b/b1/Mortal_Kombat_Logo.svg/1024px-Mortal_Kombat_Logo.svg.png','Mortal Kombat 1',NULL,1992,NULL,_binary 'ae832cdb-8412-43'),(_binary '0f5bb4c2-14f0-44','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/pt/a/ad/Black_cover_art.jpg','Black',NULL,2006,NULL,_binary '6f2bb441-b956-42'),(_binary '15a1c3b4-0d98-49','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/thumb/0/02/CoD_Black_Ops_cover.png/220px-CoD_Black_Ops_cover.png','Call of Duty Black Ops',NULL,2010,NULL,_binary '113e02d1-df2d-48'),(_binary '17d27e61-814b-47','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/b/b1/Black_Ops_3.jpg','Call of Duty Black Ops III',NULL,2015,NULL,_binary '113e02d1-df2d-48'),(_binary '22042d12-3cda-48','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/0/0e/Comix_Zone_Coverart.png','Comix Zone',NULL,1995,NULL,_binary 'ae832cdb-8412-43'),(_binary '3c240c8e-0e44-49','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/pt/6/6c/Sonic_the_Hedgehog_3_capa.png','Sonic the Hedgehog 3',NULL,1994,NULL,_binary 'ae832cdb-8412-43'),(_binary '3d166ea3-b56e-4b','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/pt/b/bc/Gran_Turismo_6_capa.png','Gran Turismo 6',NULL,2013,NULL,_binary '113e02d1-df2d-48'),(_binary '4064d4dc-0f60-42','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/c/c8/Bloody_Roar_3_Coverart.png','Blood Roar 3',NULL,2000,NULL,_binary '6f2bb441-b956-42'),(_binary '40ca3736-5a04-40','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/f/f9/Ultimate_MK3.png','Ultimate Mortal Kombat 3',NULL,1995,NULL,_binary 'ae832cdb-8412-43'),(_binary '573e99df-65b6-41','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/9/9e/Mortal_Kombat_3_cover.JPG','Mortal Kombat 3',NULL,1995,NULL,_binary 'ae832cdb-8412-43'),(_binary '69696295-c4ea-43','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/8/8b/God_of_War_III_cover_art.jpg','God of War III',NULL,2010,NULL,_binary '113e02d1-df2d-48'),(_binary '6cfd1f42-0a37-40','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/8/8b/GT5-boxart-final-EU.jpg','Gran Turismo 5',NULL,2010,NULL,_binary '113e02d1-df2d-48'),(_binary '79a852f3-aa15-45','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/d/df/Mortal_Kombat_II_boxart.png','Mortal Kombat 2',NULL,1993,NULL,_binary 'ae832cdb-8412-43'),(_binary '836912c9-96f7-45','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/8/8d/Dark_Souls_Cover_Art.jpg','Dark Souls',NULL,2011,NULL,_binary '113e02d1-df2d-48'),(_binary '9b0d50e9-50a7-4c','2024-01-15 23:40:41.045219','https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg','Super Mario World',NULL,1990,NULL,_binary 'b51963cb-addd-4b'),(_binary 'c7af96b5-dc9b-42','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/0/05/Call_of_Duty_Black_Ops_II_box_artwork.png','Call of Duty Black Ops II',NULL,2012,NULL,_binary '113e02d1-df2d-48'),(_binary 'cdedad45-e403-45','2024-01-21 23:40:41.045219','https://www.lukiegames.com/assets/images/PS3/ps3_dark_souls_ii_scholar_of_p_ttkbt9.jpg','Dark Souls II: Scholar of the First Sin',NULL,2015,NULL,_binary '113e02d1-df2d-48'),(_binary 'ce41ac71-bfcc-46','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/e/ed/Dark_Souls_II_cover.jpg','Dark Souls II',NULL,2014,NULL,_binary '113e02d1-df2d-48'),(_binary 'd07a5be8-acb7-40','2024-01-21 23:40:41.045219','https://upload.wikimedia.org/wikipedia/en/9/9c/Call_of_duty_ghosts_box_art.jpg','Call of Duty Ghosts',NULL,2013,NULL,_binary '113e02d1-df2d-48');
/*!40000 ALTER TABLE `tb_game` ENABLE KEYS */;
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
