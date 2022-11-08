package com.momo.middle.util;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;


/**
 * UtilTool
 * @author Allen 2013/06/19
 */
public class UtilTool {
	
	private UtilTool() {
	}
	
	/**
	 * true:成功, false:失敗 
	 * @param insert
	 * @return
	 * @author Allen 2013/07/03
	 */
	public static boolean convterResult(int result) {
		if (result == 0) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
	/**
	 * 取得固定的JSONObject
	 * @param isError
	 * @return
	 * @author Allen 2013/07/03
	 */
	public static JSONObject getActiveJSONObject(boolean isError) {
		JSONObject obj = new JSONObject();
		if (isError) {
			obj.put("result", "-1");
			obj.put("token", Data.EMPTY);
			obj.put("user_id", Data.EMPTY);
		} else {
			obj.put("result", "0");
		}
		return obj;
	}
	
	/**
	 * 物件轉換成字串
	 * @param obj
	 * @return
	 * @author Allen 2013/07/03
	 */
	public static String obj2Str(Object obj) {
		String str = Data.EMPTY;
		if (obj != null) {
			str = StringUtils.trim(obj.toString());
		}
		return str;
	}
	
	/**
	 * getPrintStackTrace
	 * @param e
	 * @return
	 * @author Allen 2013/07/03
	 */
	public static String getPrintStackTrace(Throwable e) {
		StringBuffer sRtn = new StringBuffer(e.toString()).append("\n");
		StackTraceElement[] traceAry = e.getStackTrace();
		for (StackTraceElement trace : traceAry){
			sRtn.append("\tat ").append(trace).append("\n");
		}
		return sRtn.toString();
	}
	
}
