create table tb_console (release_year smallint not null, created_at timestamp(6) with time zone, updated_at timestamp(6) with time zone, id varchar(36) not null, name varchar(100), img_url varchar(255), primary key (id));
create table tb_game (release_year integer, create_date timestamp(6), update_date timestamp(6), id varchar(36) not null, console_id varchar(255) not null, image_url varchar(255), name varchar(255), personal_code varchar(255), primary key (id));
alter table if exists tb_game add constraint FK9ewb7pm6t4oxor4un9gt4tmbr foreign key (console_id) references tb_console;
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Nintendo', 1983, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/0/06/Nintendo-Famicom-Console-Set-FL.jpg','d2d67e45-0037-47a5-b6d4-c04ecb376c28');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Super Nintendo', 1990, '2024-01-15T23:40:41.045218790Z','https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/SNES-Mod1-Console-Set.jpg/1920px-SNES-Mod1-Console-Set.jpg','b51963cb-addd-4b6b-a49b-afe3a1f004ef');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Nintendo 64', 1996, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/N64-Console-Set.png/1920px-N64-Console-Set.png','7c67453b-314e-416b-ac97-8330aa46d9d4');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('Mega Drive', 1988, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Sega-Mega-Drive-JP-Mk1-Console-Set.jpg/1920px-Sega-Mega-Drive-JP-Mk1-Console-Set.jpg','ae832cdb-8412-43da-a8b8-f5b460c73503');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('PlayStation 1', 1994, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/PSX-Console-wController.png/1920px-PSX-Console-wController.png','c7b80f17-2d5e-4668-8f7f-3a271ea29897');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('PlayStation 2', 2000, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/PS2-Versions.png/1024px-PS2-Versions.png','6f2bb441-b956-427f-a342-348ec0f81157');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('PlayStation 3', 2006, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Sony-PlayStation-3-2001A-wController-L.jpg/1920px-Sony-PlayStation-3-2001A-wController-L.jpg','113e02d1-df2d-48ef-bab8-3985d3c7a314');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('PlayStation 4', 2013, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Sony-PlayStation-4-PS4-wDualShock-4.jpg/1024px-Sony-PlayStation-4-PS4-wDualShock-4.jpg','4ffdd8cc-e64b-48fb-8c17-c82d21a31f0f');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('PlayStation 5', 2020, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Black_and_white_Playstation_5_base_edition_with_controller.png/800px-Black_and_white_Playstation_5_base_edition_with_controller.png','6eac9c9d-65cf-414a-bf27-19d5445eb78e');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('XBOX 360', 2005, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Xbox-360S-Console-Set.jpg/800px-Xbox-360S-Console-Set.jpg','a1899397-f94a-4ad2-a8b4-c75980ad6fab');
INSERT INTO tb_console(name, release_year, created_at, img_url, id) VALUES('XBOX ONE', 2013, '2024-01-15T23:40:41.045218790Z', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Xbox-One-Console-BR.jpg/1280px-Xbox-One-Console-BR.jpg','e5082ede-2d0b-4e9a-b252-9a5be3ce3a23');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503', 'Comix Zone', 1995, 'https://upload.wikimedia.org/wikipedia/en/0/0e/Comix_Zone_Coverart.png', '2024-01-15T23:40:41.045218790Z','22042d12-3cda-484a-9d00-9e9eab729b8b');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503', 'Sonic the Hedgehog 3', 1994, 'https://upload.wikimedia.org/wikipedia/pt/6/6c/Sonic_the_Hedgehog_3_capa.png', '2024-01-15T23:40:41.045218790Z','3c240c8e-0e44-49d0-a9fb-270b11acaa6a');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Gran Turismo 5', 2010, 'https://upload.wikimedia.org/wikipedia/en/8/8b/GT5-boxart-final-EU.jpg', '2024-01-15T23:40:41.045218790Z','6cfd1f42-0a37-4002-94e1-fd25339dc48d');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Gran Turismo 6', 2013, 'https://upload.wikimedia.org/wikipedia/pt/b/bc/Gran_Turismo_6_capa.png', '2024-01-15T23:40:41.045218790Z','3d166ea3-b56e-4bc8-81e8-b2c0699ca53f');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('6f2bb441-b956-427f-a342-348ec0f81157', 'Black', 2006, 'https://upload.wikimedia.org/wikipedia/pt/a/ad/Black_cover_art.jpg', '2024-01-15T23:40:41.045218790Z', '0f5bb4c2-14f0-44c0-89f2-b25a9304f35c');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('6f2bb441-b956-427f-a342-348ec0f81157', 'Blood Roar 3', 2000, 'https://upload.wikimedia.org/wikipedia/en/c/c8/Bloody_Roar_3_Coverart.png','2024-01-15T23:40:41.045218790Z','4064d4dc-0f60-42f1-b78a-1b96e92199bd' );
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('b51963cb-addd-4b6b-a49b-afe3a1f004ef', 'Super Mario World', 1990, 'https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg', '2024-01-15T23:40:41.045218790Z','9b0d50e9-50a7-4c30-94a9-eb4ed276fb33');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503',	'Mortal Kombat 1', 1992	,'https://upload.wikimedia.org/wikipedia/en/thumb/b/b1/Mortal_Kombat_Logo.svg/1024px-Mortal_Kombat_Logo.svg.png','2024-01-15T23:40:41.045218790Z','020c2418-c2c4-45fd-a17b-9faf9ffb0368');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503',	'Mortal Kombat 2', 1993,'https://upload.wikimedia.org/wikipedia/en/d/df/Mortal_Kombat_II_boxart.png','2024-01-15T23:40:41.045218790Z','79a852f3-aa15-454c-b2fe-3946f3e038c8');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503',	'Mortal Kombat 3', 1995,'https://upload.wikimedia.org/wikipedia/en/9/9e/Mortal_Kombat_3_cover.JPG','2024-01-15T23:40:41.045218790Z','573e99df-65b6-416e-8729-916392406074');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('ae832cdb-8412-43da-a8b8-f5b460c73503',	'Ultimate Mortal Kombat 3', 1995,'https://upload.wikimedia.org/wikipedia/en/f/f9/Ultimate_MK3.png','2024-01-15T23:40:41.045218790Z','40ca3736-5a04-40a9-8001-e1e03ef7627e');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Dark Souls', 2011, 'https://upload.wikimedia.org/wikipedia/en/8/8d/Dark_Souls_Cover_Art.jpg', '2024-01-21T23:40:41.045218790Z','836912c9-96f7-45bc-816f-6a91ec55876f');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Dark Souls II', 2014, 'https://upload.wikimedia.org/wikipedia/en/e/ed/Dark_Souls_II_cover.jpg', '2024-01-21T23:40:41.045218790Z','ce41ac71-bfcc-4639-928e-b74e26eff0bd');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Dark Souls II: Scholar of the First Sin', 2015, 'https://www.lukiegames.com/assets/images/PS3/ps3_dark_souls_ii_scholar_of_p_ttkbt9.jpg', '2024-01-21T23:40:41.045218790Z','cdedad45-e403-45cf-b60f-721d8e0d6fbb');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'God of War III', 2010, 'https://upload.wikimedia.org/wikipedia/en/8/8b/God_of_War_III_cover_art.jpg', '2024-01-21T23:40:41.045218790Z','69696295-c4ea-438d-a07b-29dd986404ba');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Call of Duty Black Ops', 2010, 'https://upload.wikimedia.org/wikipedia/en/thumb/0/02/CoD_Black_Ops_cover.png/220px-CoD_Black_Ops_cover.png', '2024-01-21T23:40:41.045218790Z', '15a1c3b4-0d98-497c-a5e3-493191b220ce');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Call of Duty Black Ops II', 2012, 'https://upload.wikimedia.org/wikipedia/en/0/05/Call_of_Duty_Black_Ops_II_box_artwork.png', '2024-01-21T23:40:41.045218790Z','c7af96b5-dc9b-420e-a57f-f8b4e9111f41');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Call of Duty Black Ops III', 2015, 'https://upload.wikimedia.org/wikipedia/en/b/b1/Black_Ops_3.jpg', '2024-01-21T23:40:41.045218790Z','17d27e61-814b-47af-bc3c-322534fc7c4a');
INSERT INTO tb_game(console_id, name, release_year, image_url, create_date, id) VALUES ('113e02d1-df2d-48ef-bab8-3985d3c7a314', 'Call of Duty Ghosts', 2013, 'https://upload.wikimedia.org/wikipedia/en/9/9c/Call_of_duty_ghosts_box_art.jpg', '2024-01-21T23:40:41.045218790Z','d07a5be8-acb7-403a-bccc-0bdb4d1bc539');
