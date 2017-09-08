/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.stream.ParallelSumTest;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 并行流
 *
 * @author gaoziqiang
 */
public class StreamParallelUtil {

    public static void main(String[] args) {
        //orderSum(100);
        //parallelSum(100);
        //meaureParallelSumTest(ParallelSumTest::parallelSumTest,10000000);
        //System.out.println("---运行结果---\r\n");
        System.out.println("---并行流的最快时间---\r\n" + meaureParallelSumTest(ParallelSumTest::parallelSumTest, 10000000) + "msecs");
        //System.out.println("---顺序流的最快时间---\r\n" + meaureParallelSumTest(ParallelSumTest::orderSumTest, 10000000) + "msecs");
    }

    //传统的顺序流
    public static void orderSum(long n) {
        long startTime1 = System.nanoTime();//当前时间的毫秒数
        long result1 = 0;
        for (long i = 1L; i <= n; i++) {
            result1 += i;
        }
        long endTime1 = System.nanoTime();
        System.out.println("---顺序流运行结果 sum的值---\r\n" + result1 + "\r\n----顺序流运行时间---\r\n" + (endTime1 - startTime1) + "毫秒");
    }

    //将顺序流转换为并行流
    public static void parallelSum(long n) {
        long startTime = System.nanoTime();//当前时间的毫秒数
        //long start = System.nanoTime();
        long result = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
        long endTime = System.nanoTime();
        System.out.println("---并行流运行结果 sum的值---\r\n" + result + "\r\n---并行流运行时间---\r\n" + (endTime - startTime) + "毫秒");
    }

    //测量性能
    public static long meaureParallelSumTest(Function<Long, Long> adder, long n) {
        long fastestTime = Long.MAX_VALUE;//将fastestTime设为long.MAX_VALUE可以保证所有duration都不会比fsatestTime大
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();//开始时间
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - startTime) / 1000000;
            if (duration < fastestTime) {
                fastestTime = duration;
            }
        }
        return fastestTime;
    }
}
