package com.atguigu.spzx.user.service.impl;

import com.atguigu.spzx.common.service.exception.GuiguException;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.user.service.SmsService;
import com.atguigu.spzx.utils.HttpUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void sendValidateCode(String phone) {
        String code = redisTemplate.opsForValue().get("phone:code:" + phone);
        if (StringUtils.hasText(code)) {
            return;
        }
        // 生成验证码
        String validateCode = RandomStringUtils.randomNumeric((4));
        // 将验证码存入redis
        redisTemplate.opsForValue().set("phone:code:" + phone, validateCode, 5, TimeUnit.MINUTES);
        // 将验证码发送给用户
        sendSms(phone, validateCode);
    }

    private void sendSms(String phone, String validateCode) {
        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "457914d2f0224eae8de38b50b1688ce1";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:"+validateCode);
        bodys.put("template_id", "CST_ptdie100");  //该模板为调试接口专用，短信下发有受限制，调试成功后请联系客服报备专属模板
        bodys.put("phone_number", phone);


        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuiguException(ResultCodeEnum.SYSTEM_ERROR);
        }
    }

}
