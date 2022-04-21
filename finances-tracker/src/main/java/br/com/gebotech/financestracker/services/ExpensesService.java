package br.com.gebotech.financestracker.services;

import br.com.gebotech.financestracker.models.Expenses;
import br.com.gebotech.financestracker.repository.interfaces.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class ExpensesService {

    @Autowired
    ExpensesRepository expensesRepository;

    public ResponseEntity<List<Expenses>> findAll() {
        return ResponseEntity.ok().body(expensesRepository.findAll());
    }

    public ResponseEntity<?> saveAllExpenses(List<Expenses> expenses) {
        expensesRepository.saveAll(expenses);

        return ResponseEntity.ok().body("List was saved to database!");
    }

    public ResponseEntity<List<Expenses>> getAllByMonth(int month) {
        YearMonth yearMonth = YearMonth.of( LocalDateTime.now().getYear(), month );
        LocalDate startLocalDate = LocalDate.of(LocalDateTime.now().getYear(), month, yearMonth.atDay(1).getDayOfMonth());
        LocalDate endLocalDate = LocalDate.of(LocalDateTime.now().getYear(), month, yearMonth.atEndOfMonth().getDayOfMonth());

        LocalDateTime start = LocalDateTime.of(startLocalDate, LocalTime.MIDNIGHT);
        LocalDateTime end = LocalDateTime.of(endLocalDate, LocalTime.MIDNIGHT);

        return ResponseEntity.ok().body(expensesRepository.findAllByExpireAtBetween(start, end));
    }
}
