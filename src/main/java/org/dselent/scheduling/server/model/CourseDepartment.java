package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


public class CourseDepartment extends Model {
    // Table Name
    public static final String TABLE_NAME = "course_departments";

    // Column Names
    public static enum Columns {
        ID,
        COURSES_ID,
        DEPARTMENTS_ID,
        COURSE_NUMBER,
        CREATED_AT,
        UPDATED_AT
    }

    // Make a List of the Columns
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // Type Mapping
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static {
        for (Columns key : Columns.values()) {
            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.COURSES_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.DEPARTMENTS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.COURSE_NUMBER, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    }

    ;

    // Attributes
    private Integer id;
    private Integer courseId;
    private Integer departmentId;
    private Integer courseNumber;
    private Instant createdAt;
    private Instant updatedAt;

    // Column Methods

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

    // Setters and Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
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
        CourseDepartment that = (CourseDepartment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(courseNumber, that.courseNumber) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseId, departmentId, courseNumber, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +"\', \'courseId\'=\'" + courseId +
                "\', \'departmentId\'=\'" + departmentId +
                "\', \'courseNumber\'=\'" + courseNumber +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}