package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


/**
 * Created by Krishna on 1/31/2018.
 */
public class FacultyDepartment extends Model {
    // table name
    public static final String TABLE_NAME = "faculty_departments";

    // column names
    public static enum Columns {
        ID,
        FACULTY_ID,
        DEPARTMENTS_ID,
        CREATED_AT,
        UPDATED_AT
    }

    // enum list
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // type mapping
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static {
        for (Columns key : Columns.values()) {
            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.FACULTY_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.DEPARTMENTS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    }

    ;

    // attributes

    private Integer id;
    private Integer facultyID;
    private Integer departmentsID;
    private Instant createdAt;
    private Instant updatedAt;

    // methods

    public static JDBCType getColumnType(Columns column) {
        return COLUMN_TYPE_MAP.get(column);
    }

    public static String getColumnName(Columns column) {
        return column.toString().toLowerCase();
    }

    public static List<String> getColumnNameList() {
        List<String> columnNameList = new ArrayList<>();

        for (Columns column : COLUMN_LIST) {
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

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public Integer getDepartmentsID() {
        return departmentsID;
    }

    public void setDepartmentsID(Integer departmentsID) {
        this.departmentsID = departmentsID;
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
        FacultyDepartment that = (FacultyDepartment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(facultyID, that.facultyID) &&
                Objects.equals(departmentsID, that.departmentsID) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, facultyID, departmentsID, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'facultyID\'=\'" + facultyID +
                "\', \'departmentsID\'=\'" + departmentsID +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
