package re.kaguya.ivos.base.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import re.kaguya.ivos.base.response.StatusCode;

@AllArgsConstructor
@Getter
public class ServiceException extends RuntimeException {
    private StatusCode statusCode;

}
