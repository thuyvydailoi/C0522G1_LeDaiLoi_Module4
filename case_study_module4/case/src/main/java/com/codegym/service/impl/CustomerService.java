package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

//    @Override
//    public Page<Customer> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<Customer> findAllByBlogNameContaining(String search, Pageable pageable) {
//        return null;
//    }
}
