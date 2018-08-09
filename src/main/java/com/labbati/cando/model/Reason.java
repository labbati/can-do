package com.labbati.cando.model;

import java.util.Map;

public class Reason {

    private String code;

    private boolean failed;

    private Object data;

    public Reason(String code) {
        this(code, true, null);
    }

    public Reason(String code, boolean failed, Object data) {
        this.code = code;
        this.failed = failed;
        this.data = data;
    }
}
