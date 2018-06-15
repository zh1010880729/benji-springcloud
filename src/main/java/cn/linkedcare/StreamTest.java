package cn.linkedcare;

import cn.linkedcare.entity.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Benji on 2018/4/10.
 */
public class StreamTest {

    public static void main(String[] args) throws Exception {
        testFileChannel();
    }

    public static void testFileChannel() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\admin\\Desktop\\接口文档.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\真的是接口文档啦.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((inputStreamChannel.read(buffer)) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                outputStreamChannel.write(buffer);
            }
            buffer.clear();
        }
        outputStreamChannel.close();
        inputStreamChannel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void test3() {
        LocalDateTime localDateTime = LocalDateTime.now().minusMonths(11);
        System.out.println(localDateTime.toString());
    }

    public static void test1() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                User user = new User();
                user.setId(j);
                user.setUsername("demo" + i);
                users.add(user);
            }
        }
        List<Integer> collect = users.stream().map(User::getId).distinct().collect(Collectors.toList());
        System.out.print(collect);
    }

    private static void test2() {
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
