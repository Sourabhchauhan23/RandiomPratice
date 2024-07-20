package Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PraticeStream {

    public static void main(String[] args){

        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::print);

    }
}
