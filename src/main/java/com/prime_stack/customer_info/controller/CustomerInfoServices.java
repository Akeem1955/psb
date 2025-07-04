package com.prime_stack.customer_info.controller;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prime_stack.customer_info.model.Customer;
import com.prime_stack.customer_info.model.CustomerRepo;

@RestController
@RequestMapping("/psb/services/api/v1")
public class CustomerInfoServices {

    @Autowired
    CustomerRepo repo;


    @GetMapping("/search/{customerId}")
    ResponseEntity<Customer> findById(@PathVariable("customerId") String customerId)
    {
        if (customerId != null && repo.existsById(customerId)) {
            Optional<Customer> customer = repo.findById(customerId);
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{customerId}")
     ResponseEntity<String> deleteById(@PathVariable("customerId") String customerId){
         if (customerId != null && repo.existsById(customerId)) {
            repo.deleteById(customerId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/create")
     ResponseEntity<String> create(@RequestBody Customer customer){
        if(customer.customerId == null){
            return ResponseEntity.badRequest().body("Id is Required..");
        }

        if (repo.existsById(customer.customerId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Entity Already Exist");
        }
        repo.save(customer);
        return ResponseEntity.created(URI.create("/psb/services/api/v1/search/"+customer.customerId)).build();
    }


    @PutMapping("/update")
     ResponseEntity<String> updateById(@RequestBody Customer customer){

        if (customer.customerId != null && repo.existsById(customer.customerId)) {
            customer.markAsNotNew();
            repo.save(customer);
            ResponseEntity.ok().body("Updated Succesfully...");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Info Not found...");
    }

    
    @GetMapping("/search")
     ResponseEntity<Iterable<Customer>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }


}
