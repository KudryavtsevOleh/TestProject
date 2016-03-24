package com.testproject.util;


import com.testproject.model.Todo;

import java.util.List;

public class ResponseBean {

    private String status;
    private List<Todo> objects;

    public ResponseBean(String status, List<Todo> objects) {
        this.status = status;
        this.objects = objects;
    }

}
