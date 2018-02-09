package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.UsersPermissionsDao;
import org.dselent.scheduling.server.dto.AdminChangeUserRoleDto;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.model.UserPermission;
import org.dselent.scheduling.server.requests.AdminChangeUserRole;
import org.dselent.scheduling.server.service.UserPermissionService;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;


public class UserPermissionServiceImpl implements UserPermissionService
{
    private UsersPermissionsDao usersPermissionsDao;

    public UserPermissionServiceImpl(){
        //
    }
    public List<Integer> changeUserRole(AdminChangeUserRoleDto dto) throws SQLException
    {
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer userId = dto.getUserId();
        String role = dto.getRole();

        queryTermList.add(new QueryTerm(UserPermission.getColumnName(UserPermission.Columns.USERS_ID), EQUAL, userId, null));
        rowsAffectedList.add(usersPermissionsDao.update(UserPermission.getColumnName(UserPermission.Columns.ROLE), role, queryTermList));

        return rowsAffectedList;
    }
}