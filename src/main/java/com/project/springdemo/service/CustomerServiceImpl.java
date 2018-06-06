package com.project.springdemo.service;

import com.project.springdemo.dao.CustomerDAO;
import com.project.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers() ;
    }

    @Transactional
    public void saveCustomer(Customer customer) {

        customerDAO.saveCustomer(customer);
    }

    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Transactional
    public void deleteCustomer(int theId) {
         customerDAO.deleteCustomer(theId);
    }
}
