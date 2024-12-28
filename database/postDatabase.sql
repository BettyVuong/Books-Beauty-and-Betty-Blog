-- create the database
CREATE DATABASE IF NOT EXISTS blogDb;

-- use the current db
USE blogDb;

-- create a table for posts
CREATE TABLE IF NOT EXISTS posts(
  Id BIGINT AUTO_INCREMENT PRIMARY KEY,
  Category VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Date DATE NOT NULL,
  Image LONGBLOB,
  Blurb VARCHAR(255),
  Content TEXT NOT NULL
);
