package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


/**
 * Created by Nathan on 1/31/2018.
 */
public class Faculty extends Model {
    // table name
    public static final String TABLE_NAME = "faculty";

    // column names
    public static enum Columns
    {
        ID,
        USERS_ID,
        REQUIRED_CREDITS,
        CREATED_AT,
        UPDATED_AT
    }

    // enum list
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // type mapping
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static
    {
        for(Columns key : Columns.values())
        {
            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.USERS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.REQUIRED_CREDITS, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    };

    // attributes

    private Integer id;
    private Integer usersId;
    private Integer requiredCredits;
    private Instant createdAt;
    private Instant updatedAt;

    // methods

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

    //getters and setters

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

    public Integer getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(Integer requiredCredits) {
        this.requiredCredits = requiredCredits;
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

        Faculty faculty = (Faculty) o;

        if (id != null ? !id.equals(faculty.id) : faculty.id != null) return false;
        if (usersId != null ? !usersId.equals(faculty.usersId) : faculty.usersId != null) return false;
        if (requiredCredits != null ? !requiredCredits.equals(faculty.requiredCredits) : faculty.requiredCredits != null)
            return false;
        if (createdAt != null ? !createdAt.equals(faculty.createdAt) : faculty.createdAt != null) return false;
        return updatedAt != null ? updatedAt.equals(faculty.updatedAt) : faculty.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usersId != null ? usersId.hashCode() : 0);
        result = 31 * result + (requiredCredits != null ? requiredCredits.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'usersId\'=\'" + usersId +
                "\', \'requiredCredits\'=\'" + requiredCredits +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
