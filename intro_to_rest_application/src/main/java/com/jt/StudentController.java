package com.jt;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Controller
// @ResponseBody
// these above controller ussed together so we can use new annotation that is mde by these 2 annotation naamed:
// @RestController
public class StudentController {
    private ObjectMapper mapper;

    public StudentController(ObjectMapper mapper){
        this.mapper=mapper;
    }

    
    @RequestMapping(value="/student", method=RequestMethod.GET)
    @ResponseBody// it tells springboot to return a jason object instead of a view file(html page)
    public Student getStudent(){ //as we will return student type of data so without writting string we wrote student;

       Student student= new Student(101,"Ankit", new String[]{"Java","Python"} );
       
       System.out.println("//////"+ student);
       // return "student_page";
       return student;
    }  
    @RequestMapping("/student1")
    public void convertjavaObjToJSON() throws JacksonException{
        Student student= new Student(101,"Ankit", new String[]{"Java","Python"} );
        

        // converrt to json
        String json=mapper.writeValueAsString(student);
        System.out.println("Json value is "+ json);
    }   
    @RequestMapping("/student2")
    public void convertJSONtojavaObj() throws JacksonException{
       String json ="""
       {
       "id":102,
       "name": "Aniket",
       "courses":["C","C++"]
       }
       """;
               Student student =mapper.readValue(json,Student.class);
               System.out.println("After converting from json to java Object " + student);

    
    }
    @RequestMapping("fruits")
    @ResponseBody
    public List<String> getStrings(){
        return List.of("Apple","Mango","Grapes");
    }
 }
// springboot 's  json converter in behind is jackson convert a java obj to json