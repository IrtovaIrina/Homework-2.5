package pro.sky.homework_2_5;
import java.io.IOException;

public class EmployeeAlreadyAddedException extends IOException {
    public EmployeeAlreadyAddedException() {
        super();
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(String message, Throwable t) {
        super(message, t);
    }

    public EmployeeAlreadyAddedException(Throwable t) {
        super(t);
    }
}
