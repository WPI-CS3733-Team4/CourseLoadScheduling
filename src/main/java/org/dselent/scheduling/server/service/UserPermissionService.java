package org.dselent.scheduling.server.service;

import java.sql.SQLException;
import java.util.List;

import org.dselent.scheduling.server.dto.AdminChangeUserRoleDto;
import org.dselent.scheduling.server.dto.UserLogoutDto;
import org.dselent.scheduling.server.dto.UserModifyDto;
import org.dselent.scheduling.server.dto.UserRegisterDto;
import org.dselent.scheduling.server.model.UsersPermission;
import org.dselent.scheduling.server.requests.AdminChangeUserRole;
import org.springframework.stereotype.Service;

public interface UserPermissionService
{
    public List<Integer> changeUserRole(AdminChangeUserRoleDto dto) throws SQLException;
}
