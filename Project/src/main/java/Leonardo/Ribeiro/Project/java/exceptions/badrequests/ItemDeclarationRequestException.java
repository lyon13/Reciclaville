package Leonardo.Ribeiro.Project.java.exceptions.badrequests;

public class ItemDeclarationRequestException extends RuntimeException {
    public ItemDeclarationRequestException(String objectName, String attribute) {
        super("Required attribute '" + objectName + "." + attribute + "' is not present");
    }
}
