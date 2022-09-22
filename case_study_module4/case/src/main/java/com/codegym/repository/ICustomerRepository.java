package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);
}
