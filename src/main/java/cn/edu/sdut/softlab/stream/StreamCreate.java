/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import javafx.scene.shape.Path;

/**
 * 流的创建方法
 *
 * @author gaoziqiang
 */
public class StreamCreate {

    //由值创建流
    public static void createStreamByValue() {
        System.out.println("---createStreamByValue---");
        //空流
        Stream<String> emptyStream = Stream.empty();
        System.out.println("---输出空流---");
        emptyStream.forEach(System.out::println);
        //String类型
        Stream<String> stringStream = Stream.of("Java8", "In", "Action");
        System.out.println("---输出String型的流---");
        stringStream.forEach(System.out::println);
        //Integer类型
        Stream<Integer> integerStream = Stream.of(12, 11, 10);
        System.out.println("---输出Integer型的流---");
        integerStream.forEach(System.out::println);
    }

    //由数组创建流
    public static void createStreamByArray() {
        System.out.println("---createStreamByArray---");
        //String类型
        String[] characters = {"Java8", "In", "Action"};
        Stream<String> stream1 = Arrays.stream(characters);
        System.out.println("---createStreamByArray-输出String型的流---");
        stream1.forEach(System.out::println);
        //Integer类型
        Integer[] numbers = {1, 2, 6, 78, 45};
        Stream<Integer> stream2 = Arrays.stream(numbers);
        System.out.println("---createStreamByArray-输出Integer型的流---");
        stream2.forEach(System.out::println);
    }

    //由文件创建流
    public static void createStreamByFile() throws IOException {
        System.out.println("---createStreamByFile---");
        long wordsNumbers = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/home/gaoziqiang/data.txt"), Charset.defaultCharset())) {
            wordsNumbers = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
        }
        System.out.println("---数量是: " + wordsNumbers + "---");
    }

    //由函数生成流
    public static void createStreamByFunction() {
        System.out.println("---createStreamByFunction---");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        //菲波纳契数列
        System.out.println("---createStreamByFunction-菲波纳契数列---");
        Stream.iterate(new int[]{0,1}, t -> new int[] {t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    //测试用main()主方法
    public static void main(String[] args) throws IOException {
        //StreamCreate streamDemo = new StreamCreate();
        //类引用
        //StreamCreate.createStreamByValue();
        //StreamCreate.createStreamByArray();
        //StreamCreate.createStreamByFile();
        StreamCreate.createStreamByFunction();
    }
}
