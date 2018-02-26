package org.dselent.scheduling.server.dto;


import javax.annotation.Generated;

/**
 * Fabian Gaziano
 */


public class CourseRemoveDto
{
    private final Integer courseId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private CourseRemoveDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.courseId = builder.courseId;


        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.courseId == null)
        {
            throw new IllegalStateException("Course Remove cannot be null");
        }

    }

    public Integer getCourseId()
    {
        return courseId;
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof CourseRemoveDto))
        {
            return false;
        }
        CourseRemoveDto other = (CourseRemoveDto) obj;

        if (courseId == null)
        {
            if (other.courseId != null)
            {
                return false;
            }
        }
        else if (!courseId.equals(other.courseId))
        {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "\'courseId\'=\'" + courseId +
                "\'}";
    }



    /**
     * Creates builder to build {@link CourseRemoveDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link CourseRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer courseId;


        private Builder()
        {
        }

        public Builder withCourseId (Integer courseId)
        {
            this.courseId = courseId;
            return this;
        }



        public CourseRemoveDto build()
        {
            return new CourseRemoveDto(this);
        }
    }
}
