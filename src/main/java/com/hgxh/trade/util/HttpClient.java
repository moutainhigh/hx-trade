package com.hgxh.trade.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClient {
	
	private static RequestConfig requestConfig;

	private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

	public static String doPost(String url, Map<String, String> params,String cookie, String refer) throws Exception {
		// 设置cookie策略
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).setConnectTimeout(5000).setConnectionRequestTimeout(2000)
				.setSocketTimeout(5000).build();
		// 设置可关闭的httpClient
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
		
		HttpPost httpPost = new HttpPost(url);
		if (StringUtils.isNotBlank(cookie)) {
			httpPost.setHeader("Cookie", cookie);
		}
		if (StringUtils.isNotBlank(refer)) {
			httpPost.setHeader("Referer", refer);
		}
		httpPost.setHeader("Accept", "text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		httpPost.setHeader("Accept-Charset", "utf-8,GB2312;q=0.7,*;q=0.7");    
		List<NameValuePair> values = new ArrayList<NameValuePair>();
		if (null != params) {
			values = mapToList(params);
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(values, "UTF-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		String body = null;
		try {
			if (null != response) {
				HttpEntity httpEntity = response.getEntity();
				if (null != httpEntity) {
					body = EntityUtils.toString(httpEntity, "UTF-8");
				}
			}
		} catch (Exception e) {
			logger.info("获取相应内容异常：", e);
		} finally {
			response.close();
		}

		return body;
	}

	public static List<NameValuePair> mapToList(Map<String, String> params) {
		List<NameValuePair> values = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			values.add(new BasicNameValuePair(key, params.get(key)));
		}
		return values;
	}
	
	/**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param apiUrl
     * @param json json对象
     * @return
     */
    public static String doPost(String apiUrl, Object json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine().getStatusCode());
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
        return httpStr;
    }
}
