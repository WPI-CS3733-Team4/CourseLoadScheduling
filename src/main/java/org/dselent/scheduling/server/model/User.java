package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


public class User extends Model
{
	// Table Name
	public static final String TABLE_NAME = "users";

	// Column Names
	public static enum Columns
	{
		ID,
		USER_NAME,
		FIRST_NAME,
		LAST_NAME,
		EMAIL,
		ENCRYPTED_PASSWORD,
		SALT,
		CREATED_AT,
		UPDATED_AT
	}
	
	// Make a List of the Columns
	private static final List<Columns> COLUMN_LIST = new ArrayList<>();
	
	// Type Mapping
	private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();
	
	static
	{

		for(Columns key : Columns.values())
		{
			COLUMN_LIST.add(key);
		}
		
		COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
		COLUMN_TYPE_MAP.put(Columns.USER_NAME, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.FIRST_NAME, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.LAST_NAME, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.EMAIL, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.ENCRYPTED_PASSWORD, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.SALT, JDBCType.VARCHAR);
		COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
		COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
	};
	
	// Attributes
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String salt;
	private Instant createdAt;
	private Instant updatedAt;

	// Column Methods
		
	public static JDBCType getColumnType(Columns column)
	{
		return COLUMN_TYPE_MAP.get(column);
	}
	
	public static String getColumnName(Columns column)
	{
		return column.toString().toLowerCase();
	}
	
	public static List<String> getColumnNameList()
	{
		List<String> columnNameList = new ArrayList<>();
		
		for(Columns column : COLUMN_LIST)
		{
			columnNameList.add(getColumnName(column));
		}
		
		return columnNameList;
	}
	
	// Attribute Setters and Getters
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEncryptedPassword()
	{
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword)
	{
		this.encryptedPassword = encryptedPassword;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public Instant getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt)
	{
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt)
	{
		if(createdAt != null)
		{
			this.createdAt = createdAt.toInstant();
		}
	}

	public Instant getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt)
	{
		this.updatedAt = updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt)
	{
		if(updatedAt != null)
		{
			this.updatedAt = updatedAt.toInstant();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(userName, user.userName) &&
				Objects.equals(firstName, user.firstName) &&
				Objects.equals(lastName, user.lastName) &&
				Objects.equals(email, user.email) &&
				Objects.equals(encryptedPassword, user.encryptedPassword) &&
				Objects.equals(salt, user.salt) &&
				Objects.equals(createdAt, user.createdAt) &&
				Objects.equals(updatedAt, user.updatedAt);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, userName, firstName, lastName, email, encryptedPassword, salt, createdAt, updatedAt);
	}

	@Override
	public String toString() {
		return "{\'id=" + id +
				"\', \'userName\'=\'" + userName +
				"\', \'firstName\'=\'" + firstName +
				"\', \'lastName\'=\'" + lastName +
				"\', \'email\'=\'" + email +
				"\', \'encryptedPassword\'=\'" + encryptedPassword +
				"\', \'salt\'=\'" + salt +
				"\', \'createdAt\'=\'" + createdAt.toString() +
				"\', \'updatedAt\'=\'" + updatedAt.toString() +
				"\'}";
	}
}
