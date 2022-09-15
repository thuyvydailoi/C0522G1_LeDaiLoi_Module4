package com.codegym.repository.impl;


import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("From Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.rollback();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery(" from Product s where s.id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(findById(id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product p where p.name like ?1").setParameter(1, "name").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}