package com.bwzhou.dao;

import com.bwzhou.entity.Street;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository

public class StreetRepository {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void  addStreet(Street street){
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.save(street);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Street> getList(Integer pageIndex,Integer pageSize){
        List<Street> list=new ArrayList<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        try {
            String hql="FROM Street";
            Query query = currentSession.createQuery(hql);
            query.setFirstResult((pageIndex-1)*pageSize);
            query.setMaxResults(pageSize);
            list=query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
