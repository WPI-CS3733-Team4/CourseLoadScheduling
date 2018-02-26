package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.DepartmentsController;
import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.Department;
import org.dselent.scheduling.server.requests.*;
import org.dselent.scheduling.server.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * Created by Nathan on 2/9/2018.
 */
@Controller
public class DepartmentsControllerImpl implements DepartmentsController {
    @Autowired
    private DepartmentService departmentService;

    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Departments controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        String department = request.get(DepartmentAdd.getBodyName(DepartmentAdd.BodyKey.DEPARTMENT));

        DepartmentAddDto.Builder builder = DepartmentAddDto.builder();
        DepartmentAddDto departmentAddDto = builder.withDepartment(department)
                .build();

        departmentService.addDepartment(departmentAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Departments controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer departmentId = Integer.parseInt(request.get(DepartmentModify.getBodyName(DepartmentModify.BodyKey.DEPARTMENT_ID)));
        String department = request.get(DepartmentModify.getBodyName(DepartmentModify.BodyKey.DEPARTMENT));

        DepartmentModifyDto.Builder builder = DepartmentModifyDto.builder();
        DepartmentModifyDto departmentModifyDto = builder.withDepartmentId(departmentId)
                .withDepartment(department)
                .build();

        departmentService.modifyDepartment(departmentModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Departments controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer departmentId = Integer.parseInt(request.get(DepartmentRemove.getBodyName(DepartmentRemove.BodyKey.DEPARTMENT_ID)));

        DepartmentRemoveDto.Builder builder = DepartmentRemoveDto.builder();
        DepartmentRemoveDto departmentRemoveDto = builder.withDepartmentId(departmentId)
                .build();

        departmentService.removeDepartment(departmentRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> getDepartments(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Departments controller reached");



        List<Department> listOfDepartments = departmentService.grabDepartments();

        List<String> departmentsEntryList = new ArrayList<String>();

        for (Department department : listOfDepartments){
            departmentsEntryList.add(department.toString());
        }

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(departmentsEntryList);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }
}
