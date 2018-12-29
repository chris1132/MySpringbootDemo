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
         * @Descraption 将 Optional 转为一个 Stream，如果该 Optional 中包含值，那么就返回包含这个值的 Stream，否则返回一个空的 Stream（Stream.empty()）
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
         * @Descraption 如果一个Option包含值，则对其包含的值调用函数action，既action.accept(value);如果Option不包含值，那么调用emptyAction，即emptyAction.run()
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
         * @Descraption 如果值存在，返回 Optional 指定的值，否则返回一个预设的值。
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
