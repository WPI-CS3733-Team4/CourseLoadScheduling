package org.dselent.scheduling.server.service;

import java.sql.SQLException;
import java.util.List;

import org.dselent.scheduling.server.dto.FacultyUnrequestCourseDto;
import org.dselent.scheduling.server.dto.FacultyRequestCourseDto;
import org.dselent.scheduling.server.model.CourseRequest;
import org.springframework.stereotype.Service;

@Service
public interface CourseRequestService
{
    public List<Integer> requestFaculty (FacultyRequestCourseDto dto) throws SQLException;
    public List<Integer> unrequestFaculty (FacultyUnrequestCourseDto dto) throws SQLException;
    public List<CourseRequest> grabCourseRequests() throws SQLException;
}
