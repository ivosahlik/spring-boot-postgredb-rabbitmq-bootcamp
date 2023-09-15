package cz.ivosahlik.consumer.handler;

import cz.ivosahlik.exception.FileUploadConsumerException;
import cz.ivosahlik.handler.ErrorDTO;
import cz.ivosahlik.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ConsumerGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {FileUploadConsumerException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(FileUploadConsumerException exception) {
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(exception.getMessage()).build();
    }
}