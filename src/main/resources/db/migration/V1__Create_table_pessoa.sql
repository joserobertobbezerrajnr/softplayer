CREATE SEQUENCE public.pessoa_idpessoa_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE public.pessoa
(
  idpessoa bigint NOT NULL DEFAULT nextval('pessoa_idpessoa_seq'::regclass),
  nome character varying(80) NOT NULL,
  sexo character varying(9),
  email character varying(80),
  dtnascimento date NOT NULL,
  naturalidade character varying(40),
  nacionalidade character varying(40),
  cpf character varying(11),
  dtcadastro timestamp without time zone,
  dtatualizacao timestamp without time zone,
  CONSTRAINT pessoa_pkey PRIMARY KEY (idpessoa),
  CONSTRAINT pessoa_ukey UNIQUE (cpf)
);