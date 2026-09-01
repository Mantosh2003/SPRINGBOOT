package com.jt.expence_tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class ExpenseController {
    private final JdbcTemplate jdbcTemplate;

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //    this.jdbcTemplate=jdbcTemplate;

    // }
    @RequestMapping(value="/expenses",method=RequestMethod.GET)
    public List<Expense> getExpenses(){

    String sql ="Select * From expenses";

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
    
}
