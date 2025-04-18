package com.Lab3.demo.service;

import com.Lab3.demo.dao.ExpenseDao;
import com.Lab3.demo.dao.UserDao;
import com.Lab3.demo.model.Expense;
import com.Lab3.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpenseService {

    private final ExpenseDao expenseDao;
    private UserDao userdao;

    @Autowired
    public ExpenseService(ExpenseDao expenseDao, UserDao userdao) {
        this.expenseDao = expenseDao;
        this.userdao = userdao;
    }

    public List<Expense> getAllExpenses() {
        return expenseDao.findAll();
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseDao.findByUserId(userId);
    }

    public Expense createExpense(Long userId, Expense expense) {
        User user = userdao.findById(userId).orElse(null);
        if (user != null) {
            expense.setUser(user);
            return expenseDao.save(expense);
        }
        return null;
    }

    public Expense updateExpense(Long id, Expense newExpense) {
        Expense expense = expenseDao.findById(id).orElse(null);
        if (expense != null) {
            expense.setDescription(newExpense.getDescription());
            expense.setAmount(newExpense.getAmount());
            return expenseDao.save(expense);
        }
        return null;
    }

    public void deleteExpense(Long id) {
        expenseDao.deleteById(id);
    }

}
