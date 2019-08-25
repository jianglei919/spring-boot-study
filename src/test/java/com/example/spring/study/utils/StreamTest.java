package com.example.spring.study.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jianglei on 2019/8/25.
 */
public class StreamTest {

    /**
     * distinct
     * 数字流式去重并转化为list
     * 保证输出的流中包含唯一的元素，它是通过Object.equals(Object)来检查是否包含相同的元素。
     */
    @Test
    public void test1() {
        List<String> list = Stream.of("a", "b", "c", "b").distinct().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * filter
     * 过滤出偶数
     * 返回的流中只包含满足断言(predicate)的数据。
     */
    @Test
    public void test2() {
        List<Integer> list = IntStream.range(1, 10).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * map
     * 将字符元素映射成它的哈希码(ASCII值)。
     * 方法将流中的元素映射成另外的值，新的值类型可以和原来的元素的类型不同。
     */
    @Test
    public void test3() {
        List<Integer> list = Stream.of('a', 'b', 'c').map(c -> c.hashCode()).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * flatmap
     * 将一首唐诗生成一个按行分割的流，然后在这个流上调用flatmap得到单词的小写形式的集合，去掉重复的单词然后打印出来。
     * 混合了map + flattern的功能，它将映射后的流的元素全部放入到一个新的流中
     */
    @Test
    public void test4() {
        String poetry = "Where, before me, are the ages that have gone?\n" +
                "And where, behind me, are the coming generations?\n" +
                "I think of heaven and earth, without limit, without end,\n" +
                "And I am all alone and my tears fall down.";
        Stream<String> lines = Arrays.stream(poetry.split("\n"));
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" ")));
        List<String> l = words.map(w -> {
            if (w.endsWith(",") || w.endsWith(".") || w.endsWith("?")) {
                return w.substring(0, w.length() - 1).trim().toLowerCase();
            } else {
                return w.trim().toLowerCase();
            }
        }).distinct().sorted().collect(Collectors.toList());
        System.out.println(l);
    }


    /**
     * limit
     * 方法指定数量的元素的流。对于串行流，这个方法是有效的，这是因为它只需返回前n个元素即可，但是对于有序的并行流，
     * 它可能花费相对较长的时间，如果你不在意有序，可以将有序并行流转换为无序的，可以提高性能。
     */
    @Test
    public void test5() {
        List<Integer> list = IntStream.range(1, 100).limit(5).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * peek
     * 方法方法会使用一个Consumer消费流中的元素，但是返回的流还是包含原来的流中的元素。
     */
    @Test
    public void test6() {
        String[] arr = {"b", "d", "a", "c"};
        Arrays.stream(arr).sorted().peek(i -> System.out.println(i.hashCode())).
                forEach(System.out::println);
    }

    /**
     * sorted
     * 将流中的元素按照自然排序方式进行排序，如果元素没有实现Comparable，则终点操作执行时会抛出java.lang.ClassCastException异常。
     * sorted(Comparator<? super T> comparator)可以指定排序的方式。
     * 对于有序流，排序是稳定的。对于非有序流，不保证排序稳定。
     */
    @Test
    public void test7() {
        String[] arr = new String[]{"b_123", "c+342", "b#632", "d_123"};
        List<String> list = Arrays.stream(arr)
                .sorted((s1, s2) -> {
                    if (s1.charAt(0) == s2.charAt(0)) {
                        return s1.substring(2).compareTo(s2.substring(2));
                    } else {
                        return s1.charAt(0) - s2.charAt(0);
                    }
                })
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * skip
     * 返回丢弃了前n个元素的流，如果流中的元素小于或者等于n，则返回空的流。
     */
    @Test
    public void test8() {
        List<String> list = Stream.of("b_123", "c+342", "b#632", "d_123").skip(2).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * match
     * 1、allMatch只有在所有的元素都满足断言时才返回true,否则flase,流为空时总是返回true
     * 2、anyMatch只有在任意一个元素满足断言时就返回true,否则flase,
     * 3、noneMatch只有在所有的元素都不满足断言时才返回true,否则flase,
     */


    /**
     * count
     *返回流中的元素的数量。
     */

    /**
     * collect
     * 使用一个collector执行mutable reduction操作。辅助类Collectors提供了很多的collector，可以满足我们日常的需求，
     * 你也可以创建新的collector实现特定的需求。它是一个值得关注的类，你需要熟悉这些特定的收集器，如聚合类averagingInt、
     * 最大最小值maxBy minBy、计数counting、分组groupingBy、字符串连接joining、
     * 分区partitioningBy、汇总summarizingInt、化简reducing、转换toXXX等。
     */

    /**
     * find
     * findAny()返回任意一个元素，如果流为空，返回空的Optional，对于并行流来说，它只需要返回任意一个元素即可，所以性能可能要好于findFirst()，
     * 但是有可能多次执行的时候返回的结果不一样。
     * findFirst()返回第一个元素，如果流为空，返回空的Optional。
     */

    /**
     * forEach、forEachOrdered
     * 遍历流的每一个元素，执行指定的action。它是一个终点操作，和peek方法不同。这个方法不担保按照流的encounter order顺序执行，
     * 如果对于有序流按照它的encounter order顺序执行，你可以使用forEachOrdered方法。
     */

    /**
     * max、min
     * max返回流中的最大值，min返回流中的最小值。
     */

    /**
     * reduce
     *
     */

    /**
     * toArray方法将一个流转换成数组，而如果想转换成其它集合类型，需要调用collect方法，利用Collectors.toXXX方法进行转换：
     *
     */
}
