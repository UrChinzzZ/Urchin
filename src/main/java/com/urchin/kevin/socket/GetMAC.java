package com.urchin.kevin.socket;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月18日-下午2:10:54
*@Description :获取MAC地址
**/
@SuppressWarnings("all")
public class GetMAC {
	private static void getMacAdress() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			byte [] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < mac.length; i++) {
				if (i != 0 ) {
					buffer.append("-");
				}
				String string = Integer.toHexString(mac[i] & 0xFF);
				buffer.append(string.length() == 1 ? 0 + string : string);
				System.out.println(buffer.toString().toUpperCase());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void errorThrow() throws Exception {
		try {
			int a = 1;
			int b = a/0;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("异常");
		}
	}
	public static void main(String[] args) throws Exception {
		getMacAdress();
//		errorThrow();
	}
}

