drop table if exists wiedzmak.pola;
drop table if exists wiedzmak.lands;
drop table if exists wiedzmak.stwory;
drop database if exists wiedzmak;

create database wiedzmak DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use wiedzmak;

create table pola(id smallint primary key auto_increment, planszax tinyint, planszay tinyint, x tinyint, y tinyint, podloze smallint, rodzaj smallint, stwor tinyint);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,0,0,1,104,0),(0,0,0,1,1,102,0),(0,0,0,2,1,101,0),(0,0,0,3,1,102,0),(0,0,0,4,1,101,0),(0,0,0,5,1,104,0),(0,0,0,6,1,102,0),(0,0,0,7,1,101,0),(0,0,0,8,1,102,0),(0,0,0,9,1,100,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,1,0,1,103,0),(0,0,1,1,1,103,0),(0,0,1,2,1,100,0),(0,0,1,3,1,101,0),(0,0,1,4,1,106,0),(0,0,1,5,1,107,0),(0,0,1,6,1,103,0),(0,0,1,7,1,101,0),(0,0,1,8,1,102,0),(0,0,1,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,2,0,1,102,0),(0,0,2,1,1,101,0),(0,0,2,2,1,104,0),(0,0,2,3,1,0,0),(0,0,2,4,1,0,0),(0,0,2,5,1,0,0),(0,0,2,6,1,103,0),(0,0,2,7,1,104,0),(0,0,2,8,1,0,0),(0,0,2,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,3,0,1,103,0),(0,0,3,1,1,102,0),(0,0,3,2,1,0,0),(0,0,3,3,1,0,0),(0,0,3,4,1,0,0),(0,0,3,5,1,0,0),(0,0,3,6,1,0,1),(0,0,3,7,1,103,0),(0,0,3,8,1,0,0),(0,0,3,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,4,0,1,101,0),(0,0,4,1,1,100,0),(0,0,4,2,1,0,0),(0,0,4,3,1,0,0),(0,0,4,4,1,105,0),(0,0,4,5,1,0,0),(0,0,4,6,1,0,0),(0,0,4,7,1,0,0),(0,0,4,8,1,0,0),(0,0,4,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,5,0,1,100,0),(0,0,5,1,1,100,0),(0,0,5,2,1,102,0),(0,0,5,3,1,0,0),(0,0,5,4,1,0,0),(0,0,5,5,1,0,0),(0,0,5,6,1,0,0),(0,0,5,7,1,0,0),(0,0,5,8,1,0,0),(0,0,5,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,6,0,1,100,0),(0,0,6,1,1,100,0),(0,0,6,2,1,0,1),(0,0,6,3,1,0,0),(0,0,6,4,1,0,0),(0,0,6,5,1,0,0),(0,0,6,6,1,0,0),(0,0,6,7,1,0,0),(0,0,6,8,1,0,0),(0,0,6,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,7,0,1,101,0),(0,0,7,1,1,101,0),(0,0,7,2,1,104,0),(0,0,7,3,1,0,0),(0,0,7,4,1,0,1),(0,0,7,5,1,103,0),(0,0,7,6,1,102,0),(0,0,7,7,1,0,0),(0,0,7,8,1,0,0),(0,0,7,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,8,0,1,101,0),(0,0,8,1,1,103,0),(0,0,8,2,1,0,0),(0,0,8,3,1,0,0),(0,0,8,4,1,0,0),(0,0,8,5,1,0,0),(0,0,8,6,1,0,0),(0,0,8,7,1,0,0),(0,0,8,8,1,0,0),(0,0,8,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,0,9,0,1,103,0),(0,0,9,1,1,0,0),(0,0,9,2,1,0,0),(0,0,9,3,1,0,0),(0,0,9,4,1,0,0),(0,0,9,5,1,0,0),(0,0,9,6,1,0,0),(0,0,9,7,1,0,0),(0,0,9,8,1,0,0),(0,0,9,9,1,0,0);

INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,0,0,1,102,0),(0,1,0,1,1,102,0),(0,1,0,2,1,101,0),(0,1,0,3,1,100,0),(0,1,0,4,1,103,0),(0,1,0,5,1,101,0),(0,1,0,6,1,102,0),(0,1,0,7,1,102,0),(0,1,0,8,1,102,0),(0,1,0,9,1,101,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,1,0,1,0,0),(0,1,1,1,1,101,0),(0,1,1,2,1,100,0),(0,1,1,3,1,104,0),(0,1,1,4,1,0,0),(0,1,1,5,1,0,0),(0,1,1,6,1,0,0),(0,1,1,7,1,0,0),(0,1,1,8,1,0,0),(0,1,1,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,2,0,1,0,0),(0,1,2,1,1,0,0),(0,1,2,2,1,0,0),(0,1,2,3,1,102,0),(0,1,2,4,1,102,0),(0,1,2,5,1,0,0),(0,1,2,6,1,0,0),(0,1,2,7,1,0,0),(0,1,2,8,1,101,0),(0,1,2,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,3,0,1,0,0),(0,1,3,1,1,0,0),(0,1,3,2,1,0,0),(0,1,3,3,1,101,0),(0,1,3,4,1,0,0),(0,1,3,5,1,0,0),(0,1,3,6,1,0,0),(0,1,3,7,1,0,0),(0,1,3,8,1,0,0),(0,1,3,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,4,0,1,0,0),(0,1,4,1,1,0,0),(0,1,4,2,1,0,0),(0,1,4,3,1,0,0),(0,1,4,4,1,0,0),(0,1,4,5,1,0,0),(0,1,4,6,1,0,0),(0,1,4,7,1,0,0),(0,1,4,8,1,101,0),(0,1,4,9,1,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,5,0,1,0,0),(0,1,5,1,1,0,0),(0,1,5,2,1,0,0),(0,1,5,3,7,0,0),(0,1,5,4,4,0,0),(0,1,5,5,4,103,0),(0,1,5,6,4,0,0),(0,1,5,7,4,0,0),(0,1,5,8,4,0,0),(0,1,5,9,4,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,6,0,1,0,0),(0,1,6,1,1,0,0),(0,1,6,2,1,0,0),(0,1,6,3,3,0,0),(0,1,6,4,2,101,0),(0,1,6,5,2,102,0),(0,1,6,6,2,104,0),(0,1,6,7,2,0,0),(0,1,6,8,2,0,0),(0,1,6,9,2,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,7,0,1,0,0),(0,1,7,1,1,0,0),(0,1,7,2,1,0,0),(0,1,7,3,3,0,0),(0,1,7,4,2,0,0),(0,1,7,5,2,102,0),(0,1,7,6,2,0,0),(0,1,7,7,2,0,0),(0,1,7,8,2,0,0),(0,1,7,9,2,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,8,0,1,0,0),(0,1,8,1,1,103,0),(0,1,8,2,1,0,0),(0,1,8,3,3,0,0),(0,1,8,4,2,0,0),(0,1,8,5,2,0,0),(0,1,8,6,2,0,0),(0,1,8,7,2,0,0),(0,1,8,8,2,0,0),(0,1,8,9,2,0,0);
INSERT INTO pola(planszax, planszay, x , y, podloze, rodzaj, stwor) VALUES (0,1,9,0,1,0,0),(0,1,9,1,1,0,0),(0,1,9,2,1,0,0),(0,1,9,3,3,0,0),(0,1,9,4,2,0,0),(0,1,9,5,2,0,0),(0,1,9,6,2,0,0),(0,1,9,7,2,0,0),(0,1,9,8,2,0,0),(0,1,9,9,2,0,0);

create table lands(id smallint primary key auto_increment, justname varchar(30), filename varchar(30));
INSERT INTO lands VALUES (1, 'trawa', 'trawa.jpg');
INSERT INTO lands VALUES (2, 'piasek', 'piasek.jpg');
INSERT INTO lands VALUES (3, 'trawa-piasek', 'trawa_piasek.jpg');
INSERT INTO lands VALUES (4, 'trawa-piasek-kat', 'trawa_piasek_kat.jpg');

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