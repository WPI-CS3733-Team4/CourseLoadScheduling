package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.DepartmentsDao;

import org.dselent.scheduling.server.dto.DepartmentAddDto;
import org.dselent.scheduling.server.dto.DepartmentModifyDto;
import org.dselent.scheduling.server.dto.DepartmentRemoveDto;
import org.dselent.scheduling.server.model.Department;
import org.dselent.scheduling.server.service.DepartmentService;

import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;
/**
 * Created by Nathan on 2/9/2018.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentsDao departmentsDao;

    public DepartmentServiceImpl(){

    }

    /*
     * (non-Javadoc)
     * @see org.dselent.scheduling.server.service.DepartmentService#addDepartment(org.dselent.scheduling.server.dto.DepartmentAddDto)
     */
    @Transactional
    @Override
    public List<Integer> addDepartment(DepartmentAddDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();

        Department department = new Department();
        department.setDepartment(dto.getDepartment());


        /*dunno what to do with this. we'll probably need to add a new thing in BaseDaoImpl
         * --Has been modified so that Departments don't necessarily require a department*/
        //String DepartmentDept = dto.getDepartmentDept();

        List<String> DepartmentInsertColumnNameList = new ArrayList<>();
        List<String> DepartmentKeyHolderColumnNameList = new ArrayList<>();

        DepartmentInsertColumnNameList.add(Department.getColumnName(Department.Columns.DEPARTMENT));


        DepartmentKeyHolderColumnNameList.add(Department.getColumnName(Department.Columns.ID));
        DepartmentKeyHolderColumnNameList.add(Department.getColumnName(Department.Columns.CREATED_AT));
        DepartmentKeyHolderColumnNameList.add(Department.getColumnName(Department.Columns.UPDATED_AT));

        rowsAffectedList.add(departmentsDao.insert(department, DepartmentInsertColumnNameList, DepartmentKeyHolderColumnNameList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> modifyDepartment(DepartmentModifyDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer departmentId = dto.getDepartmentId();
        String department = dto.getDepartment();


        /*I have no idea how to modify a Department's department. the system'll work okay without it though
         * --Has been modified so that Departments don't necessarily require a department*/
        //String DepartmentDept = dto.getDepartmentDept();


        queryTermList.add(new QueryTerm(Department.getColumnName(Department.Columns.ID),EQUAL,departmentId,null));

        rowsAffectedList.add(departmentsDao.update(Department.getColumnName(Department.Columns.DEPARTMENT),department,queryTermList));

        return rowsAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> removeDepartment(DepartmentRemoveDto dto) throws SQLException{
        List<Integer> rowsAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer DepartmentId = dto.getDepartment();
        queryTermList.add(new QueryTerm(Department.getColumnName(Department.Columns.ID),EQUAL,DepartmentId,null));

        rowsAffectedList.add(departmentsDao.delete(queryTermList));

        return rowsAffectedList;
    }

    public List<Department> grabDepartments() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        columns.add(Department.getColumnName(Department.Columns.ID));
        columns.add(Department.getColumnName(Department.Columns.DEPARTMENT));
        columns.add(Department.getColumnName(Department.Columns.CREATED_AT));
        columns.add(Department.getColumnName(Department.Columns.UPDATED_AT));

        return departmentsDao.select(columns, queryTermList, null);
    }
}
