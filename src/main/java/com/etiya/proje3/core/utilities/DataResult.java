package com.etiya.proje3.core.utilities;

public class DataResult<T> extends Result {//T jenerik yapı
    private final T data;

    public DataResult(T data, Boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}