package com.jt.expence_tracker;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unable to find with id: " + id));
    }

    public void deleteExpenseById(int id) {
        getExpenseById(id); // ensures existence
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Expense expense) {
        getExpenseById(expense.getId()); // ensures existence
        return expenseRepository.save(expense);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
