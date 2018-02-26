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
public class LocationModifyDto {
    private final Integer LocationId;
    private final String Building;
    private final Integer Room;
    private final Integer RoomSize;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private LocationModifyDto(Builder builder) {
        // can add defaults if null for other places where the builder pattern is used

        this.LocationId = builder.LocationId;
        this.Building = builder.Building;
        this.Room = builder.Room;
        this.RoomSize = builder.RoomSize;


        // making claim that none of these can be null
        // add other state checks here as necessary


        if (this.LocationId == null) {
            throw new IllegalStateException("LocationId cannot be null");
        } else if (this.Building == null) {
            throw new IllegalStateException("Building cannot be null");
        } else if (this.Room == null) {
            throw new IllegalStateException("Room cannot be null");
        } else if (this.RoomSize == null) {
            throw new IllegalStateException("RoomSize cannot be null");
        }


    }

    public Integer getLocationId() {
        return LocationId;
    }
    public String getBuilding() {
        return Building;
    }

    public Integer getRoom() {
        return Room;
    }

    public Integer getRoomSize() {
        return RoomSize;
    }


    /**
     * Creates builder to build {@link LocationModifyDto}.
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
        LocationModifyDto that = (LocationModifyDto) o;
        return Objects.equals(LocationId, that.LocationId) &&
                Objects.equals(Building, that.Building) &&
                Objects.equals(Room, that.Room) &&
                Objects.equals(RoomSize, that.RoomSize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(LocationId, Building, Room, RoomSize);
    }

    @Override
    public String toString() {
        return "{" +
                "\'LocationId\'=\'" + LocationId +
                "\', \'Building\'=\'" + Building + '\'' +
                ", \'Room\'=\'" + Room +
                "\', \'RoomSize\'=\'" + RoomSize +
                "\'}";
    }

    /**
     * Builder to build {@link LocationModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder {
        private Integer LocationId;
        private String Building;
        private Integer Room;
        private Integer RoomSize;


        private Builder() {
        }

        public Builder withLocationId(Integer LocationId) {
            this.LocationId = LocationId;
            return this;
        }
        public Builder withBuilding(String Building) {
            this.Building = Building;
            return this;
        }

        public Builder withRoom(Integer Room) {
            this.Room = Room;
            return this;
        }
        public Builder withRoomSize(Integer RoomSize) {
            this.RoomSize = RoomSize;
            return this;
        }

        public LocationModifyDto build(){
            return new LocationModifyDto(this);
        }


    }
}