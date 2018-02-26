package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.CourseAdd;
import org.dselent.scheduling.server.requests.CourseModify;
import org.dselent.scheduling.server.requests.CourseRemove;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/course")
public interface CoursesController
{
    // Adds a term in the system
    @RequestMapping(method=RequestMethod.POST, value= CourseAdd.REQUEST_NAME)
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception;

    // Modifies a User into the system
    @RequestMapping(method=RequestMethod.POST, value= CourseModify.REQUEST_NAME)
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception;

    //Removes a User out of the system
    @RequestMapping(method=RequestMethod.POST, value= CourseRemove.REQUEST_NAME)
    public ResponseEntity<String> remove(@RequestBody Map<String,String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= "getCourses")
    public ResponseEntity<String> getCourses(@RequestBody Map<String, String> request) throws Exception;
}

