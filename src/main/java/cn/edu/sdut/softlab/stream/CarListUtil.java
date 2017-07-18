/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.car.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author gaoziqiang
 */
public class CarListUtil {

    public static void main(String[] args) {
        List<Car> garage = Arrays.asList(
                new Car("奔驰", "black", 500, 1000, 300),
                new Car("奥迪", "wihte", 400, 900, 100),
                new Car("宝马", "red", 600, 1100, 200),
                new Car("大众", "blue", 300, 700, 50),
                new Car("吉普", "black", 450, 8000, 80)
        );

        List<Car> highPriceCars = new ArrayList<>();
        //用累加器筛选元素
        for (Car car : garage) {
            if (car.getPrice() >= 100) {
                highPriceCars.add(car);
            }
        }

        //用匿名类对车进行排序
        Collections.sort(highPriceCars, new Comparator<Car>() {
            public int compare(Car c1, Car c2) {
                return Integer.compare(c1.getPrice(), c2.getPrice());
            }
        });

        //收集满足条件的车名
        List<String> highPriceCarsName = new ArrayList<>();
        for (Car car : highPriceCars) {
            highPriceCarsName.add(car.getName());
        }
        //打印输出车名
        for (String carName : highPriceCarsName) {
            System.out.println("车名：  " + carName);
        }
    }
}
