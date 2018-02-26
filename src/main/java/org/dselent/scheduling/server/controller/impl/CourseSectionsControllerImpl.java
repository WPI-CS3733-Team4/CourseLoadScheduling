package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.CourseSectionsController;
import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.CourseSection;
import org.dselent.scheduling.server.requests.*;
import org.dselent.scheduling.server.service.CourseSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Nathan on 2/9/2018.
 */
@Controller
public class CourseSectionsControllerImpl implements CourseSectionsController{
    @Autowired
    private CourseSectionService courseSectionService;

    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course Sections controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseId = Integer.parseInt(request.get(CourseSectionAdd.getBodyName(CourseSectionAdd.BodyKey.COURSE_ID)));
        String sectionType = request.get(CourseSectionAdd.getBodyName(CourseSectionAdd.BodyKey.SECTION_TYPE));
        String term = request.get(CourseSectionAdd.getBodyName(CourseSectionAdd.BodyKey.TERM));

        CourseSectionAddDto.Builder builder = CourseSectionAddDto.builder();
        CourseSectionAddDto courseSectionAddDto = builder.withCourseId(courseId)
                .withSectionType(sectionType)
                .withTerm(term)
                .build();

        courseSectionService.addCourseSection(courseSectionAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course Sections controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseSectionId = Integer.parseInt(request.get(CourseSectionModify.getBodyName(CourseSectionModify.BodyKey.COURSE_SECTION_ID)));
        Integer courseId = Integer.parseInt(request.get(CourseSectionModify.getBodyName(CourseSectionModify.BodyKey.COURSE_ID)));
        String sectionType = request.get(CourseSectionModify.getBodyName(CourseSectionModify.BodyKey.SECTION_TYPE));
        String term = request.get(CourseSectionModify.getBodyName(CourseSectionModify.BodyKey.TERM));

        CourseSectionModifyDto.Builder builder = CourseSectionModifyDto.builder();
        CourseSectionModifyDto courseSectionModifyDto = builder
                .withCourseSectionId(courseSectionId)
                .withCourseId(courseId)
                .withSectionType(sectionType)
                .withTerm(term)
                .build();

        courseSectionService.modifyCourseSection(courseSectionModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course Sections controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseSectionId = Integer.parseInt(request.get(CourseSectionRemove.getBodyName(CourseSectionRemove.BodyKey.COURSE_SECTION_ID)));

        CourseSectionRemoveDto.Builder builder = CourseSectionRemoveDto.builder();
        CourseSectionRemoveDto courseSectionRemoveDto = builder
                .withCourseSectionId(courseSectionId)
                .build();

        courseSectionService.removeCourseSection(courseSectionRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> getCourseSections(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Course Sections controller reached");


        //get all the users (how do we do the responseSet????)
        List<CourseSection> listOfCourseSections = courseSectionService.grabCourseSections();

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(listOfCourseSections);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }
}
