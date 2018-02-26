package org.dselent.scheduling.server.service.impl;

import org.dselent.scheduling.server.dao.CourseTimesDao;
import org.dselent.scheduling.server.dto.CourseSectionTimeAddDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeModifyDto;
import org.dselent.scheduling.server.dto.CourseSectionTimeRemoveDto;
import org.dselent.scheduling.server.model.CourseTime;
import org.dselent.scheduling.server.service.CourseSectionTimeService;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;

/**
 * Created by Nathan on 2/9/2018.
 */
@Service
public class CourseSectionTimeServiceImpl implements CourseSectionTimeService{

    @Autowired
    private CourseTimesDao courseTimesDao;

    public CourseSectionTimeServiceImpl(){

    }

    @Transactional
    @Override
    public List<Integer> addCourseSectionTime(CourseSectionTimeAddDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        CourseTime courseTime = new CourseTime();
        courseTime.setCourseSectionsId(dto.getCourseSectionId());
        courseTime.setDayOfWeek(dto.getDayOfWeek());
        courseTime.setStartTime(dto.getStartTime());
        courseTime.setEndTime(dto.getEndTime());
        courseTime.setLocationID(dto.getLocation());

        List<String> courseInsertColumnNameList = new ArrayList<>();
        List<String> courseKeyHolderColumnNameList = new ArrayList<>();

        courseInsertColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.COURSE_SECTIONS_ID));
        courseInsertColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.DAY_OF_WEEK));
        courseInsertColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.START_TIME));
        courseInsertColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.END_TIME));
        courseInsertColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.LOCATIONS_ID));

        courseKeyHolderColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.ID));
        courseKeyHolderColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.CREATED_AT));
        courseKeyHolderColumnNameList.add(CourseTime.getColumnName(CourseTime.Columns.UPDATED_AT));

        rowsAffectedList.add(courseTimesDao.insert(courseTime, courseInsertColumnNameList, courseKeyHolderColumnNameList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> modifyCourseSectionTime(CourseSectionTimeModifyDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer courseSectionTimeId = dto.getCourseSectionTimeId();
        Integer courseSectionId = dto.getCourseSectionId();
        Integer dayOfWeek = dto.getDayOfWeek();
        Integer startTime = dto.getStartTime();
        Integer endTime = dto.getEndTime();
        Integer locationId = dto.getLocation();

        /*I have no idea how to modify a course's department. the system'll work okay without it though
        * --Has been modified so that courses don't necessarily require a department*/
        //String courseDept = dto.getCourseDept();


        queryTermList.add(new QueryTerm(CourseTime.getColumnName(CourseTime.Columns.ID),EQUAL,courseSectionTimeId,null));

        rowsAffectedList.add(courseTimesDao.update(CourseTime.getColumnName(CourseTime.Columns.COURSE_SECTIONS_ID),courseSectionId,queryTermList));
        rowsAffectedList.add(courseTimesDao.update(CourseTime.getColumnName(CourseTime.Columns.DAY_OF_WEEK),dayOfWeek,queryTermList));
        rowsAffectedList.add(courseTimesDao.update(CourseTime.getColumnName(CourseTime.Columns.START_TIME),startTime,queryTermList));
        rowsAffectedList.add(courseTimesDao.update(CourseTime.getColumnName(CourseTime.Columns.END_TIME),endTime,queryTermList));
        rowsAffectedList.add(courseTimesDao.update(CourseTime.getColumnName(CourseTime.Columns.LOCATIONS_ID),locationId,queryTermList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> removeCourseSectionTime(CourseSectionTimeRemoveDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer courseSectionTimeId = dto.getCourseSectionTimeId();
        queryTermList.add(new QueryTerm(CourseTime.getColumnName(CourseTime.Columns.ID),EQUAL,courseSectionTimeId,null));

        rowsAffectedList.add(courseTimesDao.delete(queryTermList));

        return rowsAffectedList;
    }

    public List<CourseTime> grabCourseSectionTimes() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        columns.add(CourseTime.getColumnName(CourseTime.Columns.ID));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.COURSE_SECTIONS_ID));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.DAY_OF_WEEK));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.START_TIME));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.END_TIME));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.LOCATIONS_ID));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.CREATED_AT));
        columns.add(CourseTime.getColumnName(CourseTime.Columns.UPDATED_AT));

        return courseTimesDao.select(columns, queryTermList, null);
    }
}
