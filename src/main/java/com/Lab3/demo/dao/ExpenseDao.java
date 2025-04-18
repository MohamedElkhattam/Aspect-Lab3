package com.Lab3.demo.dao;

import com.Lab3.demo.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseDao extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
}