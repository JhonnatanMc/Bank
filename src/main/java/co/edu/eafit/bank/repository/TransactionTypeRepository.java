package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
