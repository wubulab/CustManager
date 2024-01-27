package ua.customer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ua.customer.model.Customer;
import ua.customer.repository.CustomerRepository;
import ua.customer.service.CustomerService;

@SpringBootTest
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void createCustomer() {
        Customer customer = new Customer();
        customer.setFull_name("Dmytro");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer created = customerService.createCustomer(customer);

        assertEquals("Dmytro", created.getFull_name());
    }
}
