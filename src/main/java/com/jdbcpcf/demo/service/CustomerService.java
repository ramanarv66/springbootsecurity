package com.jdbcpcf.demo.service;

import java.util.List;

import com.jdbcpcf.demo.dao.CustomerDaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcpcf.demo.model.Customer;

@Service
public class CustomerService {

    @Autowired
    CustomerDaoRepo customerDaoRepo;

 public List<Customer> getAllCustomers(){
     List<Customer> customerList = customerDaoRepo.findAll();

     return  customerList;
 }

    public void  saveCustomerData(Customer customer) {
          customerDaoRepo.save(customer);
    }
}
