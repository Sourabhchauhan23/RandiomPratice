package Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MorePractice {
    public static void main(String[] arg){

        Integer[] a = {9,8,1,2,3,4,5,6,7,8,9,10,11,12};
        int[] b = {7,1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(a));

        double s = Arrays.stream(b)
                        .average().getAsDouble();
        System.out.println(s +" ");

        al.stream().forEach(System.out::print);

        System.out.println(" -- ");

        al.stream().sorted().forEach(System.out::print);

        al.removeIf(x -> x%2==0);
        System.out.println("");

        printPrimeNumber(al, x -> BigInteger.valueOf(x).isProbablePrime(1));
        System.out.println("");

        al.forEach(System.out::print);
    }

    private static void printPrimeNumber(ArrayList<Integer> al, Predicate<Integer> c) {
        al.stream().filter(c).forEach(System.out::print);
    }


}
