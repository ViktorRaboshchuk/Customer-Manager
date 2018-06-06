package com.project.springdemo.controller;

import java.util.List;

import com.project.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.springdemo.entity.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        //create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        // save the customer using our service
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId")int theId, Model model){

        //get the customer from the service
        Customer customer = customerService.getCustomer(theId);

        //set the customer as a model attribute to pre-pipulate the form
        model.addAttribute("customer", customer);

        //send over to our form

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId, Model model){
       customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

}