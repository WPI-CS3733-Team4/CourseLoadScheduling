package org.dselent.scheduling.server.dto;

import javax.annotation.Generated;
import java.util.Objects;


public class CourseSectionTimeModifyDto
{
    private final Integer CourseSectionTimeId;
    private final Integer CourseSectionId;
    private final String DayOfWeek;
    private final Integer StartTime;
    private final Integer EndTime;
    private final String Location;


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
        this.Location = builder.Location;


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
        else if(this.Location == null)
        {
            throw new IllegalStateException("Location cannot be null");
        }

    }

    public Integer getCourseSectionTimeId() { return CourseSectionTimeId;}

    public Integer getCourseSectionId() { return CourseSectionId;}

    public String getDayOfWeek()
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

    public String getLocation()
    {
        return Location;
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
                Objects.equals(Location, that.Location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionTimeId, CourseSectionId, DayOfWeek, StartTime, EndTime, Location);
    }

    @Override
    public String toString() {
        return "CourseSectionTimeModifyDto{" +
                "CourseSectionTimeId=" + CourseSectionTimeId +
                ", CourseSectionId=" + CourseSectionId +
                ", DayOfWeek='" + DayOfWeek + '\'' +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", Location='" + Location + '\'' +
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
        private String DayOfWeek;
        private Integer StartTime;
        private Integer EndTime;
        private String Location;


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

        public Builder withDayOfWeek(String DayOfWeek)
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

        public Builder withLocation(String Location)
        {
            this.Location = Location;
            return this;
        }


        public CourseSectionTimeModifyDto build()
        {
            return new CourseSectionTimeModifyDto(this);
        }
    }
}
