package com.jdbcpcf.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcpcf.demo.model.Customer;

public class CustomerRowMapper implements RowMapper {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setEmail(rs.getString("email"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));
        customer.setUsername(rs.getString("username"));
        customer.setId(rs.getInt("id"));
        return customer;
    }
}
