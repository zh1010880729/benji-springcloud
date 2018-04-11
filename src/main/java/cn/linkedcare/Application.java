package cn.linkedcare;

import cn.linkedcare.feign.FeignService;
import cn.linkedcare.feign.Feigninterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张恒 on 2018/4/8.
 */
@ComponentScan(basePackages = {"cn.linkedcare.config"})
public class Application {

    public static void main(String[] args) throws IOException {
        FeignService target = Feign.builder()
                .encoder(new GsonEncoder())
                .requestInterceptor(new Feigninterceptor())
                .logLevel(Logger.Level.BASIC)
                .logger(new Logger.JavaLogger().appendToFile("E:/logs/http.log"))
                .target(FeignService.class, "http://bi.linkedcare.cn:35769/");
        Map<String, String> map = new HashMap<>();
        map.put("email", "xiaomei.ma@linkedcare.cn");
        String info = target.getOfficeInfoByEmail(map);
        ObjectMapper objectMapper = new ObjectMapper();
        Map response = objectMapper.readValue(info, Map.class);
        response.forEach((key, value) -> System.out.println(key + ":" + value));
    }

}