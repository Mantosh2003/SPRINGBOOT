package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCyleApplication {

	public static void main(String[] args) {
		System.out.println("hii");
		var context =	SpringApplication.run(BeanLifeCyleApplication.class, args);
		System.out.println("Hello");
		var greet=context.getBean(Greet.class);
		greet.greet();
	}
	/*Bean life cycle
	-contain 5 phases 

	1.Bean Instantiated  => Object is created ,when object is created when constructor is called,
	2.Dependency Injected(if available)\
	3.Bean initialized
	4.Bean used
	5.Bean Destroyed      => @Predestroyed
	- it is managed by Spring Container
	*/
	// @Override
	// public void run (String...args)throws Exception{

	// }

}



// command line runner means when the spring container starts it will start eun
