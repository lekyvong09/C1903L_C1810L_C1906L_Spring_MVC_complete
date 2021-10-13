package com.ray.springmvc.dao;

import com.ray.springmvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);
    public Customer getCustomer(int theId);
    public void deleteCustomer(int theId);
}
