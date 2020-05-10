CREATE TABLE company (
    symbol VARCHAR(36) PRIMARY KEY,
    name VARCHAR(36),
    created_date TIMESTAMP(6) NOT NULL,
    modified_date TIMESTAMP(6) NOT NULL
);

CREATE TABLE tweet_user (
    screen_name VARCHAR(36) PRIMARY KEY,
    fk_company VARCHAR(36) NOT NULL,
    created_date TIMESTAMP(6) NOT NULL,
    modified_date TIMESTAMP(6) NOT NULL
);

ALTER TABLE PUBLIC.tweet_user
ADD FOREIGN KEY (fk_company)
REFERENCES PUBLIC.company(symbol);