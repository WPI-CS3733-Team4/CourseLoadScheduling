package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.TermsController;
import org.dselent.scheduling.server.dto.TermRemoveDto;
import org.dselent.scheduling.server.dto.TermAddDto;
import org.dselent.scheduling.server.dto.TermModifyDto;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.Term;
import org.dselent.scheduling.server.requests.TermRemove;
import org.dselent.scheduling.server.requests.TermModify;
import org.dselent.scheduling.server.requests.TermAdd;
import org.dselent.scheduling.server.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller for handling requests related to the user such as logging in or registering.
 * Controller methods are the first methods reached by the request server-side (with special exception).
 * They parse the request and then call the appropriate service method to execute the business logic.
 * Any results or data is then sent back to the client.
 *
 * @author dselent
 */
@Controller
public class TermsControllerImpl implements TermsController
{
    @Autowired
    private TermService termService;

    /**
     *
     * @param request The body of the request expected to contain a map of String key-value pairs
     * @return A ResponseEntity for the response object(s) and the status code
     * @throws Exception
     */
    public ResponseEntity<String> add(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Terms controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();


        success.add("{'json_test':{'item1':1,'item2':2}");
        success.add("balbalalbsabld");

        String termName = request.get(TermAdd.getBodyName(TermAdd.BodyKey.TERM_NAME));

        TermAddDto.Builder builder = TermAddDto.builder();
        TermAddDto termAddDto = builder.withTermName(termName)
                .build();

        termService.addTerm(termAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Terms controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer termId = Integer.parseInt(request.get(TermModify.getBodyName(TermModify.BodyKey.TERM_ID)));
        String termName = request.get(TermModify.getBodyName(TermModify.BodyKey.TERM_NAME));

        TermModifyDto.Builder builder = TermModifyDto.builder();
        TermModifyDto termModifyDto = builder.withTermId(termId)
                .withTermName(termName)
                .build();

        termService.modifyTerm(termModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> remove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Terms controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer termId = Integer.parseInt(request.get(TermRemove.getBodyName(TermRemove.BodyKey.TERM_ID)));

        TermRemoveDto.Builder builder = TermRemoveDto.builder();
        TermRemoveDto termRemoveDto = builder.withTermId(termId)
                .build();

        termService.removeTerm(termRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

    public ResponseEntity<String> getTerms(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Terms controller reached");


        //get all the users (how do we do the responseSet????)
        List<Term> listOfUsers = termService.grabTerms();

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(listOfUsers);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }
}

