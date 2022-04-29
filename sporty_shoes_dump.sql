-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: sporty_shoes
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `status` varchar(80) DEFAULT NULL,
  `user_id` varchar(80) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `product_product_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `product_id_idx` (`product_id`),
  KEY `fk_order_id_idx` (`user_id`),
  KEY `FK28pbu5jl0w5do6m72yj1echht` (`product_product_id`),
  CONSTRAINT `FK28pbu5jl0w5do6m72yj1echht` FOREIGN KEY (`product_product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2022-04-26','2022-04-29','in transit','ritankar@gmail.com',3,NULL),(2,'2022-04-27','2022-04-30','in transit','ritankar@gmail.com',1,NULL),(3,'2022-04-27','2022-04-30','in transit','ritankar@gmail.com',1,NULL),(4,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',2,NULL),(5,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',2,NULL),(6,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',2,NULL),(8,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',2,NULL),(9,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',2,NULL),(10,'2022-04-28','2022-05-01','in transit','ritankar@gmail.com',1,NULL),(12,'2022-04-29','2022-05-02','in transit','ritankar@gmail.com',1,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_number` varchar(80) DEFAULT NULL,
  `product_name` varchar(80) DEFAULT NULL,
  `product_price` double(11,2) DEFAULT NULL,
  `product_quantity` int DEFAULT NULL,
  `product_vendor` varchar(80) DEFAULT NULL,
  `product_category` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'T-kids-101','Kids Walker',1320.00,6,'Ritesh Enterprise','Kids'),(2,'T-Mens-908','Men\'s Adidas Shoes',670.00,17,'Bahadur company','Mens'),(3,'T-Kids-103','Kids Socks',310.00,57,'Raj Traders','Kids'),(5,'T-women-790','Women Sandals',2999.00,21,'Deshmukh Enterprise','Women');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(80) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `type` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin@gmail.com','admin@1234','Mahesh Singh','admin'),('ritankar@gmail.com','qwerty@123456','Ritankar','customer'),('ritankar@yahoo.com','qwerty@123','Ritankar Ganguly','customer');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 10:59:23
