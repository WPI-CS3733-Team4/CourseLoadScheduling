package org.dselent.scheduling.server.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.dao.FacultyDao;
import org.dselent.scheduling.server.extractor.FacultyExtractor;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.miscellaneous.QueryStringBuilder;
import org.dselent.scheduling.server.model.Faculty;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.ComparisonOperator;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

public abstract class FacultyDaoImpl extends BaseDaoImpl<Faculty> implements FacultyDao {
    private void addParameterMapValue(MapSqlParameterSource parameters, String insertColumnName, Faculty FacultyModel) {
        String parameterName = QueryStringBuilder.convertColumnName(insertColumnName, false);

        // Wish this could generalize
        // The getter must be distinguished unless the models are designed as simply a map of columns-values
        // Would prefer not being that generic since it may end up leading to all code being collections of strings

        if (insertColumnName.equals(Faculty.getColumnName(Faculty.Columns.ID))) {
            parameters.addValue(parameterName, FacultyModel.getId());
        } else if (insertColumnName.equals(Faculty.getColumnName(Faculty.Columns.USERS_ID))) {
            parameters.addValue(parameterName, FacultyModel.getUsersId());
        } else if (insertColumnName.equals(Faculty.getColumnName(Faculty.Columns.REQUIRED_CREDITS))) {
            parameters.addValue(parameterName, FacultyModel.getRequiredCredits());
        } else if (insertColumnName.equals(Faculty.getColumnName(Faculty.Columns.CREATED_AT))) {
            parameters.addValue(parameterName, FacultyModel.getCreatedAt());
        } else if (insertColumnName.equals(Faculty.getColumnName(Faculty.Columns.UPDATED_AT))) {
            parameters.addValue(parameterName, FacultyModel.getUpdatedAt());

        } else {
            // should never end up here
            // lists should have already been validated
            throw new IllegalArgumentException("Invalid column name provided: " + insertColumnName);
        }
    }

    private void addObjectValue(Map<String, Object> keyMap, String keyHolderColumnName, Faculty FacultyModel) {
        if (keyHolderColumnName.equals(Faculty.getColumnName(Faculty.Columns.ID))) {
            FacultyModel.setId((Integer) keyMap.get(keyHolderColumnName));
        } else if (keyHolderColumnName.equals(Faculty.getColumnName(Faculty.Columns.USERS_ID))) {
            FacultyModel.setUsersId((Integer) keyMap.get(keyHolderColumnName));
        } else if (keyHolderColumnName.equals(Faculty.getColumnName(Faculty.Columns.REQUIRED_CREDITS))) {
            FacultyModel.setRequiredCredits((Integer) keyMap.get(keyHolderColumnName));
        } else if (keyHolderColumnName.equals(Faculty.getColumnName(Faculty.Columns.CREATED_AT))) {
            FacultyModel.setCreatedAt((Timestamp) keyMap.get(keyHolderColumnName));
        } else if (keyHolderColumnName.equals(Faculty.getColumnName(Faculty.Columns.UPDATED_AT))) {
            FacultyModel.setUpdatedAt((Timestamp) keyMap.get(keyHolderColumnName));

        } else
        {
            // should never end up here
            // lists should have already been validated
            throw new IllegalArgumentException("Invalid column name provided: " + keyHolderColumnName);
        }
    }

}