package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.UserRegister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/schedule")
public interface ScheduleController {
/**
    @RequestMapping(method=RequestMethod.POST, value=UserRegister.REQUEST_NAME)
    public ResponseEntity<String> getSchedules(@RequestBody Map<String, String> request) throws Exception;
*/
}

