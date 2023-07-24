-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 13 juil. 2023 à 16:23
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp-java`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `nomVoie` varchar(50) NOT NULL,
  `codePostal` varchar(5) NOT NULL,
  `ville` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `nomVoie`, `codePostal`, `ville`) VALUES
(1, 'Rue de Paris', '75012', 'Paris'),
(2, 'rue de Madrid', '95200', 'Madrid'),
(3, 'Voie', '8000', 'Deuil'),
(4, 'Voie de', '95410', 'Villa'),
(5, '2', '3', '4'),
(6, '5', '15', '15'),
(7, '46 bis allée de Pampelune', '95410', 'Groslay'),
(8, 'adresse8', '8', '8'),
(9, 'voie de la réussite', 'alors', 'peut-etre'),
(10, 'voie de la réussite', 'alors', 'peut-etre'),
(11, 'oujr', 'ief', 'oif'),
(12, '7', 'rde2', 'ville'),
(13, 'supposably', '132', '13'),
(14, 'rue', 'ieu', 'oer'),
(15, 'update', 'eiuf', 'ae'),
(16, 'test', '12345', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` int(11) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(80) NOT NULL,
  `mdp` text NOT NULL,
  `adresseId` int(11) NOT NULL,
  `ddn` date NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `stagiaire`
--

INSERT INTO `stagiaire` (`id`, `prenom`, `email`, `mdp`, `adresseId`, `ddn`, `role`) VALUES
(9, 'raph', 'raph@inetum.es', '$2a$10$dvQoej6NuQmnkYFHDCutpu7iiyCBvITNby2ZtAI7gKCtsIyVqdhIm', 14, '1996-04-22', 'admin'),
(11, 'admin', 'admin@inetum.fr', 'admin', 7, '1996-04-22', 'ADMIN'),
(12, 'Test', 'test@test.fr', '$2a$10$UqDDM.LvwnRB9dd6eRsvvOvtp73bXiZdbOHNIlJ8.WKrfGoq7pjjy', 16, '1878-12-15', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_adresseId` (`adresseId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD CONSTRAINT `fk_adresseId` FOREIGN KEY (`adresseId`) REFERENCES `adresse` (`id`) ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
