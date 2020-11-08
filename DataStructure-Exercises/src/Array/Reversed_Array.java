package Array;

import java.util.Arrays;

public class Reversed_Array {
    public static void main(String[] args) {
        System.out.println("IN PLACE REVERSE  ");

        int [] reverse={1,2,3,4,5,6,7,8,9};
        int tem=0;

        for (int k = 0; k < reverse.length/2; k++) {

            tem=reverse[k];
            reverse[k]=reverse[reverse.length-k-1];
            reverse[reverse.length-k-1]=tem;

        }

        System.out.println(Arrays.toString(reverse));
    }
}
