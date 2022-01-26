INSERT INTO users (username, password, account_id, enabled)
    VALUES ('admin', '$2a$10$n43IA4sq8quJ63BnjwAffehgVlaekwqAVx28YX0rSMKl2WqMBSG9u', 'af470324', true);
/* password: admin */

INSERT INTO users (username, password, account_id, enabled)
    VALUES ('gabor', '$2a$10$xoin.Vas8TAh6Tf1tZe8heIqNEzF0SGCETaxJ6Q4OT4s7lgEKNgwu', '3g42ad06', true);
/* password: pass */

INSERT INTO authorities (username, authority)
    VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO authorities (username, authority)
    VALUES ('gabor', 'ROLE_USER');
