package ua.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.customer.model.Customer;
import ua.customer.repository.CustomerRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Component
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    public Optional<Customer> getCustomerById(Long Id) {
        return customerRepository.findById(Id);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFull_name(customerDetails.getFull_name());
        customer.setPhone(customerDetails.getPhone());
        customer.setUpdated(Instant.now());
        return customerRepository.save(customer);

    }

    public void deleteCustomer(Long Id) {
        Customer customer = customerRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setIs_active(false);
        customerRepository.save(customer);

    }


}
