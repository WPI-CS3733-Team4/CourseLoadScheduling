package org.dselent.scheduling.server.dto;

import javax.annotation.Generated;
import java.util.Objects;


public class CourseSectionTimeModifyDto
{
    private final Integer CourseSectionTimeId;
    private final Integer CourseSectionId;
    private final Integer DayOfWeek;
    private final Integer StartTime;
    private final Integer EndTime;
    private final Integer LocationId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private CourseSectionTimeModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used
        this.CourseSectionTimeId = builder.CourseSectionTimeId;
        this.CourseSectionId = builder.CourseSectionId;
        this.DayOfWeek = builder.DayOfWeek;
        this.StartTime = builder.StartTime;
        this.EndTime = builder.EndTime;
        this.LocationId = builder.LocationId;


        // making claim that none of these can be null
        // add other state checks here as necessary
        if(this.CourseSectionTimeId == null){
            throw new IllegalStateException("CourseSectionTimeId cannot be null");
        }
        else if(this.CourseSectionId == null){
            throw new IllegalStateException("CourseSectionId cannot be null");
        }
        else if(this.DayOfWeek == null)
        {
            throw new IllegalStateException("DayOfWeek cannot be null");
        }
        else if(this.StartTime == null)
        {
            throw new IllegalStateException("StartTime cannot be null");
        }
        else if(this.EndTime == null)
        {
            throw new IllegalStateException("EndTime cannot be null");
        }
        else if(this.LocationId == null)
        {
            throw new IllegalStateException("Location cannot be null");
        }

    }

    public Integer getCourseSectionTimeId() { return CourseSectionTimeId;}

    public Integer getCourseSectionId() { return CourseSectionId;}

    public Integer getDayOfWeek()
    {
        return DayOfWeek;
    }

    public Integer getStartTime()
    {
        return StartTime;
    }

    public Integer getEndTime()
    {
        return EndTime;
    }

    public Integer getLocation()
    {
        return LocationId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSectionTimeModifyDto that = (CourseSectionTimeModifyDto) o;
        return Objects.equals(CourseSectionTimeId, that.CourseSectionTimeId) &&
                Objects.equals(CourseSectionId, that.CourseSectionId) &&
                Objects.equals(DayOfWeek, that.DayOfWeek) &&
                Objects.equals(StartTime, that.StartTime) &&
                Objects.equals(EndTime, that.EndTime) &&
                Objects.equals(LocationId, that.LocationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionTimeId, CourseSectionId, DayOfWeek, StartTime, EndTime, LocationId);
    }

    @Override
    public String toString() {
        return "{" +
                "\'CourseSectionTimeId\'=\'" + CourseSectionTimeId +
                "\', \'CourseSectionId\'=\'" + CourseSectionId +
                "\', \'DayOfWeek\'=\'" + DayOfWeek + '\'' +
                ", \'StartTime\'=\'" + StartTime +
                ", \'EndTime\'=\'" + EndTime +
                "\', \'Location=\'" + LocationId + '\'' +
                '}';
    }

    /**
     * Creates builder to build {@link UserRegisterDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link UserRegisterDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseSectionTimeId;
        private Integer CourseSectionId;
        private Integer DayOfWeek;
        private Integer StartTime;
        private Integer EndTime;
        private Integer LocationId;


        private Builder()
        {
        }

        public Builder withCourseSectionTimeId(Integer CourseSectionTimeId){
            this.CourseSectionTimeId = CourseSectionTimeId;
            return this;
        }

        public Builder withCourseSectionId(Integer CourseSectionId){
            this.CourseSectionId = CourseSectionId;
            return this;
        }

        public Builder withDayOfWeek(Integer DayOfWeek)
        {
            this.DayOfWeek = DayOfWeek;
            return this;
        }

        public Builder withStartTime(Integer StartTime)
        {
            this.StartTime = StartTime;
            return this;
        }

        public Builder withEndTime(Integer EndTime)
        {
            this.EndTime = EndTime;
            return this;
        }

        public Builder withLocation(Integer LocationId)
        {
            this.LocationId = LocationId;
            return this;
        }


        public CourseSectionTimeModifyDto build()
        {
            return new CourseSectionTimeModifyDto(this);
        }
    }
}
