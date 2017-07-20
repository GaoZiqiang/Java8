/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.car;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gaoziqiang
 */
public class Car {

    private String name;
    private String color;
    private int weight;
    private int speed;
    private int price;

    public Car(String name, String color, int weight, int speed, int price) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", color=" + color + ", weight=" + weight + ", speed=" + speed + '}';
    }

    //garage
    public static final List<Car> garage = Arrays.asList(
            new Car("奔驰", "black", 500, 1000, 300),
            new Car("奥迪", "wihte", 400, 900, 100),
            new Car("宝马", "red", 600, 1100, 200),
            new Car("大众", "blue", 300, 700, 50),
            new Car("吉普", "black", 450, 8000, 80)
    );

    //谓词筛选

    /**
     *
     * @return
     */
    public static boolean isHighEndCar() {

        return garage.stream().allMatch(car -> car.getPrice() > 400);

    }
}
