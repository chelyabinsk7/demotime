package com.example.demotime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
public class MyTask {

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy ");

    public String times;

    @Scheduled(fixedRate = 4000)
    public void CurrentTime() throws Exception {
        times = dtf.format(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
        System.out.println("Now: " + times);
    }
}
