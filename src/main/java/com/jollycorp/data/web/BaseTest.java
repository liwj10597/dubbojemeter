package com.jollycorp.data.web;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	
    public ClassPathXmlApplicationContext getApplicationContext(){
        String[] s = new String[]{"applicationContext.xml"};
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(s);
        return ac;
    }

}

