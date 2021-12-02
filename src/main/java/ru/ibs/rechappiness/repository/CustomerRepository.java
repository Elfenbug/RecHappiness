package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
