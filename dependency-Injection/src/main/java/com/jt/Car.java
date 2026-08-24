package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // private Engine engine =new Engine();

    // Dependency Injection (DI)= It is a mechanism in which springContainer automaticaally inject the Bean inside the Class Reference Value, 
    // in simple word Spring Container Automatically assigns the Adress of the Bean inside Anathor classs Reference

    // we can inject in 3 ways:
    // 1.Field Based Injection(Not Recommended)

    // @Autowired ----Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.jt.Engine.startEngine()" because "this.engine" is null
        // at com.jt.Car.startCar(Car.java:23)
        // at com.jt.DependencyInjectionApplication.main(DependencyInjectionApplication.java:19)

    // @Autowired
    // private Engine engine ;
// ================================================================================================================================================================
    // 2. Setter Method Based Injection(Specific senario Recommended)
    // private Engine engine;
    // @Autowired
    // public void setEngine(Engine engine){
    //     System.out.println("Parameter Engine"+engine);
    //     System.out.println("Variable Engine"+this.engine);

    //     this.engine=engine;
    // }
// =================================================================================================================================================================

    // 3. Constructor Based Injection(Highly Recomended )   it is bit supportive in testing, 

    private Engine engine;
    @Autowired
    public Car(@Qualifier("dieselEngine.") Engine engine){         //Qualifier is used for avoiding the conflict of 2 primary beans     
        
        this.engine=engine;
        System.out.println("Parameterized constructor");
    }
    // if we use single method we no need to write @Autowired 

    
    public Car(){
    // this will give us a null pointer exception
    System.out.println("NON- Parameterized Constructor");
        // default java will call the non parameterized constructoer so that this method will show an error
    }
    // if we want both constructor we will use @ autowired to avoid this error in the parameterized constructor
    

    public void startCar(){
        // Engine engine =new Engine();  without repeating frequently, we can create and also we cannot acess a instance variable in side a static variable
        engine.startEngine();
        System.out.println("Car is Started");
    }

    public void stopCar(){
        // Engine engine =new Engine();
        engine.stopEngine();
        System.out.println("Car is Stopped");
    }
    
}


// 