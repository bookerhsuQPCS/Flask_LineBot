package com.momo.middle.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import tmax.webt.WebtBuffer;
import tmax.webt.WebtConnection;
import tmax.webt.WebtConnectionPool;
import tmax.webt.WebtException;
import tmax.webt.WebtField;
import tmax.webt.WebtFieldSet;
import tmax.webt.WebtRemoteService;
import tmax.webt.WebtServiceFailException;
import tmax.webt.WebtSystem;

/**
 * 呼叫Tmax的Util<br>
 * 直接拿momoshop的來使用
 * @author Allen 2013/08/13
 */
public class WebtUtil implements Serializable {

	private static final long serialVersionUID = 2391274829828831784L;
	
	private final static Logger logger = Logger.getLogger(WebtUtil.class);
	
	/**
	 * 呼叫Tmax回傳List格式資料
	 * @param pool
	 * @param svcname
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List serviceCallL(String pool, String svcname, HashMap map) {
	    WebtConnection con = null;
	    WebtRemoteService service = null;
	    WebtBuffer rcvbuf;
	    List result = new ArrayList();

	    try {
	    	con = WebtConnectionPool.getConnection(pool);
	    	service = new WebtRemoteService(svcname, con);
	    	WebtFieldSet sndset = new WebtFieldSet(service.createFieldBuffer());
	    	
	    	if (map != null) {
	    		Set keySet = map.keySet();
	    		Iterator it = keySet.iterator();
	    		while(it.hasNext()) {
	    			String col = (String)it.next();
	    			sndset.add(col, nvl((String)map.get(col)));
	    		}
	    	}
	    	
	    	rcvbuf = service.tpcall(sndset.getFieldBuffer());
	    	List fieldNames = rcvbuf.getFieldKeyNames();
	    	List fieldList = rcvbuf.getFields();
	    	int colcnt = fieldList.size();
	    	int rowcnt = 0;
	    	
	    	for (int i=0; i<colcnt; i++) {
	    		rowcnt = Math.max(rowcnt, ((WebtField)fieldList.get(i)).size());
	    	}
	    	for (int i=0; i<rowcnt; i++) {
	    		HashMap rowdata = new HashMap();
	    		for (int j=0; j<colcnt; j++) {
	    			String colName = (String)fieldNames.get(j);
	    			WebtField field = (WebtField)fieldList.get(j);
	    			if (field.size() > i) {
	    				setResultField(field, colName, rowdata, i);
	    			}
	    		}
	    		result.add(rowdata);
	    	}
	    } catch (WebtServiceFailException se) {
	      String errMsg = svcname + " -> " + se.getTPErrorMessage() + "\n" + se.getReceiveBuffer().getField("E_MSG").get(0).stringValue();
	      WebtSystem.userLog("serviceCallV -> Service Fail : " + errMsg);
	      WebtSystem.userLog(se.getMessage());
	      result = null;
	    } catch (WebtException e) {
	      String errMsg = svcname + " -> " + e.getTPErrorMessage();
	      WebtSystem.userLog("serviceCallV -> Service  : " + errMsg);
	      WebtSystem.userLog(e.getMessage());
	      result = null;
	    } catch (Exception e) {
	      result = null;
	    } finally {
	    	if (con != null) con.close();
	    }
	    return result;
	  }
	
	/**
	 * 呼叫Tmax回傳List格式資料
	 * @param pool
	 * @param svcname
	 * @param reqlist
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List serviceCallLArr(String pool, String svcname, List reqlist) {
		  WebtConnection con = null;
		  WebtRemoteService service = null;
		  WebtBuffer rcvbuf;
		  List result = new ArrayList();

		  try {
			  con = WebtConnectionPool.getConnection(pool);
			  service = new WebtRemoteService(svcname, con);
			  WebtFieldSet sndset = new WebtFieldSet(service.createFieldBuffer());
			  
			  if (reqlist != null) {
				  for (int i=0; i<reqlist.size(); i++) {
					  HashMap req = (HashMap)reqlist.get(i);
					  Set keySet = req.keySet();
					  Iterator it = keySet.iterator();
					  while(it.hasNext()) {
						  String col = (String)it.next();
						  sndset.add(col, nvl((String)req.get(col)));
					  }
				  }
			  }

			  rcvbuf = service.tpcall(sndset.getFieldBuffer());
			  List fieldNames = rcvbuf.getFieldKeyNames();
			  List fieldList = rcvbuf.getFields();
			  int colcnt = fieldList.size();
			  int rowcnt = 0;
			  
			  for (int i=0; i<colcnt; i++) {
				  rowcnt = Math.max(rowcnt, ((WebtField)fieldList.get(i)).size());
			  }
			  for (int i=0; i<rowcnt; i++) {
				  HashMap rowdata = new HashMap();
				  for (int j = 0; j < colcnt; j++) {
					  String colName = (String)fieldNames.get(j);
					  WebtField field = (WebtField)fieldList.get(j);
					  if (field.size() > i) {
						  setResultField(field, colName, rowdata, i);
					  }
				  }
				  result.add(rowdata);
			  }
		  } catch (WebtServiceFailException se) {
			  String errMsg = svcname + " -> " + se.getTPErrorMessage() + "\n" + se.getReceiveBuffer().getField("E_MSG").get(0).stringValue();
			  WebtSystem.userLog("serviceCallV -> Service Fail : " + errMsg);
			  WebtSystem.userLog(se.getMessage());
			  result = null;
		  } catch (WebtException e) {
			  String errMsg = svcname + " -> " + e.getTPErrorMessage();
			  WebtSystem.userLog("serviceCallV -> Service  : " + errMsg);
			  WebtSystem.userLog(e.getMessage());
			  result = null;
		  } catch (Exception e) {
			  result = null;
		  } finally {
			  if (con != null) con.close();
		  }
		  return result;
	  }
	
	/**
	 * 呼叫Tmax回傳HashMap格式資料
	 * @param pool
	 * @param svcname
	 * @param sendfld
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap serviceCallH(String pool, String svcname, Map sendfld) throws Exception {
		  WebtConnection con = null;
		  WebtRemoteService service = null;
		  WebtBuffer rcvbuf;
		  HashMap rowdata = new HashMap();
		  
		  try {
			  con = WebtConnectionPool.getConnection(pool);
			  service = new WebtRemoteService(svcname, con);
			  WebtFieldSet sndset = new WebtFieldSet(service.createFieldBuffer());
			  
			  if (sendfld != null) {
				  Set keySet = sendfld.keySet();
				  Iterator it = keySet.iterator();
				  while(it.hasNext()) {
					  String col = (String)it.next();
					  sndset.add(col, nvl((String)sendfld.get(col)));
				  }
			  }
			  
			  rcvbuf = service.tpcall(sndset.getFieldBuffer());
			  List fieldNames = rcvbuf.getFieldKeyNames();
			  List fieldList = rcvbuf.getFields();
			  int colcnt = fieldList.size();
			  
			  for (int i=0; i<colcnt; i++) {
				  String colName = (String)fieldNames.get(i);
				  WebtField field = (WebtField)fieldList.get(i);
				  setResultField(field, colName, rowdata, 0);
			  }
		  } catch (WebtServiceFailException se) {
			  String errMsg = svcname + " -> " + se.getTPErrorMessage() + "\n" + se.getReceiveBuffer().getField("E_MSG").get(0).stringValue();
			  WebtSystem.userLog("serviceCallH -> Service Fail : " + errMsg);
			  WebtSystem.userLog(se.getMessage());
			  rowdata = null;
		  } catch (WebtException e) {
			  String errMsg = svcname + " -> " + e.getTPErrorMessage();
			  WebtSystem.userLog("serviceCallH -> Service  : " + errMsg);
			  WebtSystem.userLog(e.getMessage());
			  rowdata = null;
		  } catch (Exception e) {
			  rowdata = null;
			  throw e;
		  } finally {
			  if (con != null) con.close();
		  }
		  return rowdata;
	  }

	/**
	 * 呼叫Tmax回傳HashMap格式資料
	 * @param pool
	 * @param svcname
	 * @param reqlist
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap serviceCallHArr(String pool, String svcname, List reqlist) {
		  WebtConnection con = null;
		  WebtRemoteService service = null;
		  WebtBuffer rcvbuf;
		  HashMap rowdata = new HashMap();
		  
		  try {
			  con = WebtConnectionPool.getConnection(pool);
			  
			  logger.debug("Tmax Webt connection > " + con);
			  
			  if(con!=null){
				  logger.debug("Connection Address > " + con.getAddress());
				  logger.debug("Connection Port > " + con.getPort());
			  }
			  
			  service = new WebtRemoteService(svcname, con);
			  WebtFieldSet sndset = new WebtFieldSet(service.createFieldBuffer());
			  
			  if (reqlist != null) {
				  for (int i=0; i<reqlist.size(); i++) {
					  HashMap req = (HashMap)reqlist.get(i);
					  Set keySet = req.keySet();
					  Iterator it = keySet.iterator();
					  while(it.hasNext()) {
						  String col = (String)it.next();
						  sndset.add(col, nvl((String)req.get(col)));
					  }
				  }
			  }
			  
			  rcvbuf = service.tpcall(sndset.getFieldBuffer());
			  List fieldNames = rcvbuf.getFieldKeyNames();
			  List fieldList = rcvbuf.getFields();
			  int colcnt = fieldList.size();
			  
			  for (int i=0; i<colcnt; i++) {
				  String colName = (String)fieldNames.get(i);
				  WebtField field = (WebtField)fieldList.get(i);
				  setResultField(field, colName, rowdata, 0);
			  }
		  } catch (WebtServiceFailException se) {
			  String errMsg = svcname + " -> " + se.getTPErrorMessage() + "\n" + se.getReceiveBuffer().getField("E_MSG").get(0).stringValue();
			  WebtSystem.userLog("serviceCallH -> Service Fail : " + errMsg);
			  WebtSystem.userLog(se.getMessage());
			  rowdata = null;
		  } catch (WebtException e) {
			  String errMsg = svcname + " -> " + e.getTPErrorMessage();
			  WebtSystem.userLog("serviceCallH -> Service  : " + errMsg);
			  WebtSystem.userLog(e.getMessage());
			  rowdata = null;
		  } catch (Exception e) {
			  rowdata = null;
		  } finally {
			  if (con != null) con.close();
		  }
		  return rowdata;
	  }

	  @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setResultField(WebtField field, String colName, HashMap rowdata, int row) {
	    int fieldtype = field.getFieldType();
	    
	    switch(fieldtype) {
	    case WebtField.FB_CARRAY:
	    	rowdata.put(colName, field.get(row).bytesValue());
	    	break;
	    case WebtField.FB_CHAR:
	    	rowdata.put(colName, new Byte(field.get(row).byteValue()));
	    	break;
	    case WebtField.FB_DOUBLE:
	    	rowdata.put(colName, new Double(field.get(row).doubleValue()));
	    	break;
	    case WebtField.FB_FLOAT:
	    	rowdata.put(colName, new Float(field.get(row).floatValue()));
	    	break;
	    case WebtField.FB_INT:
	    	rowdata.put(colName, new Integer(field.get(row).intValue()));
	    	break;
	    case WebtField.FB_LONG:
	    	rowdata.put(colName, new Long(field.get(row).longValue()));
	    	break;
	    case WebtField.FB_SHORT:
	    	rowdata.put(colName, new Short(field.get(row).shortValue()));
	    	break;
	    case WebtField.FB_STRING:
	    	rowdata.put(colName, field.get(row).stringValue());
	    	break;
	    }
	  }

	  /**
	   * 若 字串變數 = Null或是空字串，回傳空字串
	   * @param str string
	   * @return String
	   * @author clcheng 2011.5.4
	   */
	  private static String nvl(String str) {
		  return (str == null || str.length() == 0) ? "" : str;
	  }
	
}
