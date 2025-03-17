-- Database Creation
CREATE DATABASE maek_tion;
USE maek_tion;
-- Table client creation
CREATE TABLE client(
username VARCHAR(255) PRIMARY KEY,
client_name VARCHAR(255),
client_password VARCHAR(255) NOT NULL,
age INT
);
-- Table task creation
CREATE TABLE task(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description VARCHAR(255),
due_date DATE,
state ENUM('pending', 'completed') DEFAULT 'pending',
username VARCHAR(255),
FOREIGN KEY (username) REFERENCES client(username) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Table category creation
CREATE TABLE category(
id INT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(255) UNIQUE,
category_description VARCHAR(255)
);
-- Table tag creation
CREATE TABLE tag (
id INT AUTO_INCREMENT PRIMARY KEY,
tag_name VARCHAR(255) UNIQUE
);
-- Table task_tag creation
CREATE TABLE task_tag(
task_id INT,
tag_id INT,
PRIMARY KEY (task_id, tag_id),
FOREIGN KEY (task_id) REFERENCES task(id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (tag_id) REFERENCES tag(id) ON UPDATE CASCADE ON DELETE CASCADE
);




