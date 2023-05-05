package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
        nums();
        week();
        matrix();

    }

    // Question 1
    // Write Java statements that do the following:
    // a) Declare an arrayList nums of 15 elements of type int.
    // b) Output the value of the tenth element of the array nums.
    // c) Set the value of the 5th element of the array nums to 99.
    // d) set the value of the 13th element to 15
    // d) set the value of the 2nd element to 6
    // d) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.

    public static void nums() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i <= 15; i++) {
            nums.add(i);
        }
        System.out.println("Array List 15 numbers: "+ nums);

        System.out.println(nums.get(9));

        nums.set(4, 99);
        System.out.println("Set value of 5th element to 99: "+nums);

        nums.set(12, 15);
        System.out.println("Set value of 13th element to 15: "+nums);

        nums.set(1, 6);
        System.out.println("Set value of 2nd element to 6: "+nums);

        nums.set(8, nums.get(12) + nums.get(1));
        System.out.println("Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums: "+nums);
    
    }
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)
    // b) output each of the days of the week
    // c) output the days of the week that we have class 
    // d) change the arrayList to start on Sunday

    public static void week() {
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        for (String day : days) {
            System.out.println(day);
        }

        //If when only have Programming and Problem Solving 1 Class
        System.out.println("When we have class: " + days.get(1) + " and " + days.get(3));

        String s = "Sunday";
        days.remove(days.size() - 1);
        days.add(0, s);
        System.out.println("Sunday is now the start of the week: " + days);

    }

    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected
    // b) return the largest and smallest number
    // c) return the ArrayList sorted smallest to largest
    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format
    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }

    public static void matrix() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int num = 1;
        while (num != 0) {
            System.out.println("Please enter a number to add to the ArrayList or enter 0 to stop adding numbers: ");
            num = input.nextInt();
            numbers.add(num);
        }
        numbers.remove(numbers.size() - 1);
        System.out.println(numbers);

        int largest = numbers.get(0);
        int smallest = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > largest) {
                largest = numbers.get(i);
            }
            if (numbers.get(i) < smallest) {
                smallest = numbers.get(i);
            }
        }
        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);

        Collections.sort(numbers);
        System.out.println(numbers);

        while (numbers.size() % 3 != 0) {
            System.out.println("Please enter a number to add to the ArrayList to make it divisable by 3: ");
            num = input.nextInt();
            numbers.add(num);
        }
        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        
    
}
}  

