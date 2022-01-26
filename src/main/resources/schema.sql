DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  account_id VARCHAR(32) NOT NULL,
  enabled TINYINT(1) DEFAULT 1
);

CREATE TABLE authorities (
  username VARCHAR_IGNORECASE(50) NOT NULL,
  authority VARCHAR_IGNORECASE(50) NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);