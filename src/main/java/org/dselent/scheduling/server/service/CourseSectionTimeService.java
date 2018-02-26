package org.dselent.scheduling.server.service;


import org.dselent.scheduling.server.dto.CourseSectionTimeAddDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeModifyDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeRemoveDto;
import org.dselent.scheduling.server.model.CourseTime;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathan on 2/9/2018.
 */

@Service
public interface CourseSectionTimeService {

    public List<Integer> addCourseSectionTime(CourseSectionTimeAddDto dto) throws  SQLException;
    public List<Integer> modifyCourseSectionTime(CourseSectionTimeModifyDto dto) throws SQLException;
    public List<Integer> removeCourseSectionTime(CourseSectionTimeRemoveDto dto) throws SQLException;
    public List<CourseTime> grabCourseSectionTimes() throws SQLException;
}
