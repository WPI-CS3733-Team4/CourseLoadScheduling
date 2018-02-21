INSERT INTO users(user_name,first_name,last_name,email,encrypted_password,salt) VALUES
('TEMP1','Aparna','Mahadev','Mahadev','',''),
('A1K','Kabir','Ahmedul','Ahmedul','',''),
('BN1','Blake','Nelson','Nelson','',''),
('CEW','Craig','Willis','Willis','',''),
('CKN','Chun-Kit','Ngan','Ngan','',''),
('CR','Carolina','Ruiz','Ruiz','',''),
('CR1','Charles','Rich','Rich','',''),
('CS2','Craig','Shue','Shue','',''),
('CP4','Carol','Pinciroli','Pinciroli','',''),
('DJD','Dan','Dougherty','Dougherty','',''),
('DK2','Dimitry','Korkin','Korkin','',''),
('DS4','Doug','Selent','Selent','',''),
('EAR','Elke','Rundensteiner','Rundensteiner','',''),
('EOA','Emmanuel','Agu','Agu','',''),
('GFP','Gary','Pollice','Pollice','',''),
('GMH','Glynis','Hamel','Hamel','',''),
('GTH','Gorge','Heineman','Heineman','',''),
('GXS','Gabor ','Sarkozy','Sarkozy','',''),
('TEMP2','Hao','Loi','Loi','',''),
('HCL','Huge','Laurer','Laurer','',''),
('HJS','Herman','Servatius','Servatius','',''),
('JB7','Joe','Beck','Beck','',''),
('JJB','Jerry','Breecher','Breecher','',''),
('J1C','Joushua','Cuneo','Cuneo','',''),
('JSZ','J','Singh','Singh','',''),
('JT1','Jorge','Toro','Toro','',''),
('JRW','Jacob','Whitehill','Whitehill','',''),
('KKV','Krishna','Venkatasubramanian','Venkatasubramanian','',''),
('KP','Keith','Pray','Pray','',''),
('LTH','Lane','Harrison','Harrison','',''),
('MKH','Micha','Hofri','Hofri','',''),
('MLC','Mark','Claypool','Claypool','',''),
('MXC','Mike','Ciaraldi','Ciaraldi','',''),
('MXG','Mike','Gennert','Gennert','',''),
('MYE','Mohammed Y.','Eltabark','Eltabark','',''),
('NTH','Neil','Heffernan','Heffernan','',''),
('RJW','Robert','Walls','Walls','',''),
('RN1','Rodica','Neamtu','Neamtu','',''),
('SIM','Suzanne','Mello-Stark','Mello-Stark','',''),
('SL4','Susan','Landau','Landau','',''),
('TG1','Tian','Guo','Guo','',''),
('W1W','Wilson','Wong','Wong','',''),
('XK1','Xiangan','Kong','Kong','',''),
('YL2','Yanhua','Li','Li','','');

INSERT INTO users_permissions(users_id, role) VALUES
((SELECT id FROM users WHERE user_name = 'TEMP1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'A1K'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'BN1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CEW'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CKN'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CR'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CR1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CS2'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'CP4'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'DJD'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'DK2'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'DS4'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'EAR'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'EOA'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'GFP'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'GMH'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'GTH'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'GXS'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'TEMP2'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'HCL'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'HJS'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'JB7'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'JJB'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'J1C'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'JSZ'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'JT1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'JRW'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'KKV'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'KP'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'LTH'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'MKH'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'MLC'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'MXC'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'MXG'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'MYE'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'NTH'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'RJW'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'RN1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'SIM'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'SL4'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'TG1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'W1W'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'XK1'), 'faculty'),
((SELECT id FROM users WHERE user_name = 'YL2'), 'faculty');


INSERT INTO terms(term_name) VALUES
('A'),
('B'),
('C'),
('D'),
('E1'),
('E2');

INSERT INTO locations(building,room,room_size) VALUES
('HL',220,45);

INSERT INTO courses(course_name,course_description) VALUES
('201',''),
('453',''),
('502',''),
('503',''),
('509',''),
('513',''),
('525',''),
('528',''),
('534',''),
('539',''),
('542',''),
('543',''),
('548',''),
('558',''),
('565',''),
('583',''),
('584',''),
('585',''),
('586',''),
('1004',''),
('1101',''),
('1102',''),
('2011',''),
('2012',''),
('2022',''),
('2043',''),
('2102',''),
('2119',''),
('2223',''),
('2223',''),
('2301',''),
('2302',''),
('3013',''),
('3041',''),
('3043',''),
('3133',''),
('3431',''),
('3516',''),
('3733',''),
('4120',''),
('4123',''),
('4233',''),
('4341',''),
('4401',''),
('4432',''),
('4445',''),
('4513',''),
('4518',''),
('4536',''),
('4731',''),
('4803',''),
('5003',''),
('5007',''),
('23011',''),
('GPS',''),
('ProjA17',''),
('ProjC18','');

INSERT INTO departments(department) VALUES
('CS');

INSERT INTO faculty(users_id,required_credits) VALUES
((SELECT id FROM users WHERE user_name = 'TEMP1'),1);

INSERT INTO faculty_departments(faculty_id,departments_id) VALUES
((SELECT id FROM faculty WHERE users_id = (SELECT id FROM users WHERE user_name = 'TEMP1')),(SELECT id FROM departments WHERE department = 'CS'));

INSERT INTO course_departments(courses_id,departments_id,course_number) VALUES
((SELECT id FROM courses WHERE course_name = '1004'),(SELECT id FROM departments WHERE department = 'CS'),1004);

INSERT INTO course_sections(courses_id,section_type) VALUES
((SELECT id FROM courses WHERE course_name = '1004'),'C01');

INSERT INTO course_times(course_sections_id,day_of_week,start_time,end_time,locations_id) VALUES
((SELECT id FROM course_sections WHERE courses_id = (SELECT id FROM courses WHERE course_name = '1004')),1,1,2,(SELECT id FROM locations WHERE building = 'HL' AND room = 220));

INSERT INTO faculty_courses(faculty_id,course_sections_id) VALUES
((SELECT id FROM faculty WHERE users_id = (SELECT id FROM users WHERE user_name = 'TEMP1')),(SELECT id FROM course_sections WHERE courses_id = (SELECT id FROM courses WHERE course_name = '1004')));

INSERT INTO course_requests(faculty_id,course_sections_id) VALUES
((SELECT id FROM faculty WHERE users_id = (SELECT id FROM users WHERE user_name = 'TEMP1')),(SELECT id FROM course_sections WHERE courses_id = (SELECT id FROM courses WHERE course_name = '1004')));

INSERT INTO course_sections_terms(course_sections_id,terms_id) VALUES
((SELECT id FROM course_sections WHERE courses_id = (SELECT id FROM courses WHERE course_name = '1004')),(SELECT id FROM terms WHERE term_name = 'C'));

