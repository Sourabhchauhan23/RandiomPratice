package Test;

import org.junit.Test;

import java.util.Arrays;

public class More {


    @Test
    public void sumExists() {

        // Your code here
        int[] arr= {73,23,39,93,39,80,91,58,59,92,16,89,57,12,35,73,56,29};
        int sum =47;
        Arrays.sort(arr);
        int counter=0;
        int result=0;
        for(int i=1; i<=arr.length; i++){
            System.out.println("value " + arr[arr.length-i]);
            int maxValue = arr[arr.length-i];
            int findValue = sum-maxValue;
            for(int j=0; j<arr.length; j++){
                if(findValue==arr[j]){
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter);
        if(counter>1){
            result=1;
        }
        System.out.println(result);
    }
}
