CREATE DATABASE sb

CREATE TABLE IF NOT EXISTS public.cliente_pj
(
    conta character varying(15) COLLATE pg_catalog."default" NOT NULL,
    agencia character varying(6) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(15) COLLATE pg_catalog."default" NOT NULL,
    saldo numeric(17,2) NOT NULL,
    limite numeric(11,2) NOT NULL,
    cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
    razao_social character varying(70) COLLATE pg_catalog."default" NOT NULL,
    nome_fantasia character varying(70) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cliente_pj_pkey PRIMARY KEY (conta),
    CONSTRAINT cliente_pj_cnpj_key UNIQUE (cnpj),
    CONSTRAINT cliente_pj_telefone_key UNIQUE (telefone)
)

CREATE TABLE IF NOT EXISTS public.cliente_pj
(
    conta character varying(15) COLLATE pg_catalog."default" NOT NULL,
    agencia character varying(6) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(15) COLLATE pg_catalog."default" NOT NULL,
    saldo numeric(17,2) NOT NULL,
    limite numeric(11,2) NOT NULL,
    cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
    razao_social character varying(70) COLLATE pg_catalog."default" NOT NULL,
    nome_fantasia character varying(70) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cliente_pj_pkey PRIMARY KEY (conta),
    CONSTRAINT cliente_pj_cnpj_key UNIQUE (cnpj),
    CONSTRAINT cliente_pj_telefone_key UNIQUE (telefone)
)