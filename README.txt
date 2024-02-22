E-CHAT 

C'est une application de CHAT crée pour envoyer et recevoir des messages via les autres membres du chat.

TYPE d'APPLICATION : Desktop

LANGAGE de PROGRAMMATION : JAVA

INTERFACE : Swing

SGBD : Mysql

IDE : NetBeans 17

Platteform JAVA : JDK 20

MODE DE FONCTIONNEMENT : En réseau via des SOCKET

	Explication des dossiers :

		base : contient le fichier "chatapp.sql"  qui contient le schéma de la base de donnée utiliser.

		ChatApp : Ce le projet du coté interface utilisteur.
	
		server :  Ce le projet du coté server socket.

FONCTIONNALITE : 

	Création de compte utilisateur
	Connexion sur l'application
	Listage des utilisateurs membres de l'APP.
	Vue des utilisateurs en cours de connexion (Status En ligne et Hors ligne.
	Envoye et recoit des messages via d'autre utilisateurs.

MISE EN MARCHE :

	Importer le(s) projets dans NetBeans.
	Ajouter les librairies situés dans (/server/lib/* et /ChatApp/lib/*) à chaque projet correspondantes.
	Crée et importer la base de donnée.
	************* CONFIGURER LES FICHIERS DE CONFIGURATION DU SERVER ET DU CHATAPP **************
	Lancer le server
	Lancer l'application chatAPP 


************ IMPORTANT ***********

/server/conf.properties : ce fichier contient les paramètres du server SOCKET et de la base de donnée (adresse ou host de la base, nom d'utilisateur, mot de passe, port du server de base de donnée, nom de la base, port et adresse d'écoute du server SOCKET)

/ChatApp/conf.properties : ce ficheir contient les paramètres du server SOCKET dans le client. ( C'est à dire, il faut mettre l'adresse et le port d'écoute du server SOCKET)

Projet JAVA AVANCE 2024 - M1 IG - RASTA && RIJA 	