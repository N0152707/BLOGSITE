DROP SCHEMA IF EXISTS blogsite ;

CREATE SCHEMA IF NOT EXISTS blogsite;

USE blogsite ;

CREATE TABLE IF NOT EXISTS blogsite.category (
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (category_id)
);


CREATE TABLE IF NOT EXISTS blogsite.user_blog (
  user_blog_id INT NOT NULL AUTO_INCREMENT,
  user_blog_name VARCHAR(45) NOT NULL,
  user_blog_password VARCHAR(45) NOT NULL,
  user_blog_first_name VARCHAR(45) NOT NULL,
  user_blog_last_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_blog_id)
);


CREATE TABLE IF NOT EXISTS blogsite.blog (
  blog_id INT NOT NULL AUTO_INCREMENT,
  blog_published VARCHAR(45) NOT NULL,
  blog_date_published DATE NOT NULL,
  blog_title VARCHAR(45) NOT NULL,
  blog_article VARCHAR(45) NOT NULL,
  blog_deleted VARCHAR(45) NOT NULL,,
  PRIMARY KEY (blog_id),
);

CREATE TABLE IF NOT EXISTS blogsite.role (
  role_id INT NOT NULL,
  role_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (role_id)
);

CREATE TABLE IF NOT EXISTS blogsite.tag (
  tag_id INT NOT NULL AUTO_INCREMENT,
  tag_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (tag_id)
);


CREATE TABLE IF NOT EXISTS blogsite.blog_has_tag (
  blog_blog_id INT NOT NULL,
  tag_tag_id INT NOT NULL,
  PRIMARY KEY (blog_blog_id, tag_tag_id),
  INDEX fk_blog_has_tag_tag1_idx (tag_tag_id ASC),
  INDEX fk_blog_has_tag_blog1_idx (blog_blog_id ASC),
  CONSTRAINT fk_blog_has_tag_blog1
    FOREIGN KEY (blog_blog_id)
    REFERENCES blogsite.blog (blog_id),
  CONSTRAINT fk_blog_has_tag_tag1
    FOREIGN KEY (tag_tag_id)
    REFERENCES blogsite.tag (tag_id)
);


CREATE TABLE IF NOT EXISTS blogsite.role_has_user_blog (
  role_role_id INT NOT NULL,
  user_blog_user_blog_id INT NOT NULL,
  PRIMARY KEY (role_role_id, user_blog_user_blog_id),
  CONSTRAINT fk_role_has_user_blog_role1
    FOREIGN KEY (role_role_id)
    REFERENCES blogsite.role (role_id),
  CONSTRAINT fk_role_has_user_blog_user_blog1
    FOREIGN KEY (user_blog_user_blog_id)
    REFERENCES blogsite.user_blog (user_blog_id)
);

INSERT INTO `blogsite`.`role`
(`role_id`,
`role_name`)
VALUES
(1,"admin");


INSERT INTO `blogsite`.`role`
(`role_id`,
`role_name`)
VALUES
(2,"write");


INSERT INTO `blogsite`.`role`
(`role_id`,
`role_name`)
VALUES
(3,"read");
