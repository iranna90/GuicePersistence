package builder;

/**
 * Created by iranna.patil on 09-07-2016.
 */
public class EmployeeBuilder {

    private final Employee emp;

    public EmployeeBuilder() {
        this.emp = new Employee();
    }

    public EmployeeBuilder withName(String name) {
        emp.setName(name);
        return this;
    }

    public EmployeeBuilder withId(String id) {
        emp.setId(id);
        return this;
    }

    public Employee build() {
        return emp;
    }
}
