# Java8系列--Java Stream入门篇（流的操作）
## **1 Stream接口**
### **1.1 接口情况**
  java.util.stream接口下共有DoubleStream、LongStream、IntStream、Stream四个接口，如下图所示:
  ![stream](http://img.blog.csdn.net/20170718173028033?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzM0Mjk5Njg=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### **1.2 流的分类和使用**
  其中，Stream接口定义了许多方法，大体可以分为**两类**：
 
 - 中间操作类
 - 终端操作类

一般来说，**流的使用**可以概括为三件事：

 - 一个数据源来执行一个查询
 - 一个中间操作链，形成一条流的流水线
 - 一个终端操作，执行流水线，并生成结果

### **1.3 结构图**
![liucaozuo](http://img.blog.csdn.net/20170718184445587?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzM0Mjk5Njg=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
## **2 中间操作**
中间操作类的返回的是另一个流，即其返回值类型是流Stream。
例如，filter或sorted方法连接起来可以形成一个查询操作，除非流水线上触发一个终端操作，否则不会执行任何处理。
**总之，中间操作只是各种操作的一个顺序上的联合，它们操作的对象是流，产生的对象也是各种各样的流，只有在终端操作之后才能显示最终的操作结果。**
流的**中间操作**常有以下几种：
<table>
  <tr>
    <td>
    操作
    </td>
     <td>
     类型
    </td>
<td>
返回类型
    </td>
     <td>
     操作参数
    </td>
     <td>
     函数描述符
    </td>
  </tr>
    <tr>
    <td>
    filter
    </td>
     <td>
     中间操作
    </td>
<td>
Stream T
    </td>
     <td>
     Predicate T
    </td>
     <td>
     T -> boolean
    </td>
  </tr>
    <tr>
    <td>
    map
    </td>
     <td>
     中间操作
    </td>
     <td>
     Stream R
    </td>
     <td>
     Function T,R
    </td>
     <td>
     T -> R
    </td>
  </tr>
    <tr>
    <td>
    limit
    </td>
     <td>
     中间操作 
    </td>
     <td>
     Stream T 
    </td>
     <td>
    </td>
     <td>
    </td>
  </tr>
    <tr>
    <td>
    sorted
    </td>
     <td>
     中间操作 
    </td>
     <td>
     Stream T 
    </td>
     <td>
     Comparator T
    </td>
     <td>
     (T,T) -> int
    </td>
  </tr>
    <tr>
    <td>
    distinct
    </td>
     <td>
     中间操作 
    </td>
     <td>
     Stream T 
    </td>
     <td>
    </td>
     <td>
    </td>
  </tr>
</table>

## **3 终端操作**
  流的终端操作会从流的流水线生成结果，其结果是任何不为流的值，比如List、Integer甚至是void。
  常用的流的**终端操作**：
<table>
  <tr>
    <td>
    操作
    </td>
<td>
类型
    </td>
        <td>
        目的
    </td>
  </tr>
    <tr>
    <td>
    forEach
    </td>
        <td>
        终端操作
    </td>
    <td>
消费流中的每个元素并对其应用Lambda。这一操作返回void
    </td>
  </tr>
    <tr>
    <td>
    count
    </td>
        <td>
        终端操作
    </td>
    <td>
返回流中元素的个数。这一操作返回long
    </td>
  </tr>
  <tr>
    <td>
    collect
    </td>
    <td>
    终端操作 
    </td>
    <td>
    把流归约成一个集合，比如List、Map甚至是Integer。
    </td>
  </tr>
</table>

