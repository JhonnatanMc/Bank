package co.edu.eafit.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepositry;
	
	@Autowired
	Validator validator;
	
	@Override
	public void validate(Customer entity) throws Exception {
		Set<ConstraintViolation<Customer>> constrainsViolations = validator.validate(entity);
		
		if(constrainsViolations.isEmpty() == false) {
			throw new ConstraintViolationException(constrainsViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return customerRepositry.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Customer> findById(Integer id) {
		return customerRepositry.findById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Customer save(Customer entity) throws Exception {
		if(entity == null) {
			throw new Exception("The customer is null");
		}
		
		validate(entity);
		
		if(customerRepositry.existsById(entity.getCustId())==true) {
			throw new Exception("The customer already exists");
		}
		
		return customerRepositry.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Customer update(Customer entity) throws Exception {
		if(entity == null) {
			throw new Exception("The customer is null");
		}
		
		validate(entity);
		
		if(customerRepositry.existsById(entity.getCustId())==false) {
			throw new Exception("The customer doesn't exists");
		}
		
		return customerRepositry.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Customer entity) throws Exception {
		if(entity == null) {
			throw new Exception("The customer is null");
		}
		
		if(customerRepositry.existsById(entity.getCustId())==false) {
			throw new Exception("The customer doesn't exists");
		}
		
		findById(entity.getCustId()).ifPresent(customer->{
			if(customer.getAccounts() != null && customer.getAccounts().isEmpty() == false) {
				throw new RuntimeException("The custome has associete accounts");
			}
			
			if(customer.getRegisteredAccounts() != null && customer.getRegisteredAccounts().isEmpty() == false) {
				throw new RuntimeException("The customer has register accounts");
			}
		});
		
		customerRepositry.deleteById(entity.getCustId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if(id == null) {
			throw new Exception("Id is null");
		}
		
		if(customerRepositry.existsById(id)) {
			delete(customerRepositry.findById(id).get());
		}
	}


	@Override
	public Long count() {
		return customerRepositry.count();
	}

}
