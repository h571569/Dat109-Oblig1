CREATE SCHEMA IF NOT EXISTS stigespill;

SET search_path TO stigespill;

CREATE TABLE slange (
    fra INTEGER NOT NULL,
    til INTEGER NOT NULL
);

CREATE TABLE stige (
    fra INTEGER NOT NULL,
    til INTEGER NOT NULL
);

--insetning data

SET search_path TO stigespill;

INSERT INTO stige (fra, til) VALUES
    (3, 22),
    (8, 26),
    (20, 38),
    (36, 57),
    (63, 81);

INSERT INTO slange (fra, til) VALUES
    (17, 7),
    (34, 14),
    (52, 29),
    (79, 54),
    (96, 72);