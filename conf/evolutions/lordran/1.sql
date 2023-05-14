# --- !Ups
CREATE TABLE messages(
  id SERIAL PRIMARY KEY,
  text VARCHAR(255)
);

# --- !Downs
DROP TABLE messages;