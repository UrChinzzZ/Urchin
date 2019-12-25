/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午4:55:00
*@Description :管道通信
**/
package com.urchin.kevin.thread.comm.demo6;

import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipeline {
		private static void piped() throws Exception {
	        //面向于字符 PipedInputStream 面向于字节
			PipedWriter writer = new PipedWriter();
			PipedReader reader = new PipedReader();
			
			//输入输出流建立连接
			writer.connect(reader);
			//写入数据
			Thread thread1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("###running###");
					try {
						for (int i = 0; i < 10; i++) {
							writer.write(i+"");
							Thread.sleep(10);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}finally {
						try {
							writer.close();
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				}
			});
			
			//读取数据，并处理
			Thread thread2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("###running2###");
					int msg = 0;
					try {
						while ((msg = reader.read())!=-1) {
							System.out.println("msg={"+(char) msg+"}");
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});
			
			thread1.start();
			thread2.start();
		}
		
		public static void main(String[] args) throws Exception {
			piped();
		}
}
