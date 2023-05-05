package HW4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Arrays {

    // CONVERT THE SUMS METHOD FROM HW3 TO ADD EACH VALUE TO AN ARRAY AND THEN OUTPUT THE 
    // ARRAY AND THE TOTAL.
    // SEE HW3 FOR SUMS METHOD
    // If you want to use an ArrayList for the inputs to be dynamic that is okay
    // Otherwise if you are using a regular array, assume the size is 10 total. 
    // EXAMPLE 
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 0
    // Total: 22
    // Array: {12,2,3,4,1,0}
    public static void Arraysums(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me....");

        int[] numbers = new int[10];
        int sum = 0;
        int count = 0;
        int number = 0;

        while (true) {
            System.out.print("Number: ");
            number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            numbers[count] = number;
            sum += number;
            count++;

            System.out.println("The total so far is " + sum + ".");

            if (count == 10) {
                break;
            }
        }
        

        System.out.println("Total:" + sum);
        System.out.print("Array: {");
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i]);
            if (i != count - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");

        scanner.close();

    }
    

    // Create a method that will brute force a password EX.
    // bruteForce("ZZZZ")
    // The program should then guess each char of the string and compare it to see if it is equal
    // to the index of the alphabet char array below
    // Output Example:
    // Z
    // ZZ
    // ZZZ
    // ZZZZ

    // Hint 1: using a char array for the password is helpful here 
    // Hint 2: using the method .toCharArray is a way to convert the password parameter to a char array as well
    // From there creating for and while loops to compare the values is trivial
    public static boolean arraysEqual(char[] arr1, char[] arr2, int n) {
        if (arr1 == arr2) {
            return true;
        }
        if (arr1 == null || arr2 == null || arr1.length < n || arr2.length < n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String bruteForce(String password){
        String answer = "";
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')','<','>','/','?'};
    
        char[] passwordChars = password.toCharArray();
        char[] guess = new char[passwordChars.length];

        // Loop through each character in the guess and test all possible values
        for (int i = 0; i < passwordChars.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                guess[i] = alphabet[j];
                if (arraysEqual(guess, passwordChars, i+1)) {
                    System.out.println(new String(guess, 0, i+1));
                    break;
                }
            }
        }
    
        return answer;
    }

    
    // Create a method that will sort an Array of integers from smallest to greatest.
    // NOTE: You CANNOT use the built in Arrays.sort method
    // Ex. 
    // sorter([9,10,2,5,3,4,7,8]) -> [2,3,4,5,7,8,9,10]

    // Hint 1: a temp Array is a helpful way to store variables for comparing 
    // Hint 2: 2 nested For loops should be all thats needed for the swapping logic
    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public static int[] sorter(int[] nums){
        int [] sortedArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sortedArray[i] = nums[i];
        }
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        printArray(sortedArray);
        return sortedArray;
    }




public static void main(String[] args) {
   //     // Tester main method for your methods
    //    System.out.println("Hello World!");
    Arrays.Arraysums();

    Arrays.bruteForce("ZZZZ");

    Arrays.sorter(new int[]{9,10,2,5,3,4,7,8});

    }

    
}