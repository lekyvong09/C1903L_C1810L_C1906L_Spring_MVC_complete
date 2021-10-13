package com.ray.springmvc.controller;

import com.ray.springmvc.dao.CustomerDAO;
import com.ray.springmvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        // get customers from the DAO
        List<Customer> theCustomers = customerDAO.getCustomers();

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
