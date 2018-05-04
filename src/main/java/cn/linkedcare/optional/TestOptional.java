package cn.linkedcare.optional;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Benji on 2018/5/4.
 */
public class TestOptional {

    public static void main(String[] args) {
//        //BigDecimal money = new BigDecimal(0.5);
//        BigDecimal money = null;
//        Optional<BigDecimal> value = Optional.ofNullable(money);
//        println(value.orElseThrow(() -> new RuntimeException("报告老板，发现异常")));
//        println(value.orElse(new BigDecimal(0)).setScale(0, BigDecimal.ROUND_HALF_UP));
        testCollection();
    }


    public static void println(Object obj) {
        System.out.println(obj);
    }


    public static void testCollection() {
        String[] arr = null;
        Optional.ofNullable(arr).ifPresent(array -> Arrays.stream(array).forEach(System.out::println));
    }
}
