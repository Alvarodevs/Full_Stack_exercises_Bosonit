package com.exercise.BS8.persona.infrastructure.errors;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    private Date timeStamp;
    private int httpCode;
    private String message;

    public CustomError(Date timeStamp, int httpCode, String message){
        super();
        this.timeStamp=timeStamp;
        this.httpCode=httpCode;
        this.message=message;
    }
}
