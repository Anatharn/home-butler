-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 06 Mars 2015 à 07:48
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `training`
--

-- --------------------------------------------------------

--
-- Structure de la table `accounting`
--

CREATE TABLE IF NOT EXISTS `accounting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Contenu de la table `accounting`
--

INSERT INTO `accounting` (`id`, `name`) VALUES
(15, 'ActivitÃ©'),
(16, 'Assurance'),
(17, 'Banque'),
(18, 'Cadeau'),
(19, 'Carburant'),
(20, 'Divers'),
(21, 'Eau'),
(22, 'Ã?conomie'),
(23, 'Ã?lectricitÃ©'),
(24, 'Enfants'),
(25, 'Entretien Automobile'),
(26, 'Immobilier'),
(27, 'ImpÃ´t sur le revenu'),
(28, 'Internet'),
(29, 'Loisir'),
(30, 'Loyer'),
(31, 'Maison'),
(32, 'Nourriture'),
(33, 'PrÃªt automobile'),
(34, 'PrÃªt Ã?tudiant'),
(35, 'PrÃªt immobilier'),
(36, 'Projet'),
(37, 'Redevance'),
(38, 'Restaurant'),
(39, 'Salaire'),
(40, 'SantÃ©'),
(41, 'Soin du corps'),
(42, 'Taxe d''habitation'),
(43, 'TÃ©lÃ©phone mobile'),
(44, 'Transport'),
(45, 'Travail'),
(46, 'VÃªtement'),
(47, 'Voyage'),
(48, 'Chauffage'),
(49, 'Taxe fonciÃ¨res');

-- --------------------------------------------------------

--
-- Structure de la table `bank_account`
--

CREATE TABLE IF NOT EXISTS `bank_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `number` varchar(255) CHARACTER SET latin1 NOT NULL,
  `iban` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7f0x0nd573ed7eyrwci67eq82` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=17 ;

--
-- Contenu de la table `bank_account`
--

INSERT INTO `bank_account` (`id`, `name`, `number`, `iban`, `type`) VALUES
(10, 'blbalab', 'numéro', '125', 1),
(14, 'CCP LBP', '487489879', '48484461', 1),
(16, 'LA LBP ML', '7400+406061406', '4606516849600431', 2);

-- --------------------------------------------------------

--
-- Structure de la table `bank_account_type`
--

CREATE TABLE IF NOT EXISTS `bank_account_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `bank_account_type`
--

INSERT INTO `bank_account_type` (`id`, `name`) VALUES
(1, 'Compte courant'),
(2, 'Livret A'),
(3, 'Compte épargne logement');

-- --------------------------------------------------------

--
-- Structure de la table `bank_check`
--

CREATE TABLE IF NOT EXISTS `bank_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `cancelled` tinyint(1) DEFAULT NULL,
  `used` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `bank_check`
--

INSERT INTO `bank_check` (`id`, `number`, `cancelled`, `used`) VALUES
(8, 5405046, NULL, NULL),
(10, 150, NULL, 1),
(11, 1519806, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `entry`
--

CREATE TABLE IF NOT EXISTS `entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accounting_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `third_party_id` int(11) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `bank_check_number` int(11) DEFAULT NULL,
  `total` float NOT NULL,
  `bank_account_id` int(11) DEFAULT NULL,
  `has_been_checked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jkmx3lpgrboxglopge4g4cgyi` (`accounting_id`),
  KEY `FK_62hg4hece92ohxypr6m4iux1x` (`bank_account_id`),
  KEY `FK_t4q8dj3dcx4qi86uwo9ojljqr` (`third_party_id`),
  KEY `FK_3l94bxy4frd2ksw5xpvbq484f` (`bank_check_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `entry`
--

INSERT INTO `entry` (`id`, `accounting_id`, `date`, `third_party_id`, `detail`, `bank_check_number`, `total`, `bank_account_id`, `has_been_checked`) VALUES
(3, 15, '2015-02-02', 4, '', NULL, 12.05, 10, NULL),
(4, 15, '2015-03-12', 7, 'ceci est un détail', 8, 50, 10, 1),
(5, 32, '2014-05-15', 8, 'un test', NULL, -14, 14, 1),
(6, 30, '2014-05-25', 9, 'un loyer', NULL, -750, 14, 1),
(7, 31, '2015-02-12', 10, '', NULL, -250, 14, 0),
(8, 26, '2014-05-01', 1, 'une autre entrée', NULL, 450, 14, 0),
(9, 15, '2015-10-01', NULL, 'bbbbbbb', 10, 250, 10, 0),
(10, 15, '2014-10-10', NULL, 'ccccc', NULL, -50, 14, 0),
(11, 28, '2015-03-15', NULL, 'yes', NULL, 60, 10, 0),
(12, 31, '2015-05-05', NULL, '', NULL, 50, 10, 0),
(13, 15, '2015-09-05', 4, 'tadzam', NULL, -80, 14, 0);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FK_g46n82f45xs0ds0r7m7ahel3d` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`, `user_id`) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'USER', 1);

-- --------------------------------------------------------

--
-- Structure de la table `third_party`
--

CREATE TABLE IF NOT EXISTS `third_party` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `third_party`
--

INSERT INTO `third_party` (`id`, `name`) VALUES
(1, 'toto'),
(2, 'totaux'),
(3, 'total'),
(4, 'totomatique'),
(5, 'tout la vie'),
(6, 'to be alive'),
(7, 'essai'),
(8, 'Delhaize'),
(9, 'M. Domenico'),
(10, 'Bricomarché'),
(11, 'to be alive');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_avh1b2ec82audum2lyjx2p1ws` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `dob`, `email`, `name`, `password`) VALUES
(1, '2015-02-22 00:00:00', 'sebastien.desantis@gmail.com', 'sébastien', 'toto');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `bank_account`
--
ALTER TABLE `bank_account`
  ADD CONSTRAINT `FK_7f0x0nd573ed7eyrwci67eq82` FOREIGN KEY (`type`) REFERENCES `bank_account_type` (`id`);

--
-- Contraintes pour la table `entry`
--
ALTER TABLE `entry`
  ADD CONSTRAINT `FK_3l94bxy4frd2ksw5xpvbq484f` FOREIGN KEY (`bank_check_number`) REFERENCES `bank_check` (`id`),
  ADD CONSTRAINT `FK_62hg4hece92ohxypr6m4iux1x` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`id`),
  ADD CONSTRAINT `FK_jkmx3lpgrboxglopge4g4cgyi` FOREIGN KEY (`accounting_id`) REFERENCES `accounting` (`id`),
  ADD CONSTRAINT `FK_t4q8dj3dcx4qi86uwo9ojljqr` FOREIGN KEY (`third_party_id`) REFERENCES `third_party` (`id`);

--
-- Contraintes pour la table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `FK_g46n82f45xs0ds0r7m7ahel3d` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
