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
public class DepartmentRemoveDto
{
    private final Integer Department_Id;





    // I added to the auto-generated code
    @Generated("SparkTools")
    private DepartmentRemoveDto(Builder builder)
    {
        // can add defaults if null for other places where the builder pattern is used

        this.Department_Id = builder.Department_Id;




        // making claim that none of these can be null
        // add other state checks here as necessary

        if(this.Department_Id == null)
        {
            throw new IllegalStateException("Department cannot be null");
        }



    }

    public Integer getDepartment()
    {
        return Department_Id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentRemoveDto that = (DepartmentRemoveDto) o;
        return Objects.equals(Department_Id, that.Department_Id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Department_Id);
    }

    @Override
    public String toString() {
        return "{" +
                "\'Department_Id\'=\'" + Department_Id +
                "\'}";
    }

    /**
     * Creates builder to build {@link DepartmentRemoveDto}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link DepartmentRemoveDto}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private Integer Department_Id;





        private Builder()
        {
        }

        public Builder withDepartmentId(Integer Department)
        {
            this.Department_Id = Department_Id;
            return this;
        }




        public DepartmentRemoveDto build()
        {
            return new DepartmentRemoveDto(this);
        }
    }
}
