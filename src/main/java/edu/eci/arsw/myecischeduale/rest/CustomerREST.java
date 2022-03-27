package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Customer;
import edu.eci.arsw.myecischeduale.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerREST {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/api/Userexist")
    private ResponseEntity<Boolean> UserExist(@RequestParam String c){
        return null;
    }
}
