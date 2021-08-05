/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nick
 * Created: 27 jul. 2021
 */

CREATE TABLE IF NOT EXISTS public.student
(
    id_student integer NOT NULL DEFAULT nextval('student_id_student_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    lastname character varying COLLATE pg_catalog."default",
    cellphone character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    CONSTRAINT pk_student PRIMARY KEY (id_student)
)

TABLESPACE pg_default;

ALTER TABLE public.student
    OWNER to developer;
-----------------------------------------------------
SELECT c.id_course, c.name_course, a.name_assignment FROM public.course c, public.assignment a WHERE (c.id_assignment1 = a.id_assignment) or (c.id_assignment2 = a.id_assignment) or (c.id_assignment3 = a.id_assignment) or (c.id_assignment4 = a.id_assignment)
-----------------------------------------------------
-- Table: public.assignment

-- DROP TABLE public.assignment;

CREATE TABLE IF NOT EXISTS public.assignment
(
    id_assignment integer NOT NULL DEFAULT nextval('assignment_id_assignment_seq'::regclass),
    name_assignment character varying COLLATE pg_catalog."default",
    CONSTRAINT assignment_pk PRIMARY KEY (id_assignment)
)

TABLESPACE pg_default;

ALTER TABLE public.assignment
    OWNER to developer;
----------------------------------------------------------
-- Table: public.course

-- DROP TABLE public.course;

CREATE TABLE IF NOT EXISTS public.course
(
    id_course integer NOT NULL DEFAULT nextval('course_id_course_seq'::regclass),
    name_course character varying COLLATE pg_catalog."default",
    id_teacher integer,
    id_assignment integer,
    id_assignment2 integer,
    CONSTRAINT course_pk PRIMARY KEY (id_course),
    CONSTRAINT id_assignment FOREIGN KEY (id_assignment)
        REFERENCES public.assignment (id_assignment) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT id_assignment2 FOREIGN KEY (id_assignment2)
        REFERENCES public.assignment (id_assignment) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_teacher FOREIGN KEY (id_teacher)
        REFERENCES public.teacher (id_teacher) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.course
    OWNER to developer;
----------------------------------------------------------
-- Table: public.inscription

-- DROP TABLE public.inscription;

CREATE TABLE IF NOT EXISTS public.inscription
(
    id_inscription integer NOT NULL DEFAULT nextval('inscription_id_inscription_seq'::regclass),
    id_course integer,
    id_student integer,
    CONSTRAINT inscription_pk PRIMARY KEY (id_inscription),
    CONSTRAINT id_course FOREIGN KEY (id_course)
        REFERENCES public.course (id_course) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT id_student FOREIGN KEY (id_student)
        REFERENCES public.student (id_student) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.inscription
    OWNER to developer;
-----------------------------------------------------
-- Table: public.teacher

-- DROP TABLE public.teacher;

CREATE TABLE IF NOT EXISTS public.teacher
(
    id_teacher integer NOT NULL DEFAULT nextval('teacher_id_teacher_seq'::regclass),
    name_teacher character varying COLLATE pg_catalog."default",
    lastname character varying COLLATE pg_catalog."default",
    cellphone character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    CONSTRAINT teacher_pkey PRIMARY KEY (id_teacher)
)

TABLESPACE pg_default;

ALTER TABLE public.teacher
    OWNER to developer;