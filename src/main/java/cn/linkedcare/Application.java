package cn.linkedcare;

import cn.linkedcare.entity.Offfice;
import cn.linkedcare.feign.FeignService;
import cn.linkedcare.feign.Feigninterceptor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
        map.put("email", "wei.liu@linkedcare.cn");
        String info = target.getOfficeInfoByEmail(map);
        System.out.print(info);
        JSONObject jsonObject = JSON.parseObject(info);
        List<Offfice> offfices = jsonObject.getJSONArray("offices").toJavaList(Offfice.class);
        StringBuilder sb = new StringBuilder("(");
        offfices.forEach(offfice -> {
            sb.append("\'").append(offfice.getTenantCode())
                    .append(offfice.getOfficeCode()).append("\'")
                    .append(",");
        });
        String substring = sb.substring(0, sb.lastIndexOf(",")) + ")";
        //System.out.print(substring);
    }

}
