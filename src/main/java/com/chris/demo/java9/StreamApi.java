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
         *@Descraption takeWhile() ����ʹ��Predicate��Ϊ������������stream�е�Ԫ�أ�ֱ��ĳ��Ԫ�ط���false��ֹͣ���������ظ�Ԫ��֮ǰ���Ӽ���
        �����һ��ֵ���������������������һ���յ� Stream��
         *��������ԵĻ�ȡ��ֱ����һ�������������ģ�����֮ǰ��stream�Ӽ�
         *@Result print: ABC
         */
        List<? extends String> list = List.of("A", "B", "C", "D", "1", "E");
        list.stream().filter(codeMatch())
                .takeWhile(e -> isNotEqualStr(e, "D"))
                .forEach(System.out::println);
        System.out.println("--------");
        /**
         *@function_name default Stream<T> dropWhile(Predicate<? super T> predicate)
         *@Descraption������ takeWhile �����෴�ģ�ʹ��һ��������Ϊ������ֱ����������һ�η���true,���ظ�Ԫ�ؼ������Stream�Ӽ���
         * ��������������Ķ�����ֱ����һ�������������ģ����ظ�Ԫ�غ����stream�Ӽ�
         *@Result print: DE
         * */
        var list2 = List.of("A", "B", "C", "D", "1", "E");
        list2.stream().filter(codeMatch()).dropWhile(e -> isNotEqualStr(e, "D")).forEach(System.out::println);
        System.out.println("--------");
        /**
         * @function_name static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
         * ��������ʹ�ó�ʼ����ֵ����˳�򣨿��������ޣ�����������Ӧ��ָ������һ�������� ��ָ���� hasNext �� predicate ���� false ʱ������ֹͣ
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
