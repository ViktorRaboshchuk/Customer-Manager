package com.project.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.springdemo.entity.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery =
                currentSession.createQuery("FROM Customer", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    public void saveCustomer(Customer customer) {
        //get current Hibernate session
        Session session = sessionFactory.getCurrentSession();
        // save the customer ...
        session.saveOrUpdate(customer);
    }

    public Customer getCustomer(int theId) {
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //now retrive/read from database using the primary key

        Customer theCustomer = session.get(Customer.class, theId);

        return theCustomer;
    }

    public void deleteCustomer(int theId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId", theId);

        query.executeUpdate();
    }

}


