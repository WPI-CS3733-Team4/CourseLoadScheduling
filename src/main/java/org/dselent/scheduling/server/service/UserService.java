package org.dselent.scheduling.server.service;

import java.sql.SQLException;
import java.util.List;

import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.model.User;
import org.springframework.stereotype.Service;

/**
 * Service layer to specify all business logic. Calls the dao layer when data retrieval is needed.
 * Interfaces specify the behavior and the implementation provide the specific implementations.
 * 
 * @author dselent
 *
 */
@Service
public interface UserService
{
	/**
	 * Registers a user into the system
	 * Performs an insert into the users table and users_roles_links table as a transaction
	 * 
	 * @param userRegisterDto DTO container information for the insertions
	 * @return A list of rows affected for each insert operation
	 * @throws SQLException
	 */
	public List<Integer> registerUser(UserRegisterDto userRegisterDto) throws SQLException;
    public User loginUser(UserLoginDto userLoginDto) throws SQLException;
    public User logoutUser(UserLogoutDto userLogoutDto) throws SQLException;
    public List<Integer> modifyUser(UserModifyDto userModifyDto) throws SQLException;
    public List<Integer> deactivateUser(UserDeactivateDto dto) throws SQLException;
    public List<User> grabUsers() throws SQLException;
}
