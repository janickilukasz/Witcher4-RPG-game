drop table if exists wiedzmak.pola;
drop table if exists wiedzmak.lands;
drop table if exists wiedzmak.obstacles;
drop table if exists wiedzmak.creatures;
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
INSERT INTO lands VALUES (1, 'trawa', 'land_trawa.jpg');
INSERT INTO lands VALUES (2, 'piasek', 'land_piasek.jpg');
INSERT INTO lands VALUES (3, 'trawa-piasek', 'land_trawa_piasek.jpg');
INSERT INTO lands VALUES (4, 'trawa-piasek-kat', 'land_trawa_piasek_kat.jpg');

create table obstacles(id smallint primary key, justname varchar(30), filename varchar(30));
INSERT INTO obstacles VALUES (1, 'drzewo1','obst_tree1.png');
INSERT INTO obstacles VALUES (2, 'drzewo2','obst_tree2.png');
INSERT INTO obstacles VALUES (3, 'drzewo3','obst_tree3.png');
INSERT INTO obstacles VALUES (4, 'drzewo4','obst_tree4.png');
INSERT INTO obstacles VALUES (5, 'drzewo5','obst_tree5.png');
INSERT INTO obstacles VALUES (6, 'drzewo4','obst_tree6.png');
INSERT INTO obstacles VALUES (7, 'drzewo5','obst_tree7.png');
INSERT INTO obstacles VALUES (8, 'ognisko', 'obst_ognisko.png');
INSERT INTO obstacles VALUES (9, 'namiot lewa str', 'obst_namiot_lewo.png');
INSERT INTO obstacles VALUES (10, 'namiot prawa str', 'obst_namiot_prawo.png');
INSERT INTO obstacles VALUES (11, 'skała1','obst_rock1.png');
INSERT INTO obstacles VALUES (12, 'jezioro_lewo','obst_jezioro1.png');
INSERT INTO obstacles VALUES (13, 'jezioro_srodek','obst_jezioro2.png');
INSERT INTO obstacles VALUES (14, 'jezioro_prawo','obst_jezioro3.png');

create table creatures(id smallint primary key, justname varchar(30), filename varchar(30), filenameBig varchar(30), smart tinyint, offence tinyint, defence tinyint, weapon varchar(40), weaponPower tinyint, life smallint);
#MAX ŻYCIE TO 210 PKT!!!!!
INSERT INTO creatures VALUES(1, 'Kura','creat_kura.png','kura.png',1,0,1,'dziób',0,3);
INSERT INTO creatures VALUES(2, 'Dzik','creat_dzik.png','dzik.png',1,2,1,'kły',1,10);
INSERT INTO creatures VALUES(3, 'Szczur','creat_szczurek.png','szczurek.png',4,4,1,'zęby',1,8);
INSERT INTO creatures VALUES(4, 'Pająk','creat_spider.png','spider.png',3,2,2,'odnóża',2,6);