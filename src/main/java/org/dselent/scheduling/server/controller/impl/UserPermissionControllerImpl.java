package org.dselent.scheduling.server.controller.impl;

import org.dselent.scheduling.server.controller.UserPermissionController;
import org.dselent.scheduling.server.dto.AdminChangeUserRoleDto;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.requests.AdminChangeUserRole;
import org.dselent.scheduling.server.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserPermissionControllerImpl implements UserPermissionController{

	@Autowired
    private UserPermissionService usersPermissionService;

    public ResponseEntity<String> changeUserRole(@RequestBody Map<String, String> request) throws Exception
    {
        String userRole = request.get(AdminChangeUserRole.getBodyName(AdminChangeUserRole.BodyKey.ROLE));
        Integer userID = Integer.parseInt(request.get(AdminChangeUserRole.getBodyName(AdminChangeUserRole.BodyKey.USER_ID)));

        AdminChangeUserRoleDto.Builder builder = AdminChangeUserRoleDto.builder();
        AdminChangeUserRoleDto userRegisterDto = builder.withRole(userRole)
                .withUserId(userID)
                .build();

        String response = "";
        List<Object> success = new ArrayList<Object>();

        usersPermissionService.changeUserRole(userRegisterDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> getUserPermissions(@RequestBody Map<String, String> request) throws Exception
    {
        return null;
    }

}


