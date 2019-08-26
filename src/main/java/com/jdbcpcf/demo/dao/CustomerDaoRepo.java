package com.jdbcpcf.demo.dao;
import com.jdbcpcf.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDaoRepo extends JpaRepository<Customer, Integer>{

}

