package org.dselent.scheduling.server.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dselent.scheduling.server.dao.UsersDao;
import org.dselent.scheduling.server.extractor.UsersExtractor;
import org.dselent.scheduling.server.miscellaneous.Pair;
import org.dselent.scheduling.server.model.User;
import org.dselent.scheduling.server.sqlutils.ColumnOrder;
import org.dselent.scheduling.server.sqlutils.QueryStringBuilder;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


/*
 * @Repository annotation
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html
 * 
 * Useful link
 * https://howtodoinjava.com/spring/spring-core/how-to-use-spring-component-repository-service-and-controller-annotations/
 */
@Repository
public class UsersDaoImpl extends BaseDaoImpl<User> implements UsersDao
{
	@Override
	protected String getTableName(){ return User.TABLE_NAME; }

	@Override
	protected String getIdColumnName(){ return User.getColumnName(User.Columns.ID); }

	@Override
	protected List<String> getColumnNameList(){ return User.getColumnNameList(); }

	@Override
	public List<User> select(List<String> selectColumnNameList, List<QueryTerm> queryTermList, List<Pair<String, ColumnOrder>> orderByList) throws SQLException
	{
		UsersExtractor extractor = new UsersExtractor();
		String queryTemplate = QueryStringBuilder.generateSelectString(getTableName(), selectColumnNameList, queryTermList, orderByList);

		List<Object> objectList = new ArrayList<Object>();
		
		for(QueryTerm queryTerm : queryTermList)
		{
			objectList.add(queryTerm.getValue());
		}
		System.out.print(queryTemplate);
	    Object[] parameters = objectList.toArray();

	    List<User> usersList = jdbcTemplate.query(queryTemplate, extractor, parameters);
	    System.out.println(usersList.toString());
	    return usersList;
	}

	@Override
	protected void addParameterMapValue(MapSqlParameterSource parameters, String insertColumnName, User userModel)
	{
		String parameterName = QueryStringBuilder.convertColumnName(insertColumnName, false);
    	
    	// Wish this could generalize
    	// The getter must be distinguished unless the models are designed as simply a map of columns-values
    	// Would prefer not being that generic since it may end up leading to all code being collections of strings
		
    	if(insertColumnName.equals(User.getColumnName(User.Columns.ID)))
    	{
    		parameters.addValue(parameterName, userModel.getId());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.USER_NAME)))
    	{
    		parameters.addValue(parameterName, userModel.getUserName());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.FIRST_NAME)))
    	{
    		parameters.addValue(parameterName, userModel.getFirstName());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.LAST_NAME)))
    	{
    		parameters.addValue(parameterName, userModel.getLastName());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.EMAIL)))
    	{
    		parameters.addValue(parameterName, userModel.getEmail());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD)))
    	{
    		parameters.addValue(parameterName, userModel.getEncryptedPassword());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.SALT)))
    	{
    		parameters.addValue(parameterName, userModel.getSalt());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.CREATED_AT)))
    	{
    		parameters.addValue(parameterName, userModel.getCreatedAt());
    	}
    	else if(insertColumnName.equals(User.getColumnName(User.Columns.UPDATED_AT)))
    	{
    		parameters.addValue(parameterName, userModel.getUpdatedAt());
    	}
    	else
    	{
    		// should never end up here
    		// lists should have already been validated
    		throw new IllegalArgumentException("Invalid column name provided: " + insertColumnName);
    	}
	}	

	@Override
	protected void addObjectValue(Map<String, Object> keyMap, String keyHolderColumnName, User userModel)
	{
    	if(keyHolderColumnName.equals(User.getColumnName(User.Columns.ID)))
    	{
    		userModel.setId((Integer) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.USER_NAME)))
    	{
    		userModel.setUserName((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.FIRST_NAME)))
    	{
    		userModel.setFirstName((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.LAST_NAME)))
    	{
    		userModel.setLastName((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.EMAIL)))
    	{
    		userModel.setEmail((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.ENCRYPTED_PASSWORD)))
    	{
    		userModel.setEncryptedPassword((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.SALT)))
    	{
    		userModel.setSalt((String) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.CREATED_AT)))
    	{
    		userModel.setCreatedAt((Timestamp) keyMap.get(keyHolderColumnName));
    	}
    	else if(keyHolderColumnName.equals(User.getColumnName(User.Columns.UPDATED_AT)))
    	{
    		userModel.setUpdatedAt((Timestamp) keyMap.get(keyHolderColumnName));
    	}
    	else
    	{
    		// should never end up here
    		// lists should have already been validated
    		throw new IllegalArgumentException("Invalid column name provided: " + keyHolderColumnName);
    	}
	}

}
