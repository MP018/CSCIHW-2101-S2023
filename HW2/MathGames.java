package HW2;
import java.util.Scanner;

public class MathGames {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //call pythagorean method
        System.out.println("What is the base of the triangle:");
        double a = input.nextDouble();
        System.out.print("What is the perpendicular of the triangle:");
        double b = input.nextDouble();
        pythagorean(a, b);

        //call grade value
        System.out.println("What is your grade:");
        double grade = input.nextDouble();
        grade(grade);

        //call tip per person
        System.out.println("What is the total bill:");
        double total = input.nextDouble();
        System.out.println("How many people are splitting the bill:");
        int people = input.nextInt();
        System.out.println("What is the tip percentage (whole number):");
        double tip = input.nextDouble();
        
        billing(total, people, tip);
    
        input.close();
    }

    public static double pythagorean(double a, double b) {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
        System.out.println("The hypotenuse of the triangle is " + c);
        
        return c;
    }

    public static String grade(double grade) {

        double roundup = Math.ceil(grade);
        String letterGrade;

        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        System.out.println("Your grade is " + letterGrade);

        return letterGrade;
}

    public static double billing(double total, int people, double tip){
        double tipAmount = total * (tip/100);
        double totalAmount = Math.ceil(total + tipAmount);
        double perPerson = Math.ceil(totalAmount/people);
        
        System.out.println("The total bill, including tip is $" + totalAmount + " and each person owes $" + perPerson);

        return perPerson;
    }

}


// You can either create a tester class or put your code here
    //public static void main(String[] args){
        
    //}
//}
 // 1. Create a method that will calculate the Pythagorean Theorem (https://en.wikipedia.org/wiki/Pythagorean_theorem)
    // c = sqrt(a^2+b^2)
    // NOTE: You can assume you will only need to calculate the Hypotenuse
    // Hint 1: Method should take in 2 sides(a and b) of the triangle and return the missing side.
    //      Remember the Triangle has a base, Perpendicular, and Hypotenuse
    // Hint 2: Math.pow and Math.sqrt are your friend here
    // Bonus points: Try to make it accept any 2 sides and return the 3rd. So it can take in
    // Hypotenuse and Perpendicular and return the base.
    // Example 1: pythagorean(3,4) would return 5

 // 2. Create a method that will calcuate my grade in the class. You can use the grade range as follows
        // A: 100 - 90
        // B:  89 - 80
        // C:  79 - 70
        // D:  69 - 60
        // F:  60 -  0 
        // method should accept the grade as a double and return the letter grade of what I got
        // NOTE: Im a really nice guy and always round up on my grading so a 69.3 will round up to a 70.0
        // Hint 1: if statements required here you will probably need at the least 5 if / ifelse / else statments
        // Hint 2: You will probably need to cast the double to an int
        // Hint 3: You will probably need to use the Math.ceil() method
        // Example: grade(69.3) would return a D

    // 3. Create a method that will calculate the tip on a bill per person
    //      Method parameters: total bill, amount of people splitting the bill, percentage to tip.
    //      Note: I would like the total always rounded up to a whole number
    //      Hint 1: percentage can be made easier to work with if you divide by 100 so 18% is 18/100 = 0.18
    //      Hint 2: Using doubles will be helpful for when you need to calculate decimals
    //      Hint 3: It is possible you might need to Cast a double to an int or vice versa
    //      Hint 4: You will probably need to use the Math.ceil() method
    //      Example: tip(100, 4, 18) would return 5.0

