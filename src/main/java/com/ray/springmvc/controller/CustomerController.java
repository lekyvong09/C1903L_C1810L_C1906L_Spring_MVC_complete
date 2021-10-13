package com.ray.springmvc.controller;

import com.ray.springmvc.entity.Customer;
import com.ray.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        // get customers from the DAO
        List<Customer> theCustomers = customerService.getCustomers();

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
