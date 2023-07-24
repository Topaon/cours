*** Le projet a été Maven clean ***

---------------------------------------------------

*** Données de connexion à la base de données ***
src/main/resources/dbParams.properties

---------------------------------------------------

*** Les mdp sont hashés avec ***
<dependency>
	<groupId>org.mindrot</groupId>
	<artifactId>jbcrypt</artifactId>
	<version>0.4</version>
</dependency>

--------------------------------------------------

*** Comparaison avec le mdp en clair avec la méthode ***
BCrypt.checkpw(mdp, hashedPassword)