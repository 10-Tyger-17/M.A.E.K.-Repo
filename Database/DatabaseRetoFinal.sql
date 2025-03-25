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
category_name VARCHAR(255) PRIMARY KEY,
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
category_name VARCHAR(255),
FOREIGN KEY (username) REFERENCES client(username) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (category_name) REFERENCES category(category_name) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Table client inserts
INSERT INTO client VALUES ("ekaitz123", "Ekaitz", "1234", 23), ("alicia123", "Alicia", "1234", 23), ("mosi123", "Mosi", "1234", 23), ("kevin123", "Kevin", "1234", 23);

-- Table category inserts
INSERT INTO category (category_name, category_description) VALUES ("Personal", "Personal tasks"), ("Work", "Work tasks"), ("Health", "Health tasks"), ("Shopping", "Shopping tasks");

-- Table task inserts
INSERT INTO task (task_name, task_description, due_date, task_state, username, category_name) VALUES ("Buy groceries", "Buy groceries for the week", "2025-04-30", "pending", "ekaitz123", "Shopping"), ("Go gym", "Pay the month for the gym and go", "2025-04-30", "pending", "alicia123", "Personal");

-- This procedure takes usernameP, client_nameP, client_paswordP and ageP as parametrers to insert into the table client as a new client.
DELIMITER //
CREATE PROCEDURE SignUp (usernameP VARCHAR(255), client_nameP VARCHAR(255), client_passwordP VARCHAR(255), ageP INT)
READS SQL DATA
BEGIN
    DECLARE dupli BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR 1062 SET dupli = 1;
    
    INSERT INTO client VALUES (usernameP, client_nameP, client_passwordP, ageP);

    IF dupli = 1 THEN
        SELECT CONCAT('You already have a profile ', usernameP) AS Message;
    ELSE
        SELECT CONCAT('New client added ', usernameP) AS Message;
    END IF;
END //
DELIMITER  ;
