DELIMITER //
create procedure SignUp (username VARCHAR(255), client_name VARCHAR(255),client_password VARCHAR(255), age INT) 
reads sql data
begin
declare duplicado bool default 0;
declare continue handler for 1062 set duplicado = 1; insert into client values (username, client_name,client_password,age);
if duplicado = 1 then
select concat ('You already have a profile ',username) Error; else
select concat ('Añadido pedido con referencia ',username) Mensaje; end if;
end//
DELIMITER ;

call SignUp("ekaitz123", "Ekaitz", "1234", 23);


