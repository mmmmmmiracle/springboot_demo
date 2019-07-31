package com.hyd.mercury.util;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hyd.mercury.common.ResultResponse;

public class HttpUtil {
	
	 public static ResultResponse sendPostRequest(String url, HttpMethod method, MultiValueMap<String, String> params, String data, String authority){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<ResultResponse> response = client.exchange(url, method, requestEntity, ResultResponse.class, data, authority);

        return response.getBody();
    }
}
