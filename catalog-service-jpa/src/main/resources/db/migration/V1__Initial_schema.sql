CREATE TABLE track (
      id                  BIGSERIAL PRIMARY KEY NOT NULL,
      artist              varchar(255) NOT NULL,
      track_id                varchar(255) UNIQUE NOT NULL,
      price               float8 NOT NULL,
      title               varchar(255) NOT NULL,
      created_date        timestamp NOT NULL,
      last_modified_date  timestamp NOT NULL,
      version             integer NOT NULL
);