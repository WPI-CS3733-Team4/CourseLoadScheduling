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
public class GetSchedulesDto {
    private final String SearchBy;
    private final String Query;
    private final String Term;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private GetSchedulesDto(Builder builder) {
        // can add defaults if null for other places where the builder pattern is used

        this.SearchBy = builder.SearchBy;
        this.Query = builder.Query;
        this.Term = builder.Term;


        // making claim that none of these can be null
        // add other state checks here as necessary

        if (this.SearchBy == null) {
            throw new IllegalStateException("SearchBy cannot be null");
        } else if (this.Query == null) {
            throw new IllegalStateException("Query cannot be null");
        } else if (this.Term == null) {
            throw new IllegalStateException("Term cannot be null");
        }


    }

    public String getSearchBy() {
        return SearchBy;
    }

    public String getQuery() {
        return Query;
    }

    public String getTerm() {
        return Term;
    }


    /**
     * Creates builder to build {@link GetSchedulesDto}.
     *
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSchedulesDto that = (GetSchedulesDto) o;
        return Objects.equals(SearchBy, that.SearchBy) &&
                Objects.equals(Query, that.Query) &&
                Objects.equals(Term, that.Term);
    }

    @Override
    public int hashCode() {

        return Objects.hash(SearchBy, Query, Term);
    }

    @Override
    public String toString() {
        return "{" +
                "\'SearchBy\'=\'" + SearchBy + '\'' +
                ", \'Query\'=\'" + Query + '\'' +
                ", \'Term=\'" + Term + '\'' +
                '}';
    }

    /**
     * Builder to build {@link GetSchedulesDto}.
     */
    @Generated("SparkTools")
    public static final class Builder {
        private String SearchBy;
        private String Query;
        private String Term;


        private Builder() {
        }

        public Builder withSearchBy(String SearchBy) {
            this.SearchBy = SearchBy;
            return this;
        }

        public Builder withQuery(String Query) {
            this.Query = Query;
            return this;
        }
        public Builder withTerm(String Term) {
            this.Term = Term;
            return this;
        }

    }
}