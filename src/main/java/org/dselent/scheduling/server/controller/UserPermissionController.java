package org.dselent.scheduling.server.controller;

import org.dselent.scheduling.server.requests.AdminChangeUserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping("/admin")
public interface UserPermissionController {
    @RequestMapping(method = RequestMethod.POST, value = AdminChangeUserRole.REQUEST_NAME)
    public ResponseEntity<String> changeUserRole(@RequestBody Map<String, String> request) throws Exception;

    @RequestMapping(method = RequestMethod.POST, value = "getUserPermissions")
    public ResponseEntity<String> getUserPermissions(@RequestBody Map<String, String> request) throws Exception;
}
