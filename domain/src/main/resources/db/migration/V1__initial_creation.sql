CREATE TABLE `chamber`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,
  `name` VARCHAR(256) NOT NULL,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL
);

CREATE TABLE `formation`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `form` VARCHAR(16),
  `chamber_id` INTEGER NOT NULL,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL,

  FOREIGN KEY (`chamber_id`) REFERENCES `chamber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `lawyer`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `reg_num` VARCHAR(16),
  `status` VARCHAR(16),
  `source_url` VARCHAR(256),
  `chamber_id` INTEGER NOT NULL,
  `formation_id` INTEGER,

  `created_at` DATE NOT NULL,
  `updated_at` DATE NOT NULL,

  FOREIGN KEY (`chamber_id`) REFERENCES `chamber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `contact`(
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `version` INTEGER NOT NULL,
  `type` VARCHAR(16),
  `value` VARCHAR(256)
);

CREATE TABLE `chamber_contacts`(
  `chamber_id` INTEGER NOT NULL,
  `contacts_id` INTEGER NOT NULL,
  FOREIGN KEY (`chamber_id`) REFERENCES `chamber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`contacts_id`) REFERENCES `contact` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE `formation_contacts`(
  `formation_id` INTEGER NOT NULL,
  `contacts_id` INTEGER NOT NULL,
  FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`contacts_id`) REFERENCES `contact` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE `lawyer_contacts`(
  `lawyer_id` INTEGER NOT NULL,
  `contacts_id` INTEGER NOT NULL,
  FOREIGN KEY (`lawyer_id`) REFERENCES `lawyer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`contacts_id`) REFERENCES `contact` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
);
