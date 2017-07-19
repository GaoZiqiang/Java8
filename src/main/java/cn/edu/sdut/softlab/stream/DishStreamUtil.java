/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.dish.Dish;
import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author gaoziqiang
 */
public class DishStreamUtil {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("pizza", false, 300, Dish.Type.OTHER)
        );

        List<String> lowCaloricDishesName;
        lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .limit(1)
                .collect(toList());//终端操作，返回一个List
             
        lowCaloricDishesName.forEach(System.out::println);
        //lowCaloricDishesName.forEach(System.out::println);
        //System.out.println("热量大于400的食物" + lowCaloricDishesName);
    }
}
