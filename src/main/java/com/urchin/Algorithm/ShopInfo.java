/**
*@author :Kevin  Ding
*@Date :2019年7月17日-上午11:54:31
*@Description :百度外卖店铺信息网页版爬取
**/
package com.urchin.Algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ShopInfo {
	public static void main(String[] args) {
		
		String url = "https://star.ele.me/waimai/shop/157867683";
		Document document = null;
		List <String> info = new ArrayList<>();
		try {
			 document = Jsoup.connect(url).get();
			 String shopName = document.select(".all-show").text();
			 System.out.println("店铺名称"+shopName);
			 String type = document.select(".b-info dl").first().text();
			 System.out.println("店铺类型"+type);
			 String time = document.select(".b-info dl").get(1).text();
			 System.out.println("营业时间"+time);
			 String address = document.select(".b-info dl").get(2).text();
			 System.out.println("店铺地址"+address);
			 info.add(address);
			 info.add(shopName);
			 info.add(time);
			 info.add(type);
			 String path="c://test//shop.txt";
			 File file=new File(path);
			 
			 if (!file.exists()) {
					file.getParentFile().mkdirs();
				}
			 
			 FileWriter fw = new FileWriter(file, true);
		     BufferedWriter bw = new BufferedWriter(fw);
		     
		     for (String string : info) {
				bw.write(string);
				bw.newLine();
			}
		     
		    if (bw != null) {
				bw.close();
			} 
		    if (fw != null) {
				fw.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
