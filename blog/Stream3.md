# Java8系列--Java Stream进阶篇（流的操作）
## **1 流的操作的特点**
### **1.1 流的操作的核心机制**
　　流的操作区别于传统的集合操作的一大特点是，在Java 8中，流的操作是通过将外部迭代转向内部迭代来实现的。
　　在Java 8 Stream API中，流的操作实际上相当于对数据进行一系列的"筛选"操作，而"筛选"的标准实际上是一个个具体的"方法"，在Java 8 Stream中，是通过将这些筛选方法作为Stream流的一系列内部迭代的方法参数来实现的。
　　以下面的例子展开讲解。
　　现在要求将车的价格在300百万以上的车定义为高档车。



 - 解决办法：使用filter()方法进行筛选；
 - 筛选条件：car.getPrice() > 300即可；

　　这里，filter()方法是Stream的内部迭代方法，而car.getPrice() > 300是该filter()方法的一个内部参数。
　　示例代码：
```
 List<Car> highPriceCar;
        highPriceCar = garage.stream()
                .filter(car -> car.getPrice() > 300)
                .collect(toList());
```

### **1.2 流的操作的优势**
　　与传统的集合操作相比，流的操作主要有以下两个优势：
　　

 - 可并行操作，解决单线程的不足
 - 处理更具有针对性，处理效率高

## **2 流的常用操作结构图**
　　流的操作主要分为"筛选和切片""映射""查找个匹配""归约"等四类操作，具体操作详见下图：
　　![流的操作](http://img.blog.csdn.net/20170723211243087?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzM0Mjk5Njg=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
## **3 流的常用操作详解**
### **3.1 筛选和切片**
**1.谓词筛选**
　　Stream接口支持filter方法，该操作会接受一个谓词作为参数，并返回一个包括所有符合谓词的元素的流。
　　谓词：一个返回值为boolean类型的函数。
　　**代码示例：**
　　

```
List<Car> lowPriceCar;
        lowPriceCar = garage.stream()
                .filter(Car::isLowPriceCar)//isLowPriceCar()方法筛选低价车
                .collect(toList());
```
　　isLowPriceCar()方法：
　　

```
private static boolean isLowPriceCar(){
　　return garage.stream().allMatch(car -> car.getPricce() < 100);
}
```

**2.筛选各异的元素**
　　流还支持一个叫做distict的方法，它会将序列中重复的元素筛选掉，从而返回一个元素各异的流。
　　**实现原理：根据流所生成元素的hashCode和equals方法实现。**
　　代码示例：
　　

```
List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.println("--- 筛除重复元素---");
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
```

**3.截短流**
　　流支持limit(n)方法，该方法会返回一个给定长度的流，该方法的参数是一个整数n，该参数即为限定的长度。筛选顺序是从左到右，从前往后。
　　代码示例：
　　

```
List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.println("--- 筛除重复元素---");
        numbers.stream()
                .distinct()
                .limit(2)//将前两个不重复的数筛选出来
                .forEach(System.out::println);
```

**4.跳过元素**
　　流支持的另一个方法skip(n)正好与limit(n)方法形成互补。
　　skip(n)方法将前n个元素筛选掉，如果流中不足n个元素，则返回一个空流。
　　代码示例：
　　

```
List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.println("--- 筛除重复元素---");
        numbers.stream()
                .distinct()
                .skip(2)//将前两个不重复的数筛掉
                .forEach(System.out::println);
```

### **3.2 映射**
### **3.3 查找和匹配**
### **3.4 归约**

