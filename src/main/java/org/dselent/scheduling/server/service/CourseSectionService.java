package org.dselent.scheduling.server.service;

import org.dselent.scheduling.server.dto.CourseSectionAddDto;
import org.dselent.scheduling.server.dto.CourseSectionModifyDto;
import org.dselent.scheduling.server.dto.CourseSectionRemoveDto;
import org.dselent.scheduling.server.model.CourseSection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathan on 2/9/2018.
 */

@Service
public interface CourseSectionService {
    public List<Integer> addCourseSection(CourseSectionAddDto courseSectionAddDto) throws SQLException;
    public List<Integer> modifyCourseSection(CourseSectionModifyDto courseSectionModifyDto) throws SQLException;
    public List<Integer> removeCourseSection(CourseSectionRemoveDto courseSectionRemoveDto) throws SQLException;
    public List<CourseSection> grabCourseSections() throws SQLException;
}
