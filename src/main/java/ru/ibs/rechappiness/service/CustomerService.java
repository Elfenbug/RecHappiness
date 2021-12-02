package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer, Long id);
}
