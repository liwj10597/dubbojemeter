package com.jollycorp.data.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jollychic.data.api.model.SmsRiskValidateDto;
import com.jollychic.data.api.model.SmsRiskValidateResultDto;
import com.jollychic.data.api.risk.SmsRiskValidateService;
import com.jollychic.data.api.userprofile.TagRiskService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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

@Controller
public class TagsClient {
    @Reference(version = "1.0")
    TagRiskService tagRiskService;

    // 测试地址标签
    public String getAddressTagInfo() throws Exception{
        String id = "浙江省杭州市";
        String[] arrTags = new String[]{"A0001_001"};
        return tagRiskService.getAddressTagInfo(id,arrTags);
    }

    // 测试用户标签
    public String getUserTagInfo() {
        return tagRiskService.getUserTagInfo("015b113c-8e57-44b2-839b-82fd76934c14", new String[]{});
    }
}
