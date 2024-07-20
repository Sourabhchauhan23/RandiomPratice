package Test;

import java.util.List;
import java.util.stream.Collectors;

public class OneMore {

    public static void main(String[] args){

        String name ="Sourabh Chauhan";
        String result=null;
        int counter=0;
        List<Character> nameList= name.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        nameList.forEach(System.out::print);
    }
}
