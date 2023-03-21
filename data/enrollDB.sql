
-- CREATE DATABASE
CREATE DATABASE enrolment_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE enrolment_system;

-- CREATE TABLES

CREATE TABLE `users` (
	`id` VARCHAR(50) NOT NULL,
    `username` VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `avatar` VARCHAR(200) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `user_role` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `articles`(
	`id` VARCHAR(50) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `content` TEXT NOT NULL,
    `created_date` DATE NOT NULL,
    `update_date` DATE NOT NULL,
    `article_type` VARCHAR(100) NOT NULL,
    `user_id` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_articles_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
);

CREATE TABLE `comments` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `content` TEXT NOT NULL,
	`created_date` DATE NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `base_comment_id` INT DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_comment_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT fk_comments_base_comment_id_comments FOREIGN KEY(`base_comment_id`) REFERENCES `comments` (`id`) ON DELETE CASCADE
);

CREATE TABLE `faculties` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `article_id` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT fk_faculties_article_id_articles FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`),
    CONSTRAINT uq_faculties_article_id UNIQUE (`article_id`)
);

CREATE TABLE `livestreams` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `description` TEXT DEFAULT NULL,
    `start_time` TIME NOT NULL,
    `start_date` DATE NOT NULL,
    `duration` INT NOT NULL,
    `start_question_time` TIME DEFAULT NULL,
    `end_question_time` TIME DEFAULT NULL,
    PRIMARY KEY (`id`)
);



CREATE TABLE `questions` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `content` TEXT NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `livestream_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_questions_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT fk_questions_livestream_id_livestreams FOREIGN KEY (`livestream_id`) REFERENCES `livestreams` (`id`) ON DELETE CASCADE
);

-- INSERT DATA

INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('I4esDB8GDWMcVW40uA6x', 'cuong.nt', '123456', 'Nguyễn Tấn Cường', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', '2051052016@ou.edu.vn', 'THISINH');
INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('BxST2aBzsduwWLw1cxEQ', 'an.cp', '123456', 'Nguyễn Chu Phước Ân', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', '2051052006an@ou.edu.vn', 'TUVANVIEN');
INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('UgT5veP8Nc8HUoGva1Kc', 'a.lv', '123456', 'Lê Văn A', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', 'a.lv@gmail.com', 'ADMIN');


INSERT INTO `comments` (`id`, `content`, `created_date`, `user_id`, `base_comment_id`) VALUES ('1', 'Bạn tên gì ?', '2023-03-21', 'I4esDB8GDWMcVW40uA6x', null);
INSERT INTO `comments` (`id`, `content`, `created_date`, `user_id`, `base_comment_id`) VALUES ('2', 'Mình tên là Florentilo', '2023-03-22', 'UgT5veP8Nc8HUoGva1Kc', '1');


INSERT INTO `articles` (`id`, `title`, `content`, `created_date`, `update_date`, `article_type`, `user_id`) VALUES ('XRddcyw24gYJ40miY0xc', 'Tuyển sinh đại học chính quy', '<h1>THÔNG TIN TUYỂN SINH CẦN CHÚ Ý </h1>', '2023-02-28', '2023-03-01', 'CHINHQUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `created_date`, `update_date`, `article_type`, `user_id`) VALUES ('mwrybLN4ScPZDTZUgu1S', 'Tuyển sinh văn bằng 2', '<h1>THÔNG TIN TUYỂN SINH VĂN BẰNG 2</h1>', '2023-02-01', '2023-02-20', 'VB2', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `created_date`, `update_date`, `article_type`, `user_id`) VALUES ('cMgQIwJuYNX6A6G1HfFu', 'Thông tin khoa quản trị kinh doanh', '<h1>Tìm hiểu về quản trị kinh doanh</h1>', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');


INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('1', 'Quản trị kinh doanh', 'XRddcyw24gYJ40miY0xc');

INSERT INTO `livestreams` (`id`, `title`, `start_time`, `start_date`, `duration`, `start_question_time`, `end_question_time`) VALUES ('1', 'Tư vấn tuyển sinh ngành công nghệ thông tin', '9:00:00', '2023-03-20', '55', '9:15:00', '9:25:00');

INSERT INTO `questions` (`id`, `content`, `user_id`, `livestream_id`) VALUES ('1', 'Dự đoán điểm năm nay ?', 'BxST2aBzsduwWLw1cxEQ', '1');
