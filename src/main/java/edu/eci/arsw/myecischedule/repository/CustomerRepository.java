package edu.eci.arsw.myecischedule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischedule.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
    @Query("SELECT c FROM Customer c WHERE name=:nombre")
    Optional<Customer> findByName(@Param("nombre")String nombre);
}
