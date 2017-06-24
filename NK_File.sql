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
blog_deleted) 
VALUES ("Y", "2017-05-18", "The Perfect Loaf", "While precision, time, and technique are important, you can
achieve a pretty fantastic loaf of homemade bread simply and quickly with a few key elements: (1) water, salt, yeast, fat, and 
quality flour high in protein, (2) a mixer with a kneading attachment, and (3) a dutch oven. That's it? Yes.", "N");

INSERT into blogsite.role
(role.role_name) VALUES ("Read-Only", "Author", "Admin");

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


INSERT into blogsite.blog_has_tag (blog_blog_id, tag_tag_id) VALUES (1, 1);
INSERT into blogsite.blog_has_tag (blog_blog_id, tag_tag_id) VALUES (1, 2);
INSERT into blogsite.blog_has_tag (blog_blog_id, tag_tag_id) VALUES (1, 3);

INSERT into blogsite.role_has_user_blog (role_role_id, user_blog_user_blog_id) values (1, 1);
