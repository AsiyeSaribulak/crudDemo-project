package com.etiya.proje3.core.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }
    public Result(boolean success,String message){
        this.success=success;
        this.message=message;
    }

    public  boolean isSuccess(){
        return this.isSuccess();
    }
    public String getMessage(){
        return this.message;
    }

}
