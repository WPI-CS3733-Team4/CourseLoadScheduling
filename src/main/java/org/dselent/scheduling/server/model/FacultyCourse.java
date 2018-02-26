package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 * Created by Nathan on 1/31/2018.
 */
public class FacultyCourse extends Model {
    // table name
    public static final String TABLE_NAME = "faculty_courses";

    // column names
    public static enum Columns
    {
        ID,
        FACULTY_ID,
        COURSE_SECTIONS_ID,
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
        COLUMN_TYPE_MAP.put(Columns.FACULTY_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.COURSE_SECTIONS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    };

    // attributes

    private Integer id;
    private Integer facultyID;
    private Integer courseSectionID;
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

    public Integer getCourseSectionID() {
        return courseSectionID;
    }

    public void setCourseSectionID(Integer courseSectionID) {
        this.courseSectionID = courseSectionID;
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

        FacultyCourse that = (FacultyCourse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (facultyID != null ? !facultyID.equals(that.facultyID) : that.facultyID != null) return false;
        if (courseSectionID != null ? !courseSectionID.equals(that.courseSectionID) : that.courseSectionID != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        return updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (facultyID != null ? facultyID.hashCode() : 0);
        result = 31 * result + (courseSectionID != null ? courseSectionID.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'facultyID\'=\'" + facultyID +
                "\', \'courseSectionID\'=\'" + courseSectionID +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
