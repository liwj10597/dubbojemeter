/**
 * Copyright       (C), 2017-2018, 浙江执御信息技术有限公司
 * FileName:       DubboJmeterController
 * Author:         Aubrey
 * Date:           2018/6/19 9:34
 * Description:    测试类
 */
package com.jollycorp.data.web;

import com.jollychic.data.api.userprofile.TagRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/dubbojmeter")
public class DubboJmeterController {
    @Autowired
    private  TagRiskService tagRiskService;

    @RequestMapping(value="/querytags", method=RequestMethod.POST)
    @ResponseBody
    public void querytags(String cookieId) {
        tagRiskService.getUserTagInfo(cookieId, new String[]{});
    }
}
