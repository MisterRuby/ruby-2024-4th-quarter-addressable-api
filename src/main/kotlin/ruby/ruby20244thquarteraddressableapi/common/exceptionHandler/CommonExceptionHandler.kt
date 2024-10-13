package ruby.ruby20244thquarteraddressableapi.common.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CommonExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun illegalArgumentExceptionHandler(exception: MethodArgumentNotValidException) : ResponseEntity<Map<String, String?>> {
        val errors = exception.bindingResult.allErrors.associate {
            (it as FieldError).field to it.defaultMessage
        }

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}
