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
    (1, 21),    
    (22, 39),    
    (68, 88),    
    (36, 56),    
    (63, 83);    

INSERT INTO slange (fra, til) VALUES
    (17, 4),    
    (34, 14),    
    (52, 29),    
    (79, 59),   
    (96, 76);    