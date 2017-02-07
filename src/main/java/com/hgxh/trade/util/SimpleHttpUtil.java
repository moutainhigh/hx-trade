package com.hgxh.trade.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang on 2016/1/5.
 */
public class SimpleHttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(SimpleHttpUtil.class);

    public static String doPost(String url, Map<String, String> params) throws Exception {
        // 设置cookie策略
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(2000)
                .setSocketTimeout(5000).build();
        // 设置可关闭的httpClient
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
        HttpPost httpPost = new HttpPost(url);
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
    
    public static String doPostGb(String url, Map<String, String> params) throws Exception {
        // 设置cookie策略
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(2000)
                .setSocketTimeout(5000).build();
        // 设置可关闭的httpClient
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httpPost.setHeader("Accept-Charset", "utf-8,GB2312;q=0.7,*;q=0.7");
        List<NameValuePair> values = new ArrayList<NameValuePair>();
        if (null != params) {
            values = mapToList(params);
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(values, "GB2312");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String body = null;
        try {
            if (null != response) {
                HttpEntity httpEntity = response.getEntity();
                if (null != httpEntity) {
                    body = EntityUtils.toString(httpEntity, "GB2312");
                }
            }
        } catch (Exception e) {
            logger.info("获取相应内容异常：", e);
        } finally {
            response.close();
        }

        return body;
    }
    
    public static String doGet(String url) throws Exception {
        // 设置cookie策略
        RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).setConnectTimeout(5000).setConnectionRequestTimeout(2000)
                .setSocketTimeout(5000).build();
        // 设置可关闭的httpClient
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httpGet.setHeader("Accept-Charset", "utf-8,GB2312;q=0.7,*;q=0.7");
        List<NameValuePair> values = new ArrayList<NameValuePair>();
        CloseableHttpResponse response = httpClient.execute(httpGet);
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

}
