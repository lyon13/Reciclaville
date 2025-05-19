package Leonardo.Ribeiro.Project.java.exceptions.notfounds;

public class DeclarationNotFoundException extends RuntimeException {
    public DeclarationNotFoundException(Long id) {
        super("Declaration not found with id: " + id);
    }
}
