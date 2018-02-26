--Get a specific course(s) professor(s)
SELECT users.* FROM users WHERE id = 
(SELECT users_id FROM faculty WHERE id = 
(SELECT faculty_id FROM faculty_courses WHERE course_sections_id = :courseSectionsId))
ORDER BY users.id ASC; 

