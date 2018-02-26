package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courseRequests")
public interface CourseRequestsController
{
    // Registers a user in the system
    @RequestMapping(method=RequestMethod.POST, value= UserRegister.REQUEST_NAME)
    public ResponseEntity<String> request(@RequestBody Map<String, String> request) throws Exception;

    //Modifies a User
    @RequestMapping(method=RequestMethod.POST, value= UserModify.REQUEST_NAME)
    public ResponseEntity<String> unrequest(@RequestBody Map<String, String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= "getCourseRequests")
    public ResponseEntity<String> getCourseRequests(@RequestBody Map<String, String> request) throws Exception;

}