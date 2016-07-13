package reflection;

import builder.Employee;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by iranna.patil on 10-07-2016.
 */
public class Driver {
    public static void main(String[] args) {
        Class clazz = Employee.class;
        System.out.println("name " + clazz.getSimpleName());
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("method " + method.getName());
            System.out.println("modifier " + method.getModifiers());
            System.out.println("return " + method.getReturnType());
            for (Parameter parameter : method.getParameters()) {
                System.out.println("parameter " + parameter.getName());
            }
        }
    }
}
