CREATE DEFINER=`root`@`%` PROCEDURE `GET_USER`(
	IN `user` VARCHAR(50)
)
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
	SELECT u.* FROM usuario u
	WHERE u.username = user;
END