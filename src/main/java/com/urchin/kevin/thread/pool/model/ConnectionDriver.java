/**
*@author :Kevin  Ding
*@Date :2019年10月21日-下午3:11:49
*@Description :TODO
**/
package com.urchin.kevin.thread.pool.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;


public class ConnectionDriver {
	//动态代理的处理器类
	static class ConnectionHandler implements InvocationHandler{

		/* (non-Javadoc)
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			Thread.sleep(1000);
			return null;
		}
		
	}
	//创建一个Connection的代理，在commit时休眠100毫秒
	//java.sql.Connection是一个接口，最终的实现是由数据库驱动提供方来实现。
	//我们通过动态代理构造一个Connection，仅仅用于示范。

	public static final Connection createConnection() {
		return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), 
				new Class<?>[]{Connection.class}, new ConnectionHandler());
		
	}
}
