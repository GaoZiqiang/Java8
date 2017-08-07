/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.stream;

import cn.edu.sdut.softlab.dish.Dish;
import static cn.edu.sdut.softlab.dish.Dish.menu;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author gaoziqiang
 */
public class DishStreamUtil {

    public static void main(String[] args) {
        DishStreamUtil.collectorCounting();
        //DishStreamUtil.lowCaloriesDishes();
        //DishStreamUtil.maxCaloriesDishes();
        //DishStreamUtil.shortMenuJoining();
        //DishStreamUtil.sumTotalCalories();
        //DishStreamUtil.collectReduceComparetor();
    }

    //lowCaloricDishes
    public static void lowCaloriesDishes() {
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

    //
    public static void collectorCounting() {
        long howManyDishes = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();
        System.out.println("---the dish's number---" + howManyDishes);
        System.out.println("---the dish's number2---" + howManyDishes2);
    }

    //maxCaloriesDishes
    public static void maxCaloriesDishes() {
        //方法一
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        mostCaloriesDish.toString();
        System.out.println("---mostCaloriesDish.toString()---\r\n" + mostCaloriesDish.toString());
        System.out.println("---mostCaloriesDish's name---\r\n" + mostCaloriesDish.get().getName());
        //方法二
        Optional<Dish> mostCaloriesDish2 = menu.stream().collect(reducing((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("---mostCaloriesDish's name---\r\n" + mostCaloriesDish2.get().getName());
    } 

    //连接字符串
    public static void shortMenuJoining() {
        String shortMenuName1 = menu.stream().map(Dish::getName).collect(joining());
        System.out.println("---shortMenuName1---\r\n" + shortMenuName1);
        String shortMenuName2 = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println("---｀shortMenuName2---\r\n" + shortMenuName2);

    }

    //summingInt
    public static void sumTotalCalories() {
        //方法一
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("---totalCalories---\r\n" + totalCalories);
        //方法二    
        int totalCalories2 = menu.stream().collect(reducing(0,Dish::getCalories,(i,j) -> i + j));
        System.out.println("---totalCalories2---\r\n" + totalCalories2);
    }
    
    //收集器的collect()与reduce()分析
    public static void collectReduceComparetor() {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream(); 
        List<Integer> streamList = stream.collect(toList());
        //stream.forEach(System.out::println);
    }
}
