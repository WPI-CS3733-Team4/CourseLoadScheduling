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
public class LocationRemoveDto {
    private final Integer LocationId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private LocationRemoveDto(Builder builder) {
        // can add defaults if null for other places where the builder pattern is used

        this.LocationId = builder.LocationId;



        // making claim that none of these can be null
        // add other state checks here as necessary


        if (this.LocationId == null) {
            throw new IllegalStateException("LocationId cannot be null");
        }

    }

    public Integer getLocationId() {
        return LocationId;
    }



    /**
     * Creates builder to build {@link LocationRemoveDto}.
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
        LocationRemoveDto that = (LocationRemoveDto) o;
        return Objects.equals(LocationId, that.LocationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(LocationId);
    }

    @Override
    public String toString() {
        return "{"+
                "\'LocationId\'=\'"+LocationId +"\'"+
                "}";
    }

    /**
     * Builder to build {@link LocationRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder {
        private Integer LocationId;


        private Builder() {
        }

        public Builder withLocationId(Integer LocationId) {
            this.LocationId = LocationId;
            return this;
        }

        public LocationRemoveDto build(){
            return new LocationRemoveDto(this);
        }
    }


}