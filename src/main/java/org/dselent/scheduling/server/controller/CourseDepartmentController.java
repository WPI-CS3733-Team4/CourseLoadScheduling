package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courseDepartments")
public interface CourseDepartmentController
{
    // Registers a user in the system
    @RequestMapping(method=RequestMethod.POST, value= UserRegister.REQUEST_NAME)
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception;
    
    //Modifies a User
    @RequestMapping(method=RequestMethod.POST, value= UserModify.REQUEST_NAME)
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception;

    //Deactivates a User
    @RequestMapping(method=RequestMethod.POST, value= UserDeactivate.REQUEST_NAME)
    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception;

}