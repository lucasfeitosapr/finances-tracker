package br.com.gebotech.financestracker.repository.interfaces;

import br.com.gebotech.financestracker.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Long> {

    Optional<Expenses> findById(Long id);
    List<Expenses> findAll();
    List<Expenses> findAllByExpireAt(LocalDateTime dateTime);
    List<Expenses> findAllByExpireAtAndPayed(LocalDateTime dateTime, Boolean payed);
    List<Expenses> findAllByExpireAtBetween(LocalDateTime start, LocalDateTime end);

}
