--Get all courses for a specific professor:
SELECT course_sections_id FROM faculty_courses
WHERE faculty_id =(SELECT faculty.id FROM faculty WHERE users_id = :userId)
ORDER BY course_sections_id ASC;
