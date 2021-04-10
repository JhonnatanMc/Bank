package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	

}
