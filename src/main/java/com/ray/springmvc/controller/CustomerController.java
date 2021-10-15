package com.ray.springmvc.controller;

import com.ray.springmvc.entity.Customer;
import com.ray.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);

        // redirect from controller to another URL in controller
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
        // get customer from DB
        Customer theCustomer = customerService.getCustomer(theId);

        // bind data to theModel
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

    @GetMapping("search")
    public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
}
