package com.example.spring_boot_data_with_thymeleaf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com")

public class SpringBootDataWithThymeleafApplication {

public static void main(String[] args) {
SpringApplication.run(SpringBootDataWithThymeleafApplication.class, args);
System.out.println("Spring Api Up");
}

}
