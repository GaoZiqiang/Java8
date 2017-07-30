# Java8系列--Java Stream入门篇（流的创建）
## **1 前言**
  流的创建方法有很多，除了我们经常用的使用集合创建流，还可以通过值、数组、文件、函数等方法来创建流。
  
  **参照下图**：
![chuangjian](http://img.blog.csdn.net/20170730133611647?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzM0Mjk5Njg=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
## **2 流的构建方法详解**
### **2.1 由值创建流**
  使用静态方法Stream.of方法，通过显式值创建一个流，它可以接受任何数量的参数。
  
  **代码示例**：
  

```
//由值创建流
    public static void createStreamByValue() {
        System.out.println("---createStreamByValue---");
        //空流
        Stream<String> emptyStream = Stream.empty();
        System.out.println("---输出空流---");
        emptyStream.forEach(System.out::println);
        //String类型
        Stream<String> stringStream = Stream.of("Java8", "In", "Action");
        System.out.println("---输出String型的流---");
        stringStream.forEach(System.out::println);
        //Integer类型
        Stream<Integer> integerStream = Stream.of(12, 11, 10);
        System.out.println("---输出Integer型的流---");
        integerStream.forEach(System.out::println);
    }
```

### **2.2 由数组创建流**
   使用静态方法Arrays.stream方法从数组创建一个流，它可以接受一个数组作为参数。
   
   **代码示例**：
   

```
//由数组创建流
    public static void createStreamByArray() {
        System.out.println("---createStreamByArray---");
        //String类型
        String[] characters = {"Java8", "In", "Action"};
        Stream<String> stream1 = Arrays.stream(characters);
        System.out.println("---createStreamByArray-输出String型的流---");
        stream1.forEach(System.out::println);
        //Integer类型
        Integer[] numbers = {1, 2, 6, 78, 45};
        Stream<Integer> stream2 = Arrays.stream(numbers);
        System.out.println("---createStreamByArray-输出Integer型的流---");
        stream2.forEach(System.out::println);
    }
```

### **2.3 由集合创建流**
  使用静态方法List.stream方法从数组创建一个流，不需要参数。
  
  **代码示例**：
  

```
//由集合创建流
    public static void createStreamByList() {
        System.out.println("---createStreamByList---");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("python");
        list.add("c++");
        list.add("c");
        list.add("lisp");

        Stream<String> listStream = list.stream();
        System.out.println("---createStreamByList-输出String型的流---");
        listStream.forEach(System.out::println);
    }
```

### **2.4 由文件创建流**
  Java中用于处理文件等I/O操作的NIO API（非阻塞I/P）已更新，以便使用Stream API。java.nio.file.Files中的很多静态方法都会返回一个流。
  例如Files.lines方法，返回一个由指定文件中的各行构成的字符串流。
  
  **代码示例：**
  

```
//由文件创建流
    public static void createStreamByFile() throws IOException {
        System.out.println("---createStreamByFile---");
        long wordsNumbers = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/home/gaoziqiang/data.txt"), Charset.defaultCharset())) {
            wordsNumbers = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
        }
        System.out.println("---数量是: " + wordsNumbers + "---");
    }
```

### **2.5 由函数创建流**
  Stream API提供了两个静态方法来从函数生成流：Stream.iterate和Stream.generate。真两种方法都可以创建无限流。

**1.迭代iterate**
 迭代法创建流通常用于按照某个创建原则（例如函数）依次生成一系列值的时候，而且为了避免无限流通常需要进行limit限制。
 
 **代码示例：**
 

```
//由函数生成流--迭代
    public static void createStreamByFunctionIterate() {
        System.out.println("---createStreamByFunctionIterate---");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        //菲波纳契数列
        System.out.println("---createStreamByFunction-菲波纳契数列---");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
```

**2.生成generate**
  与iterate方法不同的是，generate方法不是对每个新生成的值应用函数的，它接受一个特定的新值生成器，并且该生成器需要支持Lambda表达式。
  
  **代码示例：**
  

```
//由函数生成流--生成
    public static void createStreamByFunctionGenerate() {
        System.out.println("---createStreamByFunctionGenerate---");
        //随机数
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
```

