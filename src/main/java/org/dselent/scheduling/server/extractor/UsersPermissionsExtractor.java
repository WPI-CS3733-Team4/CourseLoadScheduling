package org.dselent.scheduling.server.extractor;

import org.dselent.scheduling.server.model.UsersPermission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 2/1/2018.
 */
public class UsersPermissionsExtractor extends Extractor<List<UsersPermission>>
{
    @Override
    public List<UsersPermission> extractData(ResultSet rs) throws SQLException
    {
        List<UsersPermission> resultList = new ArrayList<>();

        while(rs.next())
        {
            UsersPermission result = new UsersPermission();

            result.setId(rs.getInt(UsersPermission.getColumnName(UsersPermission.Columns.ID)));

            if(rs.wasNull())
            {
                result.setId(null);
            }

            result.setUsersId(rs.getInt(UsersPermission.getColumnName(UsersPermission.Columns.USERS_ID)));

            if(rs.wasNull())
            {
                result.setUsersId(null);
            }

            result.setRole(rs.getString(UsersPermission.getColumnName(UsersPermission.Columns.ROLE)));

            result.setCreatedAt(rs.getTimestamp(UsersPermission.getColumnName(UsersPermission.Columns.CREATED_AT)));
            result.setUpdatedAt(rs.getTimestamp(UsersPermission.getColumnName(UsersPermission.Columns.UPDATED_AT)));

            resultList.add(result);
        }

        return resultList;
    }
}
