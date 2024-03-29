package pro.sky.SkyProLesson2_8.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    @JsonProperty("firstName")
    private final String name;
    @JsonProperty("lastName")
    private final String surname;

    private final int department;

    private final double salary;



    public Employee(String name,
                    String surname,
                    int department,
                    double salary) {
        this.name = capitalize(name.toLowerCase());
        this.surname = capitalize(surname.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, department, salary);
    }

    @Override
    public String toString() {
        return String.format(
                "ФИ: %s %s, отдел: %d, ЗП: %.2f", surname, name, department, salary);
    }

}
