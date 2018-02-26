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
public class CourseSectionModifyDto
{

    private final Integer CourseSectionId;
    private final Integer CourseId;
    private final String SectionType;
    private final String Term;



    // I added to the auto-generated code
    @Generated("SparkTools")
    private CourseSectionModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.CourseSectionId = builder.CourseSectionId;
        this.CourseId = builder.CourseId;
        this.SectionType = builder.SectionType;
        this.Term = builder.Term;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.CourseSectionId == null)
        {
            throw new IllegalStateException("CourseSectionId cannot be null");
        }
        else if(this.CourseId == null)
        {
            throw new IllegalStateException("CourseId cannot be null");
        }
        else if(this.SectionType == null)
        {
            throw new IllegalStateException("SectionType cannot be null");
        }
        else if(this.Term == null)
        {
            throw new IllegalStateException("Term cannot be null");
        }


    }

    public Integer getCourseSectionId()
    {
        return CourseSectionId;
    }

    public Integer getCourseId()
    {
        return CourseId;
    }

    public String getSectionType()
    {
        return SectionType;
    }

    public String getTerm()
    {
        return Term;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSectionModifyDto that = (CourseSectionModifyDto) o;
        return Objects.equals(CourseSectionId, that.CourseSectionId) &&
                Objects.equals(CourseId, that.CourseId) &&
                Objects.equals(SectionType, that.SectionType) &&
                Objects.equals(Term, that.Term);
    }

    @Override
    public int hashCode() {

        return Objects.hash(CourseSectionId, CourseId, SectionType, Term);
    }

    @Override
    public String toString() {
        return "{" +
                "\'CourseSectionId\'=\'" + CourseSectionId +
                "\', \'CourseId\'=\'" + CourseId +
                "\', \'SectionType\'=\'" + SectionType + '\'' +
                ", \'Term\'=\'" + Term + '\'' +
                '}';
    }

    /**
     * Creates builder to build {@link CourseSectionModifyDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link CourseSectionModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseSectionId;
        private Integer CourseId;
        private String SectionType;
        private String Term;



        private Builder()
        {
        }

        public Builder withCourseSectionId(Integer CourseSectionId)
        {
            this.CourseSectionId = CourseSectionId;
            return this;
        }

        public Builder withCourseId(Integer CourseId)
        {
            this.CourseId = CourseId;
            return this;
        }

        public Builder withSectionType(String SectionType)
        {
            this.SectionType = SectionType;
            return this;
        }

        public Builder withTerm(String Term)
        {
            this.Term = Term;
            return this;
        }


        public CourseSectionModifyDto build()
        {
            return new CourseSectionModifyDto(this);
        }
    }
}
