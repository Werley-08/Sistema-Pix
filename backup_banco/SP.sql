PGDMP                       |            SP    17.2    17.2      >           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            @           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            A           1262    16404    SP    DATABASE     {   CREATE DATABASE "SP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "SP";
                     postgres    false            ά            1259    16434    contasbancarias    TABLE       CREATE TABLE public.contasbancarias (
    id integer NOT NULL,
    agencia character varying(20) NOT NULL,
    conta character varying(20) NOT NULL,
    login character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    telefone character varying(15),
    telefoneassociado character varying(3),
    cpf character varying(15),
    cpfassociado character varying(3),
    email character varying(255),
    emailassociado character varying(3),
    cnpj character varying(14),
    cnpjassociado character varying(3),
    chavealeatoria character varying(255),
    saldo double precision,
    chavealeatoriaassociada character varying(3)
);
 #   DROP TABLE public.contasbancarias;
       public         heap r       postgres    false            Ϋ            1259    16433    contasbancarias_id_seq    SEQUENCE        CREATE SEQUENCE public.contasbancarias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.contasbancarias_id_seq;
       public               postgres    false    220            B           0    0    contasbancarias_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.contasbancarias_id_seq OWNED BY public.contasbancarias.id;
          public               postgres    false    219            Ω            1259    16405    usuarios    TABLE     \  CREATE TABLE public.usuarios (
    id integer NOT NULL,
    login character varying(100),
    senha character varying(100),
    nome character varying(100),
    tipopessoa character(1),
    cpf character varying(20),
    cnpj character varying(20),
    telefone character varying(15),
    email character varying(100),
    datadenascimento date
);
    DROP TABLE public.usuarios;
       public         heap r       postgres    false            Ϊ            1259    16408    usuarios_id_seq    SEQUENCE        CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public               postgres    false    217            C           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public               postgres    false    218                       2604    16437    contasbancarias id    DEFAULT     x   ALTER TABLE ONLY public.contasbancarias ALTER COLUMN id SET DEFAULT nextval('public.contasbancarias_id_seq'::regclass);
 A   ALTER TABLE public.contasbancarias ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    219    220                       2604    16409    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    218    217            ;          0    16434    contasbancarias 
   TABLE DATA           Χ   COPY public.contasbancarias (id, agencia, conta, login, senha, telefone, telefoneassociado, cpf, cpfassociado, email, emailassociado, cnpj, cnpjassociado, chavealeatoria, saldo, chavealeatoriaassociada) FROM stdin;
    public               postgres    false    220   ¬)       8          0    16405    usuarios 
   TABLE DATA           t   COPY public.usuarios (id, login, senha, nome, tipopessoa, cpf, cnpj, telefone, email, datadenascimento) FROM stdin;
    public               postgres    false    217   Ι)       D           0    0    contasbancarias_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.contasbancarias_id_seq', 10, true);
          public               postgres    false    219            E           0    0    usuarios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuarios_id_seq', 19, true);
          public               postgres    false    218                       2606    16441 $   contasbancarias contasbancarias_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT contasbancarias_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT contasbancarias_pkey;
       public                 postgres    false    220                       2606    16509    contasbancarias unique_agencia 
   CONSTRAINT     \   ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT unique_agencia UNIQUE (agencia);
 H   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT unique_agencia;
       public                 postgres    false    220                       2606    16432    usuarios unique_cnpj 
   CONSTRAINT     O   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_cnpj UNIQUE (cnpj);
 >   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_cnpj;
       public                 postgres    false    217                        2606    16511    contasbancarias unique_conta 
   CONSTRAINT     X   ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT unique_conta UNIQUE (conta);
 F   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT unique_conta;
       public                 postgres    false    220                       2606    16428    usuarios unique_cpf 
   CONSTRAINT     M   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_cpf UNIQUE (cpf);
 =   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_cpf;
       public                 postgres    false    217                       2606    16430    usuarios unique_email 
   CONSTRAINT     Q   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_email UNIQUE (email);
 ?   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_email;
       public                 postgres    false    217                       2606    16422    usuarios unique_login 
   CONSTRAINT     Q   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_login UNIQUE (login);
 ?   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_login;
       public                 postgres    false    217                       2606    16424    usuarios unique_senha 
   CONSTRAINT     Q   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_senha UNIQUE (senha);
 ?   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_senha;
       public                 postgres    false    217                       2606    16426    usuarios unique_telefone 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT unique_telefone UNIQUE (telefone);
 B   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT unique_telefone;
       public                 postgres    false    217                       2606    16411    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public                 postgres    false    217            ‘           2606    16497    contasbancarias fk_cnpj    FK CONSTRAINT        ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_cnpj FOREIGN KEY (cnpj) REFERENCES public.usuarios(cnpj) ON UPDATE CASCADE ON DELETE CASCADE;
 A   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_cnpj;
       public               postgres    false    4750    220    217            ’           2606    16487    contasbancarias fk_cpf    FK CONSTRAINT        ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_cpf FOREIGN KEY (cpf) REFERENCES public.usuarios(cpf) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_cpf;
       public               postgres    false    220    4752    217            £           2606    16492    contasbancarias fk_email    FK CONSTRAINT        ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_email FOREIGN KEY (email) REFERENCES public.usuarios(email) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_email;
       public               postgres    false    220    4754    217            €           2606    16472    contasbancarias fk_login    FK CONSTRAINT        ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_login FOREIGN KEY (login) REFERENCES public.usuarios(login) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_login;
       public               postgres    false    220    4756    217            ₯           2606    16477    contasbancarias fk_senha    FK CONSTRAINT        ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_senha FOREIGN KEY (senha) REFERENCES public.usuarios(senha) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_senha;
       public               postgres    false    4758    217    220            ¦           2606    16482    contasbancarias fk_telefone    FK CONSTRAINT     ¨   ALTER TABLE ONLY public.contasbancarias
    ADD CONSTRAINT fk_telefone FOREIGN KEY (telefone) REFERENCES public.usuarios(telefone) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.contasbancarias DROP CONSTRAINT fk_telefone;
       public               postgres    false    4760    220    217            ;      xΡγββ Ε ©      8      xΡγββ Ε ©     