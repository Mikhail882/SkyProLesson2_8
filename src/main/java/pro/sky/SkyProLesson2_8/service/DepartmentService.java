package pro.sky.SkyProLesson2_8.service;

import org.springframework.stereotype.Service;
import pro.sky.SkyProLesson2_8.exception.EmployeeNotFoundException;
import pro.sky.SkyProLesson2_8.model.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int departament) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departament)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int departament) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departament)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findEmployeesFromDepartment(int departament) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departament)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
