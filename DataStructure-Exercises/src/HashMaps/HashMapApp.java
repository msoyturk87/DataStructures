package HashMaps;

import java.util.Scanner;

public class HashMapApp {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string :");

        String input = sc.next();
        FindCharacters.firstNonRepeated(input);
        FindCharacters.firstRepeated(input);

    }
}
