package com.wangz.sms.utils;

import java.util.HashMap;

/**
 * @ClassName SmsSender
 * @Auther: wz1016_vip@163.com
 * @Date: 2019/6/9 13:04
 * @Description: TODO 短信发送接口
 */
public class SmsSender {
    private static final String URL = "https://dx.ipyy.net/sms.aspx";
    // 签名
    private static final String SIGNATURE = "【SIGNATURE】";

    /**
     * @param content 短信内容
     * @param mobile 手机号
     * @return
     */
    public static boolean send(String content,String mobile){
        HashMap<String, String> map = new HashMap<>();
        map.put("action","send");
        map.put("userid","");
        map.put("account","hualian");
        map.put("password","hualian0282");
        map.put("mobile",mobile);
        map.put("code","8");
        map.put("content",SIGNATURE + content);
        map.put("sendTime","");
        map.put("extno","");
        String callback = HttpClientUtil.doPost(URL,map);
        return callback.contains("Success");
    }

    public static void main(String[] args) {
        boolean send = send("hello sms!", "17316290556");
        System.out.println("发送状态："+send);
    }
}
