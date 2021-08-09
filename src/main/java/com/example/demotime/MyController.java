package com.example.demotime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyTask myTask;

    @GetMapping
    public String getTime() {
        String time = myTask.times;
        return "Time is: " + time;
    }
}
