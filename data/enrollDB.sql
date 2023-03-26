
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
);

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

-- Chinh Quy
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xc', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-28', '2023-03-01', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xb', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2023-02-01', '2023-02-20', 'CHINH_QUY', 'I4esDB8GDWMcVW40uA6x');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xd', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xe', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');
INSERT INTO `articles` (`id`, `title`, `content`, `description`, `image`, `created_date`, `update_date`, `article_type`, `user_id`) 
VALUES ('XRddcyw24gYJ40miY0xf', 'Secretart for Economic Air plane that looks like', '<h4><a href="latest_news.html">Secretart for Economic Air plane that looks like', 'Struggling to sell one multi-million dollar home currently on the market won’t stop actress and singer Jennifer Lopez.', 'https://res.cloudinary.com/dttbj4ypm/image/upload/v1679664554/whats_news_details4_y3jbdo.png', '2002-11-19', '2023-03-03', 'CHINH_QUY', 'UgT5veP8Nc8HUoGva1Kc');

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





INSERT INTO `faculties` (`id`, `name`, `article_id`) VALUES ('1', 'Quản trị kinh doanh', 'XRddcyw24gYJ40miY0xc');

INSERT INTO `livestreams` (`id`, `title`, `start_time`, `start_date`, `duration`, `start_question_time`, `end_question_time`) VALUES ('1', 'Tư vấn tuyển sinh ngành công nghệ thông tin', '9:00:00', '2023-03-20', '55', '9:15:00', '9:25:00');

INSERT INTO `questions` (`id`, `content`, `user_id`, `livestream_id`) VALUES ('1', 'Dự đoán điểm năm nay ?', 'BxST2aBzsduwWLw1cxEQ', '1');
