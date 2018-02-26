package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.CourseSectionTimesController;
import org.dselent.scheduling.server.dto.CourseSectionTimeAddDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeModifyDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeRemoveDto;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.CourseTime;
import org.dselent.scheduling.server.requests.CourseSectionTimeRemove;
import org.dselent.scheduling.server.requests.CourseSectionTimeModify;
import org.dselent.scheduling.server.requests.CourseSectionTimeAdd;
import org.dselent.scheduling.server.service.CourseSectionTimeService;
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
public class CourseSectionTimesControllerImpl implements CourseSectionTimesController
{
    @Autowired
    private CourseSectionTimeService courseSectionTimeService;

    /**
     *
     * @param request The body of the request expected to contain a map of String key-value pairs
     * @return A ResponseEntity for the response object(s) and the status code
     * @throws Exception
     */
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course section times controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseSectionId = Integer.parseInt(request.get(CourseSectionTimeAdd.getBodyName(CourseSectionTimeAdd.BodyKey.COURSE_SECTION_ID)));
        Integer dayOfWeek = Integer.parseInt(request.get(CourseSectionTimeAdd.getBodyName(CourseSectionTimeAdd.BodyKey.DAY_OF_WEEK)));
        Integer startTime = Integer.parseInt(request.get(CourseSectionTimeAdd.getBodyName(CourseSectionTimeAdd.BodyKey.START_TIME)));
        Integer endTime = Integer.parseInt(request.get(CourseSectionTimeAdd.getBodyName(CourseSectionTimeAdd.BodyKey.END_TIME)));
        Integer location = Integer.parseInt(request.get(CourseSectionTimeAdd.getBodyName(CourseSectionTimeAdd.BodyKey.LOCATION)));


        CourseSectionTimeAddDto.Builder builder = CourseSectionTimeAddDto.builder();
        CourseSectionTimeAddDto termAddDto = builder.withCourseSectionId(courseSectionId)
                .withCourseSectionId(courseSectionId)
                .withDayOfWeek(dayOfWeek)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withLocation(location)
                .build();

        courseSectionTimeService.addCourseSectionTime(termAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course section times controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseSectionTimeId = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.COURSE_SECTION_TIME_ID)));
        Integer courseSectionId = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.COURSE_SECTION_ID)));
        Integer dayOfWeek = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.DAY_OF_WEEK)));
        Integer startTime = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.START_TIME)));
        Integer endTime = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.END_TIME)));
        Integer location = Integer.parseInt(request.get(CourseSectionTimeModify.getBodyName(CourseSectionTimeModify.BodyKey.LOCATION)));


        CourseSectionTimeModifyDto.Builder builder = CourseSectionTimeModifyDto.builder();
        CourseSectionTimeModifyDto termModifyDto = builder.withCourseSectionId(courseSectionId)
                .withCourseSectionId(courseSectionId)
                .withDayOfWeek(dayOfWeek)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withLocation(location)
                .build();

        courseSectionTimeService.modifyCourseSectionTime(termModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Course section times controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer courseSectionTimesId = Integer.parseInt(request.get(CourseSectionTimeRemove.getBodyName(CourseSectionTimeRemove.BodyKey.COURSE_SECTION_TIME_ID)));

        CourseSectionTimeRemoveDto.Builder builder = CourseSectionTimeRemoveDto.builder();
        CourseSectionTimeRemoveDto termRemoveDto = builder.withCourseSectionTimeId(courseSectionTimesId)
                .build();

        courseSectionTimeService.removeCourseSectionTime(termRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> getCourseSectionTimes(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Users controller reached");


        //get all the users (how do we do the responseSet????)
        List<CourseTime> listOfCourseSectionTimes = courseSectionTimeService.grabCourseSectionTimes();

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(listOfCourseSectionTimes);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }
}

