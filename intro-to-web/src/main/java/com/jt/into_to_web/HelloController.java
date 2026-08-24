package com.jt.into_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @Component
public class HelloController {
    @RequestMapping("/home")
    public void sayHello(PrintWriter writer) { // any servlet related class like printwriter then the spring cointainer
                                               // will automatically mmanage it
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1>  <p>Welcome Home</p>");

    }

    @RequestMapping // bydefaut the path is "/" so no need to write .....
    public void landingPage(PrintWriter writer) {
        System.out.println("Landing page");
        writer.println("Our First Landing Page");
    }

    @RequestMapping("/contact")
    public String contact(PrintWriter writer) {
        System.out.println("contact page established");
        return "contact-page";
    }

    // @RequestMapping("/submit-details")
    // public String submitDetails(HttpServletRequest request,Model model){
    // System.out.println("Submit details handled");
    // String name = request.getParameter("name");
    // String phone = request.getParameter("phone");
    // // System.out.println("name is : "+ name);
    // // System.out.println("Phone is : "+ phone);
    // model.addAttribute("name",name);
    // model.addAttribute("phone",phone);

    // return "details-page";
    // }

    @RequestMapping("/submit-details")
    public String submitDetails(@RequestParam(value = "name1") String name, @RequestParam String phone, Model model) {
        System.out.println("///////"+ name);
        model.addAttribute("name1", name);
        model.addAttribute("phone", phone);

        return "details-page";
    }

}
// @Controller  
/*- it marks the class as ther controller class
- which means that class is responsible to handle  http request
 */

// @RequestMapping
/*- this annotation hadles a custom path in side a controller class */

// there are 2 type of rendering
// 1.client side rendering
// 2.serversidde rendering

// 3 tier => backend , Frontend DB
// 2 tier = backend +frontend , db +> curentlly we are working on a 2 tier
// application.
