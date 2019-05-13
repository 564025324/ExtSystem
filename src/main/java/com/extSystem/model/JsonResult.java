package com.extSystem.model;

import lombok.Data;

import java.util.Map;

@Data
public class JsonResult {
    private int code;
    private Map data;
    private String msg;
    private boolean hasError;

    public JsonResult() {
        this.hasError = true;
    }

}
