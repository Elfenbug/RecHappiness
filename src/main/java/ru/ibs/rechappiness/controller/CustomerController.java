package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.CustomerDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.mapper.CustomerMapper;
import ru.ibs.rechappiness.mapper.LocationMapper;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/read")
    public List<CustomerDto> showAllCustomers() {
        return CustomerMapper.INSTANCE.map(customerService.getAllCustomers());
    }

    @GetMapping("/customer/read/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return CustomerMapper.INSTANCE.toDto(customerService.getCustomer(id));
    }

    @PostMapping("/customer/create")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PostMapping("/customer/update/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.updateCustomer(customer, id);
    }

    @PostMapping("/customer/update/")
    public Customer updateCustomer() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "customer with ID = " + id + " was deleted";
    }

    @PostMapping("/customer/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
