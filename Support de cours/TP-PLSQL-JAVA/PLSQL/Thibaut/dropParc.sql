/* Écrivez puis exécutez le script SQL de destruction des tables 
(que vous appellerez dropParc.sql). 
Lancer ce script puis à nouveau celui de la création des tables.*/

DROP TABLE Segment CASCADE CONSTRAINTS purge;
DROP TABLE Salle CASCADE CONSTRAINTS purge;
DROP TABLE Poste CASCADE CONSTRAINTS purge;
DROP TABLE Logiciel CASCADE CONSTRAINTS purge;
DROP TABLE Installer CASCADE CONSTRAINTS purge;
DROP TABLE Types;