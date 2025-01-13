package com.demo.db.controller;

import com.demo.db.entity.Customer;
import com.demo.db.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class SimpleController {

    private CustomerService customerService;

    public SimpleController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customerUpdated) {
        Customer customer = customerService.getById(id);
        if (customer != null) {
            customer.setName(customerUpdated.getName());
            return ResponseEntity.ok(customerService.create(customer));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }
}
