package org.labseq.controller;

import org.labseq.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import org.labseq.model.Customer;


import jakarta.inject.Inject;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GET
    public List<Customer> retriveCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAllCustomer();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return customers;
    }

    @POST
    @Transactional
    public void addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
