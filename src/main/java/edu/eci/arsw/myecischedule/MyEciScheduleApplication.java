package edu.eci.arsw.myecischedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"edu.eci.arsw.myecischedule"})
@SpringBootApplication
public class MyEciScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEciScheduleApplication.class, args);
	}

}
