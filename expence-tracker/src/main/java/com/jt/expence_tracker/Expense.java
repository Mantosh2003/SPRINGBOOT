package com.jt.expence_tracker;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Expense {
    private int id;
    private String title;
    private String category;
    private double price;
    private LocalDate date;

    
//    public Expense(int id){
//     this.id=id;
//     System.out.println("sdhfh"+id);
//    }

    // public Expense(){
    //     // this.id=id;
    //     // System.out.println("call"+id);
        
    // }

    // public Expense(int id, String title, String category, double price, LocalDate date) {
    //     this.id = id;
    //     this.title = title;
    //     this.category = category;
    //     this.price = price;
    //     this.date = date;
    //     System.out.println("Expense(id, title, category, price, date) constructor called");
    
    //     System.out.println("No-args constructor called");
    //     System.out.println("id = " + id);
    //     System.out.println("title = " + title);
    //     System.out.println("category = " + category);
    //     System.out.println("price = " + price);
    //     System.out.println("date = " + date);


    // }
    // public int getId() {
    //     return id;
        
    // }
    // public void setId(int id) {
    //        System.out.println("setId called with:"+ id);
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //      System.out.println("setTitle called with: " + title);

    //     this.title = title;
    // }
    // public String getCategory() {
    //     return category;
    // }
    // public void setCategory(String category) {
    //     System.out.println("setCategory called with: " + category);
    //     this.category = category;
    // }
    // public double getPrice() {
        
    //     return price;
    // }
    // public void setPrice(double price) {
    //     System.out.println("setPrice called with: " + price);
    //     this.price = price;
    // }
    // public LocalDate getDate() {
    //     return date;
    // }
    // public void setDate(LocalDate date) {
    //       System.out.println("setDate called with: " + date);
    //     this.date = date;
    }
    
    

