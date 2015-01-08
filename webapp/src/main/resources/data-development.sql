INSERT INTO CHAMBER (`id`, `name`, `version`, `created_at`, `updated_at`) VALUES (1, 'Федеральная палата адвокатов Российской Федерации', 0, CURRENT_DATE, CURRENT_DATE);

INSERT INTO FORMATION (`id`, `name`, `form`, `chamber_id`, `version`, `created_at`, `updated_at`) VALUES (1, 'Адвокатский кабинет №1', 'CABINET', 1, 0, CURRENT_DATE, CURRENT_DATE);

INSERT INTO CONTACT (`id`, `type`, `value`) VALUES (1, 'ADDRESS', '119002, Москва, Сивцев Вражек, д. 43');
INSERT INTO CONTACT (`id`, `type`, `value`) VALUES (2, 'PHONE', '8(495)787-28-35');
INSERT INTO CONTACT (`id`, `type`, `value`) VALUES (3, 'WEBSITE', 'http://fparf.ru/');
INSERT INTO CONTACT (`id`, `type`, `value`) VALUES (4, 'WEBSITE', 'http://lawyers.minjust.ru/');
INSERT INTO CONTACT (`id`, `type`, `value`) VALUES (5, 'EMAIL', 'advpalata@mail.ru');
INSERT INTO LAWYER (`id`, `name`, `reg_num`, `status`, `chamber_id`, `formation_id`, `version`, `source_url`, `created_at`, `updated_at`) VALUES (1, 'Адвокат №1', '01/01', 'SUSPENDED', 1, 1, 0, 'http://lawyers.minjust.ru/lawyers-portal/lawyers/show/1547811', CURRENT_DATE, CURRENT_DATE);
INSERT INTO LAWYER_CONTACTS (`lawyer_id`, `contacts_id`) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5);
