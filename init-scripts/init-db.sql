-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: movies_db
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'Leonardo DiCaprio','1974-11-11'),(2,'Joseph Gordon-Levitt','1981-02-17'),(3,'Kate Winslet','1975-10-05'),(4,'Christian Bale','1974-01-30'),(5,'Matthew McConaughey','1969-11-04'),(6,'Meryl Streep','1949-06-22'),(7,'Tom Hanks','1956-07-09'),(8,'Denzel Washington','1954-12-28'),(9,'Cate Blanchett','1969-05-14'),(10,'Morgan Freeman','1937-06-01'),(11,'Charlize Theron','1975-08-07'),(12,'Brad Pitt','1963-12-18'),(13,'Angelina Jolie','1975-06-04'),(14,'Johnny Depp','1963-06-09'),(15,'Scarlett Johansson','1984-11-22'),(16,'Will Smith','1968-09-25'),(17,'Jennifer Lawrence','1990-08-15'),(18,'Matt Damon','1970-10-08'),(19,'Julia Roberts','1967-10-28'),(20,'Keanu Reeves','1964-09-02'),(21,'Nicole Kidman','1967-06-20'),(22,'Robert Downey Jr.','1965-04-04'),(23,'Tom Cruise','1962-07-03'),(24,'Dwayne Johnson','1972-05-02'),(25,'Emma Stone','1988-11-06'),(26,'Ryan Reynolds','1976-10-23'),(27,'Hugh Jackman','1968-10-12'),(28,'Jessica Chastain','1977-03-24'),(29,'Bradley Cooper','1975-01-05'),(30,'Amy Adams','1974-08-20'),(31,'Chris Hemsworth','1983-08-11'),(32,'Chris Evans','1981-06-13'),(33,'Sofia Vergara','1972-07-10'),(34,'Renee Zellweger','1969-04-25'),(35,'Keira Knightley','1985-03-26'),(36,'Natalie Portman','1981-06-09'),(37,'Harrison Ford','1942-07-13'),(38,'Ellen DeGeneres','1958-01-26'),(39,'Sharon Stone','1958-03-10'),(40,'Morgan Freeman','1937-06-01'),(41,'Emma Watson','1990-04-15'),(42,'Benedict Cumberbatch','1976-07-19'),(44,'Rachel McAdams','1978-11-17'),(45,'Mark Ruffalo','1967-11-22'),(46,'Paul Rudd','1969-04-06'),(47,'Anne Hathaway','1982-11-12'),(48,'Joaquin Phoenix','1974-10-28'),(49,'Daniel Day-Lewis','1957-04-29'),(50,'Tom Hiddleston','1981-02-09'),(51,'Sandra Bullock','1964-07-26'),(52,'Lupita Nyong\'o','1983-03-01'),(53,'Idris Elba','1972-09-06'),(54,'Mark Wahlberg','1971-06-05');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor_country`
--

DROP TABLE IF EXISTS `actor_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor_country` (
  `actor_id` int NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`actor_id`,`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_country`
--

LOCK TABLES `actor_country` WRITE;
/*!40000 ALTER TABLE `actor_country` DISABLE KEYS */;
INSERT INTO `actor_country` VALUES (1,1),(2,1),(3,5),(4,5),(5,1),(6,1),(54,1);
/*!40000 ALTER TABLE `actor_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `score` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (9,'comentario','2024-12-18 23:00:00',10),(10,'la mejor pelicula del mundo.','2024-12-18 23:00:00',10);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_movie`
--

DROP TABLE IF EXISTS `comment_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_movie` (
  `movie_id` int NOT NULL,
  `comment_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_movie`
--

LOCK TABLES `comment_movie` WRITE;
/*!40000 ALTER TABLE `comment_movie` DISABLE KEYS */;
INSERT INTO `comment_movie` VALUES (1,10),(11,9);
/*!40000 ALTER TABLE `comment_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_user`
--

DROP TABLE IF EXISTS `comment_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_user` (
  `user_id` int NOT NULL,
  `comment_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`comment_id`),
  KEY `comment_id` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_user`
--

LOCK TABLES `comment_user` WRITE;
/*!40000 ALTER TABLE `comment_user` DISABLE KEYS */;
INSERT INTO `comment_user` VALUES (1,9),(1,10);
/*!40000 ALTER TABLE `comment_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Estados Unidos','US','2024-11-16 16:10:18','2024-11-16 16:10:18'),(2,'Canada','CA','2024-11-16 16:10:45','2024-11-16 16:10:45'),(3,'España','ES','2024-11-16 16:10:52','2024-11-16 16:10:52'),(4,'Mexico','MX','2024-11-16 16:11:03','2024-11-16 16:11:31'),(5,'Reino Unido','UK','2024-11-16 16:11:03','2024-11-16 16:11:31');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `year` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `synopsis` text,
  `cover_img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Inception','Sci-Fi',2010,148,'Christopher Nolan','Cobb roba información de sus objetivos entrando en sus sueños. Se le busca por su presunto papel en el asesinato de su esposa y su única posibilidad de redención es realizar una tarea casi imposible.','https://m.media-amazon.com/images/M/MV5BMjExMjkwNTQ0Nl5BMl5BanBnXkFtZTcwNTY0OTk1Mw@@._V1_.jpg'),(2,'Titanic','Romance',1997,200,'James Cameron','Rose, que se ve obligada a casarse con un hombre rico, se enamora de Jack, un artista talentoso, a bordo del insumergible Titanic. Desafortunadamente, el barco choca contra un iceberg, poniendo en peligro sus vidas.','https://m.media-amazon.com/images/M/MV5BYzYyN2FiZmUtYWYzMy00MzViLWJkZTMtOGY1ZjgzNWMwN2YxXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),(3,'The Dark Knight','Accion',2008,152,'Christopher Nolan','Batman tiene un nuevo enemigo, el Joker, que es un criminal consumado empeñado en diezmar Gotham City. Junto con Gordon y Harvey Dent, Batman lucha por frustrar al Joker antes de que sea demasiado tarde.','https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UX1000_.jpg'),(5,'Interstellar','Sci-Fi',2014,169,'Christopher Nolan','Cuando la Tierra se vuelve inhabitable en el futuro, un granjero y ex piloto de la NASA, Joseph Cooper, tiene la tarea de pilotear una nave espacial, junto con un equipo de investigadores, para encontrar un nuevo planeta para los humanos.','https://m.media-amazon.com/images/M/MV5BYzdjMDAxZGItMjI2My00ODA1LTlkNzItOWFjMDU5ZDJlYWY3XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),(11,'Deadpool & Wolverine','Accion',2024,125,'Shawn Levy','La pacífica existencia de Deadpool se derrumba cuando la Time Variance Authority lo recluta para ayudar a salvaguardar el multiverso. Pronto se une a su posible amigo, Wolverine, para completar la misión y salvar su mundo de una amenaza existencial.','https://m.media-amazon.com/images/M/MV5BZTk5ODY0MmQtMzA3Ni00NGY1LThiYzItZThiNjFiNDM4MTM3XkEyXkFqcGc@._V1_.jpg'),(12,'Meet Joe Black','Romance/Fantasia',1998,181,'Martin Brest','Disfrazado de humano, Grim Reaper Joe Black llega a la Tierra para escoltar el alma del magnate de los medios William Parrish. Pero el fascinante viaje de Joe termina cuando se enamora de la hija de William.','https://upload.wikimedia.org/wikipedia/en/f/f5/Meet_Joe_Black-_1998.jpg'),(14,'The Pianist','Drama',2002,150,'Roman Polanski','Durante la Segunda Guerra Mundial, el aclamado músico polaco Wladyslaw se enfrenta a varias luchas mientras pierde el contacto con su familia. A medida que la situación empeora, se esconde en las ruinas de Varsovia para sobrevivir.','https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p30193_p_v13_aa.jpg'),(15,'The Other Guys','Comedia',2010,107,'Adam McKay','A dos policías caídos en desgracia, Terry y Allen, se les asigna la tarea de investigar un caso que involucra a un capitalista turbio. Deben dejar de lado sus diferencias y convertirse en los oficiales que idolatran.','https://m.media-amazon.com/images/M/MV5BODU1OTY5ZTYtNWQ0MC00ZWE1LTkyYjEtZTI2ODM1ZGE2MjBkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),(25,'Wrath of the Titans','Accion/Aventura',2012,99,'Jonathan Liebesman','Perseo, un semidiós, tiene que rescatar a su padre, Zeus, que está cautivo de Ares y Hades. Sin embargo, tiene que derrotar no sólo a su hermano y a su tío sino también a los Titanes con los que se han asociado.','https://m.media-amazon.com/images/M/MV5BMjMyMzk1Nzg3OF5BMl5BanBnXkFtZTcwOTQ2NjcxNw@@._V1_.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_actor` (
  `movie_id` bigint NOT NULL,
  `actor_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`actor_id`),
  KEY `actor_id` (`actor_id`),
  CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movie_actor_ibfk_2` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` VALUES (1,1),(2,1),(1,2),(3,4),(5,5),(11,26),(11,27),(3,47);
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_country`
--

DROP TABLE IF EXISTS `movie_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_country` (
  `movie_id` int NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_country`
--

LOCK TABLES `movie_country` WRITE;
/*!40000 ALTER TABLE `movie_country` DISABLE KEYS */;
INSERT INTO `movie_country` VALUES (1,1),(2,1),(3,1),(5,1),(11,2),(12,1),(14,5),(15,1),(19,1),(20,1),(21,1),(22,1),(25,1);
/*!40000 ALTER TABLE `movie_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Test Namer','$2a$10$IpMoeFqsyFB3Ucdv4fPbKOwS4dniLkbxdYVXwAW86szHGNqiqym3y','test1@test.com'),(2,'Test Name','$2a$10$IpMoeFqsyFB3Ucdv4fPbKOwS4dniLkbxdYVXwAW86szHGNqiqym3y','test2@test.com'),(7,'Test User','$2a$10$fhmQyxrhhVBMWJ8JkhUhnuP8TkC/pgqhgpsDJdkvAjmZKV7CaTqfy','test3_user@test.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(1,2),(7,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-26 16:01:02
