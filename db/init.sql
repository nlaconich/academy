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