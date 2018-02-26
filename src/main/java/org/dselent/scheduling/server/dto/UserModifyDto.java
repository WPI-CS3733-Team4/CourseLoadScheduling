package org.dselent.scheduling.server.dto;

import javax.annotation.Generated;
import java.util.Objects;


public class UserModifyDto
{
    private final Integer id;
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    // I added to the auto-generated code
    @Generated("SparkTools")
    private UserModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used
        this.id = builder.id;
        this.userName = builder.userName;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;

        // making claim that none of these can be null
        // add other state checks here as necessary
        if(this.id == null){
            throw new IllegalStateException("id cannot be null");
        }
        if(this.userName == null)
        {
            throw new IllegalStateException("userName cannot be null");
        }
        else if(this.firstName == null)
        {
            throw new IllegalStateException("firstName cannot be null");
        }
        else if(this.lastName == null)
        {
            throw new IllegalStateException("lastName cannot be null");
        }
        else if(this.email == null)
        {
            throw new IllegalStateException("email cannot be null");
        }
        else if(this.password == null)
        {
            throw new IllegalStateException("password cannot be null");
        }
    }

    public Integer getId() { return id;}

    public String getUserName()
    {
        return userName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModifyDto that = (UserModifyDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "{"+
                "\'id\'=\'"+id+"\'"+
                ",\'userName\'=\'"+userName+"\'"+
                ",\'firstName\'=\'"+firstName+"\'"+
                ",\'lastName\'=\'"+lastName+"\'"+
                ",\'email\'=\'"+email+"\'"+
                ",\'password\'=\'"+password+"\'"+
                "}";
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
        private Integer id;
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        private Builder()
        {
        }

        public Builder withId(Integer id){
            this.id = id;
            return this;
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

        public UserModifyDto build()
        {
            return new UserModifyDto(this);
        }
    }
}
