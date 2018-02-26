package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.UsersDao;
import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.model.User;
import org.dselent.scheduling.server.service.UserService;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UsersDao usersDao;
	
    public UserServiceImpl()
    {
    	//
    }
    
    /*
     * (non-Javadoc)
     * @see org.dselent.scheduling.server.service.UserService#registerUser(org.dselent.scheduling.server.dto.UserRegisterDto)
     */
    @Transactional
    @Override
	public List<Integer> registerUser(UserRegisterDto dto) throws SQLException
	{
		List<Integer> rowsAffectedList = new ArrayList<>();
		

		String salt = KeyGenerators.string().generateKey();
		String saltedPassword = dto.getPassword() + salt;
		System.out.println(saltedPassword);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encryptedPassword = passwordEncoder.encode(saltedPassword);
        String encryptedPassword = saltedPassword;
		
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setEncryptedPassword(encryptedPassword);
		user.setSalt(salt);

    	List<String> userInsertColumnNameList = new ArrayList<>();
    	List<String> userKeyHolderColumnNameList = new ArrayList<>();
    	
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.USER_NAME));
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.FIRST_NAME));
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.LAST_NAME));
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.EMAIL));
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD));
    	userInsertColumnNameList.add(User.getColumnName(User.Columns.SALT));

    	userKeyHolderColumnNameList.add(User.getColumnName(User.Columns.ID));
    	userKeyHolderColumnNameList.add(User.getColumnName(User.Columns.CREATED_AT));
    	userKeyHolderColumnNameList.add(User.getColumnName(User.Columns.UPDATED_AT));
		
    	rowsAffectedList.add(usersDao.insert(user, userInsertColumnNameList, userKeyHolderColumnNameList));
		System.out.println("user reg done!");
		//
     	
    	// for now, assume users can only register with default role id
    	// may change in the future
    	/*

		*/
		return rowsAffectedList;
	}


	@Override
	public User loginUser(UserLoginDto userLoginDto) throws SQLException
	{
		// Get data out of the DTO
		String userName = userLoginDto.getUserName();
		String password = userLoginDto.getPassword();

		List<String> userSelectColumnNameList = new ArrayList<>();
		List<QueryTerm> queryTermList = new ArrayList<>();

		// Decide what to grab
		userSelectColumnNameList.add(User.getColumnName(User.Columns.ID));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.USER_NAME));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.FIRST_NAME));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.LAST_NAME));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.EMAIL));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.SALT));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.CREATED_AT));
		userSelectColumnNameList.add(User.getColumnName(User.Columns.UPDATED_AT));

		// Create Query Term
		queryTermList.add(new QueryTerm(User.getColumnName(User.Columns.USER_NAME), EQUAL, userName, null));

//		System.out.println(userName+queryTermList.toString());

		List<Pair<String, ColumnOrder>> orderByList = new ArrayList<>();
		Pair<String, ColumnOrder> orderPair1 = new Pair<String, ColumnOrder>(User.getColumnName(User.Columns.USER_NAME), ColumnOrder.ASC);
		orderByList.add(orderPair1);

		List<User> usersList = usersDao.select(userSelectColumnNameList, queryTermList, orderByList);

//		System.out.println(usersList.toString());

		if(usersList.isEmpty()){
			System.out.println("userNotFound");
			return null; // Could not find a user with that user name so dont both with everything else
		}

		System.out.println("userFound");
		User targetUser = usersList.get(0); // There should only be one anyways

		// Check if the password and salt match
		String saltedPassword = password + targetUser.getSalt();

		System.out.println(saltedPassword);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encryptedPassword = passwordEncoder.encode(saltedPassword);
        String encryptedPassword = saltedPassword;
		System.out.println(targetUser.getSalt()+' '+encryptedPassword+' '+targetUser.getEncryptedPassword());
		if(encryptedPassword.equals(targetUser.getEncryptedPassword())){
			return targetUser;
		} else {
			return null; // Or maybe throw a UserNotFound Exception?
		}

	}

	@Override
	public User logoutUser(UserLogoutDto userLogoutDto) throws SQLException{
		return null;
	}

	@Override
	public List<Integer> modifyUser(UserModifyDto userModifyDto) throws SQLException{
		List<Integer> rowsAffectedList = new ArrayList<>();
		List<QueryTerm> queryTermList = new ArrayList<>();

		Integer id = userModifyDto.getId();
		String userName = userModifyDto.getUserName();
		String firstName = userModifyDto.getFirstName();
		String lastName = userModifyDto.getLastName();
		String email = userModifyDto.getEmail();

		String salt = KeyGenerators.string().generateKey();
		String saltedPassword = userModifyDto.getPassword() + salt;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedPassword = passwordEncoder.encode(saltedPassword);


		queryTermList.add(new QueryTerm(User.getColumnName(User.Columns.ID), EQUAL, id, null));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.USER_NAME), userName, queryTermList));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.FIRST_NAME), firstName, queryTermList));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.LAST_NAME), lastName, queryTermList));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.EMAIL), email, queryTermList));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD), encryptedPassword, queryTermList));
		rowsAffectedList.add(usersDao.update(User.getColumnName(User.Columns.SALT), saltedPassword, queryTermList));

		return rowsAffectedList;
	}

	public List<Integer> deactivateUser(UserDeactivateDto dto) throws SQLException{
		List<Integer> rowsAffectedList = new ArrayList<>();
		List<QueryTerm> queryTermList = new ArrayList<>();

		Integer userId = dto.getUserId();
		queryTermList.add(new QueryTerm(User.getColumnName(User.Columns.ID),EQUAL,userId,null));

		rowsAffectedList.add(usersDao.delete(queryTermList));

		return rowsAffectedList;
	}

	public List<User> grabUsers() throws SQLException
	{
		List<QueryTerm> queryTermList = new ArrayList<>();

		List<String> columns = new ArrayList<>();
		columns.add(User.getColumnName(User.Columns.ID));
		columns.add(User.getColumnName(User.Columns.USER_NAME));
		columns.add(User.getColumnName(User.Columns.FIRST_NAME));
		columns.add(User.getColumnName(User.Columns.LAST_NAME));
		columns.add(User.getColumnName(User.Columns.EMAIL));
		columns.add(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD));
		columns.add(User.getColumnName(User.Columns.SALT));
		columns.add(User.getColumnName(User.Columns.CREATED_AT));
		columns.add(User.getColumnName(User.Columns.UPDATED_AT));

		return usersDao.select(columns, queryTermList, null);
	}
}
