package cn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"cn.app", "cn.zzn.dao"})
@ComponentScan(basePackages = {"cn.app"})
public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(App.class, args);
    }

}
