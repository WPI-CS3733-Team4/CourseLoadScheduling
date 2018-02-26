package org.dselent.scheduling.server.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.dao.CourseTimesDao;
import org.dselent.scheduling.server.extractor.CourseTimesExtractor;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.model.CourseTime;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.QueryStringBuilder;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


/*
 * @Repository annotation
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html
 *
 * Useful link
 * https://howtodoinjava.com/spring/spring-core/how-to-use-spring-component-repository-service-and-controller-annotations/
 */
@Repository
public class CourseTimesDaoImpl extends BaseDaoImpl<CourseTime> implements CourseTimesDao
{
    @Override
    protected String getTableName(){ return CourseTime.TABLE_NAME; }

    @Override
    protected String getIdColumnName(){ return CourseTime.getColumnName(CourseTime.Columns.ID); }

    @Override
    protected List<String> getColumnNameList(){ return CourseTime.getColumnNameList(); }

    @Override
    public List<CourseTime> select(List<String> selectColumnNameList, List<QueryTerm> queryTermList, List<Pair<String, ColumnOrder>> orderByList) throws SQLException
    {
        CourseTimesExtractor extractor = new CourseTimesExtractor();
        String queryTemplate = QueryStringBuilder.generateSelectString(getTableName(), selectColumnNameList, queryTermList, orderByList);

        List<Object> objectList = new ArrayList<Object>();

        for(QueryTerm queryTerm : queryTermList)
        {
            objectList.add(queryTerm.getValue());
        }

        Object[] parameters = objectList.toArray();

        List<CourseTime> courseTimesList = jdbcTemplate.query(queryTemplate, extractor, parameters);

        return courseTimesList;
    }

    @Override
    protected void addParameterMapValue(MapSqlParameterSource parameters, String insertColumnName, CourseTime courseTimeModel)
    {
        String parameterName = QueryStringBuilder.convertColumnName(insertColumnName, false);

        // Wish this could generalize
        // The getter must be distinguished unless the models are designed as simply a map of columns-values
        // Would prefer not being that generic since it may end up leading to all code being collections of strings

        if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.ID)))
        {
            parameters.addValue(parameterName, courseTimeModel.getId());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.COURSE_SECTIONS_ID)))
        {
            parameters.addValue(parameterName, courseTimeModel.getCourseSectionsId());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.DAY_OF_WEEK)))
        {
            parameters.addValue(parameterName, courseTimeModel.getDayOfWeek());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.START_TIME)))
        {
            parameters.addValue(parameterName, courseTimeModel.getStartTime());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.END_TIME)))
        {
            parameters.addValue(parameterName, courseTimeModel.getEndTime());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.LOCATIONS_ID)))
        {
            parameters.addValue(parameterName, courseTimeModel.getLocationID());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.CREATED_AT)))
        {
            parameters.addValue(parameterName, courseTimeModel.getCreatedAt());
        }
        else if(insertColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.UPDATED_AT)))
        {
            parameters.addValue(parameterName, courseTimeModel.getUpdatedAt());
        }
        else
        {
            // should never end up here
            // lists should have already been validated
            throw new IllegalArgumentException("Invalid column name provided: " + insertColumnName);
        }
    }

    @Override
    protected void addObjectValue(Map<String, Object> keyMap, String keyHolderColumnName, CourseTime courseTimeModel)
    {
        if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.ID)))
        {
            courseTimeModel.setId((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.COURSE_SECTIONS_ID)))
        {
            courseTimeModel.setCourseSectionsId((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.DAY_OF_WEEK)))
        {
            courseTimeModel.setDayOfWeek((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.START_TIME)))
        {
            courseTimeModel.setStartTime((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.END_TIME)))
        {
            courseTimeModel.setEndTime((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.LOCATIONS_ID)))
        {
            courseTimeModel.setLocationID((Integer) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.CREATED_AT)))
        {
            courseTimeModel.setCreatedAt((Timestamp) keyMap.get(keyHolderColumnName));
        }
        else if(keyHolderColumnName.equals(CourseTime.getColumnName(CourseTime.Columns.UPDATED_AT)))
        {
            courseTimeModel.setUpdatedAt((Timestamp) keyMap.get(keyHolderColumnName));
        }
        else
        {
            // should never end up here
            // lists should have already been validated
            throw new IllegalArgumentException("Invalid column name provided: " + keyHolderColumnName);
        }
    }

}
