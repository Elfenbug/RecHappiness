package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();
}
