package org.dselent.scheduling.server.service;

import java.sql.SQLException;
import java.util.List;

import org.dselent.scheduling.server.dto.TermAddDto;
import org.dselent.scheduling.server.dto.TermModifyDto;
import org.dselent.scheduling.server.dto.TermRemoveDto;
import org.dselent.scheduling.server.model.Term;
import org.dselent.scheduling.server.requests.TermRemove;
import org.springframework.stereotype.Service;

@Service
public interface TermService
{
    public List<Integer> addTerm(TermAddDto termAddDto) throws SQLException;
    public List<Integer> modifyTerm(TermModifyDto termModifyDto) throws  SQLException;
    public List<Integer> removeTerm(TermRemoveDto termRemoveDto) throws SQLException;
    public List<Term> grabTerms() throws SQLException;
}
