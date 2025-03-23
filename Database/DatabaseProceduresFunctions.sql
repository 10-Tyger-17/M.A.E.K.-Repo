DELIMITER //
CREATE PROCEDURE SignUp (username VARCHAR(255), client_name VARCHAR(255), client_password VARCHAR(255), age INT)
READS SQL DATA
BEGIN
    DECLARE duplicado BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR 1062 SET duplicado = 1;

    INSERT INTO client VALUES (username, client_name, client_password, age);

    IF duplicado = 1 THEN
        SELECT CONCAT('You already have a profile.', username) AS Error;
    ELSE
        SELECT CONCAT('New client added.', username) AS Message;
    END IF;
END //

CREATE PROCEDURE Unsubscribe (username VARCHAR(255), client_password VARCHAR(255))
READS SQL DATA
BEGIN
    DECLARE existe INT DEFAULT 0;
    DECLARE password_correct INT DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
        BEGIN
            SELECT CONCAT('An error occurred while unsubscribing.') AS Error;
        END;

    SELECT COUNT(*) INTO existe FROM client c WHERE c.username = username;

    IF existe > 0 THEN
        SELECT COUNT(*) INTO password_correct 
        FROM client c 
        WHERE c.username = username AND c.client_password = client_password;

        IF password_correct > 0 THEN
            DELETE FROM client c 
            WHERE c.username = username AND c.client_password = client_password;
            SELECT CONCAT("You've been unsubscribed") AS Message;
        ELSE
            SELECT CONCAT("Password incorrect.") AS Error;
        END IF;
    ELSE
        SELECT CONCAT("This user does not exist.") AS Error;
    END IF;
END //

-- he intentado controlar el enum en caso de introducirlo mal pero no he podido
/*create procedure AddTask (task_name VARCHAR(255), task_description VARCHAR(255), due_date DATE, task_state ENUM('PENDING', 'COMPLETED'), username VARCHAR(255), category_name VARCHAR(255))
reads sql data
begin
declare category_exists int default 0;

declare continue handler for SQLEXCEPTION
    begin
        select concat('Invalid data format') Error;
    end;
    
IF task_state NOT IN ('PENDING', 'COMPLETED') THEN
        SELECT CONCAT('Invalid task state. Must be PENDING or COMPLETED') AS Error;
else
	select count(*) into category_exists 
	from category c 
	where c.category_name=category_name;
	if category_exists>0 then
		insert into task (task_name, task_description, due_date, task_state, username, category_name) VALUES (task_name, task_description, due_date, 'pending', username, category_name);
		select concat('Task "', task_name, '" added for user ', username) AS Message;
	else
		select concat('The category "', category_name, '" does not exist');
	end if;
END IF;
end//*/

-- se supone que esto se usaria tras iniciar sesion, por lo tanto no hace falta verificar usuario
CREATE PROCEDURE AddTask (task_name VARCHAR(255), task_description VARCHAR(255), due_date DATE, task_state ENUM('PENDING', 'COMPLETED'), username VARCHAR(255), category_name VARCHAR(255))
READS SQL DATA
BEGIN
    DECLARE category_exists INT DEFAULT 0;

    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
        BEGIN
            SELECT CONCAT('Invalid data format') AS Error;
        END;

    SELECT COUNT(*) INTO category_exists 
    FROM category c 
    WHERE c.category_name = category_name;

    IF category_exists > 0 THEN
        INSERT INTO task (task_name, task_description, due_date, task_state, username, category_name) 
        VALUES (task_name, task_description, due_date, 'pending', username, category_name);
        SELECT CONCAT('Task "', task_name, '" added for user ', username) AS Message;
    ELSE
        SELECT CONCAT('The category "', category_name, '" does not exist') AS Error;
    END IF;
END //

CREATE PROCEDURE TasksByCategory (category_name VARCHAR(255))
BEGIN
    DECLARE fin bool DEFAULT 0;
    DECLARE v_task_name VARCHAR(255);
    DECLARE v_task_description VARCHAR(255);
    DECLARE v_due_date DATE;
    DECLARE v_task_state ENUM('PENDING', 'COMPLETED');

    DECLARE c CURSOR FOR 
	SELECT task_name, task_description, due_date, task_state 
	FROM task t
	WHERE t.category_name = category_name;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin= 1;

    OPEN c;
		FETCH c 
        INTO v_task_name, v_task_description, v_due_date, v_task_state;

		WHILE fin = 0 DO
        	SELECT v_task_name AS task, v_task_description AS description, v_due_date AS due_date, v_task_state AS state;
			FETCH c INTO v_task_name, v_task_description, v_due_date, v_task_state;
		END WHILE;
    CLOSE c;
END //

CREATE FUNCTION CountCompletedTasks(username VARCHAR(255)) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE contador INT DEFAULT 0;
    DECLARE fin BOOL DEFAULT 0;
    DECLARE v_id INT;

    DECLARE c CURSOR FOR 
        SELECT id FROM task t WHERE t.username = username AND t.task_state = 'COMPLETED';

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

    OPEN c;
	
    FETCH c INTO v_id;
    WHILE fin = 0 DO
		SET contador = contador + 1;
		FETCH c INTO v_id;
	END WHILE;
    
    CLOSE c;

    RETURN contador;
END //

CREATE FUNCTION GetOldestUser() RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE oldest_u VARCHAR(255);
    DECLARE biggest_age INT DEFAULT 0;
    DECLARE fin BOOL DEFAULT 0;
    DECLARE v_username VARCHAR(255);
    DECLARE v_age INT;

    DECLARE c CURSOR FOR 
        SELECT username, age FROM client;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

    OPEN c;
    
    FETCH c INTO v_username, v_age;
	WHILE fin = 0 DO
		IF v_age > biggest_age THEN
            SET biggest_age = v_age;
            SET oldest_u = v_username;
        END IF;
        FETCH c INTO v_username, v_age;
	END WHILE;

    CLOSE c;

    RETURN oldest_u;
END //

CREATE FUNCTION GetUserAge(username VARCHAR(255)) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE v_age INT;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_age = -1;
    SELECT age INTO v_age FROM client c WHERE c.username = username;
    RETURN v_age;
END //

CREATE FUNCTION GetTaskByDate (username VARCHAR(255), due_date DATE) RETURNS VARCHAR (255)
DETERMINISTIC
BEGIN
	DECLARE v_task_name VARCHAR(255);
    DECLARE fin BOOL DEFAULT 0;
    DECLARE all_tasks VARCHAR(1000) DEFAULT ''; -- sino se hace el default '' siempre va a ser null
    
    DECLARE c CURSOR FOR
		SELECT task_name FROM task t WHERE t.username=username AND t.due_date=due_date;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    OPEN c;
    
    FETCH c INTO v_task_name;
    WHILE fin = 0 DO
		SET all_tasks = CONCAT(all_tasks, v_task_name, ",");
        FETCH c INTO v_task_name;
    END WHILE;
    
    CLOSE c;
    
    IF all_tasks = '' THEN
		SET all_tasks = 'No tasks found';
	END IF;
    
    RETURN all_tasks;
END//
DELIMITER ;