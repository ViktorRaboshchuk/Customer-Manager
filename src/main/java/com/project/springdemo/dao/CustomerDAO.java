package com.project.springdemo.dao;

import java.util.List;

import com.project.springdemo.entity.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
