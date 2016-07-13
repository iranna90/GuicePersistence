package builder;

/**
 * Created by iranna.patil on 09-07-2016.
 */
public class Driver {

    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Employee employee = employeeBuilder
                .withId("123")
                .withName("iranna")
                .build();
        System.out.println(employee);
    }
}
