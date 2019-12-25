/**
*@author :Kevin  Ding
*@Date :2019年8月2日-下午2:17:50
*@Description :数据操作流DataOutputStream和DataInputStream的使用
**/
package com.urchin.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
	public static void main(String[] args)  {
			DataOutputStream outputStream = null;
			String pathname = "C:\\test";
			File file = new File(pathname + File.separator + "order.txt");
			String proNames[] = {"书豪的键盘","书豪的狗头","纪儿的狗头"};
			Float prices[] = {99.9f,1.2f,1.3f};
			int nums[] = {5,1,1};
			try {
				outputStream = new DataOutputStream(new FileOutputStream(file));
				for (int i = 0; i < proNames.length; i++) {
					outputStream.write(proNames[i].getBytes());
					outputStream.writeChars("\t");
					outputStream.writeFloat(prices[i]);
					outputStream.writeChars("\t");
					outputStream.writeInt(nums[i]);
					outputStream.writeChars("\n");
				}
				outputStream.close();
				System.out.println("完成");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
