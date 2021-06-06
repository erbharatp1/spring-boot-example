create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token varchar(64) ,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication varchar(64),
  refresh_token VARCHAR(255)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token varchar(64),
  authentication varchar(64)
);