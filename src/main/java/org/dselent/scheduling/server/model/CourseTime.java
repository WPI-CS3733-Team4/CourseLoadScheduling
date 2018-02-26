package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class CourseTime extends Model {

    // Table Name
    public static final String TABLE_NAME = "course_times";

    // Column Names
    public static enum Columns {
        ID,
        COURSE_SECTIONS_ID,
        DAY_OF_WEEK,
        START_TIME,
        END_TIME,
        LOCATIONS_ID,
        CREATED_AT,
        UPDATED_AT
    }

    // Column List
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // Type Map
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static {
        for (Columns key : Columns.values()) {

            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.COURSE_SECTIONS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.DAY_OF_WEEK, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.START_TIME, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.END_TIME, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.LOCATIONS_ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    }

    // Attributes
    private Integer id;
    private Integer courseSectionsId;
    private Integer dayOfWeek;
    private Integer startTime;
    private Integer endTime;
    private Integer locationID;
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

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseSectionsId() {
        return courseSectionsId;
    }

    public void setCourseSectionsId(Integer courseSectionsId) {
        this.courseSectionsId = courseSectionsId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
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
        CourseTime that = (CourseTime) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(courseSectionsId, that.courseSectionsId) &&
                Objects.equals(dayOfWeek, that.dayOfWeek) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(locationID, that.locationID) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseSectionsId, dayOfWeek, startTime, endTime, locationID, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'courseSectionsId\'=\'" + courseSectionsId +
                "\', \'dayOfWeek\'=\'" + dayOfWeek +
                "\', \'startTime\'=\'" + startTime +
                "\', \'endTime\'=\'" + endTime +
                "\', \'locationID\'=\'" + locationID +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
