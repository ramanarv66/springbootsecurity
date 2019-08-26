package com.jdbcpcf.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbcpcf.demo.mapper.CustomerRowMapper;
import com.jdbcpcf.demo.model.Customer;

@Repository
public class CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> getAllCustomers(){

        List<Customer> customerList = jdbcTemplate.query("SELECT * FROM dev_db.customer", new CustomerRowMapper());

        return  customerList;
    }

    public int saveCustomerData(Customer customer){
        String insertQuery = "insert into dev_db.customer (id,firstname,lastname,username,email)"+
                "values (?,?,?,?,?)";
        int isExec = jdbcTemplate.update(insertQuery, new Object[] {customer.getId(),customer.getFirstname(),
                customer.getLastname(),customer.getUsername(),customer.getEmail()});
        System.out.println("Value returned"+ isExec);
        return  isExec;
    }

    public int deleteCustomer(int id){
        String deleteQuery = "Delete from dev_db.customer where id=?";
        int returnDeletedValue = jdbcTemplate.update(deleteQuery,id);
        return returnDeletedValue;
    }
}
