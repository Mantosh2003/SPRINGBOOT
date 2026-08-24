package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DependencyInjectionApplication.class, args);


		// Engine engine =context.getBean(Engine.class);
		// engine.startEngine();
		// dependency injection meanss we will use one class bean as a reference of another class

		Car car =context.getBean(Car.class);
		car.startCar();
		car.stopCar();

	}

}
