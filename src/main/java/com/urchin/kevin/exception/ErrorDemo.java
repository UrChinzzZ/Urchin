package com.urchin.kevin.exception;
/**
*@author      :Kevin  Ding
*@Date        :2019年12月18日-下午2:31:12
*@Description :自定义异常
**/
@SuppressWarnings("all")
public class ErrorDemo {
	/**自定义抛出异常的方法
	 * @param r
	 * @throws Exception
	 */
	private static void errorThrows(int r) throws Exception {
		if (r < 0) {
			throw new Exception(">>>>不能为负数");
		}
	}
	public static void main(String[] args) {
		int r;
		r = -1;
		try {
			errorThrows(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

