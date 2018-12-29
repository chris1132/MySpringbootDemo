package com.chris.demo.java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {

    public static void main(String[] args) {

        /**
         * stream()
         * @Descraption �� Optional תΪһ�� Stream������� Optional �а���ֵ����ô�ͷ��ذ������ֵ�� Stream�����򷵻�һ���յ� Stream��Stream.empty()��
         * */

        List<Optional<String>> list = Arrays.asList(
                Optional.empty(),
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B")
        );

        //java8
        var filterList = list.stream()
                .flatMap(e -> e.isPresent() ? Stream.of(e.get()) : Stream.empty())
                .collect(Collectors.toList());
        System.out.println(filterList);

        //java9
        var filterList49 = list.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println(filterList49);

        System.out.println("----------------");
        /**
         * @function_name isPresentOrElse(Consumer < ? super T > action, Runnable emptyAction)
         * @Descraption ���һ��Option����ֵ������������ֵ���ú���action����action.accept(value);���Option������ֵ����ô����emptyAction����emptyAction.run()
         *
         * */
        Optional<String> optional = Optional.of("A");
//        optional = Optional.empty();
        optional.ifPresentOrElse(e -> {
            System.out.println(e += 1);
        }, () -> System.out.println("empty element"));

        System.out.println("----------------");
        /**
         * @function_name public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
         * @Descraption ���ֵ���ڣ����� Optional ָ����ֵ�����򷵻�һ��Ԥ���ֵ��
         * */
        Supplier<Optional<String>> supplierString = () -> Optional.of("Not Present");

        Optional<String> optional1 = Optional.of("Mahesh");
        optional1 = optional1.or(supplierString);
        optional1.ifPresent(x -> System.out.println("Value: " + x));

        optional1 = Optional.empty();
        optional1 = optional1.or(supplierString);
        optional1.ifPresent(x -> System.out.println("Value: " + x));


    }

}
