package com.codegym.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(int id, String name, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
