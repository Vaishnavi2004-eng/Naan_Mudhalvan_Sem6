package com.ecom.CustomerOrder.controller;

import com.ecom.CustomerOrder.model.Customer;
import com.ecom.CustomerOrder.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name="Customer API", description="operations related to customers")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return service.addCustomer(customer);
    }
//    @GetMapping
//    public String ret(){
//        return "sample";
//    }
    @GetMapping
    public List<Customer> getAllCustomer()
    {
        return service.getAllCustomers();

    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id)
    {
        return service.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id)
    {
        service.deleteCustomer(id);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer
            updatedCustomer) {
        return service.updateCustomer(id, updatedCustomer);
    }

}
