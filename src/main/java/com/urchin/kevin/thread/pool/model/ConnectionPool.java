/**
*@author :Kevin  Ding
*@Date :2019年10月21日-下午3:22:56
*@Description :TODO
**/
package com.urchin.kevin.thread.pool.model;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
	//通过一个双向队列来维护连接
	private LinkedList<Connection> pool = new LinkedList<>();
	//构造函数，设定初始化连接池大小，并进行填充

	/**
	 * 
	 */
	public ConnectionPool(int initialSize) {
		super();
		for (int i = 0; i < initialSize; i++) {
			pool.addLast(ConnectionDriver.createConnection());
		}
	}
	//获取Connection，在mills内无法获取将返回null
	public Connection fetchConnection(long mils) throws Exception {
		synchronized (pool) {
			if (mils <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			}else {
				//超时等待模式
				long future = System.currentTimeMillis()+mils;
				long remaining = mils;
				while (pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					remaining = future - System.currentTimeMillis();
				}
				//条件满足（要么是超时，要么线程池容量非空。），处理任务
				Connection result = null;
				if (!pool.isEmpty()) {
					result = pool.removeFirst();
				}
				return result;
			}
		}
	}
	//释放connection
	public void relaseConnection(Connection connection) {
		synchronized (pool) {
			pool.addLast(connection);
			pool.notifyAll();
		}
	}
	
	
	
}
