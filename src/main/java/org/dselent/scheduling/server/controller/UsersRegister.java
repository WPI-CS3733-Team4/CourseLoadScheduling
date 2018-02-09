package org.dselent.scheduling.server.controller;

import java.util.Map;

import org.dselent.scheduling.server.requests.UserRegister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/users/register")
public interface UserRegister
{
    
    @RequestMapping(method=RequestMethod.POST, value= org.dselent.scheduling.server.requests.UserRegister.REQUEST_NAME)

    // Registers a user in the system
	public ResponseEntity<String> register(@RequestBody Map<String, String> request) throws Exception;
}

	