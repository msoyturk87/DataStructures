package HashMaps;


import java.util.HashMap;

public class FindCharacters {

    static HashMap arrangeHashMap(String word) {

        //Create hashMap
        HashMap<Character, Integer> countCharacter = new HashMap<>();
        //Convert it to char
        char[] wordAsCharArray = word.toCharArray();

        for (char c : wordAsCharArray) {
            //Find unique or not
            if (countCharacter.containsKey(c)) {
                //If c already inside HashMap it meants repeated
                //Key is unique so if we set value 2 all key refers same object
                countCharacter.put(c, countCharacter.get(c) + 1);
            } else {
                // if HashMap does not contain we should add it with value 1 it is meaning not repeated
                // But end of the loop it can change
                countCharacter.put(c, 1);
            }
        }


        // to verify  values 1 or 2 if 2 it is repeated else it is non-repeated
        for (char c : wordAsCharArray) {

            System.out.println(c + " is " + countCharacter.get(c) + " times");

        }
        return countCharacter;
    }
    // to find repeated char
    static void firstRepeated(String word) {
        HashMap<Character, Integer> arrangedHashMap = arrangeHashMap(word);
        char[] wordAsCharArray = word.toCharArray();

        for (char c : wordAsCharArray) {
            if (arrangedHashMap.get(c) == 1) {
                System.out.println("First Non-Repeated is " + c );

                break;
            }
        }

    }
    // to find non repeated char
    static void firstNonRepeated(String word) {
        HashMap<Character, Integer> arrangedHashMap = arrangeHashMap(word);
        char[] wordAsCharArray = word.toCharArray();

        for (char c : wordAsCharArray) {
            if (arrangedHashMap.get(c) > 1) {
                System.out.println("First Repeated is "+ c );

                break;
            }
        }

    }
}



