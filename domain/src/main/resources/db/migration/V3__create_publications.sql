CREATE TABLE `publication`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,

  `title` VARCHAR(1024) NOT NULL,
  `text` CLOB NOT NULL,

  `lawyer_id` INTEGER NOT NULL,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL,

  FOREIGN KEY (`lawyer_id`) REFERENCES `lawyer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);