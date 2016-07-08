package com.geek.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geek.bean.EasybuyUser;

@Service("testService")  
public class TestService {  
      
    @Resource  
    private SessionFactory sessionFactory;  
      
    @Transactional  
    public void saveTwoUsers(){  
        Session session=sessionFactory.getCurrentSession();
        session.save(new EasybuyUser());  
        int a=1/0;//会抛异常,因为声明了事务,因此会回滚  
        session.save(new EasybuyUser());  
    }  
}  