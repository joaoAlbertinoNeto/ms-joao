package br.com.joao.ms_joao.infrastructure.rest.in.exceptions;


import br.com.joao.ms_joao.domain.exceptions.BadRequestException;
import br.com.joao.ms_joao.domain.exceptions.InterServerErrorRequestException;
import br.com.joao.ms_joao.domain.exceptions.UnauthorizedrRequestException;
import br.com.joao.ms_joao.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice  {

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestErrorExceptionDTO>  badRequestException(BadRequestException badRequest) {
        var msg = badRequest.getMsg();
        var code = badRequest.getCode();
        RestErrorExceptionDTO message = new RestErrorExceptionDTO(msg,code, Util.CustomTimer.timeNow());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(value = {InterServerErrorRequestException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestErrorExceptionDTO>  internalServerErrorRequestException(InterServerErrorRequestException interServerErrorRequestException) {
        var msg = interServerErrorRequestException.getMsg();
        var code = interServerErrorRequestException.getCode();
        RestErrorExceptionDTO message = new RestErrorExceptionDTO(msg,code, Util.CustomTimer.timeNow());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

    @ExceptionHandler(value = {UnauthorizedrRequestException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<RestErrorExceptionDTO>  internalServerErrorRequestException(UnauthorizedrRequestException unauthorizedrRequestException) {
        var msg = unauthorizedrRequestException.getMsg();
        var code = unauthorizedrRequestException.getCode();
        RestErrorExceptionDTO message = new RestErrorExceptionDTO(msg,code, Util.CustomTimer.timeNow());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }
}
