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
-- Table category creation
CREATE TABLE category(
category_name VARCHAR(255) UNIQUE PRIMARY KEY,
category_description VARCHAR(255)
);
-- Table task creation
CREATE TABLE task(
id INT AUTO_INCREMENT PRIMARY KEY,
task_name VARCHAR(255) NOT NULL,
task_description VARCHAR(255),
due_date DATE,
task_state ENUM('PENDING', 'COMPLETED') DEFAULT 'PENDING',
username VARCHAR(255),
category_id INT,
FOREIGN KEY (username) REFERENCES client(username) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (category_id) REFERENCES category(id) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Table client inserts
INSERT INTO client VALUES ("ekaitz123", "Ekaitz", "1234", 23), ("alicia123", "Alicia", "1234", 23), ("mosi123", "Mosi", "1234", 23), ("kevin123", "Kevin", "1234", 23);

-- Table category inserts
INSERT INTO category (category_name, category_description) VALUES ("Personal", "Personal tasks"), ("Work", "Work tasks"), ("Health", "Health tasks"), ("Shopping", "Shopping tasks");

-- Table task inserts
INSERT INTO task (task_name, task_description, due_date, task_state, username, category_id) VALUES ("Buy groceries", "Buy groceries for the week", "2025-04-30", "pending", "ekaitz123", 4), ("Go gym", "Pay the month for the gym and go", "2025-04-30", "pending", "alicia123", 1);