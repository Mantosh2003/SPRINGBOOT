package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class DieselEngine implements Engine {
    //  private final Car car;

    // DieselEngine(Car car) {
    //     this.car = car;
    // }

     @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Diesel Engine Starting");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Diesel Engine Stoping");
        // an interface cannot hold 2 beans so there we will use @primary annotation. 
        // the error is Ambiguity error 
        // we cannot use 2 bean of a class it will show a error how to avoid that we use @primry ;to avoid the error
       

        // in case we have 2 @primary in both the classes of interface we will use another annotation that is car.java where 

    //      @Autowired
    // public Car( @Qualifier("petrolEngine")Engine engine){
    //     this.engine=engine;
    //     System.out.println("Parameterized constructor");
    // }
    //  @Qualifier ("Reference of the object")//by default it put the name of the Reference object in camel case
    // while using the @Qualifier the referece  name is bydefault in camel case or we should write the name in in @Component ("referece name ")
    }
    
}

