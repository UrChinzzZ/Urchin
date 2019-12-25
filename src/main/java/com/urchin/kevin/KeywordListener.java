/**
*@author :Kevin  Ding
*@Date :2019年10月15日-下午5:28:41
*@Description :TODO
**/
package com.urchin.kevin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class KeywordListener extends JFormattedTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel1 myPanel;
	public static void main(String[] args) {
		KeywordListener listener = new KeywordListener();
	}
	public KeywordListener() {
		myPanel = new MyPanel1();
		this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(400, 300);
        this.setVisible(true);
	}
	
	class MyPanel1 extends JPanel implements KeyListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getKeyCode());
			if (e.getKeyCode() == 32) {
				System.out.println("空格");
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
}
