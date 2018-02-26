package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.CourseSectionsDao;
import org.dselent.scheduling.server.dao.CourseSectionsTermsDao;
import org.dselent.scheduling.server.dao.TermsDao;
import org.dselent.scheduling.server.dto.CourseSectionAddDto;
import org.dselent.scheduling.server.dto.CourseSectionModifyDto;
import org.dselent.scheduling.server.dto.CourseSectionRemoveDto;
import org.dselent.scheduling.server.model.CourseSection;
import org.dselent.scheduling.server.model.CourseSectionTerm;
import org.dselent.scheduling.server.model.Term;
import org.dselent.scheduling.server.service.CourseSectionService;

import org.dselent.scheduling.server.sqlutils.LogicalOperator;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;


/**
 * Created by Nathan on 2/9/2018.
 */
@Service
public class CourseSectionServiceImpl implements CourseSectionService{
    @Autowired
    private CourseSectionsDao courseSectionsDao;
    @Autowired
    private TermsDao termsDao;
    @Autowired
    private CourseSectionsTermsDao courseSectionsTermsDao;

    public CourseSectionServiceImpl(){

    }
    /*
     * (non-Javadoc)
     * @see org.dselent.scheduling.server.service.CourseSectionService#addCourseSection(org.dselent.scheduling.server.dto.CourseSectionAddDto)
     */
    @Transactional
    @Override
    public List<Integer> addCourseSection(CourseSectionAddDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();

        CourseSection courseSection = new CourseSection();
        courseSection.setCoursesId(dto.getCourseId());
        courseSection.setSectionType(dto.getSectionType());

        String termName = dto.getTerm();

        List<String> courseSectionInsertColumnNameList = new ArrayList<>();
        List<String> courseSectionKeyHolderColumnNameList = new ArrayList<>();

        courseSectionInsertColumnNameList.add(CourseSection.getColumnName(CourseSection.Columns.COURSES_ID));
        courseSectionInsertColumnNameList.add(CourseSection.getColumnName(CourseSection.Columns.SECTION_TYPE));

        courseSectionKeyHolderColumnNameList.add(CourseSection.getColumnName(CourseSection.Columns.ID));
        courseSectionKeyHolderColumnNameList.add(CourseSection.getColumnName(CourseSection.Columns.CREATED_AT));
        courseSectionKeyHolderColumnNameList.add(CourseSection.getColumnName(CourseSection.Columns.UPDATED_AT));

        rowsAffectedList.add(courseSectionsDao.insert(courseSection, courseSectionInsertColumnNameList, courseSectionKeyHolderColumnNameList));

        //adding the link to the course section's term

        //select CourseSectionId
        List<String> courseSectionIdEntry = new ArrayList<>();
        List<QueryTerm> courseSectionQueryTermList = new ArrayList<>();

        courseSectionIdEntry.add(CourseSection.getColumnName(CourseSection.Columns.ID));


        courseSectionQueryTermList.add(new QueryTerm(CourseSection.getColumnName(CourseSection.Columns.SECTION_TYPE),EQUAL,courseSection.getSectionType(), null));
        courseSectionQueryTermList.add(new QueryTerm(CourseSection.getColumnName(CourseSection.Columns.ID),EQUAL,courseSection.getCoursesId(), LogicalOperator.AND));
///////////////////////////////////////////////////////////////////////////////////////////////////
        List<CourseSection> courseSectionsList = courseSectionsDao.select(courseSectionIdEntry, courseSectionQueryTermList, null);

        if(courseSectionsList.isEmpty()){
            return null;
        }

        Integer courseSectionId = courseSectionsList.get(0).getId();

        //select TermId
        List<String> termIdEntry = new ArrayList<>();
        List<QueryTerm> termQueryTermList = new ArrayList<>();

        termIdEntry.add(Term.getColumnName(Term.Columns.ID));

        termQueryTermList.add(new QueryTerm(Term.getColumnName(Term.Columns.TERM_NAME),EQUAL,termName,null));

        List<Term> termsList = termsDao.select(termIdEntry,termQueryTermList,null);

        if(termsList.isEmpty()){
            return null;
        }

        Integer termId = termsList.get(0).getId();

        //add CourseSectionsTerms entry
        CourseSectionTerm courseSectionTerm = new CourseSectionTerm();
        courseSectionTerm.setCourseSectionsId(courseSectionId);
        courseSectionTerm.setTermsId(termId);

        List<String> courseSectionTermInsertColumnNameList = new ArrayList<>();
        List<String> courseSectionTermKeyHolderColumnNameList = new ArrayList<>();

        courseSectionTermInsertColumnNameList.add(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.COURSE_SECTIONS_ID));
        courseSectionTermInsertColumnNameList.add(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.TERMS_ID));

        courseSectionTermKeyHolderColumnNameList.add(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.ID));
        courseSectionTermKeyHolderColumnNameList.add(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.CREATED_AT));
        courseSectionTermKeyHolderColumnNameList.add(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.UPDATED_AT));

        rowsAffectedList.add(courseSectionsTermsDao.insert(courseSectionTerm,courseSectionTermInsertColumnNameList,courseSectionTermKeyHolderColumnNameList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> modifyCourseSection(CourseSectionModifyDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer courseSectionId = dto.getCourseSectionId();
        Integer courseId = dto.getCourseId();
        String courseSectionType = dto.getSectionType();

        String termName = dto.getTerm();

        queryTermList.add(new QueryTerm(CourseSection.getColumnName(CourseSection.Columns.ID),EQUAL,courseSectionId,null));

        rowsAffectedList.add(courseSectionsDao.update(CourseSection.getColumnName(CourseSection.Columns.COURSES_ID),courseId,queryTermList));
        rowsAffectedList.add(courseSectionsDao.update(CourseSection.getColumnName(CourseSection.Columns.SECTION_TYPE),courseSectionType,queryTermList));

        //select TermId
        List<String> termIdEntry = new ArrayList<>();
        List<QueryTerm> termQueryTermList = new ArrayList<>();

        termIdEntry.add(Term.getColumnName(Term.Columns.ID));

        termQueryTermList.add(new QueryTerm(Term.getColumnName(Term.Columns.TERM_NAME),EQUAL,termName,null));

        List<Term> termsList = termsDao.select(termIdEntry,termQueryTermList,null);

        if(termsList.isEmpty()){
            return null;
        }

        Integer termId = termsList.get(0).getId();

        List<QueryTerm> sectionsTermsQueryTermList = new ArrayList<>();
        sectionsTermsQueryTermList.add(new QueryTerm(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.COURSE_SECTIONS_ID),EQUAL,courseSectionId,null));

        rowsAffectedList.add(courseSectionsTermsDao.update(CourseSectionTerm.getColumnName(CourseSectionTerm.Columns.TERMS_ID),termId,sectionsTermsQueryTermList));
        return rowsAffectedList;

    }

    @Transactional
    @Override
    public List<Integer> removeCourseSection(CourseSectionRemoveDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer courseSectionId = dto.getCourseSectionId();
        queryTermList.add(new QueryTerm(CourseSection.getColumnName(CourseSection.Columns.ID),EQUAL,courseSectionId, null));

        rowsAffectedList.add(courseSectionsDao.delete(queryTermList));

        return rowsAffectedList;

    }

    public List<CourseSection> grabCourseSections() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        columns.add(CourseSection.getColumnName(CourseSection.Columns.ID));
        columns.add(CourseSection.getColumnName(CourseSection.Columns.COURSES_ID));
        columns.add(CourseSection.getColumnName(CourseSection.Columns.SECTION_TYPE));
        columns.add(CourseSection.getColumnName(CourseSection.Columns.CREATED_AT));
        columns.add(CourseSection.getColumnName(CourseSection.Columns.UPDATED_AT));

        return courseSectionsDao.select(columns, queryTermList, null);
    }
}
