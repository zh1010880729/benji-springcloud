package cn.linkedcare;

import cn.linkedcare.feign.FeignService;
import cn.linkedcare.feign.Feigninterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;

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
        map.put("startTime", "2018-04-01");
        map.put("endTime", "2018-04-30");
        String info = target.getUsers(map);
        System.out.print(info);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map response = objectMapper.readValue(info, Map.class);
//        response.forEach((key, value) -> System.out.println(key + ":" + value));


    }

}
