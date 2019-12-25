package com.urchin.kevin.wechat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月9日-下午4:06:37
*@Description :TODO
**/
public class WechatUtils {
//	final static String userid="123456";
//	final static String secret="ded15192-6275-4cc4-be22";
//	final static String url = "http://openapi.xiguaji.com/v3/subsbiz/AddLevelHighPriority";
//        final static String params = "{\"wechatid\":\"xiguaxiaojun\",\"PriorityLevel\":\"1\"}";
	/**
     * 发送HttpPost请求
     * 
     * @param strURL
     *            服务地址
     * @param params
     *            json字符串,例如: "{ \"id\":\"12345\" }"
     * @return 成功:返回json字符串<br/>
     */
    public static String post(String strURL, String params,String userid,String secret) {
        String checksum= GenCheckSum(params,secret);
        BufferedReader reader = null;
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            
            connection.setRequestProperty("userid", userid);
            connection.setRequestProperty("checksum",checksum);
            
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();
            
            return res;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error"; // 自定义错误信息
    }
    
    
    /**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		  int len=md5code.length();  
                  for (int i = 0; i < 32 - len; i++) {  
                   md5code = "0" + md5code;  
                  }
		return md5code;
	}
	
	public static String GenCheckSum(String body,String secretkey) {
		 String s = body + secretkey;
		 String sign = md5(s);
		 sign= sign.substring(14, 18);
		 return sign.toLowerCase();
	}
}


