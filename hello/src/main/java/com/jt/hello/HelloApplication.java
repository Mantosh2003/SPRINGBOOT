package com.jt.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

@ComponentScan(basePackages={"com"})
@ImportResource("beans.xml")
@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		// using xml file
		Greet greet = context.getBean(Greet.class);
		greet.sayHello();
		System.out.println("Hello Springboot");
		// using stereotype file
		Person person=context.getBean(Person.class);
		person.sayHello();
		// using configuration file
		Student student =context.getBean(Student.class);
		student.sayHello();
		Teacher teacher=context.getBean(Teacher.class);
		teacher.sayHello();

		// to know the scope of bean 
		System.out.println(teacher.hashCode());
		Teacher teacher1=context.getBean(Teacher.class);
		System.out.println(teacher1.hashCode());

		// created scope in student.java and appconfig.java
		System.out.println("Student" + student.hashCode());
		Student student2 =context.getBean(Student.class);
		System.out.println("Student" + student2.hashCode());

		//created scope using the xml file 
		System.out.println("person"+greet.hashCode());
		Greet greet2 = context.getBean(Greet.class);
		System.out.println("person"+greet2.hashCode());
		
	}
 
}
