DELIMITER //

CREATE PROCEDURE deletestu(
    IN p_rollno VARCHAR(20)
)
BEGIN
    DELETE FROM stu WHERE rollno = p_rollno;
END //

DELIMITER ;