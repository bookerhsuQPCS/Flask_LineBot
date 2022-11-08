package com.momo.middle.util;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateUtil
 * @version 1.0
 * @author Allen 2013/10/08
 */
public class RestTemplateUtil extends RestTemplate {
	
	private static final int TIME_OUT = 30*1000;
	
	/**
	 * @author Allen 2013/10/08
	 */
	public RestTemplateUtil() {
		if (getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
			((SimpleClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(TIME_OUT);
			((SimpleClientHttpRequestFactory) getRequestFactory()).setReadTimeout(TIME_OUT);
		} else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
			((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setReadTimeout(TIME_OUT);
			((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(TIME_OUT);
		}
	}
	
	/**
	 * @param timeout
	 * @author Allen 2013/10/08
	 */
	public RestTemplateUtil(int timeout) {
		if (getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
			((SimpleClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(timeout);
			((SimpleClientHttpRequestFactory) getRequestFactory()).setReadTimeout(timeout);
		} else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
			((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setReadTimeout(timeout);
			((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(timeout);
		}
	}
	
}
