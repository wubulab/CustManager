package ua.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.customer.model.Customer;

@Component
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
