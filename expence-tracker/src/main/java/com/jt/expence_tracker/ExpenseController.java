package com.jt.expence_tracker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequiredArgsConstructor

@RestController
public class ExpenseController {
   
    private final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABLE="expenses";

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //    this.jdbcTemplate=jdbcTemplate;

    // }
    // @RequestMapping(value="/expenses",method=RequestMethod.GET)
    // @GetMapping("/expenses")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    @GetMapping("/expenses")
    public List<Expense> getExpenses(){

    // String sql ="Select * From expenses";
    String sql ="Select * From %s".formatted(EXPENSES_TABLE);

    // List <Expense> expenses=new ArrayList<>();

    // jdbcTemplate.query(sql,(resultSet) -> {
    //     // System.out.println("ID is "+ resultSet.getInt("id"));
    //     // System.out.println("Title is"+ resultSet.getString("title"));
    //     // System.out.println("Category is "+ resultSet.getString("category"));

    //     var id =resultSet.getInt("id");
    //     var title =resultSet.getString("title");
    //     var category =resultSet.getString("category");
    //     var price =resultSet.getDouble("price");
    //     LocalDate date = resultSet.getDate("date").toLocalDate();

    //     var expense =new Expense(id,title,category,price,date);
        
    //     expenses.add(expense);

    //     return expense;

    // });

//    List <Expense> expenses =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
    //    return expenses;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
    }

    // @RequestMapping(value ="/expenses/{id}",method=RequestMethod.GET)
    //  //id here is know as path value
    @GetMapping("/expenses/{id}")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
     
    public Expense getExpensebyId(@PathVariable int id){ //expenses/1,2,3,4,5 then according to that we will get output and also 
                                                         //here the method handle multiple pages so it is called dynamic routing
                                                        // handler method;
        // System.out.println("Id is:  " + id);
        var sql ="Select * from %s where id=?".formatted(EXPENSES_TABLE);
        Expense expense=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Expense.class),id);
       return expense;
    }  

    // @RequestMapping(value="/expenses", method=RequestMethod.POST)
    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense){//witout writting repeated request param we can use requestBody
        
        var sql="insert into %s (title,category,price,date) values (?,?,?,?)".formatted(EXPENSES_TABLE);

        jdbcTemplate.update(sql, expense.getTitle(),expense.getCategory(),expense.getPrice(),expense.getDate());
        return expense;

        // var selectSql = "select * from expenses order by id desc limit 1";
        // Expense savedExpense = jdbcTemplate.queryForObject(selectSql,new BeanPropertyRowMapper<>(Expense.class));

        // return savedExpense;
        //queestion is how can we test it? how can we sent to normal browser.expenceTrackerApplication// by the helpof postman

      
    }
    // @RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
    // public void deleteExpense(@PathVariable int id) {

    // var deleteSql = "DELETE FROM %s WHERE id=?"
    //         .formatted(EXPENSES_TABLE);

    // jdbcTemplate.update(deleteSql, id);
// }

// a shortcut mapping is present that is:
    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable int id){
        String sql="Delete From %s where id=?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,id);
    }

    @PutMapping("/expenses")
    public Expense updateExpense(@RequestBody Expense expense){
        var sql="Update %s set title=?,category=?,price=?,date=? where id=?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(),expense.getDate(),expense.getId());
        return getExpensebyId(expense.getId());
    }


}
//here when incorect details is entered it will show diffrent type of error .:  ./mvmw package 



// JPA = java persistence api is the part of java ee
// it says no querry
// it tell what u write in java jpa will generate querry
// java ee product of apche
// jse-> oracle

// how can we share out project .mvnw package => after build sucess =>targetfolder there will be present a file snapshot.jar type =>rightclick and open in new terminal.. then java -jar .\expence-tracker-0.0.1-SNAPSHOT.jar then the file will run our spring project
// 