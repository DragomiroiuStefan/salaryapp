drop table if exists salaries;
drop table if exists users;
drop table if exists roles;
drop table if exists companies;
drop table if exists cities;
drop table if exists countries;
drop table if exists job_areas;
drop table if exists career_levels;

CREATE TABLE countries (
	country_code char (2) primary key,
	country_name varchar (50) unique not null
);

CREATE TABLE cities (
	city_id serial primary key,
	city_name varchar (50) unique not null,
	country_code varchar (50) references countries(country_code)
);

CREATE TABLE job_areas (
	area_id serial primary key,
	area_name varchar (50) unique not null
);

CREATE TABLE career_levels (
	level_id serial primary key,
	level_name varchar (20) unique not null,
	min_years_of_experience smallint,
	max_years_of_experience smallint
);

CREATE TABLE companies (
	company_id serial primary key,
	company_name varchar (50) unique not null,
	headquarters integer references cities(city_id),
	founded date,
	no_of_employees integer,
	website varchar (30)
);

CREATE TABLE salaries (
	salary_id serial primary key,
	job_title varchar(40) not null,
	area_id integer references job_areas(area_id),
	company_id integer references companies(company_id),
	location_id integer references cities(city_id),
	level_id integer references career_levels(level_id),
	added date not null,
	salary integer not null
);

CREATE TABLE roles (
	role_id serial primary key,
	role_name varchar (20) unique not null
);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	username VARCHAR (50) UNIQUE NOT NULL,
	password VARCHAR (50) NOT NULL,
	salt BYTEA NOT NULL,
	email VARCHAR (50) UNIQUE NOT NULL,
	created_on DATE NOT NULL,
	role_id INTEGER references roles(role_id)
);

