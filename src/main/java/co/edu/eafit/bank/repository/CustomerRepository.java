package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
	
	

}
