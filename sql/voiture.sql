CREATE TABLE IF NOT EXISTS public.voiture
(
    numero_plaque character varying NOT NULL,
    couleur character varying COLLATE pg_catalog."default",
    marque character varying COLLATE pg_catalog."default",
    modele character varying COLLATE pg_catalog."default",
    kilometre numeric,
    kilometre_entretient numeric,
    user_id numeric,
    CONSTRAINT voiture_pkey PRIMARY KEY (numero_plaque),
    CONSTRAINT user_fk FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

ALTER TABLE IF EXISTS public.voiture
    OWNER to postgres;
