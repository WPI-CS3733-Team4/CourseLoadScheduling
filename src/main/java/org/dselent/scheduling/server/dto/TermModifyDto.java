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
public class TermModifyDto
{
    private final Integer TermId;
    private final String TermName;




    // I added to the auto-generated code
    @Generated("SparkTools")
    private TermModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.TermId = builder.TermId;
        this.TermName = builder.TermName;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.TermId == null)
        {
            throw new IllegalStateException("TermId cannot be null");
        }
        else if(this.TermName == null)
        {
            throw new IllegalStateException("TermName cannot be null");
        }


    }

    public Integer getTermId()
    {
        return TermId;
    }

    public String getTermName()
    {
        return TermName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermModifyDto that = (TermModifyDto) o;
        return Objects.equals(TermId, that.TermId) &&
                Objects.equals(TermName, that.TermName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(TermId, TermName);
    }

    @Override
    public String toString() {
        return "{" +
                "\'TermId\'=\'" + TermId +
                "\', \'TermName=\'" + TermName + '\'' +
                '}';
    }

    /**
     * Creates builder to build {@link TermModifyDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link TermModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer TermId;
        private String TermName;




        private Builder()
        {
        }

        public Builder withTermId(Integer TermId)
        {
            this.TermId = TermId;
            return this;
        }

        public Builder withTermName(String TermName)
        {
            this.TermName = TermName;
            return this;
        }



        public TermModifyDto build()
        {
            return new TermModifyDto(this);
        }
    }
}
