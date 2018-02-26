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
public class TermRemoveDto
{
    private final Integer TermId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private TermRemoveDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.TermId = builder.TermId;

        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.TermId == null)
        {
            throw new IllegalStateException("TermId cannot be null");
        }
    }

    public Integer getTermId()
    {
        return TermId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermRemoveDto that = (TermRemoveDto) o;
        return Objects.equals(TermId, that.TermId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(TermId);
    }

    @Override
    public String toString() {
        return "{" +
                "\'TermId\'=\'" + TermId +
                "\'}";
    }

    /**
     * Creates builder to build {@link TermRemoveDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link TermRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer TermId;




        private Builder()
        {
        }

        public Builder withTermId(Integer TermId)
        {
            this.TermId = TermId;
            return this;
        }

        public TermRemoveDto build()
        {
            return new TermRemoveDto(this);
        }
    }
}
