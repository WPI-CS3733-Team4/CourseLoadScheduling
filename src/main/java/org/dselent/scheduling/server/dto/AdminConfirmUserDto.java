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
public class AdminConfirmUserDto
{
    private final Integer userId;


    // I added to the auto-generated code
    @Generated("SparkTools")
    private AdminConfirmUserDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.userId = builder.userId;

        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.userId == null)
        {
            throw new IllegalStateException("userId cannot be null");
        }

    }

    /*getters*/

    public Integer getUserId() {
        return userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminConfirmUserDto that = (AdminConfirmUserDto) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "{"+
                "\'userId\'=\'"+userId+"\'"+
                '}';
    }

    /**
     * Creates builder to build {@link UserRegisterDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link UserRegisterDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer userId;

        private Builder()
        {
        }

        public Builder withUserId(Integer userId)
        {
            this.userId = userId;
            return this;
        }




        public AdminConfirmUserDto build()
        {
            return new AdminConfirmUserDto(this);
        }
    }
}
