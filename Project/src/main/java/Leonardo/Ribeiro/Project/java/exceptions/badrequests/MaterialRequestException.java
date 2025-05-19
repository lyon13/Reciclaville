package Leonardo.Ribeiro.Project.java.exceptions.badrequests;

public class MaterialRequestException extends RuntimeException {
    public MaterialRequestException(String atributte) {
        super(atributte);
    }
}
