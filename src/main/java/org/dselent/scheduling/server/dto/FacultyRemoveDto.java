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
public class FacultyRemoveDto
{

    private final Integer FacultyId;




    // I added to the auto-generated code
    @Generated("SparkTools")
    private FacultyRemoveDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used


        this.FacultyId = builder.FacultyId;




        // making claim that none of these can be null
        // add other state checks here as necessary


         if(this.FacultyId == null)
        {
            throw new IllegalStateException("FacultyId cannot be null");
        }



    }


    public Integer getFacultyId()
    {
        return FacultyId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyRemoveDto that = (FacultyRemoveDto) o;
        return Objects.equals(FacultyId, that.FacultyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(FacultyId);
    }

    @Override
    public String toString() {
        return "{" +
                "\'FacultyId\'=\'" + FacultyId +
                "\'}";
    }

    /**
     * Creates builder to build {@link FacultyRemoveDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link FacultyRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {

        private Integer FacultyId;




        private Builder()
        {
        }


        public Builder withFacultyId(Integer FacultyId)
        {
            this.FacultyId = FacultyId;
            return this;
        }




        public FacultyRemoveDto build()
        {
            return new FacultyRemoveDto(this);
        }
    }
}
