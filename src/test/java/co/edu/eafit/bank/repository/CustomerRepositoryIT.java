package co.edu.eafit.bank.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.eafit.bank.domain.Customer;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class CustomerRepositoryIT {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	void findAll() {
		// Arrange
		List<Customer> customers = null;
				
		// Act
		customers = customerRepository.findAll();
		
		// Assert
		assertNotNull(customers);
		assertFalse(customers.isEmpty());
		
		//No deberia estar en la prueba
		//customers.forEach(cust->{
		//	log.info(cust.getName());
		//});
		
		//customers.forEach(cust->log.info(cust.getName()));
	}

}
