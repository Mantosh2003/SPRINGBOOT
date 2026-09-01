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
    private LocalDate Date;


    // public Expense(){
        
    // }

    // public Expense(int id, String title, String category, double price, LocalDate date) {
    //     this.id = id;
    //     this.title = title;
    //     this.category = category;
    //     this.price = price;
    //     Date = date;
    // }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public LocalDate getDate() {
        return Date;
    }
    public void setDate(LocalDate date) {
        Date = date;
    }
    
    
}
