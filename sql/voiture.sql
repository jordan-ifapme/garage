CREATE TABLE public.voiture
(
    id numeric,
    couleur character varying,
    marque character varying,
    modele character varying,
    kilometre numeric,
    kilometre_entretient numeric,
    user_id numeric,
    PRIMARY KEY (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.voiture
    OWNER to postgres;
