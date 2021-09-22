insert  into `master_tenant_tab`(`id`,`database_name`,`driver_class_name`,`jdbc_url`,`username`,`password`,`status`) values (1,'masterdb','com.mysql.cj.jdbc.Driver','jdbc:mysql://mysql-link:3306/masterdb?createDatabaseIfNotExist=true','root','root','true');

insert  into `roles_2`(`id`,`name`,`guard_name`,`created_at`,`updated_at`) values (1,'ROLE_SUPER_ADMIN','ROLE_SUPER_ADMIN','2021-04-28 12:55:44','2021-04-28 12:55:44');

insert  into `user_roles`(`user_id`,`role_id`) values (3,1);

insert  into `users_2`(`id`,`uuid`,`email`,`username`,`password`,`activation_token`,`status`,`remember_token`,`created_at`,`updated_at`,`enabled`) values (3,'3','admin@gmail.com','admin','$2a$10$YcM38GqMvJW/e0wwW0n10eakYum4gImHkHdrKe42fe9AI6HA.aiEq','3','1',NULL,'2021-03-01 16:04:03','2021-03-01 16:04:03',1);