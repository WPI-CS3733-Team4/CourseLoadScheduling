package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class UsersPermission extends Model{

    // Table Name
    public static final String TABLE_NAME = "users_permissions";

    // Column Names
    public static enum Columns{
        ID,
        USERS_ID,
        ROLE,
        CREATED_AT,
        UPDATED_AT
    }

    // Make a List of the Columns
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // Type Mapping
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static{
        for(Columns key : Columns.values()){
            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.USERS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.ROLE, JDBCType.VARCHAR);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    };

    // Attributes
    private Integer id;
    private Integer usersId;
    private String role;
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

    // Setters and Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersPermission that = (UsersPermission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(usersId, that.usersId) &&
                Objects.equals(role, that.role) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, usersId, role, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'usersId\'=\'" + usersId +
                "\', \'role\'=\'" + role +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
