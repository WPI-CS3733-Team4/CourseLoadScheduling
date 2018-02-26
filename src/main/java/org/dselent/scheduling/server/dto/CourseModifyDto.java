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
public class CourseModifyDto
{
    private final Integer CourseId;
    private final String CourseName;
    private final String CourseDept;
    private final String CourseDescription;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private CourseModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.CourseId = builder.CourseId;
        this.CourseName = builder.CourseName;
        this.CourseDept = builder.CourseDept;
        this.CourseDescription = builder.CourseDescription;


        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.CourseId == null)
        {
            throw new IllegalStateException("CourseId cannot be null");
        }
        else if(this.CourseName == null)
        {
            throw new IllegalStateException("CourseName cannot be null");
        }
        else if(this.CourseDept == null)
        {
            throw new IllegalStateException("CourseDept cannot be null");
        }
        else if(this.CourseDescription == null)
        {
            throw new IllegalStateException("CourseDescription cannot be null");
        }

    }

    public Integer getCourseId()
    {
        return CourseId;
    }

    public String getCourseName()
    {
        return CourseName;
    }

    public String getCourseDept()
    {
        return CourseDept;
    }

    public String getCourseDescription()
    {
        return CourseDescription;
    }


    @Override
    public int hashCode() {

        return Objects.hash(CourseId, CourseName, CourseDept, CourseDescription);
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
        if (!(obj instanceof CourseModifyDto))
        {
            return false;
        }
        CourseModifyDto other = (CourseModifyDto) obj;
        if (CourseDescription == null)
        {
            if (other.CourseDescription != null)
            {
                return false;
            }
        }
        else if (!CourseDescription.equals(other.CourseDescription))
        {
            return false;
        }
        if (CourseName == null)
        {
            if (other.CourseName != null)
            {
                return false;
            }
        }
        else if (!CourseName.equals(other.CourseName))
        {
            return false;
        }
        if (CourseDept == null)
        {
            if (other.CourseDept != null)
            {
                return false;
            }
        }
        else if (!CourseDept.equals(other.CourseDept))
        {
            return false;
        }

        if (CourseId == null)
        {
            if (other.CourseId != null)
            {
                return false;
            }
        }
        else if (!CourseId.equals(other.CourseId))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{"+
                "\'CourseId\'=\'"+CourseId + "\'"+
                ",\'CourseName\'=\'"+CourseName+"\'"+
                ",\'CourseDept\'=\'"+CourseDept+"\'"+
                ",\'CourseDescription\'=\'"+CourseDescription+"\'"+
                '}';
    }

    /**
     * Creates builder to build {@link CourseModifyDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link CourseModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer CourseId;
        private String CourseName;
        private String CourseDept;
        private String CourseDescription;


        private Builder()
        {
        }

        public Builder withCourseId(Integer CourseId)
        {
            this.CourseId = CourseId;
            return this;
        }

        public Builder withCourseName(String CourseName)
        {
            this.CourseName = CourseName;
            return this;
        }

        public Builder withCourseDept(String CourseDept)
        {
            this.CourseDept = CourseDept;
            return this;
        }

        public Builder withCourseDescription(String CourseDescription)
        {
            this.CourseDescription = CourseDescription;
            return this;
        }


        public CourseModifyDto build()
        {
            return new CourseModifyDto(this);
        }
    }
}
