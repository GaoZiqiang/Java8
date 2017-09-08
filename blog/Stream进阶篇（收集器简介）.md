# 1 收集器简介
## 1.1 个人定义

　　下面是个人总结的关于收集器的定义：

    在Lambda表达式的基础上，调用collect()接口，使用Collector类提供的方法，将流中的元素累积成一个汇总结果。

## 1.2 收集器讲解

　　通过之前的学习我们了解到，流可以用类似于数据库的操作来处理集合，因此，我们可以将流看作对数据处理的“迭代器”。流支持两种类型的操作：中间操作（filter、map）和终端操作（collect、forEach），中间操作是将一个流转换为另一个流，而不会消耗流；而终端操作会通过对流的操作产生一个结果，即会消耗流。
　　例如collect这个终端操作，我们之前的使用是将流中所有的元素结合成一个List。
　　在Lambda表达式支持的基础上，通过优秀的函数式编程，我们可以将原本很复杂的指令式编程简洁化，借用流的思想，便有了“收集器”这一概念。
## 1.3 demo讲解收集器

　　现在要统计车库garage中全部车辆的质量之和。
　　指令式编程：

public static void totalWeight1() {
        int totalWeight = 0;
        for(Car cars : garage) {
            totalWeight  = totalWeight + cars.getWeight();
        }
        System.out.println("---totalWeight2---\r\n" + totalWeight);
    }

    1
    2
    3
    4
    5
    6
    7

　　使用收集器：

public static void totalWeight2() {
        int totalWeight = garage.stream().collect(summingInt(Car::getWeight));
        System.out.println("---totalCalories---\r\n" + totalWeight);
    }

    1
    2
    3
    4

　　通过上面的简单demo可以看出，使用收集器可以简化操作步骤，而且代码的可重复利用率更高。
## 2 收集器用作高级归约

　　收集器的优势从另一个角度来理解便是归约。
　　收集器可以简洁而灵活地定义collect生成的结果集的标准，更具体的说，对流调用collect方法将对流中的元素触发一个归约操作（具体由Collector接口来参数化）。该归约操作具体来说，Collector会对元素应用一个转换函数（该函数在一般情况下不会产生效果性的影响），并将结果累积在一个数据结构呢中，最终产生这一过程中的最终输出。
　　还是以上面的例子展开讲解：
　　收集器
## 3 预定义收集器

　　预定义收集器是从Collectors这个工厂类提供的工厂方法（例如maxBy）创建的收集器。它主要提供了三大功能：
- 将流元素归约和汇总为一个值
- 元素分组
- 元素分区

　　下面展示Collectors实体类提供的常用的工厂方法即预定义收集器。
工厂方法 	返回类型 	用于
toList() 	List 	将元素收集到一个 List 中。
toSet() 	Set 	将元素收集到一个 Set 中。
toCollection(Supplier) 	Collection 	将元素收集到一个特定类型的 Collection 中。
summingInt(ToIntFunction) 	Integer 	计算将提供的 int 值映射函数应用于每个元素（以及 long 和 double 版本）的结果的总和。

　　更多预定义收集器详见：
　　http://www.cnblogs.com/litaiqing/p/6026940.html
