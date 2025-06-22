CREATE TABLE console (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    company VARCHAR(100) NOT NULL,
    releaseDate DATE NOT NULL
);

INSERT INTO console(name, company, releaseDate) VALUES('PC Engine', 'NEC', '1987-10-30');
INSERT INTO console(name, company, releaseDate) VALUES('Mega Drive', 'Sega', '1988-10-29');
INSERT INTO console(name, company, releaseDate) VALUES('Super Nintendo', 'Nintendo', '1990-11-21');
INSERT INTO console(name, company, releaseDate) VALUES('Sega CD', 'Sega', '1991-10-12');
INSERT INTO console(name, company, releaseDate) VALUES('3DO Interactive Multiplayer', 'The 3DO Company', '1993-10-04');
INSERT INTO console(name, company, releaseDate) VALUES('Atari Jaguar', 'Atari', '1993-11-18');
INSERT INTO console(name, company, releaseDate) VALUES('Sega 32X', 'Sega', '1994-11-21');
INSERT INTO console(name, company, releaseDate) VALUES('Sega Saturn', 'Sega', '1994-11-22');
INSERT INTO console(name, company, releaseDate) VALUES('PlayStation', 'Sony', '1994-12-03');
INSERT INTO console(name, company, releaseDate) VALUES('Virtual Boy', 'Nintendo', '1995-07-21');
INSERT INTO console(name, company, releaseDate) VALUES('Nintendo 64', 'Nintendo', '1996-09-29');