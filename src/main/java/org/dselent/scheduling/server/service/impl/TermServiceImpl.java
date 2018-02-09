package org.dselent.scheduling.server.service.impl;

import org.dselent.scheduling.server.dao.TermsDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.TermsDao;
import org.dselent.scheduling.server.dto.TermModifyDto;
import org.dselent.scheduling.server.dto.TermAddDto;
import org.dselent.scheduling.server.dto.TermRemoveDto;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.model.Course;
import org.dselent.scheduling.server.model.Term;
import org.dselent.scheduling.server.model.User;
import org.dselent.scheduling.server.requests.TermRemove;
import org.dselent.scheduling.server.service.TermService;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;

public class TermServiceImpl implements TermService
{
    private TermsDao termsDao;

    public TermServiceImpl(){
        //
    }
    @Transactional
    @Override
    public List<Integer> addTerm(TermAddDto termAddDto) throws SQLException
    {
        List<Integer> rowsAffectedList = new ArrayList<>();
        Term term = new Term();
        term.setTermName(termAddDto.getTermName());
        List<String> termInsertColumNameList = new ArrayList<>();
        List<String> termKeyHolderColumnNameList = new ArrayList<>();
        termInsertColumNameList.add(Term.getColumnName(Term.Columns.TERM_NAME));
        termKeyHolderColumnNameList.add(Term.getColumnName(Term.Columns.ID));
        termKeyHolderColumnNameList.add(Term.getColumnName(Term.Columns.CREATED_AT));
        termKeyHolderColumnNameList.add(Term.getColumnName(Term.Columns.UPDATED_AT));
        rowsAffectedList.add(termsDao.insert(term, termInsertColumNameList, termKeyHolderColumnNameList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> modifyTerm(TermModifyDto termModifyDto) throws SQLException
    {
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        String termName = termModifyDto.getTermName();
        Integer termId = termModifyDto.getTermId();

        queryTermList.add(new QueryTerm(Term.getColumnName(Term.Columns.ID), EQUAL, termId, null));
        rowsAffectedList.add(termsDao.update(Term.getColumnName(Term.Columns.TERM_NAME), termName, queryTermList));

        return rowsAffectedList;
    }

    @Override
    public List<Integer> removeTerm(TermRemoveDto termRemoveDto) throws SQLException {
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer termId = termRemoveDto.getTermId();
        queryTermList.add(new QueryTerm(Term.getColumnName(Term.Columns.ID), EQUAL, termId, null));
        rowsAffectedList.add(termsDao.delete(queryTermList));

        return rowsAffectedList;
    }
}
