package cn.linkedcare.decorate;

/**
 * Created by Benji on 2018/5/2.
 */
public abstract class SayHelloDecorate implements SayHello {
    private final SayHello sayHello;

    public SayHelloDecorate(SayHello sayHello) {
        this.sayHello = sayHello;
    }

    @Override
    public void sayHello() {
        sayHello.sayHello();
    }
}
