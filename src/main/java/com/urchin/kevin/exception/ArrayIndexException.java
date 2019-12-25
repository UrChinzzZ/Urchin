package com.urchin.kevin.exception;
/**
*@author      :Kevin  Ding
*@Date        :2019年12月18日-下午2:38:58
*@Description :自定义一个异常类
**/
public class ArrayIndexException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayIndexException() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "程序发生了越界异常,请检查下标变化";
	}
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ArrayIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 */
	public ArrayIndexException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 */
	public ArrayIndexException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cause
	 */
	public ArrayIndexException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}

