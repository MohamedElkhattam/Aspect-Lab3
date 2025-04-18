package com.Lab3.demo.controller;


import com.Lab3.demo.model.Expense;
import com.Lab3.demo.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public Expense create(@PathVariable Long userId, @RequestBody Expense expense) {
        return expenseService.createExpense(userId, expense);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
