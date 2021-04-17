package co.edu.eafit.bank.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.domain.DocumentType;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@TestMethodOrder(OrderAnnotation.class)
class CustomerRepositoryIT {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	DocumentTypeRepository documentTypeRepository;

	@Test
	@Order(1)
	void debeCrearUnCustomer() {
		// Arrange
		Integer idDocumentType = 1;
		Integer idCustomer = 1456454;
		
		Customer customer = null;
		DocumentType documentType = null;
		
		Optional<DocumentType> documentTypeOptional = documentTypeRepository.findById(idDocumentType);
		documentType = documentTypeOptional.get();
		
		customer = new Customer();
		customer.setAddress("Avenida Siempre viva 123");
		customer.setCustId(idCustomer);
		customer.setDocumentType(documentType);
		customer.setEmail("jmaciasl@eafit.edu.co");
		customer.setEnable("Y");
		customer.setName("Jhonnatan");
		customer.setPhone("555 555 5555");
		customer.setToken("234566jaddsrrsz");
		
		// Act
		
		customer = customerRepository.save(customer);
				
		// Assert
		assertNotNull(customer, "El customer es nulo no se grabo");
				
	}
	
	@Test
	void debeConsultarUnCustomerPorId() {
		// Arrange
		Customer customer = null;
		Optional<Customer> customerOptional = null;
		Integer id = 1;
				
		// Act
		customerOptional = customerRepository.findById(id);
		
		// Assert
		assertNotNull(customerOptional);
		assertTrue(customerOptional.isPresent(), "El customer con "+id+"no existe");
		
		customer = customerOptional.get();
		log.info(customer.getName());
		System.out.println(customer.getName());
	}
	
	@Test
	void debeConsultarUnaListaDeClientes() {
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
