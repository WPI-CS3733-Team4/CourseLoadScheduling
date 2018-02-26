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
public class FacultyRequestCourseDto
{
    private final Integer CourseSectionId;
    private final Integer FacultyId;




    // I added to the auto-generated code
    @Generated("SparkTools")
    private FacultyRequestCourseDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.CourseSectionId = builder.CourseSectionId;
        this.FacultyId = builder.FacultyId;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.CourseSectionId == null)
        {
            throw new IllegalStateException("CourseSectionId cannot be null");
        }
        else if(this.FacultyId == null)
        {
            throw new IllegalStateException("FacultyId cannot be null");
        }


    }

    public Integer getCourseSectionId()
    {
        return CourseSectionId;
    }

    public Integer getFacultyId()
    {
        return FacultyId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyRequestCourseDto that = (FacultyRequestCourseDto) o;
        return Objects.equals(CourseSectionId, that.CourseSectionId) &&
                Objects.equals(FacultyId, that.FacultyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionId, FacultyId);
    }

    @Override
    public String toString() {
        return "{" +
                "\'CourseSectionId\'=\'" + CourseSectionId +
                "\', \'FacultyId\'=\'" + FacultyId +
                "\'}";
    }

    /**
     * Creates builder to build {@link FacultyRequestCourseDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link FacultyRequestCourseDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseSectionId;
        private Integer FacultyId;




        private Builder()
        {
        }

        public Builder withCourseSectionId(Integer CourseSectionId)
        {
            this.CourseSectionId = CourseSectionId;
            return this;
        }

        public Builder withFacultyId(Integer FacultyId)
        {
            this.FacultyId = FacultyId;
            return this;
        }



        public FacultyRequestCourseDto build()
        {
            return new FacultyRequestCourseDto(this);
        }
    }
}
