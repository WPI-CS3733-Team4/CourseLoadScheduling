package org.dselent.scheduling.server.dto;


import javax.annotation.Generated;
import java.util.Objects;
// Krishna Madhurkar

public class CourseSectionTimeRemoveDto
{
    private final Integer CourseSectionTimeId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private CourseSectionTimeRemoveDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.CourseSectionTimeId = builder.CourseSectionTimeId;


        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.CourseSectionTimeId == null)
        {
            throw new IllegalStateException("Course Remove cannot be null");
        }

    }

    public Integer getCourseSectionTimeId()
    {
        return CourseSectionTimeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSectionTimeRemoveDto that = (CourseSectionTimeRemoveDto) o;
        return Objects.equals(CourseSectionTimeId, that.CourseSectionTimeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionTimeId);
    }

    @Override
    public String toString() {
        return "{"+
                "\'CourseSectionTimeId\'=\'"+CourseSectionTimeId+"\'"+
                "\'}";
    }

    /**
     * Creates builder to build {@link CourseSectionTimeRemoveDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link CourseSectionTimeRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseSectionTimeId;


        private Builder()
        {
        }

        public Builder withCourseSectionTimeId (Integer CourseSectionTimeId)
        {
            this.CourseSectionTimeId = CourseSectionTimeId;
            return this;
        }



        public CourseSectionTimeRemoveDto build()
        {
            return new CourseSectionTimeRemoveDto(this);
        }
    }
}
