package edu.eci.arsw.myecischedule.rest;

import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischedule.model.Customer;
import edu.eci.arsw.myecischedule.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerREST {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @PostMapping("/login")
    private ResponseEntity<Optional<Customer>> getCustomerByName(@PathParam("name") String name) {
        Optional<Customer> user = customerService.findByName(name);
        return ResponseEntity.ok(user);
    }
}
