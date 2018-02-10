package org.dselent.scheduling.server.controller;

/**
 * Created by Nathan on 2/9/2018.
 */

import java.util.Map;

import org.dselent.scheduling.server.requests.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/department")
public interface DepartmentsController
{
    // Registers a user in the system
    @RequestMapping(method=RequestMethod.POST, value= DepartmentAdd.REQUEST_NAME)
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception;

    // Logs a User into the system
    @RequestMapping(method=RequestMethod.POST, value= DepartmentModify.REQUEST_NAME)
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception;

    //Logs a User out of the system
    @RequestMapping(method=RequestMethod.POST, value= DepartmentRemove.REQUEST_NAME)
    public ResponseEntity<String> remove(@RequestBody Map<String,String> request) throws Exception;

}


