package com.etiya.proje3.core.utilities;

public class SuccessDataResult<T> extends DataResult{


    public SuccessDataResult(String message) {
        super(null,true,message);
    }
    public SuccessDataResult() {
        super(null,false);
    }
    public SuccessDataResult(T data, String message) {
        super(data,true,message);
    }
    public SuccessDataResult(T data) {
        super(data,true);
    }
}
