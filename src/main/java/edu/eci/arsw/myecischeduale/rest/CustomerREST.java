package edu.eci.arsw.myecischeduale.rest;


import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Customer;
import edu.eci.arsw.myecischeduale.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerREST {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    private ResponseEntity<Boolean> getCustomerByName(@PathParam("name")String name){
        Optional<Customer> user = customerService.findByName(name);
        System.out.println(user.isPresent());
        return ResponseEntity.ok(user.isPresent());
    }
}
