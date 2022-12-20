package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product ").getResultList();
        }finally {
            if (session != null){
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
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
       Session session = null;
       Product product = null;
       try {
           session = ConnectionUtil.sessionFactory.openSession();
           product = (Product)session.createQuery("from Product where id = :nyc")
                   .setParameter("nyc",id)
                   .getSingleResult();
       }finally {
           if (session != null){
               session.close();
           }
       }
       return product;
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = (List<Product>) session.createQuery("from Product where name like CONCAT ('%',:nyc,'%' )")
                    .setParameter("nyc",name)
                    .getResultList();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
    }
}