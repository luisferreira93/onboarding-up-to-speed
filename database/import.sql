CREATE TABLE IF NOT EXISTS public.logmanaging (
   text_id serial PRIMARY KEY,
   text_phrase VARCHAR (100) NOT NULL,
   request_time DATE NOT NULL
);

CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 NOCYCLE;
