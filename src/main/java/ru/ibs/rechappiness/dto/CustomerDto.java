//package ru.ibs.rechappiness.dto;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//import ru.ibs.happiness.model.Customer;
//
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class CustomerDto {
//        private Long id;
//        private String username;
//        private String firstName;
//        private String lastName;
//        private String email;
//
//        public Customer toCustomer(){
//            Customer customer = new Customer();
//            customer.setId(id);
//            customer.setUsername(username);
//            customer.setFirstName(firstName);
//            customer.setLastName(lastName);
//            customer.setEmail(email);
//
//            return customer;
//        }
//
//        public static CustomerDto fromCustomer(Customer customer) {
//            CustomerDto customerDto = new CustomerDto();
//            customerDto.setId(customer.getId());
//            customerDto.setUsername(customer.getUsername());
//            customerDto.setFirstName(customer.getFirstName());
//            customerDto.setLastName(customer.getLastName());
//            customerDto.setEmail(customer.getEmail());
//
//            return customerDto;
//        }
//    }
//
//}
