package org.dselent.scheduling.server.service;

import org.dselent.scheduling.server.dto.DepartmentAddDto;
import org.dselent.scheduling.server.dto.DepartmentModifyDto;
import org.dselent.scheduling.server.dto.DepartmentRemoveDto;
import org.dselent.scheduling.server.model.Department;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface DepartmentService {
    public List<Integer> addDepartment(DepartmentAddDto DepartmentAddDto) throws SQLException;
    public List<Integer> modifyDepartment(DepartmentModifyDto DepartmentModifyDto) throws SQLException;
    public List<Integer> removeDepartment(DepartmentRemoveDto DepartmentRemoveDto) throws SQLException;
    public List<Department> grabDepartments() throws SQLException;
}
