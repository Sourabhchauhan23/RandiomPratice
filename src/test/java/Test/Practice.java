package Test;

import java.util.List;

public class Practice {
    public static void main (String[] args){

        List<String> vowels = List.of("a", "e", "i", "o", "u");

// sequential stream - nothing to combine
        StringBuilder result = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y),
                (a, b) -> a.append(",").append(b));
        System.out.println(result.toString());

// parallel stream - combiner is combining partial results
        StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
                (a, b) -> a.append(",").append(b));
        System.out.println(result1.toString());
    }
}
