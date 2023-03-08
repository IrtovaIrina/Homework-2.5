package pro.sky.homework_2_5;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String plus(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        EmployeeServiceImpl.addEmployee(firstName,lastName);
        return "firstName: "+ firstName + "lastName: " + lastName ;
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        EmployeeServiceImpl.removeEmployee(firstName,lastName);
        return "firstName: "+ firstName + "lastName: " + lastName ;
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        EmployeeServiceImpl.containsEmployee(firstName,lastName);
        return "firstName: "+ firstName + "lastName: " + lastName ;
    }
    @GetMapping("/allEmployees")
    public void allEmployees(){
        EmployeeServiceImpl.returnEmployees();
    }
}