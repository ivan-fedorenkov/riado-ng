INSERT INTO CHAMBER (`id`, `name`, `version`) VALUES (1, 'Адвокатская палата г. Санкт-Петербурга', 0);

INSERT INTO FORMATION (`id`, `name`, `form`, `chamber_id`, `version`) VALUES (1, 'Адвокатский кабинет №1', 'CABINET', 1, 0);

INSERT INTO LAWYER (`id`, `name`, `reg_num`, `chamber_id`, `formation_id`, `version`) VALUES (1, 'Адвокат №1', '01/01', 1, 1, 0);
