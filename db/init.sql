-- Table: public.teacher

-- DROP TABLE public.teacher;

CREATE TABLE IF NOT EXISTS public.teacher
(
    id_teacher integer NOT NULL,
    "nameTeacher" character varying COLLATE pg_catalog."default",
    "lastName" character varying COLLATE pg_catalog."default",
    cellphone character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    CONSTRAINT teacher_pkey PRIMARY KEY (id_teacher)
)

TABLESPACE pg_default;

ALTER TABLE public.teacher
    OWNER to jespinola;