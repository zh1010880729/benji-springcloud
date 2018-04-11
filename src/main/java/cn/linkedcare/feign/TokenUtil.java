package cn.linkedcare.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.form.FormEncoder;
import feign.gson.GsonEncoder;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Benji on 2018/4/10.
 */
public class TokenUtil {

    public static String getToken() {
        try {
            FeignService target = Feign.builder()
                    .encoder(new FormEncoder(new GsonEncoder()))
                    .target(FeignService.class, "http://bi.linkedcare.cn:35769/");
            Map<String, String> map = new HashMap<>();
            String token = target.getToken("client_credentials", "trading", "linkedcare");
            ObjectMapper om = new ObjectMapper();
            Map response = om.readValue(token, Map.class);
            String accessToken = (String) response.get("access_token");
            if (!StringUtils.isEmpty(accessToken)) {
                return accessToken;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
