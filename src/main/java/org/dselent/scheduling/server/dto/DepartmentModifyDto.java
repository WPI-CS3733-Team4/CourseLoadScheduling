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
public class DepartmentModifyDto
{
    private final String Department;
    private final Integer Department_Id;





    // I added to the auto-generated code
    @Generated("SparkTools")
    private DepartmentModifyDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.Department = builder.Department;
        this.Department_Id = builder.Department_Id;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.Department == null)
        {
            throw new IllegalStateException("Department cannot be null");
        }
        else if(this.Department_Id == null)
        {
            throw new IllegalStateException("Department_Id cannot be null");
        }



    }

    public String getDepartment()
    {
        return Department;
    }
    public Integer getDepartmentId()
    {
        return Department_Id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentModifyDto that = (DepartmentModifyDto) o;
        return Objects.equals(Department, that.Department) &&
                Objects.equals(Department_Id, that.Department_Id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Department, Department_Id);
    }

    @Override
    public String toString() {
        return "{" +
                "\'Department\'=\'"+Department+"\'"+
                ",\'Department_Id\'=\'"+Department_Id+"\'"+
                "}";
    }

    /**
     * Creates builder to build {@link DepartmentModifyDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link DepartmentModifyDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private String Department;
        private Integer Department_Id;




        private Builder()
        {
        }

        public Builder withDepartment(String Department)
        {
            this.Department = Department;
            return this;
        }
        public Builder withDepartmentId(Integer Department_Id)
        {
            this.Department_Id = Department_Id;
            return this;
        }



        public DepartmentModifyDto build()
        {
            return new DepartmentModifyDto(this);
        }
    }
}
