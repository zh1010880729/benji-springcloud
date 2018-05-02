package cn.linkedcare.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by Benji on 2018/4/11.
 */
public class MyCommand extends HystrixCommand<String> {

    protected MyCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("DemoGroup"));
    }

    @Override
    protected String run() throws Exception {
        print("run 方法开始执行");
        return "";
    }

    @Override
    protected String getFallback() {

        print("回退方法开始执行");
        return "";
    }

    public void print(String msg) {
        System.out.println(msg);
    }
}
