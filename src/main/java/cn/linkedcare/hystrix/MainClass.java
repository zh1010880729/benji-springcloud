package cn.linkedcare.hystrix;

import com.netflix.config.ConfigurationManager;

/**
 * Created by Benji on 2018/4/11.
 */
public class MainClass {
    public static void main(String[] args) {

        testBreaker();
    }


    public static void testBreaker() {
        //强制打开断路器，测试回退方法
        System.out.println("断路器被打开");
        ConfigurationManager.getConfigInstance()
                .setProperty("hystrix.command.default.circuitBreaker.forceOpen", "true");
        MyCommand c = new MyCommand();
        System.out.println("断路器是否打开： " + c.isCircuitBreakerOpen());
        c.execute();
        System.out.println("断路器被关闭");
        ConfigurationManager.getConfigInstance()
                .setProperty("hystrix.command.default.circuitBreaker.forceOpen", "false");
        MyCommand c2 = new MyCommand();
        System.out.println("断路器是否打开： " + c2.isCircuitBreakerOpen());
        c2.execute();
    }
}
