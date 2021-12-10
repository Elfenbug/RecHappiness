package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomer(Long id);

    void saveCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);

    List<CustomerDto> getAllCustomers();

    void updateCustomer(CustomerDto customerDto, Long id);
}
