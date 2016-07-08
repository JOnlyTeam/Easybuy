package com.geek.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");     
    @Test  
    public void testBean() throws Exception{  
        TestAction testAction = (TestAction) ac.getBean("testAction");  
        System.out.println(testAction);  
    }
    
    @Test
    public void testTransaction() throws Exception{  
        TestService testService=(TestService)ac.getBean("testService");  
        testService.saveTwoUsers();  
    } 
}
