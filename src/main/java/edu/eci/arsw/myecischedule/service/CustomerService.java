package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.myecischedule.model.Customer;
import edu.eci.arsw.myecischedule.repository.CustomerRepository;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer create (Customer c){
        return customerRepository.save(c);
    }

    public List<Customer> getAllPersonas(){
        return customerRepository.findAll();
    }

    public void delete(Customer c){
        customerRepository.delete(c);
    }

    public Optional<Customer> findById(Long id){
            return customerRepository.findById(id);
    }

    public Optional<Customer> findByName(String name){
        return customerRepository.findByName(name);
    }
    
}
