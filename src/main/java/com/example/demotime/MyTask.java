package com.example.demotime;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
public class MyTask {

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy ");

    public Document doc;
    public String times;


    @Scheduled(fixedRate = 5000)
    public void dvdsv() {
        System.out.println(new File("./src/main/resources/bins/list.bin").isFile() + " MAC");
        System.out.println(new File("~/src/main/resources/bins/list.bin").isFile() + " LINUX");
        System.out.println("=======================");
    }

//    @Scheduled(fixedRate = 20000)
    public void titleGoogle() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        doc = Jsoup.parse(driver.getPageSource());
        System.out.println(doc.title());
        driver.close();
    }

    public WebDriver launchBrowser(){
        System.out.println("==================START");
        String driverPath="";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1200x600");

        if(Platform.getCurrent().is(Platform.WINDOWS)){
            System.out.println("==================WINDOWS");
            driverPath="./src/main/resources/chromedriver";
            System.setProperty("webdriver.chrome.driver", driverPath);
        }

        if(Platform.getCurrent().is(Platform.valueOf("MAC"))){
            System.out.println("==================MAC");
            driverPath="./src/main/resources/chromedriver";
            System.setProperty("webdriver.chrome.driver", driverPath);
        }

        if(Platform.getCurrent().is(Platform.LINUX)){
            System.out.println("==================LINUX");
            try{   //GOOGLE_CHROME_SHIM GOOGLE_CHROME_BIN
                String binaryPath=EnvironmentUtils.getProcEnvironment().get("GOOGLE_CHROME_SHIM");
                options.setBinary(binaryPath);
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        WebDriver driver=new ChromeDriver(options);
        return driver;
    }
}
