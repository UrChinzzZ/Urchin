package com.urchin.kevin.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月13日-下午6:26:27
*@Description :TODO
**/
public class SocketClient {
	public static void client() {
		//1.创建socket对象，建立到服务i端的连接;
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			//2.通过缓冲输出流，包装下socket对象的输出字节流，进行写操作;
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
			//通过标准输入流获取字符流;
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in,"GBK"));
			//循环升级；
			while(true){
				String str=bufferReader.readLine();
				bufferedWriter.write(str);
				bufferedWriter.write("\n");
				//3.2还需要将缓冲中的内容放到socket
				bufferedWriter.flush();
			}
//			socket.shutdownOutput();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		client();
	}
}

