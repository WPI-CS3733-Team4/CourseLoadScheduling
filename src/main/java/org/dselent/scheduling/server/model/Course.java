package org.dselent.scheduling.server.model;


import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


public class Course extends Model{

    // Table Name
    public static final String TABLE_NAME = "courses";

    // Column Names
    public static enum Columns
    {
        ID,
        COURSE_NAME,
        COURSE_DESCRIPTION,
        CREATED_AT,
        UPDATED_AT
        //hi //hello
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
        COLUMN_TYPE_MAP.put(Columns.COURSE_NAME, JDBCType.VARCHAR);
        COLUMN_TYPE_MAP.put(Columns.COURSE_DESCRIPTION, JDBCType.VARCHAR);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    };

    // Attributes
    private Integer id;
    private String courseName;
    private String courseDescription;
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

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseDescription()
    {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription)
    {
        this.courseDescription = courseDescription;
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
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseDescription, course.courseDescription) &&
                Objects.equals(createdAt, course.createdAt) &&
                Objects.equals(updatedAt, course.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseName, courseDescription, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id + "\', \'courseName\'=\'" + courseName + "\', \'courseDescription\'=\'" + courseDescription + "\', \'createdAt\'=\'" + createdAt.toString() + "\', \'updatedAt\'=\'" + updatedAt.toString() + "'}";
    }
}
