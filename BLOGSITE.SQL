

DROP SCHEMA IF EXISTS blogsite;

CREATE SCHEMA IF NOT EXISTS blogsite;

USE blogsite;


CREATE TABLE IF NOT EXISTS category (
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (category_id)
);




CREATE TABLE IF NOT EXISTS user_blog (
  user_blog_id INT NOT NULL AUTO_INCREMENT,
  user_blog_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_blog_id)
);


CREATE TABLE IF NOT EXISTS blog (
  blog_id INT NOT NULL AUTO_INCREMENT,
  blog_published TINYINT(1) NOT NULL,
  blog_date_published DATETIME NOT NULL,
  blog_title VARCHAR(45) NOT NULL,
  blog_artical VARCHAR(45) NOT NULL,
  category_category_id INT NOT NULL,
  user_blog_user_blog_id INT NOT NULL,
  PRIMARY KEY (blog_id),
  CONSTRAINT fk_blog_category1
    FOREIGN KEY (category_category_id)
    REFERENCES category (category_id),
  CONSTRAINT fk_blog_user_blog1
    FOREIGN KEY (user_blog_user_blog_id)
    REFERENCES user_blog (user_blog_id)
);


CREATE TABLE IF NOT EXISTS role (
  role_id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (role_id)
);


CREATE TABLE IF NOT EXISTS tag (
  tag_id INT NOT NULL AUTO_INCREMENT,
  tag_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (tag_id)
);



CREATE TABLE IF NOT EXISTS blog_has_tag (
  blog_blog_id INT NOT NULL,
  tag_tag_id INT NOT NULL,
  PRIMARY KEY (blog_blog_id, tag_tag_id),
  INDEX fk_blog_has_tag_tag1_idx (tag_tag_id ASC),
  INDEX fk_blog_has_tag_blog1_idx (blog_blog_id ASC),
  CONSTRAINT fk_blog_has_tag_blog1
    FOREIGN KEY (blog_blog_id)
    REFERENCES blog (blog_id),
  CONSTRAINT fk_blog_has_tag_tag1
    FOREIGN KEY (tag_tag_id)
    REFERENCES tag (tag_id)
);




CREATE TABLE IF NOT EXISTS role_has_user_blog (
  role_role_id INT NOT NULL,
  user_blog_user_blog_id INT NOT NULL,
  PRIMARY KEY (role_role_id, user_blog_user_blog_id),
  INDEX fk_role_has_user_blog_user_blog1_idx (user_blog_user_blog_id ASC),
  INDEX fk_role_has_user_blog_role1_idx (role_role_id ASC),
  CONSTRAINT fk_role_has_user_blog_role1
    FOREIGN KEY (role_role_id)
    REFERENCES role (role_id),
  CONSTRAINT fk_role_has_user_blog_user_blog1
    FOREIGN KEY (user_blog_user_blog_id)
    REFERENCES user_blog (user_blog_id)
);

