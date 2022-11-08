package com.momo.middle.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 處理 JSON 物件或 JSON 相關使用。
 * @author yqchen 2011/05/04
 */
@SuppressWarnings("unchecked")
public class JsonUtil {

  /**
   * 將 JSON 物件轉換成 Java 物件。
   * @param obj JSONObject or JSONArray. 
   * @return Java Object. (JSONObject switch to HashMap, JSONArray switch to ArrayList.)
   * @author yqchen 2011.5.16
   */
  public static Object switchJSON(Object obj) {
    if (obj == null) {
      return null;
    }
    Object rtnObj;
    if ("net.sf.json.JSONArray".equals(obj.getClass().getName())) {
      ArrayList al = new ArrayList();
      JSONArray jArr = (JSONArray) obj;
      for (int i = 0; i < jArr.size(); i++) {
        al.add(switchJSON(jArr.get(i)));
      }
      rtnObj = al;
    } else if ("net.sf.json.JSONObject".equals(obj.getClass().getName())) {
      HashMap hm = new HashMap();
      JSONObject jObj = (JSONObject) obj;
      if (jObj == null || jObj.isNullObject()) return null;
      for (Iterator iter = jObj.keys(); iter.hasNext();) {
        Object key = iter.next();
        hm.put(switchJSON(key), switchJSON(jObj.get(key)));
      }
      rtnObj = hm;
    } else if ("net.sf.json.JSONNull".equals(obj.getClass().getName())) {
      rtnObj = null;
    } else if (obj.getClass().isArray()) {
      rtnObj = switchJSON(JSONArray.fromObject(obj));
    } else if ("java.lang.Boolean".equals(obj.getClass().getName())) {
      rtnObj = ((Boolean) obj).booleanValue();
    } else if ("java.lang.Integer".equals(obj.getClass().getName())) {
      rtnObj = ((Integer) obj).intValue();
    } else if ("java.lang.Long".equals(obj.getClass().getName())) {
      rtnObj = ((Long) obj).longValue();
    } else if ("java.lang.Double".equals(obj.getClass().getName())) {
      rtnObj = ((Double) obj).doubleValue();
    } else if ("java.lang.String".equals(obj.getClass().getName())) {
      rtnObj = obj.toString();
    } else {
      rtnObj = obj;
    }
    return rtnObj;
  }
  
  /**
   * 將 JSON 或 Java(能轉成JSON的)物件轉換成 Java Bean 物件。
   * @param obj - JSONObject or Java Object(be able to change to JSON format)
   * @param c - Java Bean Class. 
   * @return Java Bean Object.If object or class is null, return null.If error return null too.
   * @author yqchen 2011.5.18
   */
  public static Object switchJSON2Bean(Object obj, Class c) {
    if (obj == null || c == null) {
      return null;
    }
    Object rtnObj = null;
    try {
      if ("net.sf.json.JSONObject".equals(obj.getClass().getName())) {
        JSONObject jObj = (JSONObject) obj;
        rtnObj = JSONObject.toBean(jObj, c);
      } else {
        try {
          Object jsonObj = JSONObject.fromObject(obj);
          rtnObj = switchJSON2Bean(jsonObj, c);
        } catch (Exception e) {
          rtnObj = switchJSON(obj);
        }
      }
    } catch (Exception e) {
      rtnObj = null;
    }
    return rtnObj;
  }
  
  /**
   * 將傳入的List內的JSON物件轉換成 Java Bean 物件。
   * @param list - 內含JSON物件的List。
   * @param c - Java Bean Class.
   * @return 轉換後的List，若參數有誤則回傳null。
   * @author yqchen 2011.10.27
   */
  public static List switchJSON2Bean4List(List list, Class c) {
    if (ComnUtil.isEmpty(list) || c == null) {
      return null;
    }
    List rtnLt = new ArrayList();
    for (int i = 0; i < list.size(); i++) {
      rtnLt.add(switchJSON2Bean(list.get(i), c));
    }
    return rtnLt;
  }
  
  /**
   * 將傳入的Map內的JSON物件轉換成 Java Bean 物件。
   * @param map - 內含JSON物件的Map。
   * @param c - Java Bean Class.
   * @return 轉換後的List，若參數有誤則回傳null。
   * @author yqchen 2011.10.27
   */
  public static Map switchJSON2Bean4Map(Map map, Class c) {
    if (ComnUtil.isEmpty(map) || c == null) {
      return null;
    }
    Map rtnMap = new HashMap();
    for(Iterator iter = map.keySet().iterator(); iter.hasNext();) {
      Object key = iter.next();
      rtnMap.put(key, switchJSON2Bean(map.get(key), c));
    }
    return rtnMap;
  }

}
