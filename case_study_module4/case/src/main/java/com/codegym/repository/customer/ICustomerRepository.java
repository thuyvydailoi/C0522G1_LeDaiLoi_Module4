package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);

    Page<Customer>search(@Param("nameSearch") String nameSearch,
                         @Param("addressSearch") String addressSearch,
                         @Param("phoneSearch") String phoneSearch,
                         Pageable pageable);
}
