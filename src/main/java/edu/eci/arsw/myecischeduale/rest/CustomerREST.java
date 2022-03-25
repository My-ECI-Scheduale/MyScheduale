package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Customer;
import edu.eci.arsw.myecischeduale.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerREST {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    private ResponseEntity<Customer> guardar(@RequestBody Customer c){
        Customer temp = customerService.create(c);
        try {
            return ResponseEntity.created(new URI("/api/customer"+temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
