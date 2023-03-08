package pro.sky.homework_2_5;

import java.io.IOException;

public class EmployeeStorageIsFullException extends IOException {
    public EmployeeStorageIsFullException() {
        super();
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(String message, Throwable t) {
        super(message, t);
    }

    public EmployeeStorageIsFullException(Throwable t) {
        super(t);
    }
}