
-- CREATE DATABASE
CREATE DATABASE enrolment_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE enrolment_system;

-- CREATE TABLES

CREATE TABLE `users` (
	`id` VARCHAR(50) NOT NULL,
    `username` VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `avatar` TEXT NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `user_role` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `articles`(
	`id` VARCHAR(50) NOT NULL,
    `title` Text NOT NULL,
    `content` TEXT NOT NULL,
    `description` TEXT NOT NULL,
    `image` TEXT NOT NULL,
    `created_date` DATE NOT NULL,
    `update_date` DATE NOT NULL,
    `article_type` VARCHAR(100) NOT NULL,
    `user_id` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_articles_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `comments` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `content` TEXT NOT NULL,
	`created_date` DATE NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `base_comment_id` INT DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_comment_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT fk_comments_base_comment_id_comments FOREIGN KEY(`base_comment_id`) REFERENCES `comments` (`id`) ON DELETE CASCADE
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `faculties` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `article_id` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT fk_faculties_article_id_articles FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`),
    CONSTRAINT uq_faculties_article_id UNIQUE (`article_id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `livestreams` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `description` TEXT DEFAULT NULL,
    `image` TEXT DEFAULT NULL,
    `link` TEXT DEFAULT NULL,
    `start_time` TIME NOT NULL,
    `start_date` DATE NOT NULL,
    `duration` INT NOT NULL,
    `start_question_time` TIME DEFAULT NULL,
    `end_question_time` TIME DEFAULT NULL,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE `questions` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `content` TEXT NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `livestream_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_questions_user_id_users FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT fk_questions_livestream_id_livestreams FOREIGN KEY (`livestream_id`) REFERENCES `livestreams` (`id`) ON DELETE CASCADE
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `banners` (
	`id` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `homepage` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`content` TEXT NOT NULL,
	`banner_id` INT NOT NULL,
	`video` VARCHAR(50) DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT fk_homepage_banner_id_banners FOREIGN KEY (`banner_id`) REFERENCES `banners` (`id`) ON DELETE CASCADE,
	CONSTRAINT uq_homepage_banner_id UNIQUE(`banner_id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE `images` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`url` VARCHAR(300) NOT NULL,
	`banner_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT fk_images_banner_id_banners FOREIGN KEY (`banner_id`) REFERENCES `banners` (`id`) ON DELETE CASCADE
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- INSERT DATA

INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('I4esDB8GDWMcVW40uA6x', 'cuong.nt', '123456', 'Nguyễn Tấn Cường', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', '2051052016@ou.edu.vn', 'THISINH');
INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('BxST2aBzsduwWLw1cxEQ', 'an.cp', '123456', 'Nguyễn Chu Phước Ân', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', '2051052006an@ou.edu.vn', 'TUVANVIEN');
INSERT INTO `users` (`id`, `username`, `password`, `name`, `avatar`, `email`, `user_role`) VALUES ('UgT5veP8Nc8HUoGva1Kc', 'a.lv', '123456', 'Lê Văn A', 'https://res.cloudinary.com/dis95mx4d/image/upload/v1668643889/sample.jpg', 'a.lv@gmail.com', 'ADMIN');


INSERT INTO `comments` (`id`, `content`, `created_date`, `user_id`, `base_comment_id`) VALUES ('1', 'Bạn tên gì ?', '2023-03-21', 'I4esDB8GDWMcVW40uA6x', null);
INSERT INTO `comments` (`id`, `content`, `created_date`, `user_id`, `base_comment_id`) VALUES ('2', 'Mình tên là Florentilo', '2023-03-22', 'UgT5veP8Nc8HUoGva1Kc', '1');

-- Chinh Quy
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xc', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679731122/cvfnsvbaowzpybhlwm7r.png', '2023-02-28', '2023-03-01', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xb', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679413107/qb4dl7pdd1qlwvegnjix.png', '2023-02-01', '2023-02-20', 'CHINH_QUY', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xd', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1669395564/cld-sample-5.jpg', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xe', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1669395564/cld-sample-4.jpg', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xf', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRdsfyw2gYJ40miY0xg', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679731122/cvfnsvbaowzpybhlwm7r.png', '2023-02-28', '2023-03-01', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddscvyw24gYJ40miY0xh', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679413107/qb4dl7pdd1qlwvegnjix.png', '2023-02-01', '2023-02-20', 'CHINH_QUY', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcywscgYJ40miY0xi', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1669395564/cld-sample-5.jpg', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miascxj', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1669395564/cld-sample-4.jpg', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('ARddcyw24gYJ40miY0k', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('BRddcyw24gYJ40miascxj', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1669395564/cld-sample-4.jpg', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('CRddcyw24gYJ40miY0k', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');

-- Lien Thong
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xg', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-28', '2023-03-01', 'LIEN_THONG', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xh', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-01', '2023-02-20', 'LIEN_THONG', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xi', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'LIEN_THONG', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xj', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'LIEN_THONG', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xk', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'LIEN_THONG', 'UgT5veP8Nc8HUoGva1Kc');

-- Cao Hoc
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xl', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-28', '2023-03-01', 'CAO_HOC', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xm', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-01', '2023-02-20', 'CAO_HOC', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xn', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CAO_HOC', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xo', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CAO_HOC', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xp', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CAO_HOC', 'UgT5veP8Nc8HUoGva1Kc');

-- Thac Si
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1a', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-28', '2023-03-01', 'THAC_SI', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1S', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-01', '2023-02-20', 'THAC_SI', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1b', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'THAC_SI', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1c', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'THAC_SI', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1d', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'THAC_SI', 'UgT5veP8Nc8HUoGva1Kc');

-- TU_XA
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1e', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-28', '2023-03-01', 'TU_XA', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1f', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-01', '2023-02-20', 'TU_XA', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1g', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'TU_XA', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1h', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'TU_XA', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('mwrybLN4ScPZDTZUgu1i', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'TU_XA', 'UgT5veP8Nc8HUoGva1Kc');



-- KHOA
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIT', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');

INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIU', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');

INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIV', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');

INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIW', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');

INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIX', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');

INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('zWVCv5qWGw3T9qvpiMIY', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'KHOA', 'UgT5veP8Nc8HUoGva1Kc');


-- UPDATE (NGAY 27-03-2023)
INSERT INTO `banners` () VALUES();
INSERT INTO `homepage` (content, banner_id, video) VALUES('<h1 style="text-align: center;"><strong><span style="font-size: 36pt;">GIỚI THI&Ecirc;̣U CHUNG</span></strong></h1>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Được th&agrave;nh lập v&agrave;o năm 1990 v&agrave; trở th&agrave;nh trường đại học c&ocirc;ng lập từ&nbsp;năm 2006, đến nay Trường Đại học Mở Th&agrave;nh phố Hồ Ch&iacute; Minh l&agrave; trường đại học đa ng&agrave;nh trực thuộc Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo, c&oacute; nhiệm vụ đ&agrave;o tạo đại học v&agrave; sau đại học, với c&aacute;c h&igrave;nh thức đ&agrave;o tạo&nbsp;ch&iacute;nh quy v&agrave; gi&aacute;o dục thường xuy&ecirc;n, đ&agrave;o tạo c&aacute;c điểm vệ tinh ,&hellip;nhằm đ&aacute;p ứng nhu cầu học tập đa dạng của x&atilde; hội, g&oacute;p phần tăng&nbsp;cường đội ngũ c&aacute;n bộ khoa học-kỹ thuật cho đất nước.</span></p>
<p style="text-align: justify;">&nbsp;</p>
<hr>
<p style="text-align: justify;">&nbsp;</p>
<p style="text-align: center;"><strong><span style="font-size: 36pt;">SỨ MẠNG</span></strong></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Sứ mạng ch&iacute;nh của Trường Đại học Mở TP.HCM l&agrave; g&oacute;p phần th&uacute;c đẩy x&atilde; hội học tập ph&aacute;t triển th&ocirc;ng qua việc truyền tải tri thức bằng c&aacute;c phương thức linh hoạt v&agrave; thuận tiện nhất cho người học.</span></p>
<p style="text-align: justify;">&nbsp;</p>
<hr>
<p style="text-align: justify;">&nbsp;</p>
<p style="text-align: center;"><strong><span style="font-size: 36pt;">TẦM NH&Igrave;N</span></strong></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Trường Đại học Mở TP.HCM phấn đấu đến năm 2023 trở th&agrave;nh trường đại học c&ocirc;ng lập đa ng&agrave;nh h&agrave;ng đầu ở Việt Nam với định hướng ứng dụng, phổ cập kiến thức v&agrave; phục vụ cộng đồng; trong đ&oacute; hoạt động đ&agrave;o tạo từ xa ph&aacute;t triển ngang tầm khu vực.</span></p>
<p style="text-align: justify;">&nbsp;</p>
<hr>
<p style="text-align: justify;">&nbsp;</p>
<p style="text-align: center;"><strong><span style="font-size: 36pt;">GI&Aacute; TRỊ CỐT L&Otilde;I</span></strong></p>
<p style="text-align: center; line-height: 1.5;"><em><span style="font-size: 14pt;">Mở rộng tri thức</span></em></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">C&aacute;c phương thức đ&agrave;o tạo đa dạng v&agrave; linh hoạt, ph&ugrave; hợp với người học ở mọi nơi với nền tảng kiến thức v&agrave; điều kiện học tập kh&aacute;c nhau.</span></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Phương ch&acirc;m giảng dạy l&agrave; l&agrave;m cho kiến thức trở th&agrave;nh đơn giản, dễ hiểu v&agrave; hữu dụng.</span></p>
<p style="text-align: justify; line-height: 1.5;">&nbsp;</p>
<p style="text-align: center; line-height: 1.5;"><em><span style="font-size: 14pt;">Gắn kết thực tiễn</span></em></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Kiến thức được giảng dạy k&egrave;m theo hướng dẫn &aacute;p dụng trong thực tiễn c&ocirc;ng việc của người học. </span><span style="font-size: 14pt;">Chương tr&igrave;nh đ&agrave;o tạo được cập nhật theo những y&ecirc;u cầu ph&aacute;t sinh từ thực tế.</span></p>
<p style="text-align: justify; line-height: 1.5;">&nbsp;</p>
<p style="text-align: center; line-height: 1.5;"><em><span style="font-size: 14pt;">Phục vụ cộng đồng</span></em></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">C&aacute;c hoạt động đ&agrave;o tạo v&agrave; nghi&ecirc;n cứu phục vụ cho cộng đồng v&agrave; lợi &iacute;ch x&atilde; hội.<br>Giảng vi&ecirc;n, sinh vi&ecirc;n v&agrave; đội ngũ c&aacute;n bộ nh&acirc;n vi&ecirc;n nh&agrave; trường tham gia t&iacute;ch cực c&aacute;c hoạt động cộng đồng.</span></p>
<p style="text-align: justify; line-height: 1.5;">&nbsp;</p>
<p style="text-align: center; line-height: 1.5;"><em><span style="font-size: 14pt;">Chuy&ecirc;n nghiệp, hiệu quả, s&aacute;ng tạo v&agrave; th&acirc;n thiện</span></em></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;">Đội ngũ chuy&ecirc;n nghiệp với khả năng thực hiện th&agrave;nh thạo c&ocirc;ng việc giảng dạy, nghi&ecirc;n cứu v&agrave; tổ chức đ&agrave;o tạo với hiệu quả cao nhất.</span></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;"><br>Tư duy s&aacute;ng tạo được thể hiện với tinh thần đổi mới c&aacute;ch nghĩ, c&aacute;ch l&agrave;m, biến th&aacute;ch thức th&agrave;nh cơ hội.</span></p>
<p style="text-align: justify; line-height: 1.5;"><span style="font-size: 14pt;"><br>M&ocirc;i trường l&agrave;m việc v&agrave; học tập th&acirc;n thiện với th&aacute;i độ hợp t&aacute;c, t&ocirc;n trọng lẫn nhau để c&ugrave;ng đạt mục ti&ecirc;u.</span></p>', 1, '_4QK81DnsEI');
INSERT INTO `images` (url, banner_id) VALUES('https://res.cloudinary.com/dttbj4ypm/image/upload/v1680126613/acrpuucftens5dkdfed7.png', 1);
INSERT INTO `images` (url, banner_id) VALUES('https://res.cloudinary.com/dttbj4ypm/image/upload/v1680128108/rbbk8fgkq6c4dhfmzgdj.png', 1);
INSERT INTO `images` (url, banner_id) VALUES('https://res.cloudinary.com/dttbj4ypm/image/upload/v1680128112/xs0gwboryz3sv3ppclq0.png', 1);
INSERT INTO `images` (url, banner_id) VALUES('https://res.cloudinary.com/dttbj4ypm/image/upload/v1680128117/jwdubghax4qhb0ggqbg4.png', 1);
INSERT INTO `images` (url, banner_id) VALUES('https://res.cloudinary.com/dttbj4ypm/image/upload/v1680128123/zcegdbbncc4bjjbh0knv.png', 1);
-- END UPDATE


INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('1', 'Quản trị kinh doanh', 'zWVCv5qWGw3T9qvpiMIT');
INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('2', 'Công nghệ thông tin', 'zWVCv5qWGw3T9qvpiMIU');
INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('3', 'Kinh tế - Quản lí công', 'zWVCv5qWGw3T9qvpiMIV');
INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('4', 'Đông Nam Á', 'zWVCv5qWGw3T9qvpiMIW');
INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('5', 'Ngoại ngữ ', 'zWVCv5qWGw3T9qvpiMIX');
INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('6', 'Xây dựng', 'zWVCv5qWGw3T9qvpiMIY');

INSERT INTO `livestreams` (`id`, `title`,`description`, `image`, `link`, `start_time`, `start_date`, `duration`, `start_question_time`, `end_question_time`) 
VALUES ('1', 'Tư vấn tuyển sinh ngành công nghệ thông tin', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1680272340/ztsqjeir1bowet4s3rs7.png', 'https://www.facebook.com/watch/live/?ref=watch_permalink&v=1341649012941254', '9:00:00', '2023-03-20', '55', '9:15:00', '9:25:00');
INSERT INTO `livestreams` (`id`, `title`,`description`, `image`, `link`, `start_time`, `start_date`, `duration`, `start_question_time`, `end_question_time`) 
VALUES ('2', 'Tư vấn tuyển sinh ngành công nghệ thông tin', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1680272340/ztsqjeir1bowet4s3rs7.png', 'https://www.facebook.com/watch/live/?ref=watch_permalink&v=1341649012941254', '9:00:00', '2023-03-20', '55', '9:15:00', '9:25:00');
INSERT INTO `livestreams` (`id`, `title`,`description`, `image`, `link`, `start_time`, `start_date`, `duration`, `start_question_time`, `end_question_time`) 
VALUES ('3', 'Tư vấn tuyển sinh ngành công nghệ thông tin', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1680272340/ztsqjeir1bowet4s3rs7.png', 'https://www.facebook.com/watch/live/?ref=watch_permalink&v=1341649012941254', '9:00:00', '2023-03-20', '55', '9:15:00', '9:25:00');

INSERT INTO `questions` (`id`, `content`, `user_id`, `livestream_id`) VALUES ('1', 'Dự đoán điểm năm nay ?', 'BxST2aBzsduwWLw1cxEQ', '1');
