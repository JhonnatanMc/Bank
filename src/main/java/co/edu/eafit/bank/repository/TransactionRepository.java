package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
