create database if not exists `masterdb`;

USE `masterdb`;

CREATE TABLE IF NOT EXISTS `academic_sessions` (
  `id` double DEFAULT NULL,
  `name` varchar(573) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `is_default` tinyint(1) DEFAULT NULL,
  `description` blob,
  `options` blob,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `backups` (
  `id` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `file` varchar(765) DEFAULT NULL,
  `options` blob,
  `updated_at` datetime DEFAULT NULL,
  `user_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `master_tenant_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `database_name` varchar(100) DEFAULT NULL,
  `driver_class_name` varchar(100) DEFAULT NULL,
  `jdbc_url` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `postal_records` (
  `id` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `is_confidential` tinyint(4) DEFAULT NULL,
  `options` varchar(150) DEFAULT NULL,
  `receiver_address` blob,
  `receiver_title` varchar(150) DEFAULT NULL,
  `reference_number` varchar(150) DEFAULT NULL,
  `sender_address` blob,
  `sender_title` varchar(150) DEFAULT NULL,
  `type` varchar(150) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `upload_token` varchar(765) DEFAULT NULL,
  `uuid` varchar(150) DEFAULT NULL,
  `user_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `roles_2` (
  `id` double DEFAULT NULL,
  `name` varchar(573) DEFAULT NULL,
  `guard_name` varchar(573) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `uploads` (
  `id` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `filename` varchar(765) DEFAULT NULL,
  `is_temp_delete` tinyint(4) DEFAULT NULL,
  `module` varchar(765) DEFAULT NULL,
  `module_id` double DEFAULT NULL,
  `options` varchar(150) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `upload_token` varchar(765) DEFAULT NULL,
  `user_filename` varchar(765) DEFAULT NULL,
  `uuid` varchar(150) DEFAULT NULL,
  `user_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user_preferences` (
  `id` double DEFAULT NULL,
  `color_theme` varchar(150) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `direction` varchar(150) DEFAULT NULL,
  `locale` varchar(60) DEFAULT NULL,
  `options` varchar(150) DEFAULT NULL,
  `sidebar` varchar(150) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `academic_session_id` double DEFAULT NULL,
  `user_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user_push_tokens` (
  `id` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `device_name` varchar(765) DEFAULT NULL,
  `options` varchar(150) DEFAULT NULL,
  `token` varchar(765) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` double DEFAULT NULL,
  `role_id` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `users_2` (
  `id` double DEFAULT NULL,
  `uuid` varchar(108) DEFAULT NULL,
  `email` varchar(573) DEFAULT NULL,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(573) DEFAULT NULL,
  `activation_token` varchar(192) DEFAULT NULL,
  `status` varchar(75) DEFAULT NULL,
  `remember_token` varchar(300) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;