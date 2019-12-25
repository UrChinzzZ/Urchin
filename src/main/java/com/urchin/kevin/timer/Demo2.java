/**
*@author :Kevin  Ding
*@Date :2019年10月17日-下午2:14:09
*@Description :定时执行任务（重复固定时间点执行）每天的凌晨1点定时执行一个任务
**/
package com.urchin.kevin.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {
	
	public static String getCurrentTime() {
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return sdf.format(date);
	  }
	public static void startTimer() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("task run"+getCurrentTime());
				try {
					Thread.sleep(1000*2);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, buildTime(),1000*60*60*24);
	}
	
	/**处理时间 
	 * @return
	 */
	private static Date buildTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    Date time = calendar.getTime();
	    if (time.before(new Date())) {
	    	//若果当前时间已经是凌晨1点后，需要往后加1天，否则任务会立即执行。
	        //很多系统往往系统启动时就需要立即执行一次任务，但下面又需要每天凌晨1点执行，怎么办呢？
	        //很简单，就在系统初始化话时单独执行一次任务（不需要用定时器，只是执行那段任务的代码）
	    	time = addDay(time, 1);
		}
	    return time;
	}
	
	private static Date addDay(Date date,int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	
}
