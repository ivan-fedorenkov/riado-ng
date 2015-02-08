CREATE TABLE `feedback`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,

  `email` VARCHAR(256) NOT NULL,
  `mark` INTEGER NOT NULL,
  `text` CLOB NOT NULL,
  `editor_key` VARCHAR(20) DEFAULT NULL,

  `status` VARCHAR(20) NOT NULL,
  `evidenced` BOOLEAN DEFAULT FALSE,
  `hide_personal_info` BOOLEAN DEFAULT TRUE,

  `lawyer_id` INTEGER NOT NULL,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL,

  FOREIGN KEY (`lawyer_id`) REFERENCES `lawyer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);