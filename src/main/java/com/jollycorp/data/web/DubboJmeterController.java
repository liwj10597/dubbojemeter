/**
 * Copyright       (C), 2017-2018, 浙江执御信息技术有限公司
 * FileName:       DubboJmeterController
 * Author:         Aubrey
 * Date:           2018/6/19 9:34
 * Description:    测试类
 */
package com.jollycorp.data.web;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class DubboJmeterController extends AbstractJavaSamplerClient {

    ClassPathXmlApplicationContext ac = null;

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sr = new SampleResult();
        try {
            sr.sampleStart();
            // 地址标签
            //String result = getAddressTagInfo();
            // 用户标签
            String result = getUserTagInfo();
            if(result!=null){
                sr.setSuccessful(true);
                sr.setResponseData(result,"utf-8");
            }else {
                sr.setSuccessful(false);
            }
            sr.sampleEnd();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sr;
    }

    String getAddressTagInfo() throws Exception{
        ac = getApplicationContext();
        TagsClient tagsClient = (TagsClient) ac.getBean("tagsClient");
       return  tagsClient.getAddressTagInfo();
    }

    String getUserTagInfo() {
        ac = getApplicationContext();
        TagsClient tagsClient = (TagsClient) ac.getBean("tagsClient");
        return tagsClient.getUserTagInfo();
    }








    public ClassPathXmlApplicationContext getApplicationContext(){
        if (null == ac) {
            String[] s = new String[]{"applicationContext.xml"};
            ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(s);
            return ac;
        } else {
            return ac;
        }
    }


}