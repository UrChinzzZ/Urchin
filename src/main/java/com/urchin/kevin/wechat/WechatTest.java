package com.urchin.kevin.wechat;

import com.urchin.kevin.wechat.utils.WechatUtils;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月9日-下午4:09:19
*@Description :西瓜数据api接口测试
**/
public class WechatTest {
	public static void main(String[] args) {
		 String userid = "266706";
		 String secret = "12817c2d-7f79-46de-844a-e71d55b4fcc3";
		 String url = "http://openapi.xiguaji.com/v3/subsbiz/AddLevelHighPriority";
	     String params = "{\"wechatid\":\"xiguaxiaojun\",\"PriorityLevel\":\"1\"}";
		 String res = WechatUtils.post(url, params,userid,secret);
		 
		 System.out.println(res);
		 
	}
}

