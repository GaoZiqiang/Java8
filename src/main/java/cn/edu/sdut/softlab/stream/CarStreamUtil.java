/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.car.Car;
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
        List<Car> garage = Arrays.asList(
                new Car("奔驰", "black", 500, 1000, 300),
                new Car("奥迪", "wihte", 400, 900, 100),
                new Car("宝马", "red", 600, 1100, 200),
                new Car("大众", "blue", 300, 700, 50),
                new Car("吉普", "black", 450, 8000, 80)
        );

        List<String> highPriceCarsName;
        highPriceCarsName = garage.stream()
                .filter(car -> car.getPrice() >= 100)
                .sorted(comparing(Car::getPrice))
                .map(Car::getName)
                .collect(toList());
        highPriceCarsName.forEach(System.out::println);
    }
}
