package br.com.gebotech.financestracker.controller;

import br.com.gebotech.financestracker.models.Expenses;
import br.com.gebotech.financestracker.services.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    ExpensesService expensesService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> saveAllExpenses(@RequestBody List<Expenses> expensesList) {
       return expensesService.saveAllExpenses(expensesList);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        return expensesService.findAll();
    }

    @GetMapping("/month/{value}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Expenses>> getExpensesByExpireMonth(@PathVariable("value") int month) {
        return expensesService.getAllByMonth(month);
    }

}
