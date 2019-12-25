/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午3:42:03
*@Description :java 多线程处理一个list的集合
**/
package com.urchin.kevin.thread.list.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.nutz.dao.entity.Record;

public class App {
	public static void main(String[] args) {
		//模拟1000条数据
		try {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				list.add(i+",");
			}
			
			//对数据进行操作
            System.out.println(list2Str(list, 2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * @param list  需要处理的list数据
	 * @param nThreads 开启的线程个数
	 * @return  多线程拼接后的数据
	 * @throws Exception
	 */
	public static String list2Str(List<String> list,final int nThreads) throws Exception {
		if (list == null || list.isEmpty()) {
			return "无数据";
		}
		StringBuffer ret = new StringBuffer();
		int size = list.size();//数据的长度
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);//线程池,开启nThread个线程
		List<Future<String>> futures = new ArrayList<>();//用来封装每个子程返回的结果信息
		for (int i = 0; i < nThreads; i++) {//根据线程个数开启任务
			final List<String> subList = list.subList(size/nThreads * i, size/ nThreads * (i + 1));//对传过来的数据进行截取
			Callable<String> task = new Callable<String>() { //callable接口 存在返回值
				
				@Override
				public String call() throws Exception {//每个线程执行的方法call()方法，存在返回值
					// TODO Auto-generated method stu  
					String id = null;
					String shop_id = null;
					String lon = null;
					String lat = null;
					String shop_img = null;
					String shop_url = "http://www.dianping.com/shop/"+shop_id;
					Record record = new Record();
					record.put("id", id);
					record.put("shop_id", shop_id);
					record.put("lon", lon);
					record.put("lat", lat);
					record.put("shop_img", shop_img);
					record.put("shop_url", shop_url);
					record.put(".table", "shop_url_task");
					
					
                    StringBuffer sb = new StringBuffer();
                    for (Object str : subList) {//遍历截取对应长度的集合,并拼接(对每个线程截取的数据进行操作)
                        sb.append(str);
                    }
					return sb.toString();
				}
			};
			futures.add(executorService.submit(task));//执行每个子程，并将返回的结果加入list中
		}
		for (Future<String> future : futures) {
			ret.append(future.get());//遍历输出结果集
		}
		executorService.shutdown();//关闭线程池
		return ret.toString();
	}
}
