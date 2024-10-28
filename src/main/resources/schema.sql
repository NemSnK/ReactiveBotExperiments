CREATE TABLE IF NOT EXISTS tutorial
(
    id          INT NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255),
    description VARCHAR(255),
    published   BOOLEAN,
    PRIMARY KEY (id)
);

insert into tutorial (title, description, published)
VALUES ('Первый заголовок', 'some discription', true),
       ('Второй заголовок', 'some discription', true),
       ('Третьий заголовок', 'some discription', true),
       ('Четвертый заголовок', 'some discription', true),
       ('Пятый заголовок', 'some discription', true);
-- DROP TABLE INFORMATION_SCHEMA.TUTORIAL;,