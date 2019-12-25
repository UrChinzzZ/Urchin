/**
*@author :Kevin  Ding
*@Date :2019年10月17日-下午1:57:43
*@Description :定时任务
**/
package com.urchin.kevin.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo {
	/**
	 * 获取时间
	 * @return 当前系统时间
	 */
	public static String  getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 启动定时任务
	 */
	public static void startTimer() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("task run:"+getCurrentTime());
				try {
					Thread.sleep(1000*3);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 1000*5,1000*10);//该任务延迟5秒后执行，然后会每隔10秒重复执行
		/*调用了 timer.schedule(task, 1000*5,1000*10); 这个含义是该任务延迟5秒后执行，然后会每隔10秒重复执行。我们观察输出信息中打印的时间，是与预期一样的。 
		另外可以看出，间隔是以任务开始执行时间为起点算的，也就是并不是任务执行完成后再等待10秒。*/
	}
	
	public static void main(String[] args) {
		System.out.println("main run:"+getCurrentTime());
		startTimer();
	}
}
