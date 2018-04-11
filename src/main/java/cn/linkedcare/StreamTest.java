package cn.linkedcare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Benji on 2018/4/10.
 */
public class StreamTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                list.add(j);
        }

        list.stream().forEach(item -> {
            System.out.println(item);
        });

        List<Integer> collect = list.stream()
                .filter(item -> item >= 6)
                .collect(Collectors.toList());
        System.out.println("---------------");
        collect.stream().forEach(integer -> System.out.print(integer));

        Integer sum = collect.stream()
                .reduce(0, Integer::sum);


        System.out.println("---------------");
        System.out.println(sum);
        System.out.println("---------------");
        List<Integer> sortedList = collect.stream()
                .sorted((t1, t2) -> t2.compareTo(t1))
                .collect(Collectors.toList());
        sortedList.stream()
                .forEach(integer -> System.out.print(integer));

        System.out.println();


        sortedList.stream()
                .distinct().collect(Collectors.toList()).stream()
                .forEach(integer -> System.out.print(integer));


        List<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("B");
        strings.add("ab");
        strings.add("abc");
        strings.add("ABC");

        Map<Integer, List<String>> map = strings.stream().collect(Collectors.groupingBy(String::length));

    }

}
