package com.jdbcpcf.demo.controller;


import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.jdbcpcf.demo.dao.CustomerDaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jdbcpcf.demo.model.Customer;
import com.jdbcpcf.demo.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerDaoRepo customerDaoRepo;
    @GetMapping("getCustomers")
    public List<Customer> getAllCustomer(){
        return  customerService.getAllCustomers();
    }
    @PostMapping("saveCustomer")
    public void saveCustomers(@RequestBody Customer customer){
        if(!Objects.nonNull(customer.getId()) || (customer.getId() == 0)){
            Random random = new Random();
            customer.setId(random.nextInt(1000));
        }
        customerService.saveCustomerData(customer);
    }
    @DeleteMapping(path = "deleteCustomer/{id}")
    public String  deleteCustomer(@PathVariable  int id){
        customerDaoRepo.deleteById(id);
        return  "Deleted";
    }
    @PutMapping("updateCustomer/{id}")
    public  String updateCustomer(@RequestBody Customer customer, @PathVariable int id){
        System.out.println("request customer" + customer);
        Customer customer1 = customerDaoRepo.getOne(id);
        System.out.println(customer1);
        customer1.setEmail(customer.getEmail());
        customer1.setFirstname(customer.getFirstname());
        customer1.setLastname(customer.getLastname());
        customer1.setUsername(customer.getUsername());
        customerDaoRepo.save(customer1);

        return "Customer Updated";

    }
}
