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
public class FacultyModifyDto
{
    private final Integer UserId;
    private final Integer FacultyId;
    private final Integer RequiredCredits;



    // I added to the auto-generated code
    @Generated("SparkTools")
    private FacultyModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.UserId = builder.UserId;
        this.FacultyId = builder.FacultyId;
        this.RequiredCredits = builder.RequiredCredits;



        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.UserId == null)
        {
            throw new IllegalStateException("UserId cannot be null");
        }
        else if(this.FacultyId == null)
        {
            throw new IllegalStateException("FacultyId cannot be null");
        }
        else if(this.RequiredCredits == null)
        {
            throw new IllegalStateException("RequiredCredits cannot be null");
        }


    }

    public Integer getUserId()
    {
        return UserId;
    }

    public Integer getFacultyId()
    {
        return FacultyId;
    }

    public Integer getRequiredCredits()
    {
        return RequiredCredits;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyModifyDto that = (FacultyModifyDto) o;
        return Objects.equals(UserId, that.UserId) &&
                Objects.equals(FacultyId, that.FacultyId) &&
                Objects.equals(RequiredCredits, that.RequiredCredits);
    }

    @Override
    public int hashCode() {

        return Objects.hash(UserId, FacultyId, RequiredCredits);
    }

    @Override
    public String toString() {
        return "{"+
                "\'UserId\'=\'"+UserId+"\'"+
                ",\'FacultyId\'=\'"+FacultyId+"\'"+
                ", \'RequiredCredits\'=\'"+RequiredCredits+"\'"+
                "}";
    }

    /**
     * Creates builder to build {@link FacultyModifyDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link FacultyModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer UserId;
        private Integer FacultyId;
        private Integer RequiredCredits;



        private Builder()
        {
        }

        public Builder withUserId(Integer UserId)
        {
            this.UserId = UserId;
            return this;
        }

        public Builder withFacultyId(Integer FacultyId)
        {
            this.FacultyId = FacultyId;
            return this;
        }

        public Builder withRequiredCredits(Integer RequiredCredits)
        {
            this.RequiredCredits = RequiredCredits;
            return this;
        }


        public FacultyModifyDto build()
        {
            return new FacultyModifyDto(this);
        }
    }
}
