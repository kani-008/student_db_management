DELIMITER //

CREATE PROCEDURE insertstu(
    IN p_rollno VARCHAR(20),
    IN p_name VARCHAR(50),
    IN p_dept VARCHAR(20),
    IN p_city VARCHAR(30)
)
BEGIN
    INSERT INTO stu VALUES (p_rollno, p_name, p_dept, p_city);
END //

DELIMITER ;
