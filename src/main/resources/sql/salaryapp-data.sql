insert into career_levels(level_name, min_years_of_experience, max_years_of_experience) values
('Junior', 0, 2),
('Middle', 2, 5),
('Senior', 5, 10),
('Executive', 10, null);

insert into countries values
('FR', 'France'), 
('GR', 'Germany'),
('NL', 'Netherlands'),
('RO', 'Romania'),
('ES', 'Spain'), 
('SE', 'Sweden');

insert into cities(city_name, country_code) values
('Bucharest', 'RO'),
('Cluj', 'RO'),
('Timisoara', 'RO'),
('Amsterdam', 'NL'),
('Berlin', 'GR'),
('Munich', 'GR');

insert into companies(company_name, headquarters, founded, no_of_employees, website) values
('BRD', 1, '1950-01-01', 2000, 'www.brd.ro'),
('Adobe', 1, '2000-01-01', 500, 'www.adobe.ro'),
('ING', 1, '2000-01-01', 500, 'www.ing.ro');

insert into job_areas (area_name) values
('Machine Learning'),
('Security'),
('Software Engineer'),
('Web Development (Back End)'),
('Web Development (Front End)'),
('QA / Testing'),
('Site Reliability'),
('Full Stack'),
('DevOps'),
('Networking');

insert into roles (role_name) values
('user'),
('admin');

insert into salaries (job_title, area_id, company_id, location_id, level_id, added, salary) values
('Java Developer', 3, 2, 1, 1, NOW(), 4500),
('Java Developer', 3, 2, 1, 2, NOW(), 7000),
('Java Developer', 3, 2, 1, 3, NOW(), 12000),
('Java Developer', 3, 3, 1, 1, NOW(), 4000),
('Java Developer', 3, 3, 1, 2, NOW(), 6000),
('Java Developer', 3, 3, 1, 3, NOW(), 13000),
('Angular Developer', 5, 1, 1, 1, NOW(), 4000),
('Angular Developer', 5, 1, 1, 2, NOW(), 6000),
('Angular Developer', 5, 1, 1, 3, NOW(), 10000),
('Angular Developer', 5, 3, 1, 1, NOW(), 5000),
('Angular Developer', 5, 3, 1, 2, NOW(), 7000),
('Angular Developer', 5, 3, 1, 3, NOW(), 11000),
('Dev ops engineer', 9, 1, 1, 2, NOW(), 7000),
('Dev ops engineer', 9, 1, 1, 3, NOW(), 12000),
('Dev ops engineer', 9, 2, 1, 2, NOW(), 8000),
('Dev ops engineer', 9, 2, 1, 3, NOW(), 14000);