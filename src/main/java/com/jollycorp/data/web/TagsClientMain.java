package com.jollycorp.data.web;



import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (c) 2013-2018 JOLLY INFORMATION TECHNOLOGY CO.LTD.
 * All rights reserved.
 * This software is the confidential and proprietary information of JOLLY
 * INFORMATION Technology CO.LTD("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with JOLLY.
 * Website：http://www.jollycorp.com
 * Created by chauncey on 18/6/7.
 */

/**
 * 短信风险验证服务测试
 */
public class TagsClientMain extends BaseTest {
    public final static Logger logger = Logger.getLogger(TagsClientMain.class);
    public static void main(String...args){
        JavaSamplerContext arg0 = new JavaSamplerContext(new Arguments());

        DubboJmeterController test = new DubboJmeterController();

        try {
            test.setupTest(arg0);
            test.runTest(arg0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAddressTagInfo() throws Exception{
        ClassPathXmlApplicationContext ac = getApplicationContext();
        TagsClient tagsClient = (TagsClient) ac.getBean("tagsClient");
        return tagsClient.getAddressTagInfo();
    }
}
