Projet pour examen JAVA

Sujet: Vous utiliserez la base de données Pizza et développerez un classe regroupant les pizzas , les quantités et les ingrédients , et vous instancierez les objets de cette classe
, qui seront ensuite rangé dans une Arraylist<>  Java.

Application
Structure du projet

Donc le projet est composé est d'un ficher src qui contient le package soutenance java qui contient lui même deux classes Pizza_connect et Pizza puis le fichier jarlib qui contient la librairies qui contient les méthodes nécessaire pour se connecté à la base de donnée

![image](https://github.com/user-attachments/assets/42c1ef5e-56cc-48e9-9666-8e183399cd2d)


Le package soutenance java

Pizza connect 
Permet de se connecter à la base de donnée, de faire une requête en boucle sur les tables pizza composer et ingrétients puis de les synthetiser, les ajouter à une array liste et de les affichers, lorsqu'il ny a plus de donnée à vérifier il ferme la connection tout en gérant les erreurs 

![image](https://github.com/user-attachments/assets/deeae466-2200-426d-9478-6407df2a5dbf)

Pizza

C'est la classe qui contient les données et leurs types utiliser dans le programme mais aussi la fonction toString qui montre comment les données seront formater avant d'être afficher

![image](https://github.com/user-attachments/assets/94c5d8cd-f90c-471c-8847-d8bff428b5ab)
