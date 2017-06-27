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
  blog_published VARCHAR(1) NOT NULL,
  blog_date_published DATE NOT NULL,
  blog_title VARCHAR(45) NOT NULL,
  blog_article VARCHAR(500) NOT NULL,
  blog_deleted VARCHAR(1) NOT NULL,
category_category_id INT NOT NULL,
  user_blog_user_blog_id INT NOT NULL,

  PRIMARY KEY (blog_id),
  CONTSTRAINT fk_blog_category
  FOREIGN KEY (category_category_id)
  REFERENCES blogsite.category (category_id)
  CONTSTRAINT fk_blog_user_blog
  FOREIGN KEY (user_blog_user_blog_id)
  REFERENCES blogsite.user_blog (user_blog_id)
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

INSERT INTO blogsite.role
(role_id,
role_name)
VALUES
(1,"Admin");


INSERT INTO blogsite.role
(role_id,
role_name)
VALUES
(2,"Author");


INSERT INTO blogsite.role
(role_id,
role_name)
VALUES
(3,"Read-Only");


INSERT into blogsite.user_blog 
(user_blog_name, 
user_blog_password, 
user_blog_first_name,
user_blog_last_name)
values ("bakerDude23", "balloon", "Brett", "Breadmaker");

INSERT INTO blogsite.category (category_name) values ("Baking");

INSERT into blogsite.blog 
(blog_published, 
blog_date_published, 
blog_title, 
blog_article,
category_category_id,
 user_blog_user_blog_id,
blog_deleted) 
VALUES ("Y", "2017-05-18", "The Perfect Bread", "While precision, time, and technique are important, you can
achieve a pretty fantastic loaf of homemade bread simply and quickly with a few key elements: (1) water, salt, yeast, fat, and 
quality flour high in protein, (2) a mixer with a kneading attachment, and (3) a dutch oven. That's it? Who knows.", 1, 1, "N");

INSERT INTO blogsite.category (category_name) values ("Living");

INSERT into blogsite.blog 
(blog_published, 
blog_date_published, 
blog_title, 
blog_article,
category_category_id,
 user_blog_user_blog_id,
blog_deleted) 
VALUES ("Y", "2016-05-18", "Starting A Pretty Great Day", "Wake up early after a restful night's sleep and walk out the front
door into perfect weather for a run that rejuvenates your mind and body. Then, head to a local bakery for a fresh and delicious breakfast with 
a friend.", 2, 1, "N");

INSERT INTO blogsite.tag
(tag_id,
tag_name)
VALUES
(1,
"#bread");

INSERT INTO blogsite.tag
(tag_id,
tag_name)
VALUES
(2 , "#baking");

INSERT INTO blogsite.tag
(tag_id,
tag_name)
VALUES
(3 , "#perfect loaf");

INSERT INTO blogsite.category 
(category_name) VALUES ("Woodwork Projects");

select * from blogsite.category ;