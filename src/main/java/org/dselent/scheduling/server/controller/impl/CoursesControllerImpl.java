package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.CoursesController;
import org.dselent.scheduling.server.dto.CourseAddDto;
import org.dselent.scheduling.server.dto.CourseRemoveDto;
import org.dselent.scheduling.server.dto.CourseModifyDto;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.Course;
import org.dselent.scheduling.server.requests.CourseRemove;
import org.dselent.scheduling.server.requests.CourseModify;
import org.dselent.scheduling.server.requests.CourseAdd;
import org.dselent.scheduling.server.service.CourseService;
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
public class CoursesControllerImpl implements CoursesController
{
    @Autowired
    private CourseService courseService;

    /**
     *
     * @param request The body of the request expected to contain a map of String key-value pairs
     * @return A ResponseEntity for the response object(s) and the status code
     * @throws Exception
     */
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Courses controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        String courseName = request.get(CourseAdd.getBodyName(CourseAdd.BodyKey.COURSE_NAME));
        String courseDept = request.get(CourseAdd.getBodyName(CourseAdd.BodyKey.COURSE_DEPT));
        String courseDescription = request.get(CourseAdd.getBodyName(CourseAdd.BodyKey.COURSE_DESCRIPTION));


        CourseAddDto.Builder builder = CourseAddDto.builder();
        CourseAddDto termAddDto = builder.withCourseName(courseName)
                .withCourseDept(courseDept)
                .withCourseDescription(courseDescription)
                .build();

        courseService.addCourse(termAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Courses controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        String courseName = request.get(CourseModify.getBodyName(CourseModify.BodyKey.COURSE_NAME));
        String courseDept = request.get(CourseModify.getBodyName(CourseModify.BodyKey.COURSE_DEPT));
        String courseDescription = request.get(CourseModify.getBodyName(CourseModify.BodyKey.COURSE_DESCRIPTION));
        Integer courseId = Integer.parseInt(request.get(CourseModify.getBodyName(CourseModify.BodyKey.COURSE_ID)));

        CourseModifyDto.Builder builder = CourseModifyDto.builder();
        CourseModifyDto termModifyDto = builder.withCourseId(courseId)
                .withCourseName(courseName)
                .withCourseDept(courseDept)
                .withCourseDescription(courseDescription)
                .build();

        courseService.modifyCourse(termModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseId = Integer.parseInt(request.get(CourseRemove.getBodyName(CourseRemove.BodyKey.COURSE_ID)));

        CourseRemoveDto.Builder builder = CourseRemoveDto.builder();
            CourseRemoveDto termRemoveDto = builder.withCourseId(courseId)
                .build();

        courseService.removeCourse(termRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> getCourses(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Users controller reached");


        //get all the users (how do we do the responseSet????)
        List<Course> listOfCourses = courseService.grabCourses();

        List<String> coursesEntryList = new ArrayList<String>();

        for (Course course : listOfCourses){
            coursesEntryList.add(course.toString());
        }

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(coursesEntryList);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }
}

