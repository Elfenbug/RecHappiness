package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.CustomerDto;
import ru.ibs.rechappiness.mapper.CustomerMapper;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.repository.CustomerRepository;
import ru.ibs.rechappiness.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        log.info("IN CustomerServiceImpl getAllCustomers");
        List<CustomerDto> customerDtoList = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customers : customerList) {
            customerDtoList.add(CustomerMapper.INSTANCE.fromCustomer(customers));
        }
        return customerDtoList;
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        log.info("IN CustomerServiceImpl getCustomer {}", id);
        return CustomerMapper.INSTANCE.fromCustomer(customerRepository.findById(id).orElse(null));
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        log.info("IN CustomerServiceImpl saveCustomer {}", customerDto);
        customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customerDto));
    }

    @Override
    public void deleteCustomer(Long id) {
        log.info("IN CustomerServiceImpl deleteCustomer {}", id);
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", customerDto);
        if (customerRepository.findById(id).orElse(null) != null) {
            customerDto.setId(id);
            customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customerDto));
        }
    }
}
