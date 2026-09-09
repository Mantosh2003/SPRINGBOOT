package com.jt.expence_tracker;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping("/expenses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteExpenseById(id);
    }

    @PutMapping("/expenses")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Expense updateExpense(@RequestBody Expense expense) {
        return expenseService.updateExpense(expense);
    }
}
