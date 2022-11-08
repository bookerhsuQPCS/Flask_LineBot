/* vim:sw=4:ts=4:expandtab
 *
 * @author    Wu, Deepblue <deepblue.wu@gmail.com>
 */
package com.momo.middle.util;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class HttpSendRequest {
    public static boolean LOG_MODE = true;
    public static String LOG_FILE = "HttpSendRequest_";
    private static Log logSave = LogFactory.getLog("fubonscm-save");
    private static Log logExceptionSave = LogFactory.getLog("exception-save");
    public static String makeRequestParameter( HashMap hmParameter ) {
        StringBuffer _strBuffer = new StringBuffer();

        try {
            for ( Iterator itrKeys = hmParameter.keySet().iterator(); itrKeys.hasNext() ; ) {
                String _strKey = (String) itrKeys.next();
                String _strValue = (String) hmParameter.get(_strKey);
                _strBuffer.append(_strKey + "=" + _strValue + (itrKeys.hasNext() ? "&" : "") );
            }
        } catch (Exception e) {
          logExceptionSave.error("Exception: HttpSendRequest(_makeRequestParameter) :",e);
        }
        return _strBuffer.toString();
    }

    public static String doPost(String strURL, String strParameter, String strCookie, String strReferer, String strCharset) { 
        java.io.BufferedWriter bufWrite = null; 
        StringBuffer strBufReturn = new StringBuffer();

        try { 
            URL url = new URL(strURL); 
            String strTempLine = "";

            HttpURLConnection URLConn = (HttpURLConnection) url.openConnection(); 
            URLConn.setDoOutput(true); 
            URLConn.setDoInput(true); 
            URLConn.setRequestMethod("POST"); 
            //((HttpURLConnection) URLConn).setRequestMethod("POST");
            URLConn.setUseCaches(false); 
            URLConn.setAllowUserInteraction(true); 
            URLConn.setFollowRedirects(true); 
            URLConn.setInstanceFollowRedirects(true); 

            URLConn.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; zh-TW; rv:1.9.1.2) " 
                        + "Gecko/20090729 Firefox/3.5.2 GTB5 (.NET CLR 3.5.30729)"); 
            URLConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"); 
            URLConn.setRequestProperty("Accept-Language", "zh-tw,en-us;q=0.7,en;q=0.3"); 
            URLConn.setRequestProperty("Accept-Charse", "Big5,utf-8;q=0.7,*;q=0.7"); 
            if (strCookie != null) 
                URLConn.setRequestProperty("Cookie", strCookie); 
            if (strReferer != null) 
                URLConn.setRequestProperty("Referer", strReferer); 

            URLConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
            URLConn.setRequestProperty("Content-Length", String.valueOf(strParameter.getBytes().length)); 

            java.io.DataOutputStream objDataOut= new java.io.DataOutputStream(URLConn.getOutputStream()); 
            objDataOut.writeBytes(strParameter); 

            java.io.BufferedReader bufRead = new java.io.BufferedReader( new java.io.InputStreamReader(URLConn.getInputStream(), strCharset)); 

            while ((strTempLine = bufRead.readLine()) != null) { 
                strBufReturn.append(strTempLine);
            } 

            if ( HttpSendRequest.LOG_MODE ) {
              logSave.info("\n"+
                        "\tHttpSendRequest(doPost) \n"+
                        "\tURL    : " + strURL + "?" + strParameter + " \n" +
                        "\tRefer  : " + strReferer + " \n" +
                        "\tCookie : " + strCookie  + " \n" +
                        "\tCharset: " + strCharset + " \n" +
                        "\tReturn : " + strBufReturn.toString());
            }

            bufRead.close(); 
        } catch (java.io.IOException e) { 
          logExceptionSave.error("\tException: HttpSendRequest(doPost) \n"+
              "\t"
              ,e);
            
        } finally { 
            if (bufWrite != null) { 
                try { 
                    bufWrite.close(); 
                } catch (java.io.IOException e) { 
 
                    logExceptionSave.error("\tException: HttpSendRequest(doPost) \n"+
                        "\t"
                        ,e);
                } 
                bufWrite = null; 
            } 
        } 

        return strBufReturn.toString(); 
    } 

    public static String doGet(String strURL, String strCookie, String strReferer, String strCharset) { 
        BufferedReader bufRead = null; 
        StringBuffer strBufReturn = new StringBuffer();
        try { 
            URL url = new URL(strURL); 
            HttpURLConnection URLConn = (HttpURLConnection) url.openConnection(); 
            URLConn.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; zh-TW; rv:1.9.1.2) " 
                        + "Gecko/20090729 Firefox/3.5.2 GTB5 (.NET CLR 3.5.30729)"); 
            URLConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"); 
            URLConn.setRequestProperty("Accept-Language", "zh-tw,en-us;q=0.7,en;q=0.3"); 
            URLConn.setRequestProperty("Accept-Charse", "Big5,utf-8;q=0.7,*;q=0.7"); 

            if (strCookie != null) 
                URLConn.setRequestProperty("Cookie", strCookie); 
            if (strReferer != null) 
                URLConn.setRequestProperty("Referer", strReferer); 

            URLConn.setDoInput(true); 
            URLConn.setDoOutput(true); 
            URLConn.connect(); 
            URLConn.getOutputStream().flush(); 

            bufRead = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), strCharset)); 
            String strTempLine; 
            while ((strTempLine = bufRead.readLine()) != null) { 
                strBufReturn.append(strTempLine); 
            } 
            if ( HttpSendRequest.LOG_MODE ) {
              logSave.info("\n"+
                        "\tHttpSendRequest(doGet) \n"+
                        "\tURL    : " + strURL +" \n" +
                        "\tRefer  : " + strReferer + " \n" +
                        "\tCookie : " + strCookie  + " \n" +
                        "\tCharset: " + strCharset + " \n" +
                        "\tReturn : " + strBufReturn.toString());
            }

        } catch (IOException e) { 
            logExceptionSave.error("\tException: HttpSendRequest(doGet) \n"+
                "\t"
                ,e);
        } finally { 
            if (bufRead != null) { 
                try { 
                    bufRead.close(); 
                } catch (java.io.IOException e) { 
                  logExceptionSave.error("\tException: HttpSendRequest(doGet) \n"+
                      "\t"
                      ,e);
                } 
                bufRead = null; 
            } 
        } 

        return strBufReturn.toString(); 
    } 
}

