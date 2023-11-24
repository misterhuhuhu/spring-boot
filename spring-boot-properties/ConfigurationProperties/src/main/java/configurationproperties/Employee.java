package configurationproperties;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Component
    @ConfigurationPropertiesBinding
    public static class EmployeeConverter implements Converter<String, Employee> {
        
        @Override
        public Employee convert(String from) {
            String[] data = from.split(",");
            return new Employee(data[0], Double.parseDouble(data[1]));
        }
    }
}
