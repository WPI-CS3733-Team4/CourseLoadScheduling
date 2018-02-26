package org.dselent.scheduling.server.controller;
import java.util.Map;

import org.dselent.scheduling.server.requests.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/location")
public interface  LocationController {
    @RequestMapping(method= RequestMethod.POST, value= LocationAdd.REQUEST_NAME)
    public ResponseEntity<String> locationAdd(@RequestBody Map<String, String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= LocationModify.REQUEST_NAME)
    public ResponseEntity<String> locationModify(@RequestBody Map<String, String> request) throws Exception;

    @RequestMapping(method = RequestMethod.POST, value = LocationRemove.REQUEST_NAME)
    public ResponseEntity<String> locationRemove(@RequestBody Map<String, String> request) throws Exception;

    @RequestMapping(method=RequestMethod.POST, value= "getLocations")
    public ResponseEntity<String> getLocations(@RequestBody Map<String, String> request) throws Exception;
}
