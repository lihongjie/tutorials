package com.github.lihongjie.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {

    public static void main(String[] args) {
        StreamApiTest test = new StreamApiTest();
//        test.summary();
//        test.peek();
//        test.skip();

        test.reduce();
    }

    //方法 'forEach' 来迭代流中的每个数据。
    private void forEach() {
        //使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    //map 方法用于映射每个元素到对应的结果
    private void map() {
        //使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());

    }

    //filter 方法用于通过设置的条件过滤出元素。
    private void filter() {

        //使用 filter 方法过滤出空字符串：
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();

    }

    //limit 方法用于获取指定数量的流,imit 返回 Stream 的前面 n 个元素；
    private void limit() {
        //使用 limit 方法打印出 10 条数据：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    //skip skip 则是扔掉前 n 个元素
    private void skip() {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().skip(2).forEach(System.out::println);


    }

    //sorted 方法用于对流进行排序
    private void sorted() {
        //使用 sorted 方法对输出的 10 个随机数进行排序
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

    }

    //parallelStream 是流并行处理程序的代替方法
    private void parallel() {

        // 使用 parallelStream 来输出空字符串的数量
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
    }

    //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
    private void collectors() {
        //Collectors 可用于返回列表或字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

    }

    //统计
    private void summary() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    // peek
    private void peek() {

        Stream.of("Fred","Jim","Sheila")

                .peek(System.out::println)
               .allMatch(s ->s.startsWith("J"));

//
//        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());

    }

    private void reduce() {

        Stream.of(new A("Mercury"), new A("Venus"), new A("Earth"))
                .flatMap(i -> i.integerList.stream()).mapToInt(j -> j).max().ifPresent(s -> System.out.println(s));
    }

    private void match() {


    }

    class A{
        public String s;

        public List<Integer> integerList;

        public A(String s) {

            this.s = s;
            integerList = new LinkedList<>();

            for (int i =0; i < this.s.length(); ++i) {
                integerList.add(i);
            }
        }
    }
}
