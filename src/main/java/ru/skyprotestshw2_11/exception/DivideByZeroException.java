package ru.skyprotestshw2_11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivideByZeroException extends IllegalArgumentException {

    public DivideByZeroException(String s) {

        super(s);
    }
    

}
