package com.jt;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    public Greeting(){
        System.out.println("Greeting obj is Constructed..");
    }
    public void sayHii(){
        System.out.println("hii evryone");
    }
}
