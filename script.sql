CREATE TABLE console (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    company VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    image_url TEXT NOT NULL
);

INSERT INTO console (id, name, company, release_date, image_url) VALUES
(1, 'Atari 2600', 'Atari', '1977-09-11', 'https://pt.wikipedia.org/wiki/Atari_2600#/media/Ficheiro:Atari-2600-Wood-4Sw-Set.png'),
(2, 'Mega Drive', 'SEGA', '1988-10-29', 'https://pt.wikipedia.org/wiki/Mega_Drive#/media/Ficheiro:Sega-Mega-Drive-JP-Mk1-Console-Set.jpg'),
(3, 'Super Nintendo', 'Nintendo', '1990-11-21', 'https://pt.wikipedia.org/wiki/Super_Nintendo_Entertainment_System#/media/Ficheiro:SNES-Mod1-Console-Set.jpg');
