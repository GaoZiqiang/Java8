package cn.edu.sdut.softlab.stream;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String args[]) {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));
    }
}
