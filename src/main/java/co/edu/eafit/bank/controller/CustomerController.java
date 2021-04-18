package co.edu.eafit.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.dto.CustomerDTO;
import co.edu.eafit.bank.mapper.CustomerMapper;
import co.edu.eafit.bank.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDTO> delete(@PathVariable("id") Integer id) throws Exception{
		
		customerService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping()
	public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO customerDTO) throws Exception{
		
		Customer customer=customerMapper.customerDTOtoCustomer(customerDTO);
		customer=customerService.update(customer);
		
		customerDTO=customerMapper.customerToCustomerDTO(customer);
		
		return ResponseEntity.ok(customerDTO);
	}
	
	@PostMapping()
	public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO)throws Exception{
		
		Customer customer=customerMapper.customerDTOtoCustomer(customerDTO);
		customer=customerService.save(customer);
		
		customerDTO=customerMapper.customerToCustomerDTO(customer);
		
		return ResponseEntity.ok(customerDTO);
	}
	
	//127.0.0.1:9090/api/v1/customer/7
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id){
		
		Optional<Customer> customerOptional=customerService.findById(id);
		
		Customer customer=(customerOptional.isPresent()==true)?customerOptional.get():null;
		
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
		
		return ResponseEntity.ok().body(customerDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> findAll(){
		List<Customer> customers=customerService.findAll();
		List<CustomerDTO> customerDTOs = customerMapper.customersToCustomersDTOs(customers);
		
		return ResponseEntity.ok().body(customerDTOs);
	}

	
		
}
