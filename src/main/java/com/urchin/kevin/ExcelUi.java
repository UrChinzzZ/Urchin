/**
*@author :Kevin  Ding
*@Date :2019年10月17日-下午2:51:00
*@Description :GUI 界面 Excel导入处理
**/
package com.urchin.kevin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import com.urchin.kevin.util.ExcleUtil;
@SuppressWarnings("all")
public class ExcelUi extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblPath;
	
	private JTextField txtPath;//选择后显示路径
	
	private JButton btn;//文件夹选择按钮
	
	private JButton ioBtn;//确认导入按钮
	
	private JTextField message;//导入成功后提示信息

	private JFileChooser chooser;//文件选择器;
	
	private List<Map> excelData = new ArrayList<>();//存放读取到的Excel数据
	
	/*数据库连接
	 * @return
	 */
	public static NutDao getDao() {
		SimpleDataSource dataSource = new SimpleDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/a");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
	
    public ExcelUi() {
    	initLayout();
    	initComponents();
    }
    
    
    public static void main(String[] args) {
		ExcelUi ui = new ExcelUi();
		ui.setVisible(true);
	}
	
	/**
	 * 初始化面板和属性
	 */
	private void initLayout() {
		this.setTitle("Excel导入工具");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//设置窗体居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		int windowsHeight = this.getHeight();
		int windowsWidth = this.getWidth();
		
		this.setLocation(screenWidth/2 - windowsWidth/2, screenHeight/2 - windowsHeight/2);
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponents() {
		lblPath = new JLabel();
		lblPath.setSize(130,16);
		lblPath.setLocation(20,18);
		lblPath.setText("请选择文件:");
		
		// txtPath
        txtPath = new JTextField();
        txtPath.setSize(280, 34);
        txtPath.setLocation(102, 13);
        txtPath.setEditable(true);
        txtPath.setText(FileSystemView.getFileSystemView().getHomeDirectory().toString()); // 默认显示桌面路径
        txtPath.setText("C:\\Users\\user\\Desktop\\test\\wxExcel.xlsx"); // 默认显示桌面路径
        //文本框 存放提示信息
        message = new JTextField();
        message.setSize(100, 34);
        message.setLocation(102, 83);
        message.setEditable(true);
        message.setText("提示栏"); // 默认显示桌面路径
        
		//button
        btn = new JButton();
        btn.setText("选择");
        btn.setSize(65,20);
        btn.setLocation(50,150);
        ChooseListener chooseListener = new ChooseListener();
        btn.addActionListener(chooseListener);
        
        //确认导入按钮
        ioBtn = new JButton();
        ioBtn.setText("导入");
        ioBtn.setSize(65,20);
        ioBtn.setLocation(150,150);
        ImportListener importListener = new ImportListener();
        ioBtn.addActionListener(importListener);
        
        //添加组件
        add(lblPath);
        add(txtPath);
        add(btn);
        
        add(ioBtn);
        add(message);
        
        
	}
	
	 /**
	 *监听选择文件
	 */
	private class ChooseListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            chooseFile();//选择文件的方法
	        }
	    }
	
	/**
	 *文件导入监听
	 */
	private class ImportListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dataImport();//导入Excel的方法
		}
		
	}
	 /**
	  * 选择文件的方法
	  * 
	  */
		public void chooseFile() {
			// TODO Auto-generated method stub
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setMultiSelectionEnabled(false);
			chooser.showDialog(new JLabel(), "选择");
			File file = chooser.getSelectedFile();
			if (file.isDirectory()) {
				JOptionPane.showMessageDialog(null, "请选择xlxs文件");
				return;
			}else if (file.isFile()) {
				if (!file.getName().substring(file.getName().lastIndexOf(".")).equals(".xlsx")) {
					JOptionPane.showMessageDialog(null, "请选择xlsx文件");
					return;
				}
			    
				String fileAbsolutePath = file.getAbsolutePath();//获取文件绝对路径
				txtPath.setText(fileAbsolutePath);
				
				try {
					FileInputStream inputStream = new FileInputStream(fileAbsolutePath);
					List<Map> excel = ExcleUtil.readExcel(inputStream);
					if (!excel.isEmpty()&&excel.size()>0) {
						excelData = excel;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * 文件导入的方法
		 */
		public void dataImport() {
			List<Record> info = new  ArrayList<>();
			for (int i = 0; i < excelData.size(); i++) {
				String shop_id = excelData.get(i).get("shop_id").toString();
				Record record = new Record();
				record.put("shop_id", shop_id);
				record.put(".table", "shop");
				info.add(record);
			}
			Dao sqlDao = getDao();
			sqlDao.fastInsert(info);
			message.setText("数据已导入");
		}
		public void toMysql() {
			if (!excelData.isEmpty() && excelData.size()>0) {
				int i = 0;
				while (excelData.get(0).get("shop_id")!=null && !"".equals(excelData.get(0).get("shop_id"))) {
					String shop_id = excelData.get(i).get("shop_id").toString();
				}
			}
		}
		

}
