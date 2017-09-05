/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import java.util.stream.Stream;

/**
 *
 * @author gaoziqiang
 */
public class ParallelSumTest {

    //将顺序流转换为并行流
    public static long parallelSumTest(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
    //传统的顺序流
    public static long orderSumTest(long n) {
        long startTime1 = System.nanoTime();//当前时间的毫秒数
        long result1 = 0;
        for (long i = 1L; i <= n; i++) {
            result1 += i;
        }
        long endTime1 = System.nanoTime();
        return (endTime1 - startTime1);
        //System.out.println("---顺序流运行结果 sum的值---\r\n" + result1 + "\r\n----顺序流运行时间---\r\n" + (endTime1 - startTime1) + "毫秒");
    }
}
