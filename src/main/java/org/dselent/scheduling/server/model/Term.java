package org.dselent.scheduling.server.model;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Term extends Model
{
    // Table Name
    public static final String TABLE_NAME = "terms";

    // Column Names
    public static enum Columns
    {
        ID,
        TERM_NAME,
        CREATED_AT,
        UPDATED_AT
    }

    // Make a List of the Columns
    private static final List<Columns> COLUMN_LIST = new ArrayList<>();

    // Type Mapping
    private static final Map<Columns, JDBCType> COLUMN_TYPE_MAP = new HashMap<>();

    static
    {
        for (Columns key : Columns.values()) {
            COLUMN_LIST.add(key);
        }

        COLUMN_TYPE_MAP.put(Columns.ID, JDBCType.INTEGER);
        COLUMN_TYPE_MAP.put(Columns.TERM_NAME, JDBCType.VARCHAR);
        COLUMN_TYPE_MAP.put(Columns.CREATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);
        COLUMN_TYPE_MAP.put(Columns.UPDATED_AT, JDBCType.TIMESTAMP_WITH_TIMEZONE);

    }

    private Integer id;
    private String termName;
    private Instant createdAt;
    private Instant updatedAt;

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

    //Getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
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
        Term term = (Term) o;
        return Objects.equals(id, term.id) &&
                Objects.equals(termName, term.termName) &&
                Objects.equals(createdAt, term.createdAt) &&
                Objects.equals(updatedAt, term.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, termName, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{\'id\'=\'" + id +
                "\', termName\'=\'" + termName +
                "\', createdAt\'=\'" + createdAt +
                "\', updatedAt\'=\'" + updatedAt +
                "\'}";
    }
}
