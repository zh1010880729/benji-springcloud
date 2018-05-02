package cn.linkedcare;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Benji on 2018/4/25.
 */
public class MainFunction {

    public static void main(String[] args) {
        fun1();
    }

    public static void fun1() {
        String str = "6♧5♢10";
        String[] split = str.split("[♧♢]");
        List<String> list = Arrays.stream(split)
                .filter(item -> StringUtils.isNotBlank(item))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

}
