INSERT IGNORE INTO USERS
	(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, PASSWORD)
VALUES
	(
		'Demo',
		'User',
		'demo@dea.com',
		'5551234567',
		'$2y$10$zk8cAsH.qm1oLpm8iNQ/8.r4qRBwDIklWyB3GPDe3L5un99P/Vtn6'
	);

UPDATE USERS
SET PASSWORD = '$2y$10$zk8cAsH.qm1oLpm8iNQ/8.r4qRBwDIklWyB3GPDe3L5un99P/Vtn6'
WHERE EMAIL = 'demo@dea.com';