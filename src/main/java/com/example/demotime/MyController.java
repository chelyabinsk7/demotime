package com.example.demotime;

import org.openqa.selenium.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyTask myTask;

    @GetMapping
    public String getTime() throws Exception {
        myTask.currentTime();
        return myTask.times + "<br>" + Platform.getCurrent() + "<br>" + myTask.doc.title();
    }
}
