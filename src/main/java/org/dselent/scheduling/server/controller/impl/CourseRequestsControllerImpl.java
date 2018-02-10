package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.CourseRequestsController;
import org.dselent.scheduling.server.dto.FacultyRequestCourseDto;
import org.dselent.scheduling.server.dto.FacultyUnrequestCourseDto;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.requests.FacultyRequestCourse;
import org.dselent.scheduling.server.requests.FacultyUnrequestCourse;
import org.dselent.scheduling.server.service.CourseRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller for handling requests related to the user such as logging in or registering.
 * Controller methods are the first methods reached by the request server-side (with special exception).
 * They parse the request and then call the appropriate service method to execute the business logic.
 * Any results or data is then sent back to the client.
 *
 * @author dselent
 */

@Controller
public class CourseRequestsControllerImpl implements CourseRequestsController
{
    @Autowired
    private CourseRequestService courseRequestService;

    /**
     *
     * @param request The body of the request expected to contain a map of String key-value pairs
     * @return A ResponseEntity for the response object(s) and the status code
     * @throws Exception
     */
    public ResponseEntity<String> request (@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Users controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();



        Integer facultyId = Integer.parseInt(request.get(FacultyRequestCourse.getBodyName(FacultyRequestCourse.BodyKey.FACULTY_ID)));
        Integer courseSectionId = Integer.parseInt(request.get(FacultyRequestCourse.getBodyName(FacultyRequestCourse.BodyKey.COURSE_SECTION_ID)));

        FacultyRequestCourseDto.Builder builder = FacultyRequestCourseDto.builder();
        FacultyRequestCourseDto facultyRequestCourseDto = builder.withFacultyId(facultyId)
                .withCourseSectionId(courseSectionId).build();

        courseRequestService.requestFaculty(facultyRequestCourseDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> unrequest (@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Users controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();



        Integer courseId = Integer.parseInt(request.get(CourseDepartmentModify.getBodyName(CourseDepartmentModify.BodyKey.COURSE_ID)));
        Integer departmentId = Integer.parseInt(request.get(CourseDepartmentModify.getBodyName(CourseDepartmentModify.BodyKey.DEPARTMENT_ID)));
        Integer courseNumber = Integer.parseInt(request.get(CourseDepartmentModify.getBodyName(CourseDepartmentModify.BodyKey.COURSE_NUMBER)));
        Integer courseDepartmentId = Integer.parseInt(request.get(CourseDepartmentModify.getBodyName(CourseDepartmentModify.BodyKey.COURSE_DEPARTMENT_ID)));

        CourseDepartmentModifyDto.Builder builder = CourseDepartmentModifyDto.builder();
        CourseDepartmentModifyDto courseDepartmentModifyDto = builder.withCourseDepartmentId(courseDepartmentId)
                .withCourseId(courseId)
                .withDepartmentId(departmentId)
                .withCourseNumber(courseNumber).build();

        courseDepartmentService.modifyCourseDepartment(courseDepartmentModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

