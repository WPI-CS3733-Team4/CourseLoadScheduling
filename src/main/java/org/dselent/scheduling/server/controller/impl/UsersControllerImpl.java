package org.dselent.scheduling.server.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.controller.UsersController;
import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.extractor.UsersExtractor;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.User;
import org.dselent.scheduling.server.requests.*;
import org.dselent.scheduling.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.jws.soap.SOAPBinding;

/**
 * Controller for handling requests related to the user such as logging in or registering.
 * Controller methods are the first methods reached by the request server-side (with special exception).
 * They parse the request and then call the appropriate service method to execute the business logic.
 * Any results or data is then sent back to the client.
 * 
 * @author dselent
 */
@Controller
public class UsersControllerImpl implements UsersController
{
	@Autowired
    private UserService userService;

//	@Autowired
//	private UsersExtractor usersExtractor;
    
	/**
	 * 
	 * @param request The body of the request expected to contain a map of String key-value pairs
	 * @return A ResponseEntity for the response object(s) and the status code
	 * @throws Exception 
	 */
	public ResponseEntity<String> register(@RequestBody Map<String, String> request) throws Exception 
    {
    	// Print is for testing purposes
		System.out.println("Users controller reached");
    	
		// add any objects that need to be returned to the success list
		String response = "";
		List<Object> success = new ArrayList<Object>();
		
		String userName = request.get(UserRegister.getBodyName(UserRegister.BodyKey.USER_NAME));
		String firstName = request.get(UserRegister.getBodyName(UserRegister.BodyKey.FIRST_NAME));
		String lastName = request.get(UserRegister.getBodyName(UserRegister.BodyKey.LAST_NAME));
		String email = request.get(UserRegister.getBodyName(UserRegister.BodyKey.EMAIL));
		String password = request.get(UserRegister.getBodyName(UserRegister.BodyKey.PASSWORD));

		UserRegisterDto.Builder builder = UserRegisterDto.builder();
		UserRegisterDto userRegisterDto = builder.withUserName(userName)
		.withFirstName(firstName)
		.withLastName(lastName)
		.withEmail(email)
		.withPassword(password)
		.build();
		
		userService.registerUser(userRegisterDto);
		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

		return new ResponseEntity<String>(response, HttpStatus.OK);
    }

	public ResponseEntity<String> login(@RequestBody Map<String, String> request) throws Exception
	{
		// Print is for testing purposes
//		System.out.println("Users controller reached");

		// add any objects that need to be returned to the success list
		String response = "";
		List<Object> success = new ArrayList<Object>();

		String userName = request.get(UserLogin.getBodyName(UserLogin.BodyKey.USER_NAME));
		String password = request.get(UserLogin.getBodyName(UserLogin.BodyKey.PASSWORD));

		UserLoginDto.Builder builder = UserLoginDto.builder();
		UserLoginDto userLoginDto = builder.withUserName(userName)
				.withPassword(password)
				.build();

		User retUser =  userService.loginUser(userLoginDto);
		if(retUser != null){

			success.add(retUser);
		}else{

			success.add("WRONG_INFO");
		}
		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

		return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
	}

	public ResponseEntity<String> logout(@RequestBody Map<String, String> request) throws Exception
	{
		// Print is for testing purposes
		System.out.println("Users controller reached");

		String response = "";
		List<Object> success = new ArrayList<Object>();

		Integer userId = Integer.parseInt(request.get(UserLogout.getBodyName(UserLogout.BodyKey.USER_ID)));
		
		UserLogoutDto.Builder builder = UserLogoutDto.builder();
		UserLogoutDto userLogoutDto = builder.withUserId(userId)
				.build();

		userService.logoutUser(userLogoutDto);
		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

		return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
	}

	public ResponseEntity<String> modify(@RequestBody Map<String, String> request) throws Exception
	{
		// Print is for testing purposes
		System.out.println("Users controller reached");

		String response = "";
		List<Object> success = new ArrayList<Object>();

		Integer userId = Integer.parseInt(request.get(UserModify.getBodyName(UserModify.BodyKey.USER_ID)));
		String userName = request.get(UserModify.getBodyName(UserModify.BodyKey.USER_NAME));
		String firstName = request.get(UserModify.getBodyName(UserModify.BodyKey.FIRST_NAME));
		String lastName = request.get(UserModify.getBodyName(UserModify.BodyKey.LAST_NAME));
		String email = request.get(UserModify.getBodyName(UserModify.BodyKey.EMAIL));
		String password = request.get(UserModify.getBodyName(UserModify.BodyKey.PASSWORD));

		UserModifyDto.Builder builder = UserModifyDto.builder();
		UserModifyDto userModifyDto = builder.withId(userId)
				.withUserName(userName)
				.withFirstName(firstName)
				.withLastName(lastName)
				.withEmail(email)
				.withPassword(password)
				.build();

		userService.modifyUser(userModifyDto);
		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

		return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
	}

	public ResponseEntity<String> deactivate(@RequestBody Map<String, String> request) throws Exception
	{
		// Print is for testing purposes
		System.out.println("Users controller reached");

		String response = "";
		List<Object> success = new ArrayList<Object>();

		Integer userId = Integer.parseInt(request.get(UserDeactivate.getBodyName(UserDeactivate.BodyKey.USER_ID)));

		UserDeactivateDto.Builder builder = UserDeactivateDto.builder();
		UserDeactivateDto userDeactivateDto = builder.withUserId(userId)
				.build();

		userService.deactivateUser(userDeactivateDto);
		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

		return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
	}

	public ResponseEntity<String> get(@RequestBody Map<String, String> request) throws Exception
	{
		System.out.println("Users controller reached");


		//get all the users (how do we do the responseSet????)
		List<User> listOfUsers = userService.grabUsers();

		List<String> userEntryList = new ArrayList<String>();

		for (User user : listOfUsers){
			userEntryList.add(user.toString());
		}

		String response = "";

		List<Object> success = new ArrayList<Object>();

		//Add the list of the users to the response
		success.add(userEntryList);


		response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
		return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
	}
}

	