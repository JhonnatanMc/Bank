package co.edu.eafit.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {
	
	@Mapping(source ="documentType.dotyId", target = "dotyId" )
	public CustomerDTO customerToCustomerDTO(Customer customer);
	
	@Mapping(source = "dotyId" , target ="documentType.dotyId")
	public Customer customerDTOtoCustomer(CustomerDTO customerDTO);
	
	public List<CustomerDTO> customersToCustomersDTOs(List<Customer> customers);
	
	public List<Customer> customersDTOsToCustomers(List<CustomerDTO> customerDTOs);
	
}