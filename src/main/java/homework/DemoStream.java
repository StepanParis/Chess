package homework;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class DemoStream {
    public static void main(String[] args) {
//        Stream.of("John", "Mike").map(Student::new);
//        Stream.of(new Student("Max"), new Student("Andy")).forEach(student -> System.out.println(student.getName()));

        Stream.of("one", "two").collect(toCollection(ArrayList::new));
        System.out.println(Stream.of("one", "two").collect(maxBy(Comparator.comparing(x -> x))));
        System.out.println(Stream.of(1, 2).collect(averagingInt(x -> x)));
        Map<Boolean, List<Integer>> map = Stream.of(1, 3, 2, 4).collect(partitioningBy(x -> x > 2));
        System.out.println(map.values());

        Map<Integer, List<Integer>> map2 = Stream.of(1, 2, 1, 3).collect(groupingBy(x -> x));
        System.out.println(map2.values());

        Map<Integer, Long> map3 = Stream.of(1, 2, 1, 3).collect(groupingBy(x -> x, counting()));
        System.out.println(map3);

        String result = Stream.of("one", "two", "three").collect(joining(", ", "{", "}"));
        System.out.println(result);

    }
}
