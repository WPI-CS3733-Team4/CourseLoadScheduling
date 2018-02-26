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
public class UserLogoutDto
{
    private final Integer userId;

    // I added to the auto-generated code
    @Generated("SparkTools")
    private UserLogoutDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.userId = builder.userId;

        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.userId == null)
        {
            throw new IllegalStateException("userName cannot be null");
        }
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
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
        if (!(obj instanceof UserLogoutDto))
        {
            return false;
        }
        UserLogoutDto other = (UserLogoutDto) obj;
        if (userId == null)
        {
            if (other.userId != null)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "\'userId=\'" + userId + '\'' +
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



        public UserLogoutDto build()
        {
            return new UserLogoutDto(this);
        }
    }
}
