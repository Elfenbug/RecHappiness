package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.repository.CustomerRepository;
import ru.ibs.rechappiness.service.CustomerService;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        log.info("IN CustomerServiceImpl getAll");
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        log.info("IN CustomerServiceImpl getById {}", id);
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        log.info("IN CustomerServiceImpl save {}", customer);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        log.info("IN CustomerServiceImpl delete {}", id);
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", customer);
        if (customerRepository.findById(id).orElse(null) != null) {
            customer.setId(id);
            customerRepository.save(customer);
        }
    }
}
