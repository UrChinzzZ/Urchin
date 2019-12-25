/**
*@author :Kevin  Ding
*@Date :2019年10月22日-下午2:39:02
*@Description :将list导出成Excel格式的文件
**/
package com.urchin.kevin;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

public class ToExcel {
	/*数据库连接
	 * @return
	 */
	public static NutDao getDao() {
		SimpleDataSource dataSource=new SimpleDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/a");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
	
	public static HSSFCell getCell(HSSFSheet sheet,int row,int col) {
		HSSFRow sheetRow = sheet.getRow(row);
		if (sheetRow == null) {
			sheetRow = sheet.createRow(row);
		}
		HSSFCell cell = sheetRow.getCell(col);
		if (cell == null) {
			cell = sheetRow.createCell(col);
		}
		return cell;
	}
	
	public static void setText(HSSFCell cell,String text) {
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(text);
	}
	
	public static void toExcel(List<String> titles,List<Record> data) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(); // 定义一个新的工作簿
		HSSFSheet sheet = wb.createSheet("第一个Sheet页"); // 创建第一个Sheet页
		  // 创建单元格，并设置值表头 设置表头居中  
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 创建一个居中格式  
		HSSFRow row = sheet.createRow(0);// 创建一个行

		HSSFCell cell = row.createCell(0);// 创建一个单元格  第1列
		HSSFCell cell2 = row.createCell(1);
		
		for (int i = 0; i < titles.size(); i++) {//设置标题
			String title = titles.get(i);
			cell = getCell(sheet, 0, i);
			cell2 = getCell(sheet, 0, i+1);
			setText(cell, title);
			setText(cell2, title);
			cell.setCellStyle(style);
			cell2.setCellStyle(style);
		}
		
		for (int i = 0; i < data.size(); i++) {// 给单元格设置值
			Record r = data.get(i);
			for (int j = 0; j < titles.size(); j++) {
//				String value = r.getString("shop_id"+(j+1)) != null ? r.getString("shop_id"+(j+1)):"";
				String value = r.getString("shop_id");
				String id = r.getString("id");
				cell = getCell(sheet, i+1, j);
				cell2 = getCell(sheet, i+1, j+1);

				setText(cell, value);
				setText(cell2, id);
				cell.setCellStyle(style);
				cell2.setCellStyle(style);

			}
		}
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\shop_id.xls");
		wb.write(fileOutputStream);
		fileOutputStream.close();
		wb.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		Dao dao = getDao();
		List<Record> data = dao.query("shop", null);
//		System.out.println(data.toArray().toString());
		List<String> titles = new ArrayList<>();
		titles.add("shop_id");
		titles.add("id");
		toExcel(titles, data);
		System.out.println("已生成Excel");
		
	}

}
