package org.dselent.scheduling.server.dto;

import javax.annotation.Generated;
import java.util.Objects;

/**
 * DTO = Data Transfer Object
 * Used to package/wrap several variables into a single object
 * Uses the Builder pattern for object instantiation
 *
 * @author dselent
 *
 */
public class FacultyUnrequestCourseDto
{
    private final Integer CourseSectionId;





    // I added to the auto-generated code
    @Generated("SparkTools")
    private FacultyUnrequestCourseDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.CourseSectionId = builder.CourseSectionId;





        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.CourseSectionId == null)
        {
            throw new IllegalStateException("CourseSectionId cannot be null");
        }


    }

    public Integer getCourseSectionId()
    {
        return CourseSectionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyUnrequestCourseDto that = (FacultyUnrequestCourseDto) o;
        return Objects.equals(CourseSectionId, that.CourseSectionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionId);
    }

    @Override
    public String toString() {
        return "{"+
                "\'CourseSectionId\'=\'"+CourseSectionId+"\'"+
                "}";
    }

    /**
     * Creates builder to build {@link FacultyUnrequestCourseDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link FacultyUnrequestCourseDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseSectionId;




        private Builder()
        {
        }

        public Builder withCourseSectionId(Integer CourseSectionId)
        {
            this.CourseSectionId = CourseSectionId;
            return this;
        }



        public FacultyUnrequestCourseDto build()
        {
            return new FacultyUnrequestCourseDto(this);
        }
    }
}
