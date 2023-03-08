package pro.sky.homework_2_5;

import java.io.IOException;

public class EmployeeNotFoundException extends IOException {
    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public EmployeeNotFoundException(Throwable t) {
        super(t);
    }

}
