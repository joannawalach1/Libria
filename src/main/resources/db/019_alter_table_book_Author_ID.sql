ALTER TABLE book
ADD COLUMN author_id BIGINT;
ALTER TABLE book
ADD FOREIGN KEY (author_id) REFERENCES author(id);
ALTER TABLE book
DROP COLUMN author;