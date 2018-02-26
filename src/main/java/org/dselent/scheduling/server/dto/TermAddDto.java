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
public class TermAddDto
{

    private final String TermName;




    // I added to the auto-generated code
    @Generated("SparkTools")
    private TermAddDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used


        this.TermName = builder.TermName;




        // making claim that none of these can be null
        // add other state checks here as necessary



         if(this.TermName == null)
        {
            throw new IllegalStateException("TermName cannot be null");
        }


    }


    public String getTermName()
    {
        return TermName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermAddDto that = (TermAddDto) o;
        return Objects.equals(TermName, that.TermName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(TermName);
    }

    @Override
    public String toString() {
        return "{" +
                "\'TermName\'=\'" + TermName + '\'' +
                '}';
    }

    /**
     * Creates builder to build {@link TermAddDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link TermAddDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {

        private String TermName;




        private Builder()
        {
        }


        public Builder withTermName(String TermName)
        {
            this.TermName = TermName;
            return this;
        }



        public TermAddDto build()
        {
            return new TermAddDto(this);
        }
    }
}
