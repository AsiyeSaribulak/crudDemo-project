package com.etiya.proje3.core.utilities;

public class SuccessResult extends Result{
    public SuccessResult() {
      super(true);
    }
    public SuccessResult(String mesage) {
        super(true,mesage);
    }
}
