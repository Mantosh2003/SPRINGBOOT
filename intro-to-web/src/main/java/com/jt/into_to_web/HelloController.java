package com.jt.into_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    // @RequestMapping(value="/submit-details", method=RequestMethod.POST)
    // public String submitDetails(@RequestParam(value = "name1", required = false, defaultValue="SpringBoot") String name, @RequestParam String phone, Model model) {
    //     System.out.println("///////"+ name);
    //     model.addAttribute("name1", name);
    //     model.addAttribute("phone", phone);

    //     return "details-page";
    // }

// }


    @RequestMapping(value="/submit-details", method=RequestMethod.POST)
    public String submitDetails(@ModelAttribute Person person,Model model) {
        
        model.addAttribute("name1", person.getName1());
        model.addAttribute("phone", person.getPhone());

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



// we need to add a depency for auto soave in the pom.xml dependency 
// <dependency>
//          	<groupId>org.springframework.boot</groupId>
//           	 <artifactId>spring-boot-devtools</artifactId>
//      		 <scope>runtime</scope>
//     		  <optional>true</optional>
//   </dependency>\


// Model  => if  we want to send data from java to html we need model
// @RequestParam => is used to get a query parameter from an HTTP request

// what  is out name1 querry parameter is not available ?
// it will show a white label error .....
// to handle this we will use @RequestParam(value = "name1", required = false)
// required :- we use to when we need only one param like here we have taken the for name1 => it will treat the value as optional value
// defaultvalue is used to add a value default to the name1 if no value is present . 
