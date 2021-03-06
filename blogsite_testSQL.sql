-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema blogsite_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS blogsite_test ;

-- -----------------------------------------------------
-- Schema blogsite_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS blogsite_test DEFAULT CHARACTER SET utf8 ;
USE blogsite_test ;

-- -----------------------------------------------------
-- Table blogsite_test.user_blog
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.user_blog ;

CREATE TABLE IF NOT EXISTS blogsite_test.user_blog (
  user_blog_id INT NOT NULL AUTO_INCREMENT,
  user_blog_name VARCHAR(45) NOT NULL,
  user_blog_password VARCHAR(45) NOT NULL,
  user_blog_first_name VARCHAR(45) NOT NULL,
  user_blog_last_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_blog_id));

-- -----------------------------------------------------
-- Table blogsite_test.category
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.category ;

CREATE TABLE IF NOT EXISTS blogsite_test.category (
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (category_id));

-- -----------------------------------------------------
-- Table blogsite_test.blog
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.blog ;

CREATE TABLE IF NOT EXISTS blogsite_test.blog (
  blog_id INT NOT NULL AUTO_INCREMENT,
  blog_published VARCHAR(1) NOT NULL,
  blog_date_published DATE NOT NULL,
  blog_title VARCHAR(45) NOT NULL,
  blog_article VARCHAR(500) NOT NULL,
  blog_deleted VARCHAR(1) NOT NULL,
  user_blog_user_blog_id INT NOT NULL,
  category_category_id INT NOT NULL,
  PRIMARY KEY (blog_id),
  INDEX fk_blog_user_blog1_idx (user_blog_user_blog_id ASC),
  INDEX fk_blog_category1_idx (category_category_id ASC),
  CONSTRAINT fk_blog_user_blog1
    FOREIGN KEY (user_blog_user_blog_id)
    REFERENCES blogsite_test.user_blog (user_blog_id),
  CONSTRAINT fk_blog_category1
    FOREIGN KEY (category_category_id)
    REFERENCES blogsite_test.category (category_id));

-- -----------------------------------------------------
-- Table blogsite_test.role
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.role ;

CREATE TABLE IF NOT EXISTS blogsite_test.role (
  role_id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (role_id));

-- -----------------------------------------------------
-- Table blogsite_test.tag
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.tag ;

CREATE TABLE IF NOT EXISTS blogsite_test.tag (
  tag_id INT NOT NULL AUTO_INCREMENT,
  tag_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (tag_id));

-- -----------------------------------------------------
-- Table blogsite_test.blog_has_tag
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.blog_has_tag ;

CREATE TABLE IF NOT EXISTS blogsite_test.blog_has_tag (
  blog_blog_id INT NOT NULL,
  tag_tag_id INT NOT NULL,
  PRIMARY KEY (blog_blog_id, tag_tag_id),
  INDEX fk_blog_has_tag_tag1_idx (tag_tag_id ASC),
  INDEX fk_blog_has_tag_blog1_idx (blog_blog_id ASC),
  CONSTRAINT fk_blog_has_tag_blog1
    FOREIGN KEY (blog_blog_id)
    REFERENCES blogsite_test.blog (blog_id),
  CONSTRAINT fk_blog_has_tag_tag1
    FOREIGN KEY (tag_tag_id)
    REFERENCES blogsite_test.tag (tag_id));

-- -----------------------------------------------------
-- Table blogsite_test.role_has_user_blog
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.role_has_user_blog ;

CREATE TABLE IF NOT EXISTS blogsite_test.role_has_user_blog (
  role_role_id INT NOT NULL,
  user_blog_user_blog_id INT NOT NULL,
  PRIMARY KEY (role_role_id, user_blog_user_blog_id),
  INDEX fk_role_has_user_blog_user_blog1_idx (user_blog_user_blog_id ASC),
  INDEX fk_role_has_user_blog_role1_idx (role_role_id ASC),
  CONSTRAINT fk_role_has_user_blog_role1
    FOREIGN KEY (role_role_id)
    REFERENCES blogsite_test.role (role_id),
  CONSTRAINT fk_role_has_user_blog_user_blog1
    FOREIGN KEY (user_blog_user_blog_id)
    REFERENCES blogsite_test.user_blog (user_blog_id));

-- -----------------------------------------------------
-- Table blogsite_test.static_page
-- -----------------------------------------------------
DROP TABLE IF EXISTS blogsite_test.static_page ;

CREATE TABLE IF NOT EXISTS blogsite_test.static_page (
  static_page_id INT NOT NULL AUTO_INCREMENT,
  stat_page_location VARCHAR(45) NULL,
  static_page_active VARCHAR(1) NULL,
  static_page_title VARCHAR(45) NULL,
  PRIMARY KEY (static_page_id));

INSERT INTO blogsite_test.role
(role_id,
role_name)
VALUES
(1,"Admin");


INSERT INTO blogsite_test.role
(role_id,
role_name)
VALUES
(2,"Author");


INSERT INTO blogsite_test.role
(role_id,
role_name)
VALUES
(3,"Read-Only");

INSERT INTO blogsite_test.category (category_name) values ("Baking");
INSERT INTO blogsite_test.user_blog (user_blog_name, user_blog_password, user_blog_first_name, user_blog_last_name) values ("sam716", "sam", "sam", "smith");