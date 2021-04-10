package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.RegisteredAccount;

public interface RegisteredAccountRepository extends JpaRepository<RegisteredAccount, Integer> {

}
