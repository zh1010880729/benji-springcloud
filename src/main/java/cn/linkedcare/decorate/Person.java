package cn.linkedcare.decorate;

/**
 * Created by Benji on 2018/5/2.
 */
public class Person implements SayHello {
    @Override
    public void sayHello() {
        System.out.println("小明说：你好");
    }
}
