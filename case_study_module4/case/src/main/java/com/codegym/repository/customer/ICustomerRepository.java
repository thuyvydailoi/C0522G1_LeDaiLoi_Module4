package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(int id);

    @Modifying
    @Query(value = "update customer set delete_status = 1 where customer_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);


    @Query(value = "select * from customer where customer_name like %:nameSearch% " +
            "and customer_address like %:addressSearch%" +
            " and customer_phone like %:phoneSearch% and delete_status = 0" , nativeQuery = true)
    Page<Customer> search(@Param("nameSearch") String nameSearch,
                          @Param("addressSearch") String addressSearch,
                          @Param("phoneSearch") String phoneSearch,
                          Pageable pageable);
}
