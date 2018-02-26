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
public class DepartmentAddDto
{
    private final String Department;





    // I added to the auto-generated code
    @Generated("SparkTools")
    private DepartmentAddDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.Department = builder.Department;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.Department == null)
        {
            throw new IllegalStateException("Department cannot be null");
        }



    }

    public String getDepartment()
    {
        return Department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentAddDto that = (DepartmentAddDto) o;
        return Objects.equals(Department, that.Department);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Department);
    }

    @Override
    public String toString() {
        return "{" +
                "\'Department\'=\'" + Department +
                "\'}";
    }

    /**
     * Creates builder to build {@link DepartmentAddDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link DepartmentAddDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private String Department;





        private Builder()
        {
        }

        public Builder withDepartment(String Department)
        {
            this.Department = Department;
            return this;
        }




        public DepartmentAddDto build()
        {
            return new DepartmentAddDto(this);
        }
    }
}
