package cn.linkedcare.decorate;

/**
 * Created by Benji on 2018/5/2.
 */
public class HappyPerson extends SayHelloDecorate {

    public HappyPerson(SayHello sayHello) {
        super(sayHello);
    }

    @Override
    public void sayHello() {
        this.dance();
        super.sayHello();
    }


    public void dance() {
        System.out.print("跳了三分钟的舞之后");
    }
}
