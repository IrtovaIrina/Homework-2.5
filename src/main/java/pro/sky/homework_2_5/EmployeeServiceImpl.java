package pro.sky.homework_2_5;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    static List<Employee> employees = new ArrayList<Employee>();
    @GetMapping
    public static boolean addEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        try{
            checkEmployee(new Employee(firstName,lastName));
            employees.add(new Employee(firstName,lastName));
            return true;
        }catch(EmployeeStorageIsFullException e){
            System.out.println("Массив переполнен");
            return false;
        }catch(EmployeeAlreadyAddedException e){
            System.out.println("Добовляемый сотрудник уже имеется");
            return false;
        }
    }
    @GetMapping
    public static boolean removeEmployee(String firstName,String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        try{
            checkEmployee(new Employee(firstName,lastName));
            employees.remove(new Employee(firstName,lastName));
            return true;
        }catch(EmployeeNotFoundException e){
            System.out.println("Данный сотрудник не найден");
            return false;
        }

    }
    @GetMapping
    public static boolean containsEmployee(String firstName,String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        try{
            checkEmployee(new Employee(firstName,lastName));
            employees.contains(new Employee(firstName,lastName));
            return true;
        }catch(EmployeeNotFoundException e){
            System.out.println("Данный сотрудник не найден");
            return false;
        }

    }
    @GetMapping
    public static void checkEmployee(Employee employee) throws EmployeeNotFoundException,EmployeeStorageIsFullException,EmployeeAlreadyAddedException{
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        if (employees.size() > 10){
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
    }
    @GetMapping
    public static void returnEmployees() {
        for (Employee emp: employees) {
            System.out.println("firstname: " + emp.getFirstName() + "lastName: " + emp.getLastName() +"/n");
        }
    }

}