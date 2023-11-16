package com.laioffer.onlineorder.repository;

import com.laioffer.onlineorder.entity.CustomerEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Long> {
    // Use function name to generate query
    List<CustomerEntity> findByFirstName(String firstName); // SELECT * FROM customers WHERE first_name = firstName;
    List<CustomerEntity> findByLastName(String lastName);
    CustomerEntity findByEmail(String email);

    // Self-defined query
    @Modifying
    @Query("UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE id = :id")
    void updateNameById(long id, String firstName, String lastName);

    @Modifying
    @Query("UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE email = :email")
    void updateNameByEmail(String email, String firstName, String lastName);
}

