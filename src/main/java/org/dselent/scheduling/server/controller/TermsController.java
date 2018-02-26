package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.TermRemove;
import org.dselent.scheduling.server.requests.TermAdd;
import org.dselent.scheduling.server.requests.TermModify;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/term")
public interface TermsController
{
    // Adds a term in the system
    @RequestMapping(method=RequestMethod.POST, value= TermAdd.REQUEST_NAME)
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception;

    // Modifies a User into the system
    @RequestMapping(method=RequestMethod.POST, value= TermModify.REQUEST_NAME)
    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception;

    //Removes a User out of the system
    @RequestMapping(method=RequestMethod.POST, value= TermRemove.REQUEST_NAME)
    public ResponseEntity<String> remove(@RequestBody Map<String,String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= "getTerms")
    public ResponseEntity<String> getTerms(@RequestBody Map<String, String> request) throws Exception;

}

