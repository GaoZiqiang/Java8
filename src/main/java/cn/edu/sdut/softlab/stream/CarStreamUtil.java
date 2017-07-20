/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.car.Car;
import static cn.edu.sdut.softlab.car.Car.garage;//特殊
import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author gaoziqiang
 */
public class CarStreamUtil {

    public static void main(String[] args) {
//        List<String> highPriceCarsName;
//        highPriceCarsName = garage.stream()
//                .filter(car -> car.getPrice() >= 100)
//                .sorted(comparing(Car::getPrice))
//                .map(Car::getName)
//                .collect(toList());
//        System.out.println("---高价位车辆---");
//        highPriceCarsName.forEach(System.out::println);

        //谓词筛选-filter
//        List<Car> highEndCarList;
//        highEndCarList = garage.stream()
//                .filter(Car::isHighEndCar)
//                //.map((Car::getName)
//                .collect(toList());
//        System.out.println("---高档车---");
        //highEndCarList.forEach(System.out::println);
        
        
//        //测试谓词筛选
//        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
//        System.out.println("---输出偶数---");
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);


     //映射--对流中的每一个元素应用函数
     List<String> wordList = Arrays.asList("Java 8","Lambda","In","Action");
     System.out.println("---字符长度---");
     wordList.stream()
             .map(String::length)
             .collect(toList())
             .forEach(System.out::println);
                
    }

}
