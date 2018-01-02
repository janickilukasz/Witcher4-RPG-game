drop table if exists wiedzmak.pola;
drop table if exists wiedzmak.podloza;
drop table if exists wiedzmak.stwory;
drop database if exists wiedzmak;

create database wiedzmak DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use wiedzmak;

create table pola(id smallint primary key auto_increment, planszax tinyint, planszay tinyint, x tinyint, y tinyint, podloze smallint, rodzaj smallint, stwor tinyint);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,1,0,1,104,0),(0,0,1,1,1,102,0),(0,0,1,2,1,101,0),(0,0,1,3,1,102,0),(0,0,1,4,1,101,0),(0,0,1,5,1,104,0),(0,0,1,6,1,102,0),(0,0,1,7,1,101,0),(0,0,1,8,1,102,0),(0,0,1,9,1,100,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,2,0,1,103,0),(0,0,2,1,1,103,0),(0,0,2,2,1,100,0),(0,0,2,3,1,101,0),(0,0,2,4,1,106,0),(0,0,2,5,1,107,0),(0,0,2,6,1,103,0),(0,0,2,7,1,101,0),(0,0,2,8,1,102,0),(0,0,2,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,3,0,1,102,0),(0,0,3,1,1,101,0),(0,0,3,2,1,104,0),(0,0,3,3,1,0,0),(0,0,3,4,1,0,0),(0,0,3,5,1,0,0),(0,0,3,6,1,103,0),(0,0,3,7,1,104,0),(0,0,3,8,1,0,0),(0,0,3,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,4,0,2,103,0),(0,0,4,1,1,102,0),(0,0,4,2,1,0,0),(0,0,4,3,1,0,0),(0,0,4,4,1,0,0),(0,0,4,5,1,0,0),(0,0,4,6,1,0,1),(0,0,4,7,1,103,0),(0,0,4,8,1,0,0),(0,0,4,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,5,0,1,101,0),(0,0,5,1,1,100,0),(0,0,5,2,1,0,0),(0,0,5,3,1,0,0),(0,0,5,4,1,105,0),(0,0,5,5,1,0,0),(0,0,5,6,1,0,0),(0,0,5,7,1,0,0),(0,0,5,8,1,0,0),(0,0,5,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,6,0,1,100,0),(0,0,6,1,2,100,0),(0,0,6,2,2,102,0),(0,0,6,3,1,0,0),(0,0,6,4,1,0,0),(0,0,6,5,1,0,0),(0,0,6,6,1,0,0),(0,0,6,7,1,0,0),(0,0,6,8,1,0,0),(0,0,6,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,7,0,1,100,0),(0,0,7,1,2,100,0),(0,0,7,2,2,0,1),(0,0,7,3,3,0,0),(0,0,7,4,2,0,0),(0,0,7,5,1,0,0),(0,0,7,6,1,0,0),(0,0,7,7,1,0,0),(0,0,7,8,1,0,0),(0,0,7,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,8,0,1,101,0),(0,0,8,1,1,101,0),(0,0,8,2,1,104,0),(0,0,8,3,1,0,0),(0,0,8,4,1,0,1),(0,0,8,5,1,103,0),(0,0,8,6,1,102,0),(0,0,8,7,1,0,0),(0,0,8,8,1,0,0),(0,0,8,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,9,0,1,101,0),(0,0,9,1,1,103,0),(0,0,9,2,1,0,0),(0,0,9,3,1,0,0),(0,0,9,4,1,0,0),(0,0,9,5,1,0,0),(0,0,9,6,1,0,0),(0,0,9,7,1,0,0),(0,0,9,8,1,0,0),(0,0,9,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,10,0,1,103,0),(0,0,10,1,1,0,0),(0,0,10,2,1,0,0),(0,0,10,3,1,0,0),(0,0,10,4,1,0,0),(0,0,10,5,1,0,0),(0,0,10,6,1,0,0),(0,0,10,7,1,0,0),(0,0,10,8,1,0,0),(0,0,10,9,1,0,0);


create table podloza(id smallint primary key auto_increment, nazwa varchar(30), img varchar(30), rotacja smallint);
INSERT INTO podloza VALUES (1, 'trawa', 'trawa.jpg', 0);
INSERT INTO podloza VALUES (2, 'piasek', 'piasek.jpg', 0);
INSERT INTO podloza VALUES (3, 'piasek', 'piasek.jpg', 90);

create table przeszkody(id smallint primary key, nazwa varchar(30), img varchar(30));
INSERT INTO przeszkody VALUES (100, 'drzewo1','tree1.png');
INSERT INTO przeszkody VALUES (101, 'drzewo2','tree2.png');
INSERT INTO przeszkody VALUES (102, 'drzewo3','tree3.png');
INSERT INTO przeszkody VALUES (103, 'drzewo4','tree4.png');
INSERT INTO przeszkody VALUES (104, 'drzewo5','tree5.png');
INSERT INTO przeszkody VALUES (105, 'ognisko', 'ognisko.png');
INSERT INTO przeszkody VALUES (106, 'namiot lewa str', 'namiot_lewo.png');
INSERT INTO przeszkody VALUES (107, 'namiot prawa str', 'namiot_prawo.png');
INSERT INTO przeszkody VALUES (108, 'skała1','rock1.png');
INSERT INTO przeszkody VALUES (109, 'jezioro_lewo','jezioro1.png');
INSERT INTO przeszkody VALUES (110, 'jezioro_srodek','jezioro2.png');
INSERT INTO przeszkody VALUES (111, 'jezioro_prawo','jezioro3.png');

create table stwory(id smallint primary key, nazwa varchar(30), img_maly varchar(30), img_duzy varchar(30), spryt tinyint, atak tinyint, obrona tinyint, bron varchar(40), bronsila tinyint, zycie smallint);
#MAX ŻYCIE TO 210 PKT!!!!!
INSERT INTO stwory VALUES(1, 'Kura','kura_mala.png','kura.png',1,0,1,'dziób',0,3);
INSERT INTO stwory VALUES(2, 'Dzik','dzik_maly.png','dzik.png',1,2,1,'kły',1,10);
INSERT INTO stwory VALUES(3, 'Szczur','szczurek_maly.png','szczurek.png',4,4,1,'zęby',1,8);
INSERT INTO stwory VALUES(4, 'Pająk','spider_maly.png','spider.png',3,2,2,'odnóża',2,6);