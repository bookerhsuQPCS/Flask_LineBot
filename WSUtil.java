package com.momo.middle.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSUtil {
  private static Log exceptionLog = LogFactory.getLog("exception-save");
  private static Log couponExceptionLog = LogFactory.getLog("couponException-save");
  private static Log wsUtilLog = LogFactory.getLog("wsutil-save");
  /**
   * 以GET方式執行Http Request，並回傳Response值
   * @param url
   * @param timeout - the connect timeout value in milliseconds, zero is as an infinite timeout.
   * @return response value
   * @author fhchen 2014.08.07
   */
  public static String doGet(String url, int timeout, String charset) {
    StringBuffer rtn = new StringBuffer();
    HttpURLConnection conn = null;
    url = ComnUtil.nvl(url);
    try {
      // 記錄 Log
      StringBuffer log = new StringBuffer();
      log.append("\n=================================== GET ============================="
          + DateUtil.getDate(new Date(), "yyyy/MM/dd HH:mm:ss:sss"));
      URL urlObj = new URL(url);
      conn = (HttpURLConnection) urlObj.openConnection();
      conn.setRequestProperty("Content-Language", charset);
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setConnectTimeout(timeout); // 單位毫秒，< 0 會Exception， = 0即不限timeout時間
      conn.setReadTimeout(2000);// 5秒
      conn.setUseCaches(false);
      conn.setRequestMethod("GET");

      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

      String temp = null;
      while ((temp = br.readLine()) != null) {
        rtn.append(temp);
      }
      br.close();
      // 記錄 Log
      log.append("\n      url : ").append(url);
      log.append("\n  timeout : ").append(timeout);
      log.append("\n      rtn : ").append(rtn);
      log.append("\n======================================================================"
          + DateUtil.getDate(new Date(), "yyyy/MM/dd HH:mm:ss:sss"));
      
      wsUtilLog.info("[doGet()] " + log.toString());
    } catch (Exception e) {
      exceptionLog.error("url=[" + url + "] " + e.getMessage(), e);
      rtn.setLength(0);
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return rtn.toString();
  }
  
  /**
   * 以POST方式執行Http Request，並回傳Response值。 (簡易版，無setRequestProperty)
   * @param url - http url
   * @param parameter - post parameter
   * @param charset - response char set (ex. UTF-8, BIG5)
   * @param timeout - the connect timeout value in milliseconds, zero is as an infinite timeout.
   * @param Property setRequestProperty 
   * @return response value
   * @author nychen 2016/4/14 從mobile搬來
   */
  public static String doPost(String url, String parameter, String charset, int timeout , String Property) {
    
    StringBuffer rtn = new StringBuffer();
    HttpURLConnection conn = null;
    url=ComnUtil.nvl(url);
    try {
      URL urlObj = new URL(url);
      conn = (HttpURLConnection) urlObj.openConnection();
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setConnectTimeout(timeout); // 單位毫秒，< 0 會Exception， = 0即不限timeout時間
      conn.setReadTimeout(5000);// 5秒
      conn.setUseCaches(false);
      conn.setAllowUserInteraction(true);

      conn.setInstanceFollowRedirects(true); // 設此conn instance是否自動執行http redirect (預設值來自static method 
                                             // setFollowRedirects(boolean)，FollowRedirects沒指定時預設true.)
      conn.setRequestProperty("Content-Type", Property);
      conn.setRequestMethod("POST");
      
      // Send Request  ( conn.getOutputStream 會隱含的執行conn.connect() )
      DataOutputStream dataOS = new DataOutputStream(conn.getOutputStream());
      dataOS.writeBytes(parameter);
      dataOS.flush();
      dataOS.close();
      
      // Get Response
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
      String tmpLine;
      while((tmpLine = br.readLine()) != null) {
        rtn.append(tmpLine);
      }
      br.close();
      
    } catch (Exception e) {
      if (url.contains("coupon.momoshop.com.tw")) {
        couponExceptionLog.info("doPost Exceiption:", e);
        couponExceptionLog.info("coupon doPost Exceiption parameter: " + parameter);
      } else {
        exceptionLog.info("doPost Exceiption:", e);
      }
      rtn.setLength(0);
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return rtn.toString();
  }
  
  
  public static String doPost(String url, String parameter, int timeout ) {
    return doPost(url, parameter, "UTF-8", timeout , "application/json");
  }
  
  /**
   * 以GET方式執行Http Request，並回傳Response值
   * @param url
   * @param connectTimeout - the connect timeout value in milliseconds, zero is as an infinite timeout.
   * @param readTimeout
   * @return response value
   * @author fhchen 2014.08.07
   */
  public static String doGet(String url, int connectTimeout, int readTimeout) {
    StringBuffer rtn = new StringBuffer();
    HttpURLConnection conn = null;
    url = ComnUtil.nvl(url);
    try {
      // 記錄 Log
      StringBuffer log = new StringBuffer();
      log.append("\n=================================== GET ============================="
          + DateUtil.getDate(new Date(), "yyyy/MM/dd HH:mm:ss:sss"));
      URL urlObj = new URL(url);
      conn = (HttpURLConnection) urlObj.openConnection();
      conn.setRequestProperty("Content-Language", "UTF-8");
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setConnectTimeout(connectTimeout); // 單位毫秒，< 0 會Exception， = 0即不限timeout時間
      conn.setReadTimeout(readTimeout); // 單位毫秒
      conn.setUseCaches(false);
      conn.setRequestMethod("GET");

      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

      String temp = null;
      while ((temp = br.readLine()) != null) {
        rtn.append(temp);
      }
      br.close();
      // 記錄 Log
      log.append("\n      url : ").append(url);
      log.append("\n  timeout : ").append(connectTimeout);
      log.append("\n      rtn : ").append(rtn);
      log.append("\n======================================================================"
          + DateUtil.getDate(new Date(), "yyyy/MM/dd HH:mm:ss:sss"));
      
      wsUtilLog.info("[doGet()] " + log.toString());
    } catch (Exception e) {
      exceptionLog.error("url=[" + url + "] " + e.getMessage(), e);
      rtn.setLength(0);
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return rtn.toString();
  }
  
  /**
   * 呼叫Redis Api
   * 單號:2017021600041948
   * 活動時間:106/04/16-04/30、106/05/01-05/15
   * 居家生活滿額登記活動，目前僅試水溫，未來可能在ECM成為機制化活動
   * @param requestMethod - GET、POST、DELETE
   * @param location
   * @param paramater
   * @return JSONObject responseBody
   * @author fhchen 2013.01.03
   *         sctsai 2016.08.17  
   *         twkuo  2017.04.10修改
   */
  public static JSONObject callRedisApi(String requestMethod, String location, String paramater) {
    String method = "[callApi()]";
    int port = 80;
    Socket socket = null;
    BufferedReader in = null;
    OutputStreamWriter out = null;
    String server_ip = "10.3.13.227"; //測試機:10.2.11.129  正式機:10.3.13.227
    int timeout = 3000;  //3秒
    String charset = "UTF-8";
    
//    LogUtil.msg(author, method + " START! requestMethod=" + requestMethod + ", server_ip=" + server_ip + ", location=" + location);
    
    try {
      socket = new Socket();
      SocketAddress endpoint = new InetSocketAddress(server_ip, port);
      socket.connect(endpoint, timeout);
      socket.setSoTimeout(timeout);
      
      String header = requestMethod + " " + location + " HTTP/1.1\n";
      header += "Host: " + server_ip + ":" + port + "\n";
      header += "User-Agent: Mozilla/5.0 (Windows NT 5.1; rv:9.0.1) Gecko/20100101 Firefox/9.0.1\n";
      header += "Accept: text/html,application/xhtml+xml,application/xml,application/json;q=0.9,*/*;q=0.8\n";
      header += "Accept-Language: zh-tw,en-us;q=0.7,en;q=0.3\n";
      header += "Accept-Encoding: gzip, deflate\n";
      header += "Accept-Charset: " + charset + ",*\n";
      header += "Content-length: " + paramater.length() + "\n";
      header += "Connection: Close\n";
      header += "Cache-Control: max-age=0\n\n";
      
      out = new OutputStreamWriter(socket.getOutputStream(), charset);
      out.write(header + paramater);
      out.flush();
      
      in = new BufferedReader(new InputStreamReader(socket.getInputStream(), charset));
      StringBuffer response = new StringBuffer(); // Api回傳的hearder和body
      StringBuffer responseBody = new StringBuffer(); // Api回傳的body
      long startTime = System.currentTimeMillis();
      boolean isTimeout = false;
      while (true) {
        String str = "";
        try {
          str = in.readLine();
        } catch (IOException e) {
          exceptionLog.error(method + " in.readLine() throws IOException:" + e.getMessage(), e);
          break;
        }
        isTimeout = System.currentTimeMillis() - startTime >= timeout;
        if ((str == null) || isTimeout) {
          break;
        }
        response.append(str);
      }
      
      if (!isTimeout) {
        if (response.length() > 0) {
          if (response.indexOf("{") > 0) {
            responseBody.append(response.substring(response.indexOf("{")));
          } else {
            wsUtilLog.info(method + " wrong response=[" + response + "]!!!");
          }
        } else {
          wsUtilLog.info(method + " no response!!!");
        }
      } else {
        wsUtilLog.info(method + " timeout!!!");
      }
      
      //特別處理
      try {
        String tmp = responseBody.toString();
        if (tmp.length() > 0 && ((int) (tmp.substring(tmp.length() - 1).charAt(0))) == 65535) {
          if (tmp.length() > 1)
            responseBody = new StringBuffer();
          responseBody.append(tmp.substring(0, tmp.length() - 2));
          responseBody.append("}");
        }
      } catch (Exception exx) {
        exceptionLog.error(method + " 特別處理失敗 exx:" + exx.getMessage(), exx);
      }
      
      if (responseBody.length() > 0) {
        JSONObject goodsObject = new JSONObject();
        goodsObject = JSONObject.fromObject(responseBody.toString());
        return goodsObject;
      }
      
    } catch(Exception e) {
      exceptionLog.error(method + " Exception:" + e.getMessage(), e);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          exceptionLog.error(method + " in.close() throws Exception:" + e.getMessage(), e);
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          exceptionLog.error(method + " out.close() throws Exception:" + e.getMessage(), e);
        }
      }
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          exceptionLog.error(method + " socket.close() throws Exception:" + e.getMessage(), e);
        }
      }
    }
    return null;
  }
  
}
