package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.FacultyDao;
import org.dselent.scheduling.server.dto.FacultyAddDto;
import org.dselent.scheduling.server.dto.FacultyModifyDto;
import org.dselent.scheduling.server.dto.FacultyRemoveDto;
import org.dselent.scheduling.server.model.Faculty;
import org.dselent.scheduling.server.service.FacultyService;

import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;
/**
 * Created by Fabian Gaziano on 2/9/2018.
 */
@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDao FacultyDao;

    public FacultyServiceImpl(){

    }

    /*
     * (non-Javadoc)
     * @see org.dselent.scheduling.server.service.CourseService#addCourse(org.dselent.scheduling.server.dto.CourseAddDto)
     */
    /* adding faculty*/
    @Transactional
    @Override
    public List<Integer> addFaculty(FacultyAddDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();

        Faculty faculty = new Faculty();
        faculty.setUsersId(dto.getUserId());
        faculty.setRequiredCredits(dto.getRequiredCredits());



        List<String> facultyInsertColumnNameList = new ArrayList<>();
        List<String> facultyKeyHolderColumnNameList = new ArrayList<>();

        facultyInsertColumnNameList.add(Faculty.getColumnName(Faculty.Columns.USERS_ID));
        facultyInsertColumnNameList.add(Faculty.getColumnName(Faculty.Columns.REQUIRED_CREDITS));
        facultyKeyHolderColumnNameList.add(Faculty.getColumnName(Faculty.Columns.ID));
        facultyKeyHolderColumnNameList.add(Faculty.getColumnName(Faculty.Columns.CREATED_AT));
        facultyKeyHolderColumnNameList.add(Faculty.getColumnName(Faculty.Columns.UPDATED_AT));

        rowsAffectedList.add(FacultyDao.insert(faculty, facultyInsertColumnNameList, facultyKeyHolderColumnNameList));
        return rowsAffectedList;
    }
    /* modifying faculty*/
    @Transactional
    @Override
    public List<Integer> modifyFaculty (FacultyModifyDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer facultyId = dto.getFacultyId();
        Integer userId = dto.getUserId();
        Integer requiredCredits = dto.getRequiredCredits();


        /*I have no idea how to modify a course's department. the system'll work okay without it though*/



        queryTermList.add(new QueryTerm(Faculty.getColumnName(Faculty.Columns.ID),EQUAL,facultyId,null));

        rowsAffectedList.add(FacultyDao.update(Faculty.getColumnName(Faculty.Columns.USERS_ID),userId,queryTermList));
        rowsAffectedList.add(FacultyDao.update(Faculty.getColumnName(Faculty.Columns.REQUIRED_CREDITS),requiredCredits,queryTermList));

        return rowsAffectedList;
    }
    /* removing faculty*/
    @Transactional
    @Override
    public List<Integer> removeFaculty (FacultyRemoveDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer userId = dto.getFacultyId();
        queryTermList.add(new QueryTerm(Faculty.getColumnName(Faculty.Columns.ID),EQUAL,userId,null));

        rowsAffectedList.add(FacultyDao.delete(queryTermList));

        return rowsAffectedList;
    }
}
