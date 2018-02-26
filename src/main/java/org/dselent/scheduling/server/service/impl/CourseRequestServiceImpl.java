package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.CourseRequestsDao;
import org.dselent.scheduling.server.dto.FacultyRequestCourseDto;
import org.dselent.scheduling.server.dto.FacultyUnrequestCourseDto;
import org.dselent.scheduling.server.model.CourseRequest;
import org.dselent.scheduling.server.service.CourseRequestService;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;

@Service
public class CourseRequestServiceImpl implements CourseRequestService
{
	@Autowired
    private CourseRequestsDao courseRequestsDao;

    public CourseRequestServiceImpl()
    {

    }

    /* requesting course */
    @Transactional
    @Override
    public List<Integer> requestFaculty(FacultyRequestCourseDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setCourseSectionsId(dto.getCourseSectionId());
        courseRequest.setFacultyId(dto.getFacultyId());



        List<String> requestInsertColumnNameList = new ArrayList<>();
        List<String> requestKeyHolderColumnNameList = new ArrayList<>();

        requestInsertColumnNameList.add(CourseRequest.getColumnName(CourseRequest.Columns.FACULTY_ID));
        requestInsertColumnNameList.add(CourseRequest.getColumnName(CourseRequest.Columns.COURSE_SECTIONS_ID));
        requestKeyHolderColumnNameList.add(CourseRequest.getColumnName(CourseRequest.Columns.ID));
        requestKeyHolderColumnNameList.add(CourseRequest.getColumnName(CourseRequest.Columns.CREATED_AT));
        requestKeyHolderColumnNameList.add(CourseRequest.getColumnName(CourseRequest.Columns.UPDATED_AT));

        rowsAffectedList.add(courseRequestsDao.insert(courseRequest, requestInsertColumnNameList, requestKeyHolderColumnNameList));
        return rowsAffectedList;
    }
    /* unrequesting course */
    @Transactional
    @Override
    public List<Integer> unrequestFaculty (FacultyUnrequestCourseDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer courseSectionId = dto.getCourseSectionId();
        queryTermList.add(new QueryTerm(CourseRequest.getColumnName(CourseRequest.Columns.ID),EQUAL,courseSectionId,null));

        rowsAffectedList.add(courseRequestsDao.delete(queryTermList));

        return rowsAffectedList;
    }

    public List<CourseRequest> grabCourseRequests() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        columns.add(CourseRequest.getColumnName(CourseRequest.Columns.ID));
        columns.add(CourseRequest.getColumnName(CourseRequest.Columns.FACULTY_ID));
        columns.add(CourseRequest.getColumnName(CourseRequest.Columns.COURSE_SECTIONS_ID));
        columns.add(CourseRequest.getColumnName(CourseRequest.Columns.CREATED_AT));
        columns.add(CourseRequest.getColumnName(CourseRequest.Columns.UPDATED_AT));


        return courseRequestsDao.select(columns, queryTermList, null);
    }
}
