package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.CourseSectionTimeAdd;
import org.dselent.scheduling.server.requests.CourseSectionTimeModify;
import org.dselent.scheduling.server.requests.CourseSectionTimeRemove;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courseSectionTime")
public interface CourseSectionTimesController
{
    // Adds a term in the system
    @RequestMapping(method=RequestMethod.POST, value= CourseSectionTimeAdd.REQUEST_NAME)
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception;

    // Modifies a User into the system
    @RequestMapping(method=RequestMethod.POST, value= CourseSectionTimeModify.REQUEST_NAME)
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception;

    //Removes a User out of the system
    @RequestMapping(method=RequestMethod.POST, value= CourseSectionTimeRemove.REQUEST_NAME)
    public ResponseEntity<String> remove(@RequestBody Map<String,String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= "getCourseSectionTimes")
    public ResponseEntity<String> getCourseSectionTimes(@RequestBody Map<String, String> request) throws Exception;

}

