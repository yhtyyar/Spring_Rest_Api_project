CREATE TABLE IF NOT EXISTS users
(
    id         BIGINT AUTO_INCREMENT,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    role       VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS events
(
    id         BIGINT AUTO_INCREMENT,
    user_id    BIGINT       NOT NULL,
    event_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE events
    ADD FOREIGN KEY (user_id) REFERENCES users (id);


CREATE TABLE IF NOT EXISTS files
(
    id        BIGINT AUTO_INCREMENT,
    event_id  BIGINT       NOT NULL,
    location  VARCHAR(256) NOT NULL,
    file_name VARCHAR(256) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE files
    ADD FOREIGN KEY (event_id) REFERENCES events (id);