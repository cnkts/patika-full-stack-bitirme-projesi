package com.can.autoRegSystem.core.utilities;

public class SuccesDataResult<T> extends DataResult<T>{



    public SuccesDataResult(String message, T data) {
        super(true, message, data);
    }



}
