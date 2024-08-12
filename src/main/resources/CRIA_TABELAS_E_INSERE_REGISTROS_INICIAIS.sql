CREATE TABLE exame (rowid bigint auto_increment PRIMARY KEY, nm_exame VARCHAR(255));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue'), ('Espirometria');

CREATE TABLE funcionario (rowid bigint PRIMARY KEY auto_increment, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES('Pedro'), ('Paulo'), ('Ana'), ('Fernanda'), ('Carlos'), ('Antonio');

CREATE TABLE exame_funcionario(
	rowid_funcionario bigint,
	rowid_exame bigint,
	dt_exame date,
	PRIMARY KEY (rowid_funcionario, rowid_exame, dt_exame),
	FOREIGN KEY (rowid_funcionario) REFERENCES funcionario (rowid) ON delete CASCADE,
	FOREIGN KEY (rowid_exame) REFERENCES exame (rowid)
);

INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES 
	(1, 2, '2024-08-07'),
	(2, 1, '2024-08-06'),
	(3, 4, '2024-09-06'),
	(4, 1, '2024-08-16'),
	(5, 5, '2024-08-26'),
	(6, 3, '2024-08-05');


