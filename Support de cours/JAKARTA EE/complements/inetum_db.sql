
--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` 		int(11) 		NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `prenom` 	varchar(20) 	NOT NULL,
  `email` 	varchar(80) 	NOT NULL,
  `mdp` 	text 			NOT NULL,
  `ddn` 	date 			DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
