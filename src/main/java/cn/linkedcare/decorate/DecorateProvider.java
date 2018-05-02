package cn.linkedcare.decorate;

/**
 * Created by Benji on 2018/5/2.
 */
public class DecorateProvider {

    public static void main(String[] args) {
        new Person().sayHello();

        new HappyPerson(new Person()).sayHello();
    }
}
