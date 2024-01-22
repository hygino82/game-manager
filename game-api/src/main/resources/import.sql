INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Nintendo', 1983, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/0/06/Nintendo-Famicom-Console-Set-FL.jpg','d2d67e45-0037-47a5-b6d4-c04ecb376c28');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Super Nintendo', 1990, '2024-01-15T23:40:41.045218790Z','https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/SNES-Mod1-Console-Set.jpg/1920px-SNES-Mod1-Console-Set.jpg','b51963cb-addd-4b6b-a49b-afe3a1f004ef');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Nintendo 64', 1996, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/N64-Console-Set.png/1920px-N64-Console-Set.png','7c67453b-314e-416b-ac97-8330aa46d9d4');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Mega Drive', 1988, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Sega-Mega-Drive-JP-Mk1-Console-Set.jpg/1920px-Sega-Mega-Drive-JP-Mk1-Console-Set.jpg','ae832cdb-8412-43da-a8b8-f5b460c73503');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Playstation 1', 1994, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/PSX-Console-wController.png/1920px-PSX-Console-wController.png','c7b80f17-2d5e-4668-8f7f-3a271ea29897');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Playstation 2', 2000, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/PS2-Versions.png/1024px-PS2-Versions.png','6f2bb441-b956-427f-a342-348ec0f81157');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Playstation 3', 2006, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Sony-PlayStation-3-2001A-wController-L.jpg/1920px-Sony-PlayStation-3-2001A-wController-L.jpg','113e02d1-df2d-48ef-bab8-3985d3c7a314');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Playstation 4', 2013, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Sony-PlayStation-4-PS4-wDualShock-4.jpg/1024px-Sony-PlayStation-4-PS4-wDualShock-4.jpg','4ffdd8cc-e64b-48fb-8c17-c82d21a31f0f');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Playstation 5', 2020, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Black_and_white_Playstation_5_base_edition_with_controller.png/800px-Black_and_white_Playstation_5_base_edition_with_controller.png','6eac9c9d-65cf-414a-bf27-19d5445eb78e');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('XBOX 360', 2005, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Xbox-360S-Console-Set.jpg/800px-Xbox-360S-Console-Set.jpg','a1899397-f94a-4ad2-a8b4-c75980ad6fab');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('XBOX ONE', 2013, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Xbox-One-Console-BR.jpg/1280px-Xbox-One-Console-BR.jpg','e5082ede-2d0b-4e9a-b252-9a5be3ce3a23');

INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503', 'Comix Zone', 1995, 'https://upload.wikimedia.org/wikipedia/en/0/0e/Comix_Zone_Coverart.png', '2024-01-15T23:40:41.045218790Z','22042d12-3cda-484a-9d00-9e9eab729b8b');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503', 'Sonic the Hedgehog 3', 1994, 'https://upload.wikimedia.org/wikipedia/pt/6/6c/Sonic_the_Hedgehog_3_capa.png', '2024-01-15T23:40:41.045218790Z','3c240c8e-0e44-49d0-a9fb-270b11acaa6a');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Gran Turismo 5', 2010, 'https://upload.wikimedia.org/wikipedia/en/8/8b/GT5-boxart-final-EU.jpg', '2024-01-15T23:40:41.045218790Z','6cfd1f42-0a37-4002-94e1-fd25339dc48d');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Gran Turismo 6', 2013, 'https://upload.wikimedia.org/wikipedia/pt/b/bc/Gran_Turismo_6_capa.png', '2024-01-15T23:40:41.045218790Z','3d166ea3-b56e-4bc8-81e8-b2c0699ca53f');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('6f2bb441-b956-427f-a342-348ec0f81157', 'Black', 2006, 'https://upload.wikimedia.org/wikipedia/pt/a/ad/Black_cover_art.jpg', '2024-01-15T23:40:41.045218790Z', '0f5bb4c2-14f0-44c0-89f2-b25a9304f35c');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('6f2bb441-b956-427f-a342-348ec0f81157', 'Blood Roar 3', 2000, 'https://upload.wikimedia.org/wikipedia/en/c/c8/Bloody_Roar_3_Coverart.png','2024-01-15T23:40:41.045218790Z','4064d4dc-0f60-42f1-b78a-1b96e92199bd' );
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('b51963cb-addd-4b6b-a49b-afe3a1f004ef', 'Super Mario World', 1990, 'https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg', '2024-01-15T23:40:41.045218790Z','9b0d50e9-50a7-4c30-94a9-eb4ed276fb33');
