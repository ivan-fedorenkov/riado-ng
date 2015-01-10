CREATE TABLE `news`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,

  `title` VARCHAR(1024) NOT NULL,
  `preview` CLOB NOT NULL,
  `text` CLOB NOT NULL,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL
);