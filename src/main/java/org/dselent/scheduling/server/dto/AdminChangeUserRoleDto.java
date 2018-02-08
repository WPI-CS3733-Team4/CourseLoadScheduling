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
public class AdminChangeUserRoleDto
{
    private final Integer userId;
    private final String role;

    // I added to the auto-generated code
    @Generated("SparkTools")
    private AdminChangeUserRoleDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.userId = builder.userId;
        this.role = builder.role;

        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.userId == null)
        {
            throw new IllegalStateException("userId cannot be null");
        }
        else if(this.role == null)
        {
            throw new IllegalStateException("role cannot be null");
        }
    }

    /*getters*/

    public Integer getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    /* hashCode*/

    @Override
    public int hashCode() {

        return Objects.hash(userId, role);
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
        if (!(obj instanceof AdminChangeUserRoleDto))
        {
            return false;
        }
        UserRegisterDto other = (UserRegisterDto) obj;
        if (userId == null)
        {
            if (other.userId != null)
            {
                return false;
            }
        }
        else if (!userId.equals(other.userId))
        {
            return false;
        }
        if (role == null)
        {
            if (other.role != null)
            {
                return false;
            }
        }
        else if (!role.equals(other.role))
        {
            return false;
        }

        return true;
    }

    /*toString*/

    @Override
    public String toString() {
        return "AdminChangeUserRoleDto{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
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
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        private Builder()
        {
        }

        public Builder withUserName(String userName)
        {
            this.userName = userName;
            return this;
        }

        public Builder withFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email)
        {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password)
        {
            this.password = password;
            return this;
        }

        public AdminChangeUserRoleDto build()
        {
            return new AdminChangeUserRoleDto(this);
        }
    }
}
