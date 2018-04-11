package cn.linkedcare.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Benji on 2018/4/10.
 */
public class Feigninterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = TokenUtil.getToken();
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("获取access_token失败");
        }
        Map<String, Collection<String>> headers = new HashMap<>();
        List<String> header1 = new ArrayList<>();
        List<String> header2 = new ArrayList<>();
        header1.add("application/json");
        header2.add("Bearer " + token);
        headers.put("Content-Type", header1);
        headers.put("Authorization", header2);
        requestTemplate.headers(headers);
        header1 = null;
        header2 = null;
    }
}
