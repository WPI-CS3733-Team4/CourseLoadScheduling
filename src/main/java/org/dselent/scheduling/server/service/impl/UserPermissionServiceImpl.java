package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.UsersPermissionsDao;
import org.dselent.scheduling.server.dto.AdminChangeUserRoleDto;
import org.dselent.scheduling.server.model.UsersPermission;
import org.dselent.scheduling.server.service.UserPermissionService;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;

@Service
public class UserPermissionServiceImpl implements UserPermissionService
{
	@Autowired
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

        queryTermList.add(new QueryTerm(UsersPermission.getColumnName(UsersPermission.Columns.USERS_ID), EQUAL, userId, null));
        rowsAffectedList.add(usersPermissionsDao.update(UsersPermission.getColumnName(UsersPermission.Columns.ROLE), role, queryTermList));

        return rowsAffectedList;
    }

    public List<UsersPermission> grabUsersPermissions() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();


        List<String> columns = new ArrayList<>();
        columns.add(UsersPermission.getColumnName(UsersPermission.Columns.ID));
        columns.add(UsersPermission.getColumnName(UsersPermission.Columns.USERS_ID));
        columns.add(UsersPermission.getColumnName(UsersPermission.Columns.ROLE));
        columns.add(UsersPermission.getColumnName(UsersPermission.Columns.CREATED_AT));
        columns.add(UsersPermission.getColumnName(UsersPermission.Columns.UPDATED_AT));

        return usersPermissionsDao.select(columns, queryTermList, null);
    }
}
