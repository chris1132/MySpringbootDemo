package com.chris.demo.java9;

import java.io.InputStream;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StreamApi {

    public static void main(String[] arg) {

        /**
         *@function_name default Stream<T> takeWhile(Predicate<? super T> predicate)
         *@Descraption takeWhile() 方法使用Predicate作为参数，来遍历stream中的元素，直到某个元素返回false，停止遍历，返回该元素之前的子集。
        如果第一个值不满足断言条件，将返回一个空的 Stream。
         *既满足断言的获取，直到第一个不满足条件的，返回之前的stream子集
         *@Result print: ABC
         */
        List<? extends String> list = List.of("A", "B", "C", "D", "1", "E");
        list.stream().filter(codeMatch())
                .takeWhile(e -> isNotEqualStr(e, "D"))
                .forEach(System.out::println);
        System.out.println("--------");
        /**
         *@function_name default Stream<T> dropWhile(Predicate<? super T> predicate)
         *@Descraption方法和 takeWhile 作用相反的，使用一个断言作为参数，直到断言语句第一次返回true,返回该元素及后面的Stream子集。
         * 即满足断言条件的丢弃，直到第一个不满足条件的，返回该元素后面的stream子集
         *@Result print: DE
         * */
        var list2 = List.of("A", "B", "C", "D", "1", "E");
        list2.stream().filter(codeMatch()).dropWhile(e -> isNotEqualStr(e, "D")).forEach(System.out::println);
        System.out.println("--------");
        /**
         * @function_name static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
         * 方法允许使用初始种子值创建顺序（可能是无限）流，并迭代应用指定的下一个方法。 当指定的 hasNext 的 predicate 返回 false 时，迭代停止
         * */

        IntStream.iterate(3, e -> e < 15, e -> e + 3).forEach(System.out::println);


    }

    public static boolean isEqualStr(String e, String compareStr) {
        return e.equals(compareStr);
    }

    public static boolean isNotEqualStr(String e, String compareStr) {
        return !isEqualStr(e, compareStr);
    }

    public static Predicate<String> codeMatch() {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                Pattern pattern = Pattern.compile("[A-Za-z]{1,}");
//                Matcher matcher = pattern.matcher(s);
//                return matcher.matches();
//            }
//        };

        Predicate<String> predicate = Pattern.compile("[A-Za-z]{1,}").asPredicate();
        return predicate;
    }

}
