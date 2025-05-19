package Leonardo.Ribeiro.Project.java.exceptions;

import Leonardo.Ribeiro.Project.java.dtos.errors.ErrorResponseDto;
import Leonardo.Ribeiro.Project.java.exceptions.badrequests.ItemDeclarationRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handle(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrorResponseDto(
                "500",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> handle(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handle(ChangeSetPersister.NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(ItemDeclarationRequestException.class)
    public ResponseEntity<ErrorResponseDto> handle(ItemDeclarationRequestException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(
                "400",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }
}
