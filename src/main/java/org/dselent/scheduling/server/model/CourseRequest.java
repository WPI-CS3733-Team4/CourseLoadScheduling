package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class CourseRequest extends Model {

    // Table Name
    public static final String TABLE_NAME = "course_requests";

    @Override
    public String getTableName(){
        return TABLE_NAME;
    }

    // Column Names
    public static enum Columns{
        ID,
        FACULTY_ID,
        COURSE_SECTIONS_ID,
        CREATED_AT,
        UPDATED_AT
    }

    // Column List
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // Type Map
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static{
        for(Columns key : COLUMN_LIST){

            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.FACULTY_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.COURSE_SECTIONS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    }

    // Attributes
    private Integer id;
    private Integer facultyId;
    private Integer courseSectionsId;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getCourseSectionsId() {
        return courseSectionsId;
    }

    public void setCourseSectionsId(Integer courseSectionsId) {
        this.courseSectionsId = courseSectionsId;
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
        CourseRequest that = (CourseRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(facultyId, that.facultyId) &&
                Objects.equals(courseSectionsId, that.courseSectionsId) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, facultyId, courseSectionsId, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "CourseRequest{" +
                "id=" + id +
                ", facultyId=" + facultyId +
                ", courseSectionsId=" + courseSectionsId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
