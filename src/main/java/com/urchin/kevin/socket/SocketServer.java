package com.urchin.kevin.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月13日-下午5:31:28
*@Description :TODO
**/
public class SocketServer {
	static String MSG = "...启动socket服务器...";
	public static void socket() {
	//1.初始化服务端Socket并绑定端口为8888
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.等待客户端的连接
			Socket socket = serverSocket.accept();
			//3.获取输入流,通过socket对象流，传递给缓冲字符流进行读取;
			BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			//4.读取一行数据;
			String str;
			//4.1升级，通过循环升级接受信息;
			while((str = bufferedReader.readLine()) != null){
				//5.输出打印
				System.out.println(str);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		System.out.println(MSG);
		socket();
	}
	
}

