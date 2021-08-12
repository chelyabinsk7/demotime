package com.example.demotime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemotimeApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SpringApplication.run(DemotimeApplication.class, args);
        System.out.println("1111");

        List<String> list = new ArrayList<>();
        list.add("Odin");
        list.add("Dva");
        list.add("Tri");

//        FileOutputStream fos = new FileOutputStream("list.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        fos.close();

//        FileInputStream fis = new FileInputStream("list.bin");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        List<String> list1 = (List) ois.readObject();
//        ois.close();


//        System.out.println(new File("./src/main/resources/bins/list.bin").isFile());
//        System.out.println("=======================");
    }

}
