package lk.ijse.pulsefit.classservice.exception;

public class ClassNotFoundException extends RuntimeException {
    public ClassNotFoundException(Long id) {
        super("Fitness class not found with id: " + id);
    }
}
