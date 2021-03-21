package Domain.Repository;

import Domain.Models.Employee;

import java.util.List;

public interface ReadDataInterface {

    /**
     * Interface that specify the behavior of Data Repository to Read data
     *
     * @return List<Employee>
     * @throws Exception Throws exception if data is invalid or can't read file
     */
    List<Employee> getEmployees() throws Exception;
}
