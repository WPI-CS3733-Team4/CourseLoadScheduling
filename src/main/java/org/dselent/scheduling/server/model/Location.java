package org.dselent.scheduling.server.model;


import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Location extends Model {

    // Table Name
    public static final String TABLE_NAME = "locations";

    // Column Names
    public static enum Columns{
        ID,
        BUILDING,
        ROOM,
        ROOM_SIZE,
        CREATED_AT,
        UPDATED_AT
    }

    // Make a list of the Columns
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
        COLUMN_TYPE_MAP.put(Columns.BUILDING, JDBCType.VARCHAR);
        COLUMN_TYPE_MAP.put(Columns.ROOM, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.ROOM_SIZE, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    };

    // Attributes
    private Integer id;
    private String building;
    private Integer room;
    private Integer roomSize;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
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

    // Overide Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(building, location.building) &&
                Objects.equals(room, location.room) &&
                Objects.equals(roomSize, location.roomSize) &&
                Objects.equals(createdAt, location.createdAt) &&
                Objects.equals(updatedAt, location.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, building, room, roomSize, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', \'building\'=\'" + building +
                "\', \'room\'=\'" + room +
                "\', \'roomSize\'=\'" + roomSize +
                "\', \'createdAt\'=\'" + createdAt.toString() +
                "\', \'updatedAt\'=\'" + updatedAt.toString() +
                "\'}";
    }
}
