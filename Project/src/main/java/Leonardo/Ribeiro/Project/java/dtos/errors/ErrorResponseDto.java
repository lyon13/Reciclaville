package Leonardo.Ribeiro.Project.java.dtos.errors;

public record ErrorResponseDto(String code,
                               String message,
                               String cause,
                               String exceptionClassName) {
}
