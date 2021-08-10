package com.example.demotime;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    public Document doc;
    public String times;

    @Scheduled(fixedRate = 600000)
    public void CurrentTime() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = launchBrowser();
        driver.get("https://www.marathonbet.ru/su/popular/Football/France/Ligue+1+-+21533");
        doc = Jsoup.parse(driver.getPageSource());
//        doc = Jsoup.connect("https://www.marathonbet.ru/su/popular/Football/France/Ligue+1+-+21533").get();
        times = dtf.format(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
//        System.out.println("Now: " + times);
    }

    public WebDriver launchBrowser(){
        String driverPath="agent//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1200x600");
//        if(getOS().equals(OS.LINUX)){
//            try{   //GOOGLE_CHROME_SHIM GOOGLE_CHROME_BIN
//                String binaryPath= EnvironmentUtils.getProcEnvironment().get("GOOGLE_CHROME_SHIM");
//                System.out.println("Path: "+binaryPath);
//                options.setBinary(binaryPath);
//                options.addArguments("--disable-gpu");
//                options.addArguments("--no-sandbox");
//            }catch(Exception e){
//
//            }
//        }

        WebDriver driver=new ChromeDriver(options);

        return driver;
    }
}
