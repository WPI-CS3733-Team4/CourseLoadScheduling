package org.dselent.scheduling.server.dao.impl;

import org.dselent.scheduling.server.dao.Dao;
import org.dselent.scheduling.server.miscellaneous.QueryStringBuilder;
import org.dselent.scheduling.server.model.Model;
import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for all Daos.  Contains the database connection objects and implements Dao.
 * Subclasses will specify the implementations for the functions in the Dao interface (how to get the data).
 * 
 * @author dselent
 *
 * @param <M> The model for the Dao
 */
public abstract class BaseDaoImpl<M extends Model> implements Dao<M>
{
	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	protected abstract String getTableName();

	protected abstract void addObjectValue(Map<String, Object> keyMap, String keyHolderColumnName, M model);
	protected abstract void addParameterMapValue(MapSqlParameterSource parameters, String insertColumnName, M model);

	// This can be shared amongst all the DAO's so it is implemented here
	public int insert(M model, List<String> insertColumnNameList, List<String> keyHolderColumnNameList) throws SQLException
	{
		validateColumnNames(insertColumnNameList);
		validateColumnNames(keyHolderColumnNameList);

		String queryTemplate = QueryStringBuilder.generateInsertString(getTableName(), insertColumnNameList);
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		List<Map<String, Object>> keyList = new ArrayList<>();
		KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

		for(String insertColumnName : insertColumnNameList)
		{
			addParameterMapValue(parameters, insertColumnName, model);
		}
		// new way, but unfortunately unnecessary class creation is slow and wasteful (i.e. wrong)
		// insertColumnNames.forEach(insertColumnName -> addParameterMap(parameters, insertColumnName, userModel));

		int rowsAffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

		Map<String, Object> keyMap = keyHolder.getKeys();

		for(String keyHolderColumnName : keyHolderColumnNameList)
		{
			addObjectValue(keyMap, keyHolderColumnName, model);
		}

		return rowsAffected;
	}

	public int delete(List<QueryTerm> queryTermList)
	{
		String queryTemplate = QueryStringBuilder.generateDeleteString(getTableName(), queryTermList);

		List<Object> objectList = new ArrayList<Object>();

		for(QueryTerm queryTerm : queryTermList)
		{
			objectList.add(queryTerm.getValue());
		}

		Object[] parameters = objectList.toArray();

		int rowsAffected = jdbcTemplate.update(queryTemplate, parameters);

		return rowsAffected;
	}

	public int update(String columnName, Object newValue, List<QueryTerm> queryTermList)
	{
		String queryTemplate = QueryStringBuilder.generateUpdateString(getTableName(), columnName, queryTermList);

		List<Object> objectList = new ArrayList<Object>();
		objectList.add(newValue);

		for(QueryTerm queryTerm : queryTermList)
		{
			objectList.add(queryTerm.getValue());
		}

		Object[] parameters = objectList.toArray();

		int rowsAffected = jdbcTemplate.update(queryTemplate, parameters);

		return rowsAffected;
	}


	// perhaps find a nice way to abstract some of the extending classes here
}
