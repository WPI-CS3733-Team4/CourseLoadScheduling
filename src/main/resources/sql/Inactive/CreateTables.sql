CREATE TABLE users(
	id serial PRIMARY KEY,
	user_name varchar (255) UNIQUE NOT NULL,
	first_name varchar (255) NOT NULL,
	last_name varchar (255) NOT NULL,
	email varchar (255) UNIQUE NOT NULL,
	encrypted_password varchar (255) NOT NULL,
	salt varchar (255) NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)

);

CREATE TABLE users_permissions(
	id serial PRIMARY KEY,
	users_id integer NOT NULL REFERENCES users(id),
	role varchar (255) NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE OR REPLACE FUNCTION user_is_faculty(_users_id integer)
RETURNS boolean
LANGUAGE plpgsql AS
$body$
BEGIN
	IF 'faculty' = (SELECT role FROM users_permissions WHERE users_id = _users_id)
	THEN
		RETURN true;
	END IF;
	RETURN false;
END
$body$;

CREATE TABLE faculty (
	id serial PRIMARY KEY,
	users_id integer UNIQUE NOT NULL REFERENCES users(id),
	CHECK(user_is_faculty(users_id) = true),
	required_credits integer NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE FUNCTION ensure_user_is_faculty() RETURNS TRIGGER AS
$body$
BEGIN
	DELETE FROM faculty WHERE users_id = (SELECT users_id FROM users_permissions WHERE NOT role = 'faculty');
	RETURN NEW;
END
$body$
LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER update_users
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE PROCEDURE ensure_user_is_faculty();

CREATE TABLE courses(
	id serial PRIMARY KEY,
	course_name varchar (255) NOT NULL,
	course_description varchar (255) NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE course_sections (
	id serial PRIMARY KEY,
	courses_id integer NOT NULL REFERENCES courses(id),
	section_type varchar(255) NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE faculty_courses (
	id serial PRIMARY KEY,
	faculty_id integer NOT NULL REFERENCES faculty(id),
	course_sections_id integer NOT NULL REFERENCES course_sections(id),
	UNIQUE(faculty_id, course_sections_id),
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE departments(
	id serial PRIMARY KEY,
	department varchar (255) UNIQUE NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE faculty_departments (
	id serial PRIMARY KEY,
	faculty_id integer NOT NULL REFERENCES faculty(id),
	departments_id integer NOT NULL REFERENCES departments(id),
	UNIQUE(faculty_id, departments_id),
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE locations (
	id serial PRIMARY KEY,
	building varchar(255) NOT NULL,
	room integer NOT NULL,
	room_size integer NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE course_requests (
	id serial PRIMARY KEY,
	faculty_id integer NOT NULL REFERENCES faculty(id),
	course_sections_id integer NOT NULL REFERENCES course_sections(id),
	UNIQUE(faculty_id, course_sections_id),
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE terms (
	id serial PRIMARY KEY,
	term_name varchar(255) UNIQUE NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE course_sections_terms(
	id serial PRIMARY KEY,
	course_sections_id integer NOT NULL REFERENCES course_sections(id),
	terms_id integer NOT NULL REFERENCES terms(id),
	UNIQUE(course_sections_id, terms_id),
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE OR REPLACE FUNCTION check_course_times(_locations_id integer, _course_sections_id integer, _day_of_week integer, _start_time integer, _end_time integer)
RETURNS boolean
LANGUAGE plpgsql AS 
$body$
DECLARE
	_term_name varchar(255) := (SELECT term_name FROM terms WHERE id = (SELECT terms_id FROM course_sections_terms WHERE course_sections_id = _course_sections_id));
BEGIN
	CREATE TEMP TABLE temp_course_times(
		start_time integer,
		end_time integer
	);
	INSERT INTO temp_course_times
	SELECT start_time, end_time
	FROM course_times
	WHERE locations_id = _locations_id
	  AND (SELECT term_name FROM terms WHERE id = (SELECT terms_id FROM course_sections_terms WHERE course_sections_id = course_sections_id)) = _term_name
	  AND day_of_week = _day_of_week
	  AND (start_time BETWEEN _start_time AND _end_time
	      OR end_time BETWEEN _start_time AND _end_time);
	
	IF EXISTS (SELECT * FROM temp_course_times)
    	THEN
		RETURN false;
    END IF;
    RETURN true;
END
$body$;

CREATE TABLE course_times (
	id serial PRIMARY KEY,
	course_sections_id integer NOT NULL REFERENCES course_sections(id),
	day_of_week integer NOT NULL,
	start_time integer NOT NULL,
	end_time integer NOT NULL,
	locations_id integer NOT NULL REFERENCES locations(id),
	CHECK(check_course_times(locations_id, course_sections_id, day_of_week, start_time, end_time) = true),
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);

CREATE TABLE course_departments (
	id serial PRIMARY KEY,
	courses_id integer NOT NULL REFERENCES courses(id),
	departments_id integer NOT NULL REFERENCES departments(id),
	UNIQUE(courses_id, departments_id),
	course_number integer NOT NULL,
	created_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	updated_at timestamp with time zone NOT NULL DEFAULT(CURRENT_TIMESTAMP)
);


