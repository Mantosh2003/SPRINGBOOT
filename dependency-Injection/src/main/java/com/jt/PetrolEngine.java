package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component("petrol")
public class PetrolEngine implements Engine {

    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol Engine Starting");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol Engine Stoping");
       
    }
    
    //engine is the interface and petrolengle is the class that uses the bean of petrol engine
}
