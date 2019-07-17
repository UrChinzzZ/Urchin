/**
*@author :Kevin  Ding
*@Date :2019年7月17日-下午2:39:03
*@Description :JFrame设计计算器
**/
package com.urchin.DesignPatterns.FactoryModel.SimpleFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcDemo extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//创建面板标签按钮控件
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JTextField field3 = new JTextField();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();
	//主方法
	public static void main(String[] args) {
		new CalcDemo();
		System.out.println("SB书豪");
	}
	//计算方法
	private void calculate(int operators) {
        try {
            double num1 = Double.parseDouble(field1.getText());
            double num2 = Double.parseDouble(field2.getText());
            switch (operators) {
                case 1:
                    field3.setText((num1 + num2) + "");
                    break;
                case 2:
                    field3.setText((num1 - num2) + "");
                    break;
                case 3:
                    field3.setText((num1 * num2) + "");
                    break;
                case 4:
                    field3.setText((num1 / num2) + "");
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入正确的数值!!!", "警告", 1);
        }
    }
	//面板初始化
	 private void init() {
	        this.setSize(300, 300);
	        label1.setText("第一个数：");
	        label2.setText("第二个数：");
	        label3.setText("结果：");
	        button1.setText("加法");
	        button2.setText("减法");
	        button3.setText("乘法");
	        button4.setText("除法");
	        label1.setBounds(10, 10, 100, 22);
	        label2.setBounds(10, 35, 100, 22);
	        label3.setBounds(10, 60, 100, 22);
	        field1.setBounds(110, 10, 100, 22);
	        field2.setBounds(110, 35, 100, 22);
	        field3.setBounds(110, 60, 100, 22);
	        button1.setBounds(10, 85, 100, 22);
	        button2.setBounds(110, 85, 100, 22);
	        button3.setBounds(110, 110, 100, 22);
	        button4.setBounds(10, 110, 100, 22);
	        //加入事件监听
	        button1.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	                calculate(1);
	            }
	        });
	        button2.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	                calculate(2);
	            }
	        });
	        button3.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	                calculate(3);
	            }
	        });
	        button4.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	                calculate(4);
	            }
	        });
	        //添加至页面布局
	        JPanel panel = (JPanel) this.getContentPane();
	        panel.setLayout(null);
	        panel.add(label1);
	        panel.add(label2);
	        panel.add(label3);
	        panel.add(field1);
	        panel.add(field2);
	        panel.add(field3);
	        panel.add(button1);
	        panel.add(button2);
	        panel.add(button3);
	        panel.add(button4);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	 
	    }
	public CalcDemo() {
		super("JFrame 计算器");
		try {
			init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	

}
