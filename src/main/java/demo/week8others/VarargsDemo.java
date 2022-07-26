package demo.week8others;

import java.util.Arrays;

public class VarargsDemo {
    // String[] args = String... args
    public static void main(String... args) {
        // method demo1 & demo2 both can take
        // an array of integers
        int[] input = {1, 2, 3};
        demo1(input);
        demo2(input);

        // demo1 uses varargs so can directly
        // pass in the ints one by one
        // instead of putting them into an array first
        demo1(1, 2, 3);
        // but demo2(1, 2, 3) is invalid!

        // method demo1 & demo2 both can take
        // an empty array of integers
        int[] input2 = {};
        demo1(input2);
        demo2(input2);

        // demo1 uses varargs so passing in nothing
        // is the same as passing in an empty int array
        demo1();
        // but demo2() is invalid!
    }

    // method demo1 & demo2 are the same except for
    // demo1 uses varargs
    public static void demo1(int... input){
        System.out.println(Arrays.toString(input));
    }

    public static void demo2(int[] input){
        System.out.println(Arrays.toString(input));
    }
}
