package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
