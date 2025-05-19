package Leonardo.Ribeiro.Project.java.exceptions.notfounds;

public class MaterialNotFoundException extends RuntimeException {
  public MaterialNotFoundException(Long id) {
    super("Material with id " + id + " not found");
  }
}
